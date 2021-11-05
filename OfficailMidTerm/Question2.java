import java.util.Stack;
public class Question2 {
    public static void main (String[] args) {
        int arr[] = {1,2,3,4,5};
        System.out.println("Reverse Int list: " + reverseIntList(arr));
    }

    public static String reverseIntList(int[] arr){
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<arr.length; i++ ){
            stack.push(arr[i]);
        }
        String result = "";
        while(!stack.isEmpty()){
            result += String.valueOf(stack.pop());
        }
        return result;
    }
}
