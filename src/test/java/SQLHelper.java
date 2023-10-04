
import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SQLHelper {
    private static final QueryRunner runner = new QueryRunner();

    private SQLHelper() {

    }

    private static Connection getConn() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
    }


    @SneakyThrows
    public static void cleanDataBase() {
        var connection = getConn();
        runner.execute(connection, "DELETE FROM payment_entity");
        runner.execute(connection, "DELETE FROM order_entity");
        runner.execute(connection, "DELETE FROM credit_request_entity");
        var status = "SELECT status FROM payment_entity ORDER BY created DESC";
    }

    @SneakyThrows
    public static void cleanAuthCodes() {
        var connection = getConn();
        runner.execute(connection, "DELETE FROM auth_codes");
    }
}