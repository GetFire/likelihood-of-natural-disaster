package myproject.likelihoodofnaturaldisaster.controller;

import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.FIODataPoint;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import myproject.likelihoodofnaturaldisaster.dto.AlexeyForecastDto;
import myproject.likelihoodofnaturaldisaster.dto.GeoForm;
import myproject.likelihoodofnaturaldisaster.dto.NatashkaOfigevashkaDto;
import myproject.likelihoodofnaturaldisaster.dto.TestDto1;
import myproject.likelihoodofnaturaldisaster.mapper.AlexeyDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
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


    private static final String GEO_PAGE = "geoPage";
    public static final String API_KEY = "321454184d08ad9ad1910cf541bab553";

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

//        AlexeyForecastDto result = mapper.sourceToDestination(today);
        AlexeyForecastDto result = mapper.map(today);

        model.addAttribute("forecast", mapper.map(today));

        return "geoPage";
    }

    public void dosmth() {
        TestDto1 testDto1 = new TestDto1();
        NatashkaOfigevashkaDto natashka = new NatashkaOfigevashkaDto();

//        natashka.setCity(testDto1.getCity().getCityName());

    }
}
