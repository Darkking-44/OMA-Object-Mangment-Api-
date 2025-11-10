/**
 * Represents a group of {@link MyObject} instances.
 * Each group receives a unique group ID (preId),
 * and every object within the group gets an additional post ID in the format "groupID.objectNumber".
 *
 * Example: groupID = 2 → object IDs become 2.1, 2.2, 2.3, ...
 */
public class MyObjectGroup {

    /** Array of all MyObject instances in this group. */
    private MyObject[] myObjects;

    /** The unique ID of this group. */
    private int preId;

    /** Static counter that tracks how many group IDs have been created globally. */
    private static int servedGroupIDs;

    /** Local counter for the number of objects inside this group. */
    private int servedIDs;

    /**
     * Constructs a new group of MyObjects.
     * Each group gets a unique preId, and all contained objects receive post IDs.
     *
     * @param myObjects the array of MyObject instances that belong to this group
     * @throws RuntimeException if the maximum number of groups (128) has been reached
     */
    public MyObjectGroup(MyObject[] myObjects) {
        if (servedGroupIDs < 129) {
            this.myObjects = myObjects;
            this.preId = ++servedGroupIDs;

            // Assign unique post IDs to all objects in the group
            for (MyObject myObject : myObjects) {
                String buildPostId = this.preId + "." + (++this.servedIDs);
                myObject.setPostId(this.preId, buildPostId);
            }
        } else {
            throw new RuntimeException("Not All IDs For Groups Are Served!");
        }
    }
}
