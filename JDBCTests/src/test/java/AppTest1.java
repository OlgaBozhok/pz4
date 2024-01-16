import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.sql.*;

public class AppTest1 {
    String selectQuery =
            "SELECT * FROM FOOD;";
    @Test
    @DisplayName("simpleApplication")

    public void simpleApplication() throws SQLException {
        Connection connection =
                DriverManager.getConnection("jdbc:h2:tcp://localhost:9092/mem:testdb","user","pass");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(selectQuery);

        while (resultSet.next()){
            int id = resultSet.getInt("FOOD_ID");
            String name = resultSet.getString("FOOD_NAME");
            String foodType = resultSet.getString("FOOD_TYPE");
            int exotic = resultSet.getInt("FOOD_EXOTIC");
            System.out.printf("%d, %s, %s, %d \n", id, name, foodType, exotic);
        }

        System.out.printf("\n \n");

        //Ввести запрос для добавления нового товара: "INSERT INTO FOOD VALUES (5, 'Папайя', 'FRUIT', 1);"

        String insert = "INSERT INTO FOOD(FOOD_NAME, FOOD_TYPE, FOOD_EXOTIC) values ('Папайя', 'FRUIT', 1)";
        statement.executeUpdate(insert);

        //Показать таблицу FOOD целиком. Ввести запрос: "SELECT * FROM FOOD;"

        ResultSet resultSet2 = statement.executeQuery(selectQuery);

        while (resultSet2.next()){
            int id = resultSet2.getInt("FOOD_ID");
            String name = resultSet2.getString("FOOD_NAME");
            String foodType = resultSet2.getString("FOOD_TYPE");
            int exotic = resultSet2.getInt("FOOD_EXOTIC");
            System.out.printf("%d, %s, %s, %d \n", id, name, foodType, exotic);
        }

        System.out.printf("\n \n");

        //Написать запрос: "DELETE FROM FOOD WHERE FOOD_ID = 5;" для удаления новой записи
        String delete = "DELETE FROM FOOD WHERE FOOD_ID = 5";
        statement.executeUpdate(delete);

        //Показать таблицу FOOD целиком. Ввести запрос "SELECT * FROM FOOD;"
        ResultSet resultSet3 = statement.executeQuery(selectQuery);
        while (resultSet3.next()){
            int id = resultSet3.getInt("FOOD_ID");
            String name = resultSet3.getString("FOOD_NAME");
            String foodType = resultSet3.getString("FOOD_TYPE");
            int exotic = resultSet3.getInt("FOOD_EXOTIC");
            System.out.printf("%d, %s, %s, %d \n", id, name, foodType, exotic);
        }

    }
}
