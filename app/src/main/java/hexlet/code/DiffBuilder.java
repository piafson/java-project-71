package hexlet.code;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Stream;
import java.util.List;
public class DiffBuilder {
    public static Map<String, List<String>> buildDiff(Map<String, Object> inp1,
                                                Map<String, Object> inp2) {
        Map<String, List<String>> result = new TreeMap<>();
        Stream
                .concat(inp1.entrySet().stream(), inp2.entrySet().stream())
                .forEachOrdered(s -> {
                    if (inp1.containsKey(s.getKey())
                            && !inp2.containsKey(s.getKey())) {
                        result.put(s.getKey(), List.of("del", s.getValue().toString()));

                    } else if (!inp1.containsKey(s.getKey())
                            && inp2.containsKey(s.getKey())) {
                        result.put(s.getKey(), List.of("add", s.getValue().toString()));

                    } else if (Objects.equals(inp1.get(s.getKey()),
                            inp2.get(s.getKey()))) {
                        result.put(s.getKey(), List.of("unchanged", s.getValue().toString()));

                    } else {
                        result.put(s.getKey(), List.of("change", s.getValue().toString(),
                                inp1.get(s.getKey()).toString()));

                    }

                });
        return result;
    }
}
