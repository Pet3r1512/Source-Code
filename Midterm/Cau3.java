import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
public class Cau3 {
    static Stack<Integer> newStack = new Stack<>();
    static Queue<Integer> newStack1 = new LinkedList<>();
    public static void main (String[] args) {
        String[] s = {"3", "4", "+", "2", "1", "+", "-"};
        System.out.println("Result: " + calculate(s));
    }

    public static int calculate(String[] expression){
        for(int i=0; i<expression.length; i++){
            if(isNumber(expression[i]) == true){
                int number = Integer.parseInt(expression[i]);
                newStack.push(number);
            }
            else{
                if(expression[i].equals("+")){
                    int o1 = newStack.pop();
                    int o2 = newStack.pop();
                    int o3 = o2 + o1;
                    newStack.push(o3);
                }
                if(expression[i].equals("-")){
                    int o1 = newStack.pop();
                    int o2 = newStack.pop();
                    int o3 = o2 - o1;
                    newStack.push(o3);
                }
            }
        }
        return newStack.pop();
    }

    public static boolean isNumber(String s){
        return s.matches("0|([1-9][0-9]*)");
    }
}
