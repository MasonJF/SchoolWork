package hello;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
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
    private final BookRepository bookRepository;
    public static Integer cacheCounter = 0;
    static Random rand = new Random();
    public static Integer random = rand.nextInt(100);
    static AtomicLong badGuess = new AtomicLong();
    public static int scheduleCounter = 0;

    public GreetingController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Called when hitting "http://localhost:8081/greeting"
     * Called when hitting "http://localhost:8081/greeting2"
     * *
     *
     * @param model
     * @return
     */
    @GetMapping("/guess")
//    @RequestParam(name="guess", required=false, defaultValue="-1") Integer guess,
    public String greetingForm(Model model, HttpSession session) {
        GuessObject sessionResult = (GuessObject) session.getAttribute("sessionResult");
        if (sessionResult == null) {
            sessionResult = new GuessObject();
            session.setAttribute("sessionResult", sessionResult);
        }
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
    public String cache(Model model) {
        cacheCounter += 1;
        model.addAttribute("cache", bookRepository.getByIsbn("isbn-1234"));
        model.addAttribute("counter", cacheCounter);
        model.addAttribute("scheduleCounter", scheduleCounter);
        return "cache";
    }

    @Scheduled (fixedRate = 5000)
    public void increment() {
        scheduleCounter += 1;
    }

    @GetMapping("/reset")
    public String reset(Model model, HttpSession session) {

        GuessObject sessionResult = (GuessObject) session.getAttribute("sessionResult");

        if (sessionResult == null) {
            sessionResult = new GuessObject();
        }
        model.addAttribute("cheat", random);
        sessionResult.setIncorrectCount(0);
        random = rand.nextInt(100);
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
        model.addAttribute("test", sessionResult);
//        model.addAttribute("badGuess", badGuess);
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