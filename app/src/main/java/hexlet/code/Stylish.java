package hexlet.code;

import java.util.Map;
public class Stylish {
    public static String formatting(Map<String, String> inp) {
        StringBuilder result = new StringBuilder("{\n");
        final String add = "  + ";
        final String unchanged = "    ";
        final String del = "  - ";
        inp.entrySet().forEach(s -> {
            if (s.getKey()
                    .substring(s.getKey().lastIndexOf(" ") + 1)
                    .equals("unch")) {
                result.append(unchanged + getFormatiingString(s.getKey(), s.getValue()));
            } else if (s.getKey()
                    .substring(s.getKey().lastIndexOf(" ") + 1)
                    .equals("1change")) {
                result.append(del + getFormatiingString(s.getKey(), s.getValue()));
            } else if (s.getKey()
                    .substring(s.getKey().lastIndexOf(" ") + 1)
                    .equals("2change")) {
                result.append(add + getFormatiingString(s.getKey(), s.getValue()));
            } else if (s.getKey()
                    .substring(s.getKey().lastIndexOf(" ") + 1)
                    .equals("add")) {
                result.append(add + getFormatiingString(s.getKey(), s.getValue()));
            } else {
                result.append(del + getFormatiingString(s.getKey(), s.getValue()));
            }
        });
        return result + "}";
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
