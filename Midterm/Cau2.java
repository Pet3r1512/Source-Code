public class Cau2 {
    public static void main (String[] args) {
        int n = 3, k =4;
        if(n < 0 || k < 0){
            System.out.println("Wrong input");
        }
        else{
            System.out.println("Result = " + recur(n,k));
        }
    }

    public static int recur(int n, int k){
        if(k == 0){
            return 1;
        }
        return n * recur(n, k-1);
    }
}
