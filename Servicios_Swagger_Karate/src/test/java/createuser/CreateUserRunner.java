package createuser;


import com.intuit.karate.KarateOptions;
import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

@RunWith(Karate.class)
@KarateOptions(features="src\\test\\java\\createuser\\create_user.feature")
public class CreateUserRunner {
}
