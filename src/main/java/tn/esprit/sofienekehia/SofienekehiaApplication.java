package tn.esprit.sofienekehia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
//@EnableAspectJAutoProxy enable Aspect
@SpringBootApplication
public class SofienekehiaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SofienekehiaApplication.class, args);
    }

}
