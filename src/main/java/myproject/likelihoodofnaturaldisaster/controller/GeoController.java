package myproject.likelihoodofnaturaldisaster.controller;

import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.FIODataPoint;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import myproject.likelihoodofnaturaldisaster.dto.AlexeyForecastDto;
import myproject.likelihoodofnaturaldisaster.dto.GeoForm;
import myproject.likelihoodofnaturaldisaster.mapper.AlexeyDtoMapper;
import myproject.likelihoodofnaturaldisaster.mapper.ResultWeatherMapper;
import myproject.likelihoodofnaturaldisaster.test.ResultWeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    private String API_KEY ;

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

//        AlexeyDtoMapper mapper = Mappers.getMapper(AlexeyDtoMapper.class);

        AlexeyForecastDto result = mapper.map(today);

        resultWeatherRepository.save(resultWeatherMapper.map(result));

        model.addAttribute("forecast", result);

        return "geoPage";
    }
}
