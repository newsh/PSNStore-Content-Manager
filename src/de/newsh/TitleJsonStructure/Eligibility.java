
package de.newsh.TitleJsonStructure;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Eligibility {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("operand")
    @Expose
    private String operand;
    @SerializedName("operator")
    @Expose
    private String operator;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("entitlement_type")
    @Expose
    private Object entitlementType;
    @SerializedName("drms")
    @Expose
    private List<Drm> drms = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOperand() {
        return operand;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getEntitlementType() {
        return entitlementType;
    }

    public void setEntitlementType(Object entitlementType) {
        this.entitlementType = entitlementType;
    }

    public List<Drm> getDrms() {
        return drms;
    }

    public void setDrms(List<Drm> drms) {
        this.drms = drms;
    }

}
