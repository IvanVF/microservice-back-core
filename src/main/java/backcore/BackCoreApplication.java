package backcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class BackCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackCoreApplication.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		System.out.println(context);
	}

}
