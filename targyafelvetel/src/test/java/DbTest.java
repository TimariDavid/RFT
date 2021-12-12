import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
        underTest = Db.getInstance("jdbc:mysql://localhost:3306/rft", "rftuser", "rKi9F3cyxn2JVJmD");

        // when-then
        assertNotNull(underTest);
    }

    @Test
    public void testSqlSelect() throws SQLException {
        //given
        underTest = Db.getInstance("jdbc:mysql://localhost:3306/rft", "rftuser", "rKi9F3cyxn2JVJmD");

        //when
        ResultSet resultSet = underTest.sqlSelect("SELECT * FROM users");

        //then
        assertNotNull(resultSet);
    }
}