
public class Recursion2 {
    public static void main (String[] args) {
        System.out.println("a) " + a(3));
        System.out.println("b) " + b(3));
        System.out.println("c) " + c(3));
        System.out.println("d) " + d(3));
        System.out.println("e) " + e(3));
    }

    public static int a(int n){
        if(n == 1){
            return 2;
        }
        else{
            return (int)Math.pow(2,n) + a(n-1);
        }
    }

    public static double b(int n){
        if(n == 0){
            return 0.5;
        }
        else{
            return (n+1)/2 + b(n-1);
        }
    }

    public static int Factorial(int n){
        int s = 1;
        for(int i=0; i<=n ;i++){
            s *= i;
        }
        return s;
    }

    public static double c(int n){
        if(n == 1){
            return 1;
        }
        else{
            return (Factorial(n)/Factorial(n-1)) + c(n-1);
        }
    }

    public static int d(int n){
        if(n == 1){
            return 0;
        }
        else{
            return n*(n-1) + d(n-1);
        }
    }

    public static int e(int n){
        if(n == 1){
            return 1;
        }
        return n*e(n-1);
    }
}
