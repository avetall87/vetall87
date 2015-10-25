import edu.spring.MainContext;
import org.apache.log4j.Logger;

/**
 * Created by виталий on 23.10.2015.
 */
public class Starter {
    private static final Logger log = Logger.getLogger(Starter.class);

    public static void main(String[] args) throws ClassNotFoundException {
        log.info("start work !!!");
        MainContext main = new MainContext();

    }

}
