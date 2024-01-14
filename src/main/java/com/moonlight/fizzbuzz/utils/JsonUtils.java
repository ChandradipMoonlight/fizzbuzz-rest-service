package com.moonlight.fizzbuzz.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static JsonNode toJson(Object object) {
        JsonNode jsonNode = null;
        try {
            jsonNode = OBJECT_MAPPER.convertValue(object, JsonNode.class);
        } catch (Exception e) {
            log.error("Exception occurred while converting Java object to JsonNode!");
        }
        return jsonNode;
    }

    public static <T> T jsonToJavaObject(JsonNode jsonNode, Class<T> tClass) {
        T t = null;
        try {
            t = OBJECT_MAPPER.convertValue(jsonNode, tClass);
        } catch (Exception e){
            log.error("Error occurred while converting JsonNode to Java Object!");
        }
        return t;
    }
}
