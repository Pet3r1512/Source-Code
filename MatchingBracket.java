import java.util.NoSuchElementException;

public class MatchingBracket {
    public static void main(String[] args) throws NoSuchElementException {
        String s = "[()]{}";
        System.out.println(s);
        String output = "No error";
        char[] t = s.toCharArray();
        MyStack<Character> bracketStack = new MyStack<Character>();
        for (int i = 0; i < t.length; i++){
            if(t[i] == '(' || t[i] == '{' || t[i] == '['){
                bracketStack.push(t[i]);
            }
            if(t[i] == ')' || t[i] == '}' || t[i] == ']'){
                if(bracketStack.isEmpty()){
                    output = "Too many close brackets";
                    break;
                }
                else if ((bracketStack.peek() == '(' & t[i] == ')') || (bracketStack.peek() == '[' & t[i] == ']') || (bracketStack.peek() == '{' & t[i] == '}')){
                    bracketStack.pop();
                }
                else{
                    output = "Mismatch error";
                    break;
                }
            }
        }
        if(!bracketStack.isEmpty() && output.equals("No error")){
            output = "Too many open brackets";
        }
        System.out.println(output);
    }
}
