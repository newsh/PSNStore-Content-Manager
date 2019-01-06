
package de.newsh.TitleJsonStructure;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Drm___ {

    @SerializedName("drm_category_type")
    @Expose
    private Long drmCategoryType;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("is_streamable")
    @Expose
    private Long isStreamable;
    @SerializedName("media_prop")
    @Expose
    private MediaProp_ mediaProp;
    @SerializedName("size")
    @Expose
    private Long size;
    @SerializedName("type")
    @Expose
    private Long type;

    public Long getDrmCategoryType() {
        return drmCategoryType;
    }

    public void setDrmCategoryType(Long drmCategoryType) {
        this.drmCategoryType = drmCategoryType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getIsStreamable() {
        return isStreamable;
    }

    public void setIsStreamable(Long isStreamable) {
        this.isStreamable = isStreamable;
    }

    public MediaProp_ getMediaProp() {
        return mediaProp;
    }

    public void setMediaProp(MediaProp_ mediaProp) {
        this.mediaProp = mediaProp;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

}
