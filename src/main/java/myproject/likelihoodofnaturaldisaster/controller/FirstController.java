package myproject.likelihoodofnaturaldisaster.controller;


import com.eclipsesource.json.JsonObject;
import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.FIODataPoint;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import myproject.likelihoodofnaturaldisaster.dto.GeoForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/")
public class FirstController {

    @GetMapping
    public String home(@RequestParam(required = false, defaultValue = "Hello")String message, Model model) {
        model.addAttribute("name", message);
        return "hello";
    }

    @RequestMapping("/home")
    public String pageWithForm() {
        return "welcome";
    }

    @RequestMapping("/hell")
    public String hell(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        model.addAttribute("weather", weather());

        return "hell";
    }

    //    @RequestMapping(value = "redirect",method = RequestMethod.GET)
//    public String displayWeather (){
//        return "redirect:hell";
//    }
    @RequestMapping("/getgeo")
    public String getGeolocation(Model model) {
        model.addAttribute("geo",getGeolocation(model));
        return "geolocation";
    }

    private List<String> weather() {
        ForecastIO fio = new ForecastIO("321454184d08ad9ad1910cf541bab553");
        fio.setUnits(ForecastIO.UNITS_SI);
        fio.setLang(ForecastIO.LANG_ENGLISH);
        fio.getForecast("49.980151", "36.349186");
        JsonObject js = fio.getDaily();

        FIODataPoint today = new FIODaily(fio).getDay(1);

        List<String> weather = new ArrayList<>();
        weather.add("Time is: " + today.time());
        weather.add("Summary: " + today.summary());
        weather.add("Sun rise: " + today.sunriseTime());
        weather.add("Sun set: " + today.sunsetTime());
        weather.add("Icon: " + today.icon());

        weather.add("getTimezone: " + today.getTimezone());
        weather.add("temperature min time: " + today.temperatureMinTime());
        weather.add("temperature Max Time: " + today.temperatureMaxTime());
        weather.add("precip type: " + today.precipType());
        weather.add("apparent Temperature Min Time: " + today.apparentTemperatureMinTime());
        weather.add("apparent Temperature Max Time: " + today.apparentTemperatureMaxTime());
        weather.add("precip Intensity: " + today.precipIntensity());
        weather.add("cloud Cover: " + today.cloudCover());
        weather.add("humidity: " + today.humidity());
        weather.add("nearest Storm Distance: " + today.nearestStormDistance());
        weather.add("precip Accumulation: " + today.precipAccumulation());
        weather.add("pressure: " + today.pressure());
        weather.add("Visibility: " + today.visibility());
        weather.add("Wind speed: " + today.windSpeed());
        return weather;
    }

}


//    PrintWriter printWriter = new PrintWriter(System.out);
//
//    ForecastIO fio = new ForecastIO("321454184d08ad9ad1910cf541bab553");
//        fio.setUnits(ForecastIO.UNITS_SI);
//                fio.setLang(ForecastIO.LANG_ENGLISH);
//                fio.getForecast("49.980151", "36.349186");
//                printWriter.println("Latitude: " + fio.getLatitude());
//                model.addAttribute("Latitude: " + fio.getLatitude());
//                printWriter.println("Longitude: " + fio.getLongitude());
//
//                printWriter.println("Timezone: " + fio.getTimezone());
//
//                FIOCurrently currently = new FIOCurrently(fio);
//                //Print currently data
//                printWriter.println("\nCurrently\n");
//
//                String[] f = currently.get().getFieldsArray();
//                for (int i = 0; i < f.length; i++) {
//        printWriter.println(f[i] + ": " + currently.get().getByKey(f[i]));
//
//        }
//        }