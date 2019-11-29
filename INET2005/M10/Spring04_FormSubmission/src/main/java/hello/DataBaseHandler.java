package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Qualifier("test")
public class DataBaseHandler implements DataModelInterface {


    private static final Logger log = LoggerFactory.getLogger(Application.class);

    // local copy of jdbcTemplate
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int save(DataModel dataModel) {
        System.out.println(dataModel.getSessionId());
        String command = "INSERT INTO DataModels(sessionId, gameNumber, sessionGuess, sessionWin) VALUES('" +
                dataModel.getSessionId() + "', " +
                dataModel.getGameNumber() + ", " +
                dataModel.getSessionGuess()  + ", " +
                dataModel.getSessionWin() + ")";
        System.out.println(command);
        log.info("\n################ DB_Handler command=" + command);

        jdbcTemplate.batchUpdate(command);

        // debug output to see what we're doing
        dump();

        return 0;
    }

    public List<DataModel> dump(){

        // get all rows with query; lambda is run for each returned row
        // https://docs.spring.io/spring/docs/3.0.x/spring-framework-reference/html/jdbc.html
        log.info("Querying for customer records where num_col > 0:");
        List<DataModel> dlist = jdbcTemplate.query(
                "SELECT * FROM DataModels",
                (rs, rowNum) -> new DataModel(rs.getString("sessionId"), rs.getInt("gameNumber"), rs.getLong("sessionGuess"),  rs.getInt("sessionWin"))
        );

        dlist.forEach(DataModel -> LoggerFactory.getLogger(Application.class).info(DataModel.toString()));

        return dlist;
    }
}
