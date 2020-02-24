package myproject.likelihoodofnaturaldisaster.controller;

import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.FIODataPoint;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import com.mapbox.api.geocoding.v5.MapboxGeocoding;
import com.mapbox.api.geocoding.v5.models.CarmenFeature;
import com.mapbox.api.geocoding.v5.models.GeocodingResponse;
import com.mapbox.geojson.Point;
import myproject.likelihoodofnaturaldisaster.dto.AlexeyForecastDto;
import myproject.likelihoodofnaturaldisaster.dto.GeoForm;
import myproject.likelihoodofnaturaldisaster.mapper.AlexeyDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.nonNull;

@Controller
@RequestMapping("/geo")
public class GeoController {

    @Autowired
    private AlexeyDtoMapper mapper;

    @Value("${map.geocode.api}")
    private String mapAPI;


    private static final String GEO_PAGE = "geoPage";

    // Use value from application.properties
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
        double longtitude = Double.parseDouble(geoForm.getLongitude());
        double latitude = Double.parseDouble(geoForm.getLatitude());

        Point point = Point.fromLngLat(longtitude, latitude);
        AlexeyForecastDto result = mapper.map(today);
        MapboxGeocoding reverseGeocode = MapboxGeocoding.builder()
                .accessToken(mapAPI)
                .query(point)
                .build();

        reverseGeocode.enqueueCall((NutCalbackTest) response -> {
            Optional.ofNullable(response.body())
                    .map(GeocodingResponse::features)
                    .map(f -> f.get(1))
                    .map(CarmenFeature::text)
                    .ifPresent(result::setCity);

//            if (nonNull(response.body())) {
//                List<CarmenFeature> features = response.body().features();
//                CarmenFeature carmenFeature = features.get(1);
//                if (nonNull(carmenFeature)) {
//                    result.setCity(carmenFeature.text());
//                }
//            }
        });

//        reverseGeocode.enqueueCall(
                new Callback<GeocodingResponse>() {
            @Override
            public void onResponse(Call<GeocodingResponse> call, Response<GeocodingResponse> response) {
                if (nonNull(response.body())) {
                    List<CarmenFeature> features = response.body().features();
                    CarmenFeature carmenFeature = features.get(1);
                    if (nonNull(carmenFeature)) {
                        result.setCity(carmenFeature.text());
                    }
                }
            }

            @Override
            public void onFailure(Call<GeocodingResponse> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        };
//        );

        model.addAttribute("city", point);

        model.addAttribute("forecast", result);


        return "geoPage";
    }
}
