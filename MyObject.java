/**
 * Represents an object with a key–value pair and internal ID management.
 * Each object has a unique numeric ID (preId) and may receive a group-based postId.
 * The key must match when modifying or retrieving the value.
 */
public class MyObject {

    /** The internal key that controls access to the value. */
    private final String objektKey;

    /** The stored value of this object. */
    private String objektValue;

    /** The automatically assigned unique object ID. */
    private int preId;

    /** The optional group-based post ID (e.g. "2.3"). */
    private String postId;

    /** Global counter for how many objects have been created. */
    private static int servedIDs = 128;

    /**
     * Creates a new MyObject with a specific key and value.
     *
     * @param objektKey   the key that identifies or secures the object
     * @param objektValue the initial value stored in the object
     */
    public MyObject(String objektKey, String objektValue) {
        this.objektKey = objektKey;
        this.objektValue = objektValue;
        this.preId = ++servedIDs;
    }

    /**
     * Creates a default MyObject with key "1234" and value "No Value!".
     */
    public MyObject() {
        this("1234", "No Value!");
    }

    /**
     * Sets a new value only if the given key matches the object's key.
     *
     * @param objektKey   the key to verify access
     * @param objektValue the new value to set
     */
    public void setObjektValue(String objektKey, String objektValue) {
        if (this.objektKey.equals(objektKey)) {
            this.objektValue = objektValue;
        } else {
            System.out.println("Objekt key does not match!");
        }
    }

    /**
     * Returns the stored value if the provided key matches.
     * Otherwise, returns a warning message.
     *
     * @param objektKey the key used for access verification
     * @return the stored value or an error message if the key does not match
     */
    public String getObjektValue(String objektKey) {
        return this.objektKey.equals(objektKey)
                ? this.objektValue
                : "Objekt key does not match!";
    }

    /**
     * Returns this object's unique numeric ID.
     *
     * @return the preId of this object
     */
    public int getObjektID() {
        return this.preId;
    }

    /**
     * Returns the current global count of created objects.
     *
     * @return the number of served IDs so far
     */
    public int servedIDs() {
        return servedIDs;
    }

    /**
     * Sets a post ID for this object if the provided group ID is valid.
     * The post ID is typically used for grouping objects.
     *
     * @param id     the ID of the group assigning this post ID
     * @param postId the post ID string to set (e.g. "1.2")
     */
    public void setPostId(int id, String postId) {
        if (id < 128) {
            this.postId = postId;
        } else {
            System.out.println("Function only for groups with right ID!");
        }
    }

    /**
     * Returns this object's post ID.
     *
     * @return the postId or null if not assigned
     */
    public String getPostId() {
        return this.postId;
    }
}
