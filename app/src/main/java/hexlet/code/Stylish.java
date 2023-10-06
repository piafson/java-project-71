package hexlet.code;

import java.util.Map;
public class Stylish {
    public static String formatting(Map<String, String> inp) {
        StringBuilder result = new StringBuilder("{\n");
        inp.entrySet().forEach(s -> {
            String sub = " }";
            if (s.getKey()
                    .substring(s.getKey().lastIndexOf(" ") + 1)
                    .equals("unch")) {
                if (s.getValue().contains("{")) {
                    result.append("    " + s.getKey().split(" ")[0] + ": "
                            + s.getValue()
                            .replaceAll("\"", "")
                            .replaceAll(",", ", ")
                            .replace(":", "=")
                            + "\n");
                } else {
                    result.append("    " + s.getKey().split(" ")[0] + ": "
                            + s.getValue().replaceAll("\"", "").replaceAll(
                            ",", ", ")
                            + "\n");
                }
            } else if (s.getKey()
                    .substring(s.getKey().lastIndexOf(" ") + 1)
                    .equals("1change")) {
                if (s.getValue().contains("{")) {
                    result.append("  - " + s.getKey().split(" ")[0] + ": "
                            + s.getValue()
                            .replaceAll("\"", "")
                            .replaceAll(",", ", ")
                            .replace(":", "=")
                            + "\n");
                } else {
                    result.append("  - " + s.getKey().split(" ")[0] + ": "
                            + s.getValue().replaceAll("\"", "").replaceAll(
                            ",", ", ")
                            + "\n");
                }
            } else if (s.getKey()
                    .substring(s.getKey().lastIndexOf(" ") + 1)
                    .equals("2change")) {
                if (s.getValue().contains("{")) {
                    result.append("  + " + s.getKey().split(" ")[0] + ": "
                            + s.getValue()
                            .replaceAll("\"", "")
                            .replaceAll(",", ", ")
                            .replace(":", "=")
                            + "\n");
                } else {
                    result.append("  + " + s.getKey().split(" ")[0] + ": "
                            + s.getValue().replaceAll("\"", "").replaceAll(
                            ",", ", ")
                            + "\n");
                }
            } else if (s.getKey()
                    .substring(s.getKey().lastIndexOf(" ") + 1)
                    .equals("add")) {
                if (s.getValue().contains("{")) {
                    result.append("  + " + s.getKey().split(" ")[0] + ": "
                            + s.getValue()
                            .replaceAll("\"", "")
                            .replaceAll(",", ", ")
                            .replace(":", "=")
                            + "\n");
                } else {
                    result.append("  + " + s.getKey().split(" ")[0] + ": "
                            + s.getValue().replaceAll("\"", "").replaceAll(
                            ",", ", ")
                            + "\n");
                }
            } else {
                if (s.getValue().contains("{")) {
                    result.append("  - " + s.getKey().split(" ")[0] + ": "
                            + s.getValue()
                            .replaceAll("\"", "")
                            .replaceAll(",", ", ")
                            .replace(":", "=")
                            + "\n");
                } else {
                    result.append("  - " + s.getKey().split(" ")[0] + ": "
                            + s.getValue().replaceAll("\"", "").replaceAll(
                            ",", ", ")
                            + "\n");
                }
            }
        });
        return result + "}";
    }
}
