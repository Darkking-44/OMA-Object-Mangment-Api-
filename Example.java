/**
 * AI-generated Example
 */
public class Example {
    public static void main(String[] args) {
        // Create LSSObject instances with fixed keys and values and compress
        LSSObject obj1 = new LSSObject("keyA", "Alpha",false);
        LSSObject obj2 = new LSSObject("keyB", "Bravo",true);
        LSSObject obj3 = new LSSObject("keyC", "Charlie",true);
        LSSObject obj4 = new LSSObject("keyD", "Delta",true);
        LSSObject obj5 = new LSSObject("keyE", "Echo",false);

        // Group them into arrays
        LSSObject[] group1 = { obj1, obj2, obj3 };
        LSSObject[] group2 = { obj4, obj5 };

        // Assign post IDs via MyObjectGroup
        MyObjectGroup g1 = new MyObjectGroup(group1);
        MyObjectGroup g2 = new MyObjectGroup(group2);

        // Print full details for group 1
        System.out.println("Group 1:");
        System.out.println(obj1.getPreId() + " | " + obj1.getPostId() + " | " + obj1.getObjektValue("keyA"));
        System.out.println(obj2.getPreId() + " | " + obj2.getPostId() + " | " + obj2.getObjektValue("keyB"));
        System.out.println(obj3.getPreId() + " | " + obj3.getPostId() + " | " + obj3.getObjektValue("keyC"));

        // Print full details for group 2
        System.out.println("\nGroup 2:");
        System.out.println(obj4.getPreId() + " | " + obj4.getPostId() + " | " + obj4.getObjektValue("keyD"));
        System.out.println(obj5.getPreId() + " | " + obj5.getPostId() + " | " + obj5.getObjektValue("keyE"));
    }
}
