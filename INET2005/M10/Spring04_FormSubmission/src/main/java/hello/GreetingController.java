package hello;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class GreetingController {
    static Random rand = new Random();
    public static Integer random = rand.nextInt(10) + 1;
    static AtomicLong badGuess = new AtomicLong();
    /**
     * Called when hitting "http://localhost:8081/greeting"
     * Called when hitting "http://localhost:8081/greeting2"
     * *
     *
     * @param model
     * @return
     */

    @Autowired
    DataBaseHandler dataBaseHandler;



    @GetMapping("/guess")
//    @RequestParam(name="guess", required=false, defaultValue="-1") Integer guess,
    public String greetingForm(Model model, HttpSession session) {

        GuessObject guesser = new GuessObject();
        guesser.setCheater(random);
        model.addAttribute("guesser", guesser);
        model.addAttribute("badGuess", badGuess);
        return "guess";
    }

    @PostMapping("/guess")
    public String guessSubmit(@ModelAttribute GuessObject guesser, Model model, HttpSession session) {
        guesser.setCheater(random);

        GuessObject sessionResult = (GuessObject) session.getAttribute("sessionResult");

        if (sessionResult == null) {
            sessionResult =  new GuessObject();
//            sessionResult.setGuess(random);
            session.setAttribute("sessionResult", sessionResult);
            session.setAttribute("attempt", badGuess);
        }

        if (guesser.getGuess() == random) {
            return "redirect:result";
        }else{

            sessionResult.setIncorrectCount(sessionResult.getIncorrectCount() + 1);
            model.addAttribute("guesser", guesser);
            return "redirect:guess";

        }
    }

    @GetMapping("/cheater")
    public String cheater(Model model) {
        model.addAttribute("cheat", random);
        return "cheater";
    }

    @GetMapping("/cache")
    @Cacheable
    public String cache(Model model) {
        model.addAttribute("cache", random);
        return "cache";
    }

    @GetMapping("/reset")
    public String reset(Model model, HttpSession session) {

        GuessObject sessionResult = (GuessObject) session.getAttribute("sessionResult");

        if (sessionResult == null) {
            sessionResult = new GuessObject();
        }
        dataBaseHandler.save(new DataModel(session.getId(), sessionResult.getGuess(), sessionResult.getIncorrectCount(), 0));
        model.addAttribute("cheat", random);
        sessionResult.setIncorrectCount(0);
        random = rand.nextInt(10);
        sessionResult.setCheater(random);


        return "redirect:guess";
    }


    @GetMapping("/result")
//    @RequestParam(name="guess", required=false, defaultValue="-1") Integer guess,
    public String result(Model model, HttpSession session) {
        GuessObject sessionResult = (GuessObject) session.getAttribute("sessionResult");

        if (sessionResult == null) {
            sessionResult =  new GuessObject();
            sessionResult.setGuess(random);
            session.setAttribute("sessionResult", sessionResult);
            session.setAttribute("attempt", badGuess);
        }
        sessionResult.setGuess(random);
        model.addAttribute("test", sessionResult);
        dataBaseHandler.save(new DataModel(session.getId(), sessionResult.getGuess(), sessionResult.getIncorrectCount() + 1, 1));
//        model.addAttribute("badGuess", badGuess);
        String formatter = "<br>";

        for (DataModel i : dataBaseHandler.dump()) {
            formatter += i.toString() + "<br>";
        }

        model.addAttribute("datalist", formatter);
        return "result";
    }

    // try #2 ... with session attributes
    @GetMapping("/greeting2")
    public String greetingForm2(Model model, HttpSession session) {

        // Create a greeting, and store it as a session variable
        Greeting SessionGreeting = (Greeting) session.getAttribute("sessionGreeting");

        if (SessionGreeting == null) {
            SessionGreeting = new Greeting();
            SessionGreeting.setId(777);
            SessionGreeting.setContent("Inserted by controller");
            session.setAttribute("sessionGreeting", SessionGreeting);
            System.out.println("###### Created Session Greeting=" + SessionGreeting.toString());
        }

        System.out.println("###### Form Session Greeting=" + SessionGreeting.toString());

        model.addAttribute("greeting", SessionGreeting);
        return "greeting2";
    }

    @PostMapping("/greeting2")
    public String greetingSubmit2(Model model, @ModelAttribute Greeting greeting,  HttpSession session) {

        System.out.println("###### Form Greeting=" + greeting.toString());

        // Copy submitted form into the session attribute...just playing around
        session.setAttribute("sessionGreeting", greeting);

        System.out.println("###### Form Session Greeting=" + greeting.toString());

        return "cheater";
    }

}