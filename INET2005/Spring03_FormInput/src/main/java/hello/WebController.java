package hello;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class WebController implements WebMvcConfigurer {


    Integer sessionInt = 0;
    private AtomicLong addressCount = new AtomicLong();
    private AtomicLong errorCounter = new AtomicLong();
    //@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    /**
     *  Called when hitting "http://localhost:8081/"
     *       *
     * @param personForm
     * @return
     */
    @GetMapping("/")
    public String showForm(PersonForm personForm, HttpSession session) {
        sessionInt = (Integer) session.getAttribute("sessionInt");
        if (sessionInt == null) {
            sessionInt = 0;
            session.setAttribute("sessionInt", sessionInt);
        }

        // Modify session integer
        sessionInt = sessionInt + 1;
        session.setAttribute("sessionInt", sessionInt);

        // You can only see the session variable in the log (unless you use it in JSON)
        System.out.println("###### Result Session sessionInt=" + sessionInt.toString());

        return "form";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            errorCounter.incrementAndGet();

            return "form";
        }

        return "redirect:/results";
    }

    @GetMapping("/address")
    public String greeting2(@RequestParam(name="name", required=false, defaultValue="World") String name,
                            @RequestParam(name="houseNum", required=false, defaultValue="50") String houseNum,
                            @RequestParam(name="street", required=false, defaultValue="Elliot Rd") String street,
                            @RequestParam(name="city", required=false, defaultValue="Lawrencetown") String city,
                            Model model) {
        model.addAttribute("name", name);
        model.addAttribute("houseNum", houseNum);
        model.addAttribute("street", street);
        model.addAttribute("city", city);
        addressCount.incrementAndGet();
        return "address";
    }

    @GetMapping("/reset")
    public String greeting3(@RequestParam(name = "reset", required = false, defaultValue = "Counters have been reset to zero!") String reset,
                            Model model) {
        model.addAttribute("addressCounter", addressCount.toString());
        model.addAttribute("sessionCounter", sessionInt.toString());
        model.addAttribute("errorCounter", errorCounter.toString());
//        Long total = addressCount.get() + greetingCount.get();
//        model.addAttribute("totalCounter", total);
        model.addAttribute("reset", reset);
        addressCount.set(0);
//        sessionInt = 0;
        errorCounter.set(0);
        return "reset";
    }
}