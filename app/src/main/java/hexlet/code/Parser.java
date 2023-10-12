package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class Parser {
    public static ObjectMapper getObj(String extension) {
        switch (extension) {
            case "json" -> {
                return new JsonMapper();
            }
            case "yml" -> {
                return new YAMLMapper();
            }
            default -> {
                return new ObjectMapper();
            }
        }
    }
}
