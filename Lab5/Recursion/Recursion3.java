
public class Recursion3 {
    public static void main (String[] args) {
        System.out.println("a) " + aRecursion(1));
        System.out.println("a) " + a(1));
        // System.out.println("b) " + bRecursion(4));
        // System.out.println("c) " + cRecursion(4, 2));
        // System.out.println("d) " + dRecursion(4));
    }

    public static double aRecursion(int n){
        if(n == 0){
            return 2;
        }
        return 2- 0.5*aRecursion(n-1);
    }

    public static double a(int n){
        double kq = 2.0;
        if(n==0){return 2.0;}
        for(int i=1; i<=n; i++){
            kq += 2-0.5*i;
        }
        return kq;
    }

    public static double bRecursion(int n){
        if(n < 10){return 1;}
        return 1 + bRecursion(n/10);
    }

    public static int cRecursion(int n, int k){
        if(k == 1){return n;}
        return n + cRecursion(n, k-1);
    }

    public static int dRecursion(int n){
        if(n == 0){return 0;}
        else if(n == 1){return 1;}
        else{
            return dRecursion(n-1) + dRecursion(n-2);
        }
    }
}
