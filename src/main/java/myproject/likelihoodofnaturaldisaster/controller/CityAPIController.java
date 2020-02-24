package myproject.likelihoodofnaturaldisaster.controller;

import myproject.likelihoodofnaturaldisaster.dto.GeoForm;
import myproject.likelihoodofnaturaldisaster.dto.cityapi.CityApiDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import static java.lang.String.format;
import static org.springframework.context.i18n.LocaleContextHolder.getLocale;


@Controller
@RequestMapping("/cityApi")
public class CityAPIController {

    public static final String PARAM_START = "?";
    public static final String AND = "&";
    @Value("${city.api.key}")
    private String cityApiKey;

    @Value("${city.api.url}")
    private String cityApiUrl;

    @Autowired
    private RestTemplate restTemplate;

    @ModelAttribute("geoForm")
    public GeoForm getGeoForm() {
        return new GeoForm();
    }

    @GetMapping
    public String getPage(Model model) {
        return "cityPage";
    }


    @PostMapping
    public String getPage(@ModelAttribute GeoForm geoForm, Model model) {

        String requestUrl = getRequestUrl(geoForm);

        CityApiDto result = restTemplate.getForObject(requestUrl, CityApiDto.class);

        model.addAttribute("city", result);
        return "cityPage";
    }

    private String getRequestUrl(GeoForm geoForm) {
        return new StringBuilder(cityApiUrl)
                .append(PARAM_START)
                .append(format("latitude=%s",geoForm.getLatitude()))
                .append(AND)
                .append(format("longitude=%s",geoForm.getLongitude()))
                .append(AND)
                .append(format("localityLanguage=%s", getLocale().getLanguage()))
                .append(AND)
                .append(format("key=%s", cityApiKey))
                .toString();
    }


}
