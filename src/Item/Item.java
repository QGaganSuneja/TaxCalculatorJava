package Item;

public class Item {

    public String item_name;
    public String item_type;
    public int item_price;
    public int item_quantity;
    public float item_sales_tax;
    public float item_final_price;
    public Item(String item_name,String item_type, int item_price, int item_quantity){
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_quantity  = item_quantity;
        this.item_type = item_type;
    }

    @Override
    public String toString() {
        return "Name :" + this.item_name + "\n" +
                "Price :" + this.item_price + "\n" +
                "Sales Tax :" + this.item_sales_tax + "\n" +
                "Final Price: " + this.item_final_price;

    }
}
