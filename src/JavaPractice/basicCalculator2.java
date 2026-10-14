package JavaPractice;
import java.util.*;
public class basicCalculator2 {
    static void main(String[] args) {

        String s=" 3+5 / 2 ";

        String temp = s.replaceAll("\\s+","");
        String[] number = new String[temp.length()];
        String[] operator = new String[temp.length()];

        Map<String,Integer> Operators =new HashMap<>();

        Operators.put("+",1);
        Operators.put("-",1);
        Operators.put("*",2);
        Operators.put("/",2);

        for(int i = 0;i<temp.length();i++){
            char current = temp.charAt(i);

        }
    }

}
