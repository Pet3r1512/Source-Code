
import java.util.Stack;
public class Exe3 {
    static Stack<String> s = new Stack<>();
    public static void main (String[] args) {
        String str = "I can     fly";
        str = str.replaceAll("( )+", " ");
        System.out.println("Reversed sentence: " + reverseSentence(str));
    }

    public static String reverseSentence(String str){
        String result = "";
        String[] t = str.split(" ");
        for(int i=0; i<t.length; i++){
            s.push(t[i]);
        }
        while(!s.isEmpty()){
            result += s.pop() + " ";
        }
        result = result.substring(0, result.length()-1);
        return result;
    }
}
