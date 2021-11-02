
import java.util.Stack;
public class Exe1 {
    static Stack<String> s1 = new Stack<>();
    public static void main (String[] args) {
        String s = "9 2 - 6 * 7 + 7 /";
        System.out.println("Result: " + CalculatePosflix(s));
    }

    public static double CalculatePosflix(String s){
        String[] t = s.split(" ");
        for(String i : t){
            if(i.equals("+") || i.equals("-") || i.equals("*") || i.equals("/")){
                int a = Integer.parseInt(s1.pop());
                int b = Integer.parseInt(s1.pop());
                if(i.equals("+")){
                    int res = b + a;
                    s1.push(String.valueOf(res));
                }
                if(i.equals("-")){
                    int res = b - a;
                    s1.push(String.valueOf(res));
                }
                if(i.equals("*")){
                    int res = b * a;
                    s1.push(String.valueOf(res));
                }
                if(i.equals("/")){
                    if(a != 0){
                        s1.push(String.valueOf(b/a));
                    }
                }
            }
            else{
                s1.push(String.valueOf(i));
            }
        }
        return Double.parseDouble(s1.pop());
    }

    public static boolean isNum(String s){
        return s.matches("0|([1-9][0-9]*)");
    }
}
