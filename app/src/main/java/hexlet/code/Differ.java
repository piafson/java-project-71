package hexlet.code;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Differ {
    public static String generate(String filePath1, String filePath2, String formatName)
            throws IOException {
        Map<String, Object> mapJson1 = Parser.readObj(filePath1);
        Map<String, Object> mapJson2 = Parser.readObj(filePath2);
        Map<String, String> res = new TreeMap<>();

        Stream
                .concat(mapJson1.entrySet().stream(), mapJson2.entrySet().stream())
                .forEachOrdered(s -> {
                    if (mapJson1.containsKey(s.getKey())
                            && !mapJson2.containsKey(s.getKey())) {
                        res.put(s.getKey() + " del", s.getValue().toString());

                    } else if (!mapJson1.containsKey(s.getKey())
                            && mapJson2.containsKey(s.getKey())) {
                        res.put(s.getKey() + " add", s.getValue().toString());

                    } else if (Objects.equals(mapJson1.get(s.getKey()),
                            mapJson2.get(s.getKey()))) {
                        res.put(s.getKey() + " unch", s.getValue().toString());

                    } else if (!s.getValue().equals(mapJson2.get(s.getKey()))) {
                        res.put(s.getKey() + " 1change", s.getValue().toString());
                    } else {
                        res.put(s.getKey() + " 2change", s.getValue().toString());
                    }
                });
        //return Stylish.formatting(res);
        //return Plain.formatting(res);
        return Formatter.getFormStr(res, formatName);
    }
}
