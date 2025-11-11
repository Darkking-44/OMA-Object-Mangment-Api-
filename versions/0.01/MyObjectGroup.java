/**
 * Represents a group of {@link LSSObject} instances.
 * Each group receives a unique group ID (preId),
 * and every object within the group gets an additional post ID in the format "groupID.objectNumber".
 *
 * Example: groupID = 2 → object IDs become 2.1, 2.2, 2.3, ...
 */
public class MyObjectGroup {

    /** Array of all MyObject instances in this group. */
    private LSSObject[] lssObjects;

    /** Static counter that tracks how many group IDs have been created globally. */
    private String Id;

    /**
     * Constructs a new group of MyObjects.
     * Each group gets a unique preId, and all contained objects receive post IDs.
     *
     * @param lssObjects the array of MyObject instances that belong to this group
     * @throws RuntimeException if the maximum number of groups (128) has been reached
     */
    public MyObjectGroup(LSSObject[] lssObjects) {
        this.lssObjects = lssObjects;
        this.Id = ObjectNameSystem.registerNewId("group");

        // Assign unique post IDs to all objects in the group
        for (LSSObject lssObject : lssObjects) {
            lssObject.setPostId(this.Id + "." + lssObject.getPreId());
        }
    }
}
