package challenges;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *  *  Input: String with a list of purchased items
 *  *  ex: apple 30 orange 10 mango 20
 *  *  output: 99 ( 30*2 + 10*1.5 + 20*1.2) , where 2,1.5,1.2 are per unit price in register
 */
public class RegisterDriver {

    public static void main(String[] args) {

        Scanner readInput = new Scanner(System.in);
        String[] input = readInput.nextLine().split(" ");

        Map<String,Integer> myItems = new HashMap<String,Integer>();
        for (int i =0; i < input.length ; i+=2) {
            myItems.put(input[i],Integer.parseInt(input[i+1]));
        }
        Register regObj = Register.getInstance();
        System.out.println(regObj.getTotalBill(myItems));
        readInput.close();
    }
}
