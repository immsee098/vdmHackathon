package metlife.team01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Project     : metlifehkt
 * @FileName    : Team01Application.java
 * @Date        : 2024. 03. 22.
 * @author      : immsee098@gmail.com
 * @description :
 */
@SpringBootApplication
@EnableAsync //async가능
public class Team01Application {

	public static void main(String[] args) {
		SpringApplication.run(Team01Application.class, args);
	}

}
