package V0

/**
 * Represents a secured key–value object with internal ID management.
 * Each instance receives a unique object ID (preId) and can be assigned a group-based post ID.
 * Access to the value is restricted via a key comparison.
 */
public class LSSObject {

    /** Immutable key used to authorize access to the value. */
    private final String objektKey;

    /** The value stored in this object. */
    private String objektValue;

    /** Unique object ID assigned by the system. */
    private String preId;

    /** Optional group-based identifier (e.g. "2.3"). */
    private String postId;

    /**
     * Constructs a new object with a specific key and initial value.
     *
     * @param objektKey   the access key for this object
     * @param objektValue the initial value to store
     */
    public LSSObject(String objektKey, String objektValue) {
        this.objektKey = objektKey;
        this.objektValue = objektValue;
        this.preId = ObjectNameSystem.registerNewId("object");
    }

    /**
     * Constructs a default object with key "1234" and value "No Value!".
     */
    public LSSObject() {
        this("1234", "No Value!");
    }

    /**
     * Updates the stored value if the provided key matches the internal key.
     *
     * @param objektKey   the key to verify access
     * @param objektValue the new value to store
     */
    public void setObjektValue(String objektKey, String objektValue) {
        if (this.objektKey.equals(objektKey)) {
            this.objektValue = objektValue;
        } else {
            System.out.println("Access denied: key mismatch.");
        }
    }

    /**
     * Retrieves the stored value if the provided key matches.
     *
     * @param objektKey the key to verify access
     * @return the stored value, or an error message if access is denied
     */
    public String getObjektValue(String objektKey) {
        return this.objektKey.equals(objektKey)
                ? this.objektValue
                : "Access denied: key mismatch.";
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
