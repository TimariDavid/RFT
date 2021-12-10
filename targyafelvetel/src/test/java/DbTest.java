import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DbTest {

    private Db underTest;

    private Connection connection;

    @Test
    public void testConnectionDatabase() throws SQLException {
        // given
        underTest = new Db("jdbc:mysql://localhost:3306/rft", "rftuser", "9R]Y/Hh3U147VUt5");

        // when

        // then

    }

}
