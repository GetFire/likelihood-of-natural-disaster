package myproject.likelihoodofnaturaldisaster.dto;

import tk.plogitech.darksky.forecast.model.Forecast;

import java.util.List;

public class CustomerDto {

    private String name;
    private String login;
    private List<Forecast>forecastList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Forecast> getForecastList() {
        return forecastList;
    }

    public void setForecastList(List<Forecast> forecastList) {
        this.forecastList = forecastList;
    }
}
