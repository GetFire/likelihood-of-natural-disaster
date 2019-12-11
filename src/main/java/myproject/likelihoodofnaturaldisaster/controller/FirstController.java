package myproject.likelihoodofnaturaldisaster.controller;

import com.github.dvdme.ForecastIOLib.FIOCurrently;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.PrintWriter;
import java.util.Map;

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String hello(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name,
            Model model
    ) {
        model.addAttribute("name", name);

        return "hello";
    }
    @GetMapping("/app")
    public String app(
            @RequestParam(value = "name", required = false)
            Model model
    ) {
        ForecastIO fio = new ForecastIO("321454184d08ad9ad1910cf541bab553");
        model.addAttribute("fio", fio.getForecast("49.980151", "36.349186"));

        return "testApp";
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