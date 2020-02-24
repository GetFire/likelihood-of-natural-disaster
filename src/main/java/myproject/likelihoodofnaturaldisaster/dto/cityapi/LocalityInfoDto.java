package myproject.likelihoodofnaturaldisaster.dto.cityapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocalityInfoDto implements Serializable {
    private List<LocalityPropertyDto> administrative;
    private List<LocalityPropertyDto> informative;


    public List<LocalityPropertyDto> getAdministrative() {
        return administrative;
    }

    public void setAdministrative(
            List<LocalityPropertyDto> administrative) {
        this.administrative = administrative;
    }

    public List<LocalityPropertyDto> getInformative() {
        return informative;
    }

    public void setInformative(List<LocalityPropertyDto> informative) {
        this.informative = informative;
    }
}
