
package de.newsh.TitleJsonStructure;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entitlement_ {

    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("drms")
    @Expose
    private List<Drm___> drms = null;
    @SerializedName("duration")
    @Expose
    private Long duration;
    @SerializedName("durationOverrideTypeId")
    @Expose
    private Object durationOverrideTypeId;
    @SerializedName("exp_after_first_use")
    @Expose
    private Long expAfterFirstUse;
    @SerializedName("feature_type_id")
    @Expose
    private Long featureTypeId;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("license_type")
    @Expose
    private Long licenseType;
    @SerializedName("metadata")
    @Expose
    private Object metadata;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("packageType")
    @Expose
    private Object packageType;
    @SerializedName("packages")
    @Expose
    private List<Object> packages = null;
    @SerializedName("preorder_placeholder_flag")
    @Expose
    private Boolean preorderPlaceholderFlag;
    @SerializedName("size")
    @Expose
    private Long size;
    @SerializedName("subType")
    @Expose
    private Long subType;
    @SerializedName("subtitle_language_codes")
    @Expose
    private Object subtitleLanguageCodes;
    @SerializedName("type")
    @Expose
    private Long type;
    @SerializedName("use_count")
    @Expose
    private Long useCount;
    @SerializedName("voice_language_codes")
    @Expose
    private Object voiceLanguageCodes;

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public List<Drm___> getDrms() {
        return drms;
    }

    public void setDrms(List<Drm___> drms) {
        this.drms = drms;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Object getDurationOverrideTypeId() {
        return durationOverrideTypeId;
    }

    public void setDurationOverrideTypeId(Object durationOverrideTypeId) {
        this.durationOverrideTypeId = durationOverrideTypeId;
    }

    public Long getExpAfterFirstUse() {
        return expAfterFirstUse;
    }

    public void setExpAfterFirstUse(Long expAfterFirstUse) {
        this.expAfterFirstUse = expAfterFirstUse;
    }

    public Long getFeatureTypeId() {
        return featureTypeId;
    }

    public void setFeatureTypeId(Long featureTypeId) {
        this.featureTypeId = featureTypeId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(Long licenseType) {
        this.licenseType = licenseType;
    }

    public Object getMetadata() {
        return metadata;
    }

    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getPackageType() {
        return packageType;
    }

    public void setPackageType(Object packageType) {
        this.packageType = packageType;
    }

    public List<Object> getPackages() {
        return packages;
    }

    public void setPackages(List<Object> packages) {
        this.packages = packages;
    }

    public Boolean getPreorderPlaceholderFlag() {
        return preorderPlaceholderFlag;
    }

    public void setPreorderPlaceholderFlag(Boolean preorderPlaceholderFlag) {
        this.preorderPlaceholderFlag = preorderPlaceholderFlag;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getSubType() {
        return subType;
    }

    public void setSubType(Long subType) {
        this.subType = subType;
    }

    public Object getSubtitleLanguageCodes() {
        return subtitleLanguageCodes;
    }

    public void setSubtitleLanguageCodes(Object subtitleLanguageCodes) {
        this.subtitleLanguageCodes = subtitleLanguageCodes;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getUseCount() {
        return useCount;
    }

    public void setUseCount(Long useCount) {
        this.useCount = useCount;
    }

    public Object getVoiceLanguageCodes() {
        return voiceLanguageCodes;
    }

    public void setVoiceLanguageCodes(Object voiceLanguageCodes) {
        this.voiceLanguageCodes = voiceLanguageCodes;
    }

}
