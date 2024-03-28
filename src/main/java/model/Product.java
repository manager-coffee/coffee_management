package model;

public class Product {
   private int product_id;
    private String product_name;
    private int price;
    private int category_id;
    private String image_url;

    public Product(int product_id, String product_name, int price, int category_id, String image_url) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
        this.category_id = category_id;
        this.image_url = image_url;
    }

    public Product() {
    }

    public Product(String product_name, int price, int category_id, String image_url) {
        this.product_name = product_name;
        this.price = price;
        this.category_id = category_id;
        this.image_url = image_url;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
