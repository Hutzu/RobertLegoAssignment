package serivce;

import java.sql.SQLException;
import java.util.ArrayList;

import basket.Product;
import database.Database;

public class BasketService {

    private Database db = new Database();
    
    public BasketService() {

    }
    
    public void addProductToBasket(Product product) throws SQLException
    {
        try {
            db.addProductToBasket(product);
            System.out.println("insert succeded");
        } catch (Exception e) {
            System.out.println("failed to add");
        }
    }

    public Product getProductById(String id){

        Product product = null;

        try {
            product = db.getProductById(id);
        } catch (Exception e ){
            System.out.println("failed to get by ID");
        }

        return product;
    }

    public ArrayList<Product> getAll(){

        ArrayList<Product> basket = null;

        try {
            basket = db.getAll();
        } catch (Exception e) {
            System.out.println("failed to get all");
        }
        return basket;
        
    }

    public void deleteById(String id){
        
        try {
            db.deleteById(id);
        } catch (Exception e) {
            System.out.println("failed to delete id = " + id);
        }
    }

    public void updateQuantityById(String id, String quantity) {
        try {
            db.updateQuantityById(id, quantity);
        } catch (Exception e) {
            System.out.println("failed to update id = " + id);
        }
    }

}