package V0

import java.util.HashSet;
import java.util.Set;

public class ObjectNameSystem {
    private static Set<String> usedIds = new HashSet<>();
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
    public static void deleteID(String ID) {
        usedIds.remove(ID);
    }
}
