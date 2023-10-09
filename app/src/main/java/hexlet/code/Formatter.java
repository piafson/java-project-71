package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {
    public static String getFormStr(Map<String, String> inp, String formatName) {
        return switch (formatName) {
            case "plain" -> Plain.formatting(inp);
            default -> Stylish.formatting(inp);
        };
    }

    public static String getFormStr(Map<String, String> inp) {
        return Stylish.formatting(inp);
    }
}
