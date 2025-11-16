package acceptance;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/feature",
    glue = {
        "acceptance",
        "com.chaffai.calculatrice"
    },
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json",
        "junit:target/cucumber-reports/cucumber.xml",
        "rerun:target/cucumber-reports/rerun.txt"
    },
    monochrome = true,
    publish = true  // Génère un lien public (optionnel)
)
public class AcceptanceTest {
}
