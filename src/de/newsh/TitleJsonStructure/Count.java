
package de.newsh.TitleJsonStructure;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Count {

    @SerializedName("star")
    @Expose
    private Long star;
    @SerializedName("count")
    @Expose
    private Long count;

    public Long getStar() {
        return star;
    }

    public void setStar(Long star) {
        this.star = star;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

}
