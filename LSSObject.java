/**
 * Represents a secured key–value object with internal ID management.
 * Each instance receives a unique object ID (preId) and can be assigned a group-based post ID.
 * Access to the value is restricted via a key comparison.
 */
public class LSSObject {

    /** Immutable key used to authorize access to the value. */
    private final String objectKey;

    /** The value stored in this object. */
    private String objectValue;

    /** Unique object ID assigned by the system. */
    private String preId;

    /** Optional group-based identifier (e.g. "2.3"). */
    private String postId;
    /** compress true to apply GZIP compression to objectValue, false to store it as-is */
    private Boolean compress;

    /**
     * Constructs a new object with a specific key and initial value.
     *
     * @param objectKey   the access key for this object
     * @param objectValue the initial value to store
     * @param compress true to apply GZIP compression to objectValue, false to store it as-is
     */
    public LSSObject(String objectKey, String objectValue,Boolean compress) {
        this.objectKey = objectKey;
        this.compress = compress;
        if(!this.compress) {
            this.objectValue = objectValue;
        } else {
            this.objectValue = Compressor.stringToGzip(objectValue);
        }
        this.preId = ObjectNameSystem.registerNewId("object");
    }
    /**
     * Constructs with compress = false
     */
    public LSSObject(String objectKey, String objectValue) {
        this(objectKey, objectValue,false);
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
     * @param objectKey   the key to verify access
     * @param objectValue the new value to store
     */
    public void setObjektValue(String objectKey, String objectValue) {
        if (this.objectKey.equals(objectKey)) {
            if(!this.compress) {
                this.objectValue = objectValue;
            } else {
                this.objectValue = Compressor.stringToGzip(objectValue);
            }
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
        if(this.objectKey.equals(objektKey)) {
            if(!this.compress) {
                return this.objectValue;
            } else {
                return Compressor.gzipToString(objectValue);
            }
        }else {
            return "Access denied: key mismatch.";
        }
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
