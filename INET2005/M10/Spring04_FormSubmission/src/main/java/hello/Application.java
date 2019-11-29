package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DatabaseDriver;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;


@SpringBootApplication
//@EnableCaching
public class Application implements CommandLineRunner{
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("test")
    private DataModelInterface dataModelInterface;



    @Override
    public void run(String... strings) {

        log.info("Creating tables");

        // Log out connection string
        try {
            log.info(jdbcTemplate.getDataSource().getConnection().toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Check "application.properties" file to configure persistent H2 DB file
        runJDBC();
    }

//    @Override
    void runJDBC() {
        jdbcTemplate.execute("DROP TABLE DataModels IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE DataModels(" +
                " id SERIAL, sessionId VARCHAR(255), gameNumber INTEGER, sessionGuess INTEGER, sessionWin INTEGER)");

        // get all rows with query; lambda is run for each returned row
        // https://docs.spring.io/spring/docs/3.0.x/spring-framework-reference/html/jdbc.html
        log.info("Querying for customer records where num_col < 250:");
//        jdbcTemplate.query(
//                "SELECT id, sessionId, sessionGuess, sessionWin FROM DataModels WHERE sessionId < 250",
//                (rs, rowNum) -> new DataModel(rs.getString("id"), rs.getLong("str_col"), rs.getInt("num_col"))
//        ).forEach(DataModel -> log.info(DataModel.toString()));

    }

}