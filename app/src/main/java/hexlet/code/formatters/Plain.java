package hexlet.code.formatters;

import java.util.Map;
import java.util.List;
public class Plain {
    public static String formatting(Map<String, List<String>> inp) {
        StringBuilder result = new StringBuilder();
        inp.entrySet().forEach(s -> {
            switch (s.getValue().get(0)) {
                case "change" -> {
                    result.append("Property '" + s.getKey()
                            + "' was updated. From "
                            + getFormatiingString(s.getValue().get(2)) + " to "
                            + getFormatiingString(s.getValue().get(1))
                            + "\n");
                }
                case "add" -> {
                    result.append("Property '" + s.getKey()
                            + "' was added with value: "
                            + getFormatiingString(s.getValue().get(1)) + "\n");
                }
                case "del" -> {
                    result.append("Property '" + s.getKey()
                            + "' was removed"
                            + "\n");
                }
                default -> {
                    result.append("");
                }
            }
        });
        String res = result.toString();
        res = res.substring(0, res.length() - 1);
        return res;
    }

    public static String getFormatiingString(String value) {
        String str = "";
        if (value.contains("[") || value.contains("{")) {
            str = "[complex value]";
        } else if (value.contains("\"")) {
            str = value.replaceAll("\"", "'").replaceAll(",", ", ").replace(
                    ":", "=");
        } else {
            str = value.replaceAll(",", ", ").replace(":", "=");
        }
        return str;
    }
}
