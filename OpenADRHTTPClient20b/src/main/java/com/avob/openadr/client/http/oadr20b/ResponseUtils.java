package com.avob.openadr.client.http.oadr20b;

import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author david
 * Date  2025/8/12
 */
public class ResponseUtils {
    private static final ResponseUtils INSTANCE = new ResponseUtils();
    private  String resString;
    public static void setResString(String resp) {
        INSTANCE.resString = resp;
    }
    public static String getResString() {
        if(INSTANCE.resString == null || INSTANCE.resString.isEmpty()){
            return "empty response";
        }
        String returnStr=INSTANCE.resString;
        INSTANCE.resString = null;

        return returnStr;
    }

    public static String toString(HttpEntity entity) throws IOException {
        return EntityUtils.toString(entity);
    }
}
