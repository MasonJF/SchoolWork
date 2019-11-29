package hello;

import java.util.Arrays;
import java.util.Locale;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.ViewResolver;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Show the names of all beans in the App.
     * CommandLineRunner is a @Functional Interface, and therefore can be
     * defined as an anonomous fucntion using the lambda notation.
     *
     * Java Beans:
     * https://en.wikipedia.org/wiki/JavaBeans
     * https://docs.oracle.com/javase/tutorial/javabeans/index.html
     *
     * @param ctx
     * @return
     */
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("===============================================================");
            System.out.println("===============================================================");
            System.out.println("      Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                Object myBean = ctx.getBean(beanName, Object.class);
                if (myBean==null) {
                    System.out.println("name=" + beanName);
                } else {
                    System.out.println("Null Bean name=" + beanName);
                }
            }

//            ViewResolver myBean = ctx.getBean("viewResolver", ViewResolver.class);
//            Locale locale = LocaleContextHolder.getLocale();
//            System.out.println("name="+myBean.toString() + myBean.resolveViewName("/", locale ));


        };
    }

}