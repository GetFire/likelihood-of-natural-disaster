package myproject.likelihoodofnaturaldisaster.dto.cityapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocalityPropertyDto implements Serializable {
    private int order;
    private int adminLevel;
    private String name;
    private String description;
    private String isoCode;
    private String isoName;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(int adminLevel) {
        this.adminLevel = adminLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getIsoName() {
        return isoName;
    }

    public void setIsoName(String isoName) {
        this.isoName = isoName;
    }
}
