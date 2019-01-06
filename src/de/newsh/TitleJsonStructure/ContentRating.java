
package de.newsh.TitleJsonStructure;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContentRating {

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("rating_system")
    @Expose
    private String ratingSystem;
    @SerializedName("url")
    @Expose
    private String url;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRatingSystem() {
        return ratingSystem;
    }

    public void setRatingSystem(String ratingSystem) {
        this.ratingSystem = ratingSystem;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
