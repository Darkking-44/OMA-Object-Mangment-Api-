import java.util.*;

public class ObjectNameSystem {
    private static Set<String> usedIds = new HashSet<>();
    private static Map<String, Object> objectRegistry = new HashMap<>();

    public static String registerNewId(String typ) {
        String prefix;
        switch (typ) {
            case "group": prefix = "g-"; break;
            case "object": prefix = "o-"; break;
            default: prefix = "external-"; break;
        }

        int counter = 1;
        String newId;
        do {
            newId = prefix + counter;
            counter++;
        } while (usedIds.contains(newId));

        usedIds.add(newId);
        return newId;
    }

    public static void registerObject(String id, Object obj) {
        objectRegistry.put(id, obj);
    }

    public static Object getObject(String id) {
        return objectRegistry.get(id);
    }

    public static void deleteID(String id) {
        usedIds.remove(id);
        objectRegistry.remove(id);
    }
}
