
package de.newsh.TitleJsonStructure;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Promomedium {

    @SerializedName("anno")
    @Expose
    private String anno;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("materials")
    @Expose
    private List<Object> materials = null;
    @SerializedName("multi")
    @Expose
    private String multi;
    @SerializedName("rep")
    @Expose
    private String rep;
    @SerializedName("type")
    @Expose
    private Long type;

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Object> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Object> materials) {
        this.materials = materials;
    }

    public String getMulti() {
        return multi;
    }

    public void setMulti(String multi) {
        this.multi = multi;
    }

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

}
