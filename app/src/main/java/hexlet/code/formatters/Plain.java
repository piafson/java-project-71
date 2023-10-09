package hexlet.code.formatters;

import java.util.Map;

public class Plain {
    public static String formatting(Map<String, String> inp) {
        StringBuilder result = new StringBuilder();
        inp.entrySet().forEach(s -> {
            if (s.getKey()
                    .substring(s.getKey().lastIndexOf(" ") + 1)
                    .equals("1change")) {
                result.append("Property '" + s.getKey().split(" ")[0]
                        + "' was updated. From " + getFormatiingString(s.getValue())
                        + " to "
                        + getFormatiingString(
                        inp.get(s.getKey().split(" ")[0] + " 2change"))
                        + "\n");
            } else if (s.getKey()
                    .substring(s.getKey().lastIndexOf(" ") + 1)
                    .equals("add")) {
                result.append("Property '" + s.getKey().split(" ")[0]
                        + "' was added with value: "
                        + getFormatiingString(s.getValue()) + "\n");
            } else if (s.getKey()
                    .substring(s.getKey().lastIndexOf(" ") + 1)
                    .equals("del")) {
                result.append("Property '" + s.getKey().split(" ")[0]
                        + "' was removed"
                        + "\n");
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
