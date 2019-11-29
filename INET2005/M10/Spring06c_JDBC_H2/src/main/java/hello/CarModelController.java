package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Called when hitting "http://localhost:8081/car"
 * Called when hitting "http://localhost:8081/car2"
 * Called when hitting "http://localhost:8081/dump"
 *
 * All println's were changed to log.info().
 **/
@Controller
public class CarModelController {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    DB_Handler db_Handler;

    /**
     * @param model
     * @return
     */
    @GetMapping("/car")
    public String carForm(Model model) {
        model.addAttribute("carModel", new CarModel());
        return "car";
    }

    @PostMapping("/car")
    public String carSubmit(@ModelAttribute CarModel carModel) {
        log.info("###### Form Greeting=" + carModel.toString());
        return "result";
    }

    @GetMapping("/dump")
    public String dumpDB(Model model) {

        List<CarModel> carModels = db_Handler.findAll();

        model.addAttribute("carModels", carModels);

        return "dump";
    }

    // try #2 ... with session attributes
    @GetMapping("/car2")
    public String carForm2(Model model, HttpSession session) {

        // Get client IP.  Don't use localhost, use your IP instead
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();
        String ip = request.getRemoteAddr();
        log.info("###### IP=" + ip);


        // Create a greeting, and store it as a session variable
        CarModel SessionCarModel = (CarModel) session.getAttribute("sessionCarModel");

        log.info("entered controller");

        if (SessionCarModel == null) {
            SessionCarModel = new CarModel();
            SessionCarModel.setId(777);
            SessionCarModel.setModelName("Inserted by controller");
            session.setAttribute("sessionCarModel", SessionCarModel);
            log.info("###### Created Session sessionCarModel=" + SessionCarModel.toString());
        }

        log.info("entered controller"+ SessionCarModel.toString());
        log.info("###### Form Session sessionCarModel=" + SessionCarModel.toString());

        model.addAttribute("sessionCarModel", SessionCarModel);
        return "car2";
    }

    @PostMapping("/car2")
    public String carSubmit2(Model model, @ModelAttribute CarModel carModel, HttpSession session) {

        log.info("###### Form carModel greeting 2=" + carModel.toString());

        // Copy submitted form into the session attribute...just playing around
        session.setAttribute("sessionCarModel", carModel);

        log.info("###### Form carModel greeting 2 (after)=" + carModel.toString());


        //////////////////////////////
        // Add new record to car DB
        db_Handler.save(carModel);

        return "result2";
    }

}