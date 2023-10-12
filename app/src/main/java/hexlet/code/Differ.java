package hexlet.code;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

import static hexlet.code.Parser.getObj;

public class Differ {
    public static String generate(String filePath1, String filePath2, String formatName)
            throws IOException {
        Map<String, Object> mapJson1 = readObj(filePath1);
        Map<String, Object> mapJson2 = readObj(filePath2);

        return Formatter.getFormStr(DiffBuilder.buildDiff(mapJson1, mapJson2),
                formatName);
    }
    public static String generate(String filePath1, String filePath2) throws IOException {
        return generate(filePath1, filePath2, "stylish");
    }
    public static TreeMap<String, Object> readObj(String filePath)
            throws IOException {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        String extension = filePath.substring(filePath.lastIndexOf(".") + 1);
        String pathStr = new String(Files.readAllBytes(path));
        JsonNode objNode = getObj(extension).readTree(pathStr);
        TreeMap<String, Object> mapObj = new TreeMap<>();
        objNode.fieldNames().forEachRemaining(
                s -> {
                    mapObj.put(s, objNode.get(s));
                });
        return mapObj;
    }
}
