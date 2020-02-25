package myproject.likelihoodofnaturaldisaster.dto.cityapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityApiDto implements Serializable {
    private double latitude;
    private double longitude;
    private String localityLanguageRequested;
    private String continentCode;
    private String countryName;
    private String countryCode;
    private String principalSubdivision;
    private String locality;
    private LocalityInfoDto localityInfo;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getLocalityLanguageRequested() {
        return localityLanguageRequested;
    }

    public void setLocalityLanguageRequested(String localityLanguageRequested) {
        this.localityLanguageRequested = localityLanguageRequested;
    }

    public String getContinentCode() {
        return continentCode;
    }

    public void setContinentCode(String continentCode) {
        this.continentCode = continentCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPrincipalSubdivision() {
        return principalSubdivision;
    }

    public void setPrincipalSubdivision(String principalSubdivision) {
        this.principalSubdivision = principalSubdivision;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public LocalityInfoDto getLocalityInfo() {
        return localityInfo;
    }

    public void setLocalityInfo(LocalityInfoDto localityInfo) {
        this.localityInfo = localityInfo;
    }

    @Override
    public String toString() {
        return "CityApiDto{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", localityLanguageRequested='" + localityLanguageRequested + '\'' +
                ", continentCode='" + continentCode + '\'' +
                ", countryName='" + countryName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", principalSubdivision='" + principalSubdivision + '\'' +
                ", locality='" + locality + '\'' +
                ", localityInfo=" + localityInfo +
                '}';
    }
}
