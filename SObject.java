/**
 * Represents a simple object with a value and internal ID management.
 * Each instance receives a unique object ID (preId) and can be assigned a group-based post ID.
 */
public class SObject {

    /** The value stored in this object. */
    private String objectValue;

    /** Unique object ID assigned by the system. */
    private String preId;

    /** Optional group-based identifier (e.g. "2.3"). */
    private String postId;
    /** compress true to apply GZIP compression to objectValue, false to store it as-is */
    private Boolean compress;

    /**
     * Constructs a new object with the specified value.
     *
     * @param objectValue the initial value to store
     * @param compress true to apply GZIP compression to objectValue, false to store it as-is
     */
    public SObject(String objectValue,Boolean compress) {
        this.compress = compress;
        if(!this.compress) {
            this.objectValue = objectValue;
        } else {
            this.objectValue = Compressor.stringToGzip(objectValue);
        }
        this.preId = ObjectNameSystem.registerNewId("object");
    }
    //Constructs with compress = false
    public SObject(String objectValue) {
        this(objectValue,false);
    }
    /**
     * Constructs a default object with value "No Value!".
     */
    public SObject() {
        this("No Value!",false);
    }

    /**
     * Updates the stored value.
     *
     * @param objectValue the new value to store
     */
    public void setObjectValue(String objectValue) {
        if(!this.compress) {
            this.objectValue = objectValue;
        } else {
            this.objectValue = Compressor.stringToGzip(objectValue);
        }
    }

    /**
     * Returns the stored value.
     *
     * @return the object's value
     */
    public String getObjectValue() {
        if(!this.compress) {
            return this.objectValue;
        } else {
            return Compressor.gzipToString(objectValue);
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
