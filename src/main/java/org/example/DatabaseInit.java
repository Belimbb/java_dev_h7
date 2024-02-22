package org.example;

import org.example.serviceClasses.FileService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInit {
    public static void initDatabase() throws SQLException {
        String filePath = "C:\\Users\\PC\\Documents\\GitHub\\java_dev_h7\\src\\main\\resources\\sql\\init_db.sql";
        String dbRequest = FileService.getFileContent(filePath);

        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();

        statement.execute(dbRequest);
    }
}
