package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {

        log.info("Creating tables");

        // Check "application.properties" file to configure persistent H2 DB file
        jdbcTemplate.execute("DROP TABLE CarModels IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE CarModels(" +
                " id SERIAL, str_col VARCHAR(256), num_col INTEGER)");

        jdbcTemplate.batchUpdate("INSERT INTO CarModels(str_col,num_col) VALUES('Ford', 100)");
        jdbcTemplate.batchUpdate("INSERT INTO CarModels(str_col,num_col) VALUES('Toyota', 200)");
        jdbcTemplate.batchUpdate("INSERT INTO CarModels(str_col,num_col) VALUES('Honda', 300)");
        jdbcTemplate.batchUpdate("INSERT INTO CarModels(str_col,num_col) VALUES('GM', 400)");

        // get all rows with query; lambda is run for each returned row
        // https://docs.spring.io/spring/docs/3.0.x/spring-framework-reference/html/jdbc.html
        log.info("Querying for customer records where num_col < 250:");
        jdbcTemplate.query(
                "SELECT id, str_col, num_col FROM CarModels WHERE num_col < 250",
                (rs, rowNum) -> new CarModel(rs.getLong("id"), rs.getString("str_col"), rs.getInt("num_col"))
        ).forEach(CarModel -> log.info(CarModel.toString()));


        // get all rows with query; lambda is run for each returned row
        jdbcTemplate.query(
                "SELECT id, str_col, num_col FROM CarModels WHERE num_col > 150",
                (rs, rowNum) -> new CarModel(rs.getLong("id"), rs.getString("str_col"), rs.getInt("num_col"))
        ).forEach(CarModel -> log.info(CarModel.toString()));


        // Get row using id
        long id = 3;
        String sql = "SELECT * FROM CarModels WHERE ID = ?";
        CarModel carModel_3  = jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new CarModel(
                        rs.getLong("id"),
                        rs.getString("str_col"),
                        rs.getInt("num_col")
                ));
        if (carModel_3!=null) {
            log.info("carModel_3 => " + carModel_3.toString());
        }


        // get all rows with query, save in ArrayList
        ArrayList<CarModel> carModelsList = new ArrayList<CarModel>();
        jdbcTemplate.query(
                "SELECT id, str_col, num_col FROM CarModels WHERE num_col > 150",
                (rs, rowNum) -> carModelsList.add(new CarModel(rs.getLong("id"), rs.getString("str_col"), rs.getInt("num_col"))
        ));

        // now arrayList contains all query rows
        log.info("====================================");
        log.info("Dump ArrayList of matched carModels ");
        log.info("====================================");
        for(CarModel c : carModelsList)
        {
            log.info("ArrayList of carModels => " + c.toString());
        }

    }
}