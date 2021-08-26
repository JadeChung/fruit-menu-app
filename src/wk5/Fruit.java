package wk5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Fruit {

    private Connection connection;

    private final String READ_ALL_FRUIT_QUERY = "SELECT * FROM fruit";
    private final String CREATE_NEW_FRUIT_QUERY = "INSERT INTO fruit(scienctific_name, common_name) VALUES(?, ?)";
    private final String DELETE_FRUIT_QUERY = "DELETE FROM fruit WHERE fruit_id = ?";
    private final String UPDATE_FRUIT_QUERY = "UPDATE fruit SET scienctific_name = ?, common_name = ? WHERE fruit_id = ?";
    public Fruit(){
        connection.getConnection();
    }

    public List<Fruit> getFruit() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(READ_ALL_FRUIT_QUERY);
        ResultSet RS = preparedStatement.executeQuery();
        List<Fruit> Fruits = new ArrayList<Fruit>();

        while(RS.next()){
            Fruit.add(new Fruit(RS.getInt(1), RS.getString(2), RS.getString(3)));
        }

        return Fruit;

    }

    public void createFruit(String scienctific_name, String common_name) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(CREATE_NEW_FRUIT_QUERY);
        preparedStatement.setString(1, scienctific_name);
        preparedStatement.setString(2, common_name);
        preparedStatement.executeUpdate();
        System.out.println("Delicious fruit was inserted!");
    }

    public void updateFruitById(int fruit_id, String scienctific_name, String common_name) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_FRUIT_QUERY);
        preparedStatement.setInt(1,fruit_id);
        preparedStatement.setString(2, scienctific_name);
        preparedStatement.setString(3, common_name);
        preparedStatement.executeUpdate();
        System.out.println("Fruit updated!");
    }

    public void deleteAlbumById(int fruit_id) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FRUIT_QUERY);
        preparedStatement.setInt(1, fruit_id);
        preparedStatement.executeUpdate();
        System.out.println("Bye Bye Fruit!");
    }

}
