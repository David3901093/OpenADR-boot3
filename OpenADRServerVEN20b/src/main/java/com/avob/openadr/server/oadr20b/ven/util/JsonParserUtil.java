package com.avob.openadr.server.oadr20b.ven.util;

import com.avob.openadr.model.oadr20b.emix.ItemBaseType;
import com.avob.openadr.model.oadr20b.power.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import jakarta.xml.bind.JAXBElement;
import org.bouncycastle.jce.exception.ExtIOException;

import javax.xml.namespace.QName;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

/**
 * Utility class for converting between JSON strings and Java objects.
 * Provides methods to deserialize JSON strings into Java objects and serialize Java objects into JSON strings.
 */
public class JsonParserUtil {

    private static final List<Class<?>> ITEM_BASE_TYPE_FALLBACK_CANDIDATES = Arrays.asList(
            EnergyRealType.class,    // Common
            PowerRealType.class,     // Common
            EnergyApparentType.class,
            PowerApparentType.class,
            EnergyReactiveType.class,
            PowerReactiveType.class,
            VoltageType.class,
            // Add others as needed based on your common use cases
            // Avoid abstract classes like EnergyItemType, PowerItemType, ItemBaseType
            // CurrencyType, CurrentType, etc. might also be relevant depending on context
            com.avob.openadr.model.oadr20b.oadr.CurrentType.class, // Example, add if present and concrete
            com.avob.openadr.model.oadr20b.oadr.FrequencyType.class // Example, add if present and concrete
            // IMPORTANT: Only add concrete classes that are actual subtypes of ItemBaseType
    );
    // Create a standard ObjectMapper for general use
    private static final ObjectMapper standardObjectMapper = new ObjectMapper();

    // Create a special ObjectMapper configured for JAXB/Jakarta objects
    private static final ObjectMapper jaxbAwareObjectMapper;

    static {
        jaxbAwareObjectMapper = new ObjectMapper();
        jaxbAwareObjectMapper.registerModule(new JaxbAnnotationModule());

        SimpleModule customModule = new SimpleModule("CustomJAXBElementModule");
        customModule.addDeserializer(JAXBElement.class, new JAXBElementDeserializer());
        jaxbAwareObjectMapper.registerModule(customModule);

        jaxbAwareObjectMapper.enable(MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME);
        jaxbAwareObjectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        jaxbAwareObjectMapper.setDateFormat(dateFormat);
    }

    /**
     * Custom deserializer for JAXBElement.
     * Attempts to deserialize the value to a known JAXB type based on contextual information or a predefined list.
     * Falls back to Object.class if no match is found, but this will likely cause marshalling issues later.
     */
    static class JAXBElementDeserializer extends JsonDeserializer<JAXBElement<?>> {

        @Override
        public JAXBElement<?> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            ObjectMapper mapper = (ObjectMapper) p.getCodec();
            JsonNode node = mapper.readTree(p);

            if (node == null || node.isNull()) {
                return null;
            }

            JsonNode valueNode = node.get("value");
            JsonNode nameNode = node.get("name");

            // --- START OF CORRECTED NAME PARSING (as before) ---
            String namespaceURI = "http://openadr.org/oadr-2.0b";
            String localPart = "defaultLocalName";

            if (nameNode != null && nameNode.isTextual()) {
                String fullName = nameNode.asText();
                if (fullName.startsWith("{")) {
                    int closingBraceIndex = fullName.indexOf('}');
                    if (closingBraceIndex > 0) {
                        namespaceURI = fullName.substring(1, closingBraceIndex);
                        localPart = fullName.substring(closingBraceIndex + 1);
                    } else {
                        // Silently use defaults if malformed
                    }
                } else {
                    localPart = fullName;
                }
            } else {
                // Silently use defaults if missing
            }
            // --- END OF CORRECTED NAME PARSING ---

