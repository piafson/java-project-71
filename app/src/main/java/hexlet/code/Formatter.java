package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import java.util.List;

import java.util.Map;

public class Formatter {
    public static String getFormStr(Map<String, List<String>> inp, String formatName)
            throws JsonProcessingException {
        return switch (formatName) {
            case "plain" -> Plain.formatting(inp);
            case "json" -> Json.formatting(inp);
            default -> Stylish.formatting(inp);
        };
    }
}
