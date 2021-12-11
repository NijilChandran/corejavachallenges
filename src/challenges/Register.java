package challenges;

import java.util.HashMap;
import java.util.Map;

/**
 *  Register:
 *  Maintains a list of items (say fruits) for sale and their sale price
 *  Initiates and completes checkout by returning a total bill amount based on
 *  input quantity
 *
 *  Register getInstance() - a static method
 *  String getTotalBill(Map<String,Integer> ItemDetails)
 *

 *
 *  Per unit price:
 *  Item|Price
 *  ------------
 *  apple|2.0
 *  orange|1.5
 *  mango|1.2
 *  grape|1.0
 *
 */
public class Register {

    private static Register register = null;

    Map<String,Float> registerItems;

    private Register(){
        System.out.println("Here is where item wise prices are registered");
        registerItems = new HashMap<String,Float>();
        registerItems.put("apple",2.0f);
        registerItems.put("orange",1.5f);
        registerItems.put("mango",1.2f);
        registerItems.put("grape",1.0f);
    }
    public static Register getInstance(){

        if (register == null)
            register = new Register();

        return register;
    }

    public String getTotalBill(Map<String,Integer> itemDetails) {

        float sum=0.0f;
        for (Map.Entry<String,Integer> entry : itemDetails.entrySet()) {

            System.out.println("item : " + entry.getKey() +
                        ", itm_count : " + entry.getValue());

            if(registerItems.containsKey(entry.getKey())){
                sum += (float)registerItems.get(entry.getKey()) * entry.getValue() ;
            }else{
                System.out.println("item is not present ");
            }

        }
        return String.valueOf(sum);
    }
}
