
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Exe2 {
    static Stack<Integer> s = new Stack<>();
    static Queue<Integer> q = new LinkedList<Integer>(); 
    public static void main (String[] args) {
        String str = "1221";
        System.out.println("Result: " + checkPalindrome(str));
    }

    public static boolean checkPalindrome(String str){
        String[] t = str.split("");//t = {"1","2", "2","1"}
        for(int i=0; i<t.length; i++){
            s.push(Integer.parseInt(t[i]));
            q.add(Integer.parseInt(t[i]));
        }
        while(q.isEmpty() == false){
            if(s.pop() != q.remove()){
                return false;
            }
        }
        return true;
    }
}