            // Determine the target type for the value based on the element name and contextual info
            Class<?> targetClass = Object.class;
            JavaType contextualType = ctxt.getContextualType();
            if (contextualType != null && contextualType.getRawClass() == JAXBElement.class && contextualType.containedTypeCount() > 0) {
                JavaType containedType = contextualType.containedType(0);
                if (containedType != null) {
                    Class<?> rawContainedClass = containedType.getRawClass();
                    if (rawContainedClass != Object.class && !ItemBaseType.class.isAssignableFrom(rawContainedClass)) {
                        targetClass = rawContainedClass;
                    } else if (ItemBaseType.class.isAssignableFrom(rawContainedClass)) {
                        // The contextual type is ItemBaseType or a supertype. Refine based on the element name.
                        switch (localPart) {
                            case "energyReal":
                                targetClass = EnergyRealType.class;
                                break;
                            case "energyApparent":
                                targetClass = EnergyApparentType.class;
                                break;
                            case "energyReactive":
                                targetClass = EnergyReactiveType.class;
                                break;
                            case "powerReal":
                                targetClass = PowerRealType.class;
                                break;
                            case "powerApparent":
                                targetClass = PowerApparentType.class;
                                break;
                            case "powerReactive":
                                targetClass = PowerReactiveType.class;
                                break;
                            case "voltage":
                                targetClass = VoltageType.class;
                                break;
                            // Add other mappings as needed
                            default:
                                // Do not break here, proceed to fallback logic
                                break;
                        }
                        if (targetClass != Object.class && ItemBaseType.class.isAssignableFrom(targetClass)) { // Ensure it's an ItemBaseType subtype
                        } else if (targetClass != Object.class) {
                            targetClass = Object.class; // Reset to Object.class to trigger fallback
                        }
                    }
                }
            }

            Object value = null;
            QName qname = new QName(namespaceURI, localPart);

            // Try the determined type first
            if (targetClass != Object.class && ItemBaseType.class.isAssignableFrom(targetClass)) {
                try {
                    value = mapper.treeToValue(valueNode != null ? valueNode : node, targetClass);
                    // Cast is safe because treeToValue succeeded with targetClass and we checked assignability
                    return new JAXBElement<>(qname, (Class<Object>) targetClass, value);
                } catch (Exception e) {
                    // Continue to fallback
                }
            } else if (targetClass != Object.class) {
                // Proceed to fallback
            }


            // Fallback: Try a list of known ItemBaseType subtypes specifically
            for (Class<?> candidateType : ITEM_BASE_TYPE_FALLBACK_CANDIDATES) {
                if (ItemBaseType.class.isAssignableFrom(candidateType)) { // Double check it's a subtype
                    try {
                        Object candidateValue = mapper.treeToValue(valueNode != null ? valueNode : node, candidateType);
                        return new JAXBElement<>(qname, (Class<Object>) candidateType, candidateValue);
                    } catch (Exception e) {
                        // Continue to next candidate
                    }
                }
            }

            // Final fallback: No known type worked, and Object.class would cause marshalling issues.
            // Throw an exception indicating failure.
            String errorMsg = String.format("Could not determine a valid JAXB type for JAXBElement value that extends ItemBaseType. The input JSON structure is incompatible with all known types. Failed to deserialize value node: %s. Element Name was: %s", (valueNode != null ? valueNode : node).toString(), localPart);
            throw new com.fasterxml.jackson.databind.JsonMappingException(p, errorMsg, p.getCurrentLocation());

        }
    }

    // Standard methods using the standard mapper
    public static <T> T parseJson(String jsonString, Class<T> clazz) throws JsonProcessingException {
        return standardObjectMapper.readValue(jsonString, clazz);
    }

    public static <T> String toJsonString(T object) throws JsonProcessingException {
        return standardObjectMapper.writeValueAsString(object);
    }

    public static <T> String toPrettyJsonString(T object) throws JsonProcessingException {
        return standardObjectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    }

    // JAXB/Jakarta-specific methods using the configured mapper
    public static <T> T parseJaxbJson(String jsonString, Class<T> clazz) throws JsonProcessingException {
        return jaxbAwareObjectMapper.readValue(jsonString, clazz);
    }

    public static <T> String toJaxbJsonString(T object) throws JsonProcessingException {
        return jaxbAwareObjectMapper.writeValueAsString(object);
    }

    public static <T> String toPrettyJaxbJsonString(T object) throws JsonProcessingException {
        return jaxbAwareObjectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    }
}