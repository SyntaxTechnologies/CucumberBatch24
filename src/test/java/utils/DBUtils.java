package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {

    public static List<Map<String,String>> fetch(String query) {
        String dbURL = ConfigReader.read("dbURL");
        String userName = ConfigReader.read("dbUserName");
        String password = ConfigReader.read("dbPassword");
        List<Map<String,String>> dataListMap = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(dbURL, userName, password);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {
                Map<String, String> rowMap = new LinkedHashMap<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {

                    String key = rsmd.getColumnLabel(i);
                    String value = rs.getString(i);
                    rowMap.put(key, value);
                }
                dataListMap.add(rowMap);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataListMap;
    }
}
