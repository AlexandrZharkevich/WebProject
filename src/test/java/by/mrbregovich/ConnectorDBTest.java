package by.mrbregovich;

import by.mrbregovich.util.ConnectorDB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectorDBTest {
    @Test
    void testGetConnection() throws SQLException {
        //give
        Connection connection = ConnectorDB.getConnection();
        //when
        //then
        Assertions.assertNotNull(connection);
    }
}
