package challenges;

import java.util.Arrays;

/**
 * cipher input/output:
 * Welcome to hackerrank
 * ?85O89*69R65*87O104*33I1043
 * decipher input/output:
 * K78A82R69K67A72*79T42E77O67L69w3
 * Hi! How are you?
 *
 * CIPHER:
 * 1.Swap case of letter in the input string
 * 2.Reverse the string
 * 3.Replace space with *
 * 4.Replace characters in even position with their equivalent ASCII value
 * 5.Add 3 at the end
 * DECIPHER:
 *  Reverse all the steps in CIPHER
 */
public class Cipherer {

    public static void main(String[] args) {

        String cipher = Cipherer.cipherIt("Hi! How are you?");
        System.out.println(cipher);

        String decipher = Cipherer.deCipherIt(cipher);
        System.out.println(decipher);

    }


    public static String cipherIt(String normal) {

        StringBuilder normalSb = new StringBuilder(normal);
        for (int i = 0; i < normal.length(); i++) {

            if (Character.isLowerCase(normal.charAt(i))) {
                normalSb.setCharAt(i, Character.toUpperCase(normal.charAt(i)));
            } else if (Character.isUpperCase(normal.charAt(i))) {
                normalSb.setCharAt(i, Character.toLowerCase(normal.charAt(i)));
            } else if (Character.isWhitespace(normal.charAt(i))) {
                normalSb.setCharAt(i, '*');
            }
        }
        normalSb.reverse();

        StringBuilder normalTemp = new StringBuilder();
        for (int i = 0; i < normalSb.length(); i++) {
            if (i % 2 != 0) {
                int ascii = (int) normalSb.charAt(i);
                normalTemp.append(ascii);
            } else {
                normalTemp.append(normalSb.charAt(i));
            }
        }
        normalTemp.append("3");
        return normalTemp.toString();
    }

    /**
     * K78A82R69K67A72*79T42E77O67L69w3
     * @param cipherStr
     * @return
     */
    public static String deCipherIt(String cipherStr) {

        StringBuilder cipherSb = new StringBuilder(cipherStr);
        int strLen = cipherStr.length();
        cipherSb.deleteCharAt(strLen - 1);

        StringBuilder cipherTemp = new StringBuilder();

        for (int i = 0; i < strLen-1; i++) {
          if(!Character.isDigit(cipherSb.charAt(i))){
              //use same character if it current
              cipherTemp.append(cipherSb.charAt(i));
          }else{
              String ascii="";
              //if loop current and next element is a number; else loop if it is a three continuous numbers
              if(Character.isDigit(cipherSb.charAt(i+1)) && !Character.isDigit(cipherSb.charAt(i+2))) {
                  ascii = cipherSb.substring(i,i+2);
                  i += 1;
              }else if(Character.isDigit(cipherSb.charAt(i+1)) && Character.isDigit(cipherSb.charAt(i+2))){
                  ascii = cipherSb.substring(i,i+3);
                  i += 2;
              }
              cipherTemp.append((char)Integer.parseInt(ascii));
          }
        }
        cipherTemp.reverse();

        for (int i = 0; i < cipherTemp.length(); i++) {

            if (Character.isLowerCase(cipherTemp.charAt(i))) {
                cipherTemp.setCharAt(i, Character.toUpperCase(cipherTemp.charAt(i)));
            } else if (Character.isUpperCase(cipherTemp.charAt(i))) {
                cipherTemp.setCharAt(i, Character.toLowerCase(cipherTemp.charAt(i)));
            }  else if (cipherTemp.charAt(i)=='*'){
                cipherTemp.setCharAt(i, ' ');
            }
        }
            return cipherTemp.toString();
        }
}
