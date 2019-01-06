
package de.newsh.TitleJsonStructure;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metadata {

    @SerializedName("cn_remotePlay")
    @Expose
    private CnRemotePlay cnRemotePlay;
    @SerializedName("cloud_only_platform")
    @Expose
    private CloudOnlyPlatform cloudOnlyPlatform;
    @SerializedName("cn_vrRequired")
    @Expose
    private CnVrRequired cnVrRequired;
    @SerializedName("cn_vrEnabled")
    @Expose
    private CnVrEnabled cnVrEnabled;
    @SerializedName("playable_platform")
    @Expose
    private PlayablePlatform playablePlatform;
    @SerializedName("cn_dualshockVibration")
    @Expose
    private CnDualshockVibration cnDualshockVibration;
    @SerializedName("tertiary_classification")
    @Expose
    private TertiaryClassification tertiaryClassification;
    @SerializedName("cn_psVrAimRequired")
    @Expose
    private CnPsVrAimRequired cnPsVrAimRequired;
    @SerializedName("cn_crossPlatformPSVita")
    @Expose
    private CnCrossPlatformPSVita cnCrossPlatformPSVita;
    @SerializedName("secondary_classification")
    @Expose
    private SecondaryClassification secondaryClassification;
    @SerializedName("cn_psVrAimEnabled")
    @Expose
    private CnPsVrAimEnabled cnPsVrAimEnabled;
    @SerializedName("primary_classification")
    @Expose
    private PrimaryClassification primaryClassification;

    public CnRemotePlay getCnRemotePlay() {
        return cnRemotePlay;
    }

    public void setCnRemotePlay(CnRemotePlay cnRemotePlay) {
        this.cnRemotePlay = cnRemotePlay;
    }

    public CloudOnlyPlatform getCloudOnlyPlatform() {
        return cloudOnlyPlatform;
    }

    public void setCloudOnlyPlatform(CloudOnlyPlatform cloudOnlyPlatform) {
        this.cloudOnlyPlatform = cloudOnlyPlatform;
    }

    public CnVrRequired getCnVrRequired() {
        return cnVrRequired;
    }

    public void setCnVrRequired(CnVrRequired cnVrRequired) {
        this.cnVrRequired = cnVrRequired;
    }

    public CnVrEnabled getCnVrEnabled() {
        return cnVrEnabled;
    }

    public void setCnVrEnabled(CnVrEnabled cnVrEnabled) {
        this.cnVrEnabled = cnVrEnabled;
    }

    public PlayablePlatform getPlayablePlatform() {
        return playablePlatform;
    }

    public void setPlayablePlatform(PlayablePlatform playablePlatform) {
        this.playablePlatform = playablePlatform;
    }

    public CnDualshockVibration getCnDualshockVibration() {
        return cnDualshockVibration;
    }

    public void setCnDualshockVibration(CnDualshockVibration cnDualshockVibration) {
        this.cnDualshockVibration = cnDualshockVibration;
    }

    public TertiaryClassification getTertiaryClassification() {
        return tertiaryClassification;
    }

    public void setTertiaryClassification(TertiaryClassification tertiaryClassification) {
        this.tertiaryClassification = tertiaryClassification;
    }

    public CnPsVrAimRequired getCnPsVrAimRequired() {
        return cnPsVrAimRequired;
    }

    public void setCnPsVrAimRequired(CnPsVrAimRequired cnPsVrAimRequired) {
        this.cnPsVrAimRequired = cnPsVrAimRequired;
    }

    public CnCrossPlatformPSVita getCnCrossPlatformPSVita() {
        return cnCrossPlatformPSVita;
    }

    public void setCnCrossPlatformPSVita(CnCrossPlatformPSVita cnCrossPlatformPSVita) {
        this.cnCrossPlatformPSVita = cnCrossPlatformPSVita;
    }

    public SecondaryClassification getSecondaryClassification() {
        return secondaryClassification;
    }

    public void setSecondaryClassification(SecondaryClassification secondaryClassification) {
        this.secondaryClassification = secondaryClassification;
    }

    public CnPsVrAimEnabled getCnPsVrAimEnabled() {
        return cnPsVrAimEnabled;
    }

    public void setCnPsVrAimEnabled(CnPsVrAimEnabled cnPsVrAimEnabled) {
        this.cnPsVrAimEnabled = cnPsVrAimEnabled;
    }

    public PrimaryClassification getPrimaryClassification() {
        return primaryClassification;
    }

    public void setPrimaryClassification(PrimaryClassification primaryClassification) {
        this.primaryClassification = primaryClassification;
    }

}
