package V0

/**
 * Represents a simple object with a value and internal ID management.
 * Each instance receives a unique object ID (preId) and can be assigned a group-based post ID.
 */
public class SObject {

    /** The value stored in this object. */
    private String objektValue;

    /** Unique object ID assigned by the system. */
    private String preId;

    /** Optional group-based identifier (e.g. "2.3"). */
    private String postId;

    /**
     * Constructs a new object with the specified value.
     *
     * @param objektValue the initial value to store
     */
    public SObject(String objektValue) {
        this.objektValue = objektValue;
        this.preId = ObjectNameSystem.registerNewId("object");
    }

    /**
     * Constructs a default object with value "No Value!".
     */
    public SObject() {
        this("No Value!");
    }

    /**
     * Updates the stored value.
     *
     * @param objektValue the new value to store
     */
    public void setObjektValue(String objektValue) {
        this.objektValue = objektValue;
    }

    /**
     * Returns the stored value.
     *
     * @return the object's value
     */
    public String getObjektValue() {
        return this.objektValue;
    }

    /**
     * Returns the system-assigned unique object ID.
     *
     * @return the object's preId
     */
    public String getPreId() {
        return this.preId;
    }

    /**
     * Assigns a group-based post ID to this object.
     *
     * @param postId the post ID to assign (e.g. "1.2")
     */
    public void setPostId(String postId) {
        this.postId = postId;
    }

    /**
     * Returns the assigned post ID, if any.
     *
     * @return the postId or null if not set
     */
    public String getPostId() {
        return this.postId;
    }
}
