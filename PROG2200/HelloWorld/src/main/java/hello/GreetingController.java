package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private static final String rootTemp = "%s";
    private final AtomicLong counter = new AtomicLong();
    private AtomicLong totalCount = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/greetingRandom")
    public GreetingRandom greetingRandom(@RequestParam(value="name", defaultValue="World") String name) {
        return new GreetingRandom(counter.incrementAndGet(),
                String.format(template, name));
    }
    @RequestMapping("/")
    public Greeting home(@RequestParam(value="/", defaultValue="You're at the index") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(rootTemp, name));
    }

    @RequestMapping("/address")
    public Greeting address(@RequestParam(value="address", defaultValue="50 Elliot Rd, Lawrencetown, NS") String name) {
        return new Greeting(totalCount.incrementAndGet(),
                String.format(rootTemp, name));
    }

    @RequestMapping("/reset")
    public Greeting reset(@RequestParam(value="reset", defaultValue="The Counter has been Reset to ZERO") String name) {
        Greeting test = new Greeting(counter.get() + totalCount.get(),
                String.format(rootTemp, name));
        counter.set(0);
        totalCount.set(0);
        return test;
    }
}