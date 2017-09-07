package tennisodds;

import java.util.TimeZone;
import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TennisoddsBeApplication {

    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC")); // workaround to get the dates working on JDBC
    }

    public static void main(String[] args) {
        SpringApplication.run(TennisoddsBeApplication.class, args);
    }
}
