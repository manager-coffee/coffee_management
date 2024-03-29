package dto;

public class OrderDto {
    private int order_id;
    private String customer_id;
    private String order_date;
    private String total_amount;
    private String order_status_id;
    private String product_id;

    private String customer_name;
    private String product_name;
    public String getOrder_status_id() {
        return order_status_id;
    }

    public void setOrder_status_id(String order_status_id) {
        this.order_status_id = order_status_id;
    }

    public OrderDto(int order_id, String customer_id, String order_date, String total_amount, String order_status_id, String product_id) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.order_date = order_date;
        this.total_amount = total_amount;
        this.order_status_id = order_status_id;
        this.product_id = product_id;
    }

    public OrderDto() {
    }

    public OrderDto(int order_id, String customer_id, String order_date, String total_amount, String product_id) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.order_date = order_date;
        this.total_amount = total_amount;
        this.product_id = product_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public OrderDto(int order_id, String customer_id, String order_date, String total_amount, String order_status_id, String product_id, String customer_name, String product_name) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.order_date = order_date;
        this.total_amount = total_amount;
        this.order_status_id = order_status_id;
        this.product_id = product_id;
        this.customer_name = customer_name;
        this.product_name = product_name;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setCustomer_name(String customerName) {
        this.customer_name = customerName;
    }

    public void setProduct_name(String productName) {
        this.product_name = productName;
    }

}
