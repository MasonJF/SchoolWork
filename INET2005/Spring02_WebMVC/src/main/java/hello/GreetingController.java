package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class GreetingController {

    private AtomicLong addressCount = new AtomicLong();
    private AtomicLong greetingCount = new AtomicLong();

    /**
     * Called when hitting "http://localhost:8081/greeting1"
     *                     "http://localhost:8081/greeting2"
     *                     "http://localhost:8081/greeting2?name=RussyPoo"
     *                     "http://localhost:8081/greeting3"
     *
     * Swaps return string into HTML so that ...
     *    <p th:text="'Hello, ' + ${name} + '!'" />
     *          ... becomes ...
     *    <p th:text="'Hello, ' + "String returned from here" + '!'" />
     *
     * @param name Name defaults to "World" if not specified
     * @param model
     * @return String name of view HTML file to use, parameters are replaced.
     */
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        greetingCount.incrementAndGet();
        return "greeting";
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
        model.addAttribute("greetingCounter", greetingCount.toString());
        Long total = addressCount.get() + greetingCount.get();
        model.addAttribute("totalCounter", total);
        model.addAttribute("reset", reset);
        addressCount.set(0);
        greetingCount.set(0);

        return "reset";
    }

}