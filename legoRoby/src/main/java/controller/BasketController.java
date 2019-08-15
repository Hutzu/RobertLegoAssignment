package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import basket.Product;
import serivce.BasketService;


@RestController
public class BasketController {

    private BasketService basketService = new BasketService();

    @RequestMapping("/addToBasket")
    public void addProductToBasket(@RequestParam(value="id") String id, @RequestParam(value="price") String price,@RequestParam(value="quantity") String quantity, @RequestParam(value="name") String name) throws SQLException{
       
         basketService.addProductToBasket(new Product(Integer.parseInt(id), Double.parseDouble(price), Integer.parseInt(quantity), name));
            
    }

    @RequestMapping("/products")
    public Product getProductById(@RequestParam(value="id") String id){
           return basketService.getProductById(id);
    }

    @RequestMapping("/getAll")
    public ArrayList<Product> getAllProducts(){
        return basketService.getAll();
    }

    @RequestMapping("/delete")
    public void deleteProductById(@RequestParam(value="id") String id){
        basketService.deleteById(id);
    }

    @RequestMapping("/update")
    public void updateQuantityById(@RequestParam(value="id") String id, @RequestParam(value="quantity") String quantity){
        basketService.updateQuantityById(id, quantity);
    }


    
}