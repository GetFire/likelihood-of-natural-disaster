package myproject.likelihoodofnaturaldisaster.model;

import tk.plogitech.darksky.forecast.model.Forecast;

import java.util.List;

public class Customer extends User {

    private String name;
    private String login;
    private List<Forecast>forecastList;

    public Customer(String id){
        super(id);
    }

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
}
