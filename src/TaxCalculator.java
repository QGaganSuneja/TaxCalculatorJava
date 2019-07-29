import Item.Item;

import java.util.Scanner;
import Constants.contants;

public class TaxCalculator {

    static float itemFinalPrice(Item item, float tax){
        return (float) item.item_price + tax;
    }

    static float calculateTaxOnRawItem(Item item){
        return (float) 0.125f * item.item_price;
    }

    static float calculateTaxOnManufacturedItem(Item item){
        float taxOnRawItem = calculateTaxOnRawItem(item);
        return (float) (taxOnRawItem + 0.02f * (taxOnRawItem + item.item_price));

    }

    static float calculateTaxOnImportedItem(Item item){
        float importDuty = 0.1f * item.item_price;
        float priceWithImportedTax = importDuty + item.item_price;
        if(priceWithImportedTax<=100){
            return 5.0f + importDuty;
        }else if(priceWithImportedTax>100 && priceWithImportedTax<=200){
            return 10.f + importDuty;
        }else{
            return (0.05f*priceWithImportedTax) + importDuty;
        }

    }

    static float calculateTaxOnItem(Item item){

        if(item.item_type == contants.RAW)
            return calculateTaxOnRawItem(item);
        else if(item.item_type == contants.MANUFACTURED){
           return calculateTaxOnManufacturedItem(item);
        }
        else {
            return calculateTaxOnImportedItem(item);
        }

    }


    static void runProgram(){
        Scanner sc = new Scanner(System.in);
        char enterMoreItems = 'Y';

        System.out.println("Enter the item Name");
        String item_name = sc.nextLine();
        System.out.println("Enter the item Type");
        String item_type = sc.nextLine();
        System.out.println("Enter the item Quantity");
        int item_quantity = sc.nextInt();
        System.out.println("Enter the item Price");
        int item_price = sc.nextInt();
        Item item = new Item(item_name,item_type,item_price,item_quantity);
        item.item_sales_tax = calculateTaxOnItem(item);
        item.item_final_price = itemFinalPrice(item,item.item_sales_tax);



        while(enterMoreItems!='N'){


            System.out.println(item.toString());
            enterMoreItems = sc.next().charAt(0);
        }


    }

    public static void main(String args[]) {
        TaxCalculator.runProgram();
    }

}
