package acceptance;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest
@ContextConfiguration(classes = com.chaffai.calculatrice.CalculatriceApplication.class)
public class CucumberSpringConfiguration {
}
