package myproject.likelihoodofnaturaldisaster.controller;

import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.FIODataPoint;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import com.mapbox.api.geocoding.v5.GeocodingCriteria;
import com.mapbox.api.geocoding.v5.MapboxGeocoding;
import com.mapbox.geojson.Point;
import myproject.likelihoodofnaturaldisaster.dto.AlexeyForecastDto;
import myproject.likelihoodofnaturaldisaster.dto.GeoForm;
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

        Point point = Point.fromLngLat(Double.valueOf(geoForm.getLongitude()),Double.valueOf(geoForm.getLongitude()));
        AlexeyForecastDto result = mapper.map(today);
        model.addAttribute("city",point);
//        MapboxGeocoding reverseGeocode = MapboxGeocoding.builder()
//                .accessToken("pk.eyJ1IjoibWFydmVsbG9zIiwiYSI6ImNrNnkzcXNjNDBuajAzcG1hbmRoeHc5YWMifQ.Ho6udxUey9qUiJw9u32QYQ")
//                .query(Point.fromLngLat(-77.03655, 38.89770))
//                .country()
//                .languages()
//                .geocodingTypes(GeocodingCriteria.TYPE_ADDRESS)
//                .build();

        model.addAttribute("city",point);

        model.addAttribute("forecast", result);


        return "geoPage";
    }
}
