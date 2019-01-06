
package de.newsh.TitleJsonStructure;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sku {

    @SerializedName("amortizeFlag")
    @Expose
    private Boolean amortizeFlag;
    @SerializedName("bundleExclusiveFlag")
    @Expose
    private Boolean bundleExclusiveFlag;
    @SerializedName("chargeImmediatelyFlag")
    @Expose
    private Boolean chargeImmediatelyFlag;
    @SerializedName("charge_type_id")
    @Expose
    private Long chargeTypeId;
    @SerializedName("credit_card_required_flag")
    @Expose
    private Long creditCardRequiredFlag;
    @SerializedName("defaultSku")
    @Expose
    private Boolean defaultSku;
    @SerializedName("display_price")
    @Expose
    private String displayPrice;
    @SerializedName("eligibilities")
    @Expose
    private List<Eligibility_> eligibilities = null;
    @SerializedName("entitlements")
    @Expose
    private List<Entitlement_> entitlements = null;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("is_original")
    @Expose
    private Boolean isOriginal;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("platforms")
    @Expose
    private List<Long> platforms = null;
    @SerializedName("price")
    @Expose
    private Long price;
    @SerializedName("rewards")
    @Expose
    private List<Object> rewards = null;
    @SerializedName("seasonPassExclusiveFlag")
    @Expose
    private Boolean seasonPassExclusiveFlag;
    @SerializedName("skuAvailabilityOverrideFlag")
    @Expose
    private Boolean skuAvailabilityOverrideFlag;
    @SerializedName("sku_type")
    @Expose
    private Long skuType;
    @SerializedName("type")
    @Expose
    private String type;

    public Boolean getAmortizeFlag() {
        return amortizeFlag;
    }

    public void setAmortizeFlag(Boolean amortizeFlag) {
        this.amortizeFlag = amortizeFlag;
    }

    public Boolean getBundleExclusiveFlag() {
        return bundleExclusiveFlag;
    }

    public void setBundleExclusiveFlag(Boolean bundleExclusiveFlag) {
        this.bundleExclusiveFlag = bundleExclusiveFlag;
    }

    public Boolean getChargeImmediatelyFlag() {
        return chargeImmediatelyFlag;
    }

    public void setChargeImmediatelyFlag(Boolean chargeImmediatelyFlag) {
        this.chargeImmediatelyFlag = chargeImmediatelyFlag;
    }

    public Long getChargeTypeId() {
        return chargeTypeId;
    }

    public void setChargeTypeId(Long chargeTypeId) {
        this.chargeTypeId = chargeTypeId;
    }

    public Long getCreditCardRequiredFlag() {
        return creditCardRequiredFlag;
    }

    public void setCreditCardRequiredFlag(Long creditCardRequiredFlag) {
        this.creditCardRequiredFlag = creditCardRequiredFlag;
    }

    public Boolean getDefaultSku() {
        return defaultSku;
    }

    public void setDefaultSku(Boolean defaultSku) {
        this.defaultSku = defaultSku;
    }

    public String getDisplayPrice() {
        return displayPrice;
    }

    public void setDisplayPrice(String displayPrice) {
        this.displayPrice = displayPrice;
    }

    public List<Eligibility_> getEligibilities() {
        return eligibilities;
    }

    public void setEligibilities(List<Eligibility_> eligibilities) {
        this.eligibilities = eligibilities;
    }

    public List<Entitlement_> getEntitlements() {
        return entitlements;
    }

    public void setEntitlements(List<Entitlement_> entitlements) {
        this.entitlements = entitlements;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getIsOriginal() {
        return isOriginal;
    }

    public void setIsOriginal(Boolean isOriginal) {
        this.isOriginal = isOriginal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Long> platforms) {
        this.platforms = platforms;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public List<Object> getRewards() {
        return rewards;
    }

    public void setRewards(List<Object> rewards) {
        this.rewards = rewards;
    }

    public Boolean getSeasonPassExclusiveFlag() {
        return seasonPassExclusiveFlag;
    }

    public void setSeasonPassExclusiveFlag(Boolean seasonPassExclusiveFlag) {
        this.seasonPassExclusiveFlag = seasonPassExclusiveFlag;
    }

    public Boolean getSkuAvailabilityOverrideFlag() {
        return skuAvailabilityOverrideFlag;
    }

    public void setSkuAvailabilityOverrideFlag(Boolean skuAvailabilityOverrideFlag) {
        this.skuAvailabilityOverrideFlag = skuAvailabilityOverrideFlag;
    }

    public Long getSkuType() {
        return skuType;
    }

    public void setSkuType(Long skuType) {
        this.skuType = skuType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
