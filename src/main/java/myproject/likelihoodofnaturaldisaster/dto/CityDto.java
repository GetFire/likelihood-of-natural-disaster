package myproject.likelihoodofnaturaldisaster.dto;

public class CityDto {

    private String cityName;
    private String cityIsoCode;
    private String country;



    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityIsoCode() {
        return cityIsoCode;
    }

    public void setCityIsoCode(String cityIsoCode) {
        this.cityIsoCode = cityIsoCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
