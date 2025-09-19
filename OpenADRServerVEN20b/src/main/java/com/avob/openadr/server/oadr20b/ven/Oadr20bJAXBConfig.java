package com.avob.openadr.server.oadr20b.ven;

import com.avob.openadr.model.oadr20b.Oadr20bJAXBContext;
import com.avob.openadr.security.exception.OadrSecurityException;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author david
 * Date  2025/8/8
 */
@Configuration
public class Oadr20bJAXBConfig {
    @Value("${oadr.security.validateOadrPayloadAgainstXsdFilePath:#{null}}")
    private String validateOadrPayloadAgainstXsdFilePath;
    @Bean
    @Profile("!test")
    public Oadr20bJAXBContext jaxbContextProd() throws OadrSecurityException, JAXBException {
        if (validateOadrPayloadAgainstXsdFilePath != null) {
            return Oadr20bJAXBContext.getInstance(validateOadrPayloadAgainstXsdFilePath);
        }
        return Oadr20bJAXBContext.getInstance();
    };
}
