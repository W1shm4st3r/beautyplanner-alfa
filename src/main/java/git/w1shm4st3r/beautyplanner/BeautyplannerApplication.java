package git.w1shm4st3r.beautyplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BeautyplannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeautyplannerApplication.class, args);
	}

}
