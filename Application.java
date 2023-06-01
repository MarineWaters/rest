package hwhwhw;

import hwhwhw.user.UserRegistrationDTO;
import hwhwhw.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner runner(UserService userService) {
        return (args) -> {
            UserRegistrationDTO registration = new UserRegistrationDTO();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input your username: ");
            registration.setUsername(scanner.nextLine());
            System.out.println("Input your password: ");
            registration.setPassword(scanner.nextLine());
            userService.save(registration);
        };
    }
}