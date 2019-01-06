
package de.newsh.TitleJsonStructure;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonData {

    @SerializedName("age_limit")
    @Expose
    private Long ageLimit;
    @SerializedName("bucket")
    @Expose
    private String bucket;
    @SerializedName("cloud_only_platform")
    @Expose
    private List<String> cloudOnlyPlatform = null;
    @SerializedName("container_type")
    @Expose
    private String containerType;
    @SerializedName("content_descriptors")
    @Expose
    private List<ContentDescriptor> contentDescriptors = null;
    @SerializedName("content_origin")
    @Expose
    private Long contentOrigin;
    @SerializedName("content_rating")
    @Expose
    private ContentRating contentRating;
    @SerializedName("content_type")
    @Expose
    private String contentType;
    @SerializedName("default_sku")
    @Expose
    private DefaultSku defaultSku;
    @SerializedName("dob_required")
    @Expose
    private Boolean dobRequired;
    @SerializedName("gameContentTypesList")
    @Expose
    private List<GameContentTypesList> gameContentTypesList = null;
    @SerializedName("game_contentType")
    @Expose
    private String gameContentType;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("links")
    @Expose
    private List<Object> links = null;
    @SerializedName("long_desc")
    @Expose
    private String longDesc;
    @SerializedName("media_layouts")
    @Expose
    private List<MediaLayout> mediaLayouts = null;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("pageTypeId")
    @Expose
    private Long pageTypeId;
    @SerializedName("playable_platform")
    @Expose
    private List<String> playablePlatform = null;
    @SerializedName("promomedia")
    @Expose
    private List<Promomedium> promomedia = null;
    @SerializedName("provider_name")
    @Expose
    private String providerName;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("restricted")
    @Expose
    private Boolean restricted;
    @SerializedName("revision")
    @Expose
    private Long revision;
    @SerializedName("short_name")
    @Expose
    private String shortName;
    @SerializedName("size")
    @Expose
    private Long size;
    @SerializedName("sku_links")
    @Expose
    private List<Object> skuLinks = null;
    @SerializedName("skus")
    @Expose
    private List<Sku> skus = null;
    @SerializedName("star_rating")
    @Expose
    private StarRating starRating;
    @SerializedName("start")
    @Expose
    private Long start;
    @SerializedName("timestamp")
    @Expose
    private Long timestamp;
    @SerializedName("title_name")
    @Expose
    private String titleName;
    @SerializedName("top_category")
    @Expose
    private String topCategory;
    @SerializedName("total_results")
    @Expose
    private Long totalResults;

    public Long getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(Long ageLimit) {
        this.ageLimit = ageLimit;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public List<String> getCloudOnlyPlatform() {
        return cloudOnlyPlatform;
    }

    public void setCloudOnlyPlatform(List<String> cloudOnlyPlatform) {
        this.cloudOnlyPlatform = cloudOnlyPlatform;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public List<ContentDescriptor> getContentDescriptors() {
        return contentDescriptors;
    }

    public void setContentDescriptors(List<ContentDescriptor> contentDescriptors) {
        this.contentDescriptors = contentDescriptors;
    }

    public Long getContentOrigin() {
        return contentOrigin;
    }

    public void setContentOrigin(Long contentOrigin) {
        this.contentOrigin = contentOrigin;
    }

    public ContentRating getContentRating() {
        return contentRating;
    }

    public void setContentRating(ContentRating contentRating) {
        this.contentRating = contentRating;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public DefaultSku getDefaultSku() {
        return defaultSku;
    }

    public void setDefaultSku(DefaultSku defaultSku) {
        this.defaultSku = defaultSku;
    }

    public Boolean getDobRequired() {
        return dobRequired;
    }

    public void setDobRequired(Boolean dobRequired) {
        this.dobRequired = dobRequired;
    }

    public List<GameContentTypesList> getGameContentTypesList() {
        return gameContentTypesList;
    }

    public void setGameContentTypesList(List<GameContentTypesList> gameContentTypesList) {
        this.gameContentTypesList = gameContentTypesList;
    }

    public String getGameContentType() {
        return gameContentType;
    }

    public void setGameContentType(String gameContentType) {
        this.gameContentType = gameContentType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public List<MediaLayout> getMediaLayouts() {
        return mediaLayouts;
    }

    public void setMediaLayouts(List<MediaLayout> mediaLayouts) {
        this.mediaLayouts = mediaLayouts;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPageTypeId() {
        return pageTypeId;
    }

    public void setPageTypeId(Long pageTypeId) {
        this.pageTypeId = pageTypeId;
    }

    public List<String> getPlayablePlatform() {
        return playablePlatform;
    }

    public void setPlayablePlatform(List<String> playablePlatform) {
        this.playablePlatform = playablePlatform;
    }

    public List<Promomedium> getPromomedia() {
        return promomedia;
    }

    public void setPromomedia(List<Promomedium> promomedia) {
        this.promomedia = promomedia;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getRestricted() {
        return restricted;
    }

    public void setRestricted(Boolean restricted) {
        this.restricted = restricted;
    }

    public Long getRevision() {
        return revision;
    }

    public void setRevision(Long revision) {
        this.revision = revision;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public List<Object> getSkuLinks() {
        return skuLinks;
    }

    public void setSkuLinks(List<Object> skuLinks) {
        this.skuLinks = skuLinks;
    }

    public List<Sku> getSkus() {
        return skus;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }

    public StarRating getStarRating() {
        return starRating;
    }

    public void setStarRating(StarRating starRating) {
        this.starRating = starRating;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getTopCategory() {
        return topCategory;
    }

    public void setTopCategory(String topCategory) {
        this.topCategory = topCategory;
    }

    public Long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Long totalResults) {
        this.totalResults = totalResults;
    }

}
