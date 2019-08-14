package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import basket.Basket;
import basket.Product;

public class Database {

    String dbURL = "jdbc:mysql://127.0.0.1/legoassignment";
    
    public Database() {

    }


    public void addProductToBasket(Product product) throws SQLException {

        Connection connection = null;
        try{
             connection = DriverManager.getConnection(dbURL, "root","");
            if(connection != null){
                System.out.println("connected");
            }
        } catch(SQLException e){
            System.out.println("not connected");
            e.printStackTrace();
        } 

        String sql = "INSERT INTO basket(id, name, price, quantity) VALUES ( "
            + product.getId() + ""
            + ",'" + product.getName() + "'"
            + "," + product.getPrice() + ""
            + "," + product.getQuantity() + ""
        +")";

        PreparedStatement stmt = connection.prepareStatement(sql);

        int response = stmt.executeUpdate();
        if (response != 1 ){
            System.out.println("failed");
        } 
    }

    public Product getProductById(String id) throws SQLException {

        Connection connection = null;
        try{
             connection = DriverManager.getConnection(dbURL, "root","");
            if(connection != null){
                System.out.println("connected");
            }
        } catch(SQLException e){
            System.out.println("not connected");
            e.printStackTrace();
        } 

        String sql = "SELECT * FROM basket WHERE id = '" + Integer.parseInt(id) + "'";
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        Product pr = new Product();
        if(resultSet.next()) {
            pr.setId(resultSet.getInt("id"));
            pr.setName(resultSet.getString("name"));
            pr.setPrice(resultSet.getDouble("price"));
            pr.setQuantity(resultSet.getInt("quantity"));
        }
        return pr;
    }

    public ArrayList<Product> getAll() throws SQLException, Exception {

        ArrayList<Product> newList = new ArrayList<Product>();
        Connection connection = null;
        try{
             connection = DriverManager.getConnection(dbURL, "root","");
            if(connection != null){
                System.out.println("connected");
            }
        } catch(SQLException e){
            System.out.println("not connected");
            e.printStackTrace();
        }

        String sql = "SELECT * FROM basket";
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        
        while(resultSet.next()) {
            Product pr = new Product();
            pr.setId(resultSet.getInt("id"));
            pr.setName(resultSet.getString("name"));
            pr.setPrice(resultSet.getInt("price"));
            pr.setQuantity(resultSet.getInt("quantity"));
            newList.add(pr);
        }
        return newList;
    }
    
    public void deleteById(String id) throws SQLException {
        Connection connection = null;
        try{
             connection = DriverManager.getConnection(dbURL, "root","");
            if(connection != null){
                System.out.println("connected");
            }
        } catch(SQLException e){
            System.out.println("not connected");
            e.printStackTrace();
        } 

        String sql = "DELETE FROM  basket WHERE id =  '" + Integer.parseInt(id) + "'";

        PreparedStatement stmt = connection.prepareStatement(sql);

        int response = stmt.executeUpdate();
        if (response != 1 ){
            System.out.println("failed");
        } 
    }

    public void updateQuantityById(String id, String quantity) throws SQLException {
        Connection connection = null;
        try{
             connection = DriverManager.getConnection(dbURL, "root","");
            if(connection != null){
                System.out.println("connected");
            }
        } catch(SQLException e){
            System.out.println("not connected");
            e.printStackTrace();
        } 

        String sql = "UPDATE basket SET quantity = '" + Integer.parseInt(quantity) + "'"  + "WHERE id = '" + Integer.parseInt(id) + "'";

        PreparedStatement stmt = connection.prepareStatement(sql);

        int response = stmt.executeUpdate();
        if (response != 1 ){
            System.out.println("failed");
        } 
    }


}