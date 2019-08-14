package basket;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Product> productList;
    private double total;

    public Basket(ArrayList<Product> productList, double total) {
        this.productList = productList;
        this.total = total;
    }    

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    

}