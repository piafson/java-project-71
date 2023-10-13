package hexlet.code.formatters;

import java.util.Map;
import java.util.List;
public class Stylish {
    public static String formatting(Map<String, List<String>> inp) {
        StringBuilder result = new StringBuilder("{\n");
        final String add = "  + ";
        final String unchanged = "    ";
        final String del = "  - ";

        inp.entrySet().forEach(s -> {
            switch (s.getValue().get(0)) {
                case "unchanged" -> {
                    result.append(unchanged + getFormatiingString(s.getKey(),
                            s.getValue().get(1)));
                }
                case "change" -> {
                    result.append(del + getFormatiingString(s.getKey(),
                            s.getValue().get(2)));
                    result.append(add + getFormatiingString(s.getKey(),
                            s.getValue().get(1)));
                }
                case "add" -> {
                    result.append(add + getFormatiingString(s.getKey(),
                            s.getValue().get(1)));
                }
                default -> {
                    result.append(del + getFormatiingString(s.getKey(),
                            s.getValue().get(1)));
                }
            }
        });
        result.append("}");
        return result.toString();
    }
    public static String getFormatiingString(String key, String value) {
        String formattingString = "";
        if (value.contains("{")) {
            formattingString = key.split(" ")[0] + ": "
                    + value
                    .replaceAll("\"", "")
                    .replaceAll(",", ", ")
                    .replace(":", "=")
                    + "\n";
        } else {
            formattingString = key.split(" ")[0] + ": "
                    + value.replaceAll("\"", "").replaceAll(
                    ",", ", ")
                    + "\n";
        }
        return formattingString;
    }
}
