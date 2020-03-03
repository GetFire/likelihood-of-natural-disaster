package myproject.likelihoodofnaturaldisaster.controller;

import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.FIODataPoint;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import myproject.likelihoodofnaturaldisaster.dto.ForecastDto;
import myproject.likelihoodofnaturaldisaster.dto.GeoForm;
import myproject.likelihoodofnaturaldisaster.entity.ResultWeather;
import myproject.likelihoodofnaturaldisaster.mapper.AlexeyDtoMapper;
import myproject.likelihoodofnaturaldisaster.mapper.ResultWeatherMapper;
import myproject.likelihoodofnaturaldisaster.repository.ResultWeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/geo")
public class GeoController {

    @Autowired
    private AlexeyDtoMapper mapper;

    @Autowired
    private ResultWeatherRepository resultWeatherRepository;

    @Autowired
    private ResultWeatherMapper resultWeatherMapper;

    private static final String GEO_PAGE = "geoPage";

    @Value("${forecast.api.key}")
    private String API_KEY;

    @ModelAttribute("geoForm")
    public GeoForm getGeoForm() {
        return new GeoForm();
    }

    @GetMapping
    public String getPage(Model model) {

        return GEO_PAGE;
    }

    @PostMapping
    public String test(@ModelAttribute GeoForm geoForm, Model model) {

        ForecastIO fio = new ForecastIO(API_KEY);
        fio.setUnits(ForecastIO.UNITS_SI);
        fio.setLang(ForecastIO.LANG_ENGLISH);
        fio.getForecast(geoForm.getLatitude(), geoForm.getLongitude());

        FIODataPoint today = new FIODaily(fio).getDay(1);

        ForecastDto result = mapper.map(today);
        ResultWeather resultWeather = resultWeatherMapper.map(result, geoForm);
        resultWeatherRepository.save(resultWeather);
        model.addAttribute("forecast", result);

        return "geoPage";
    }
}
