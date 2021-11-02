
public class Recursion1 {
    public static void main (String[] args) {
        System.out.println("Producr recursion: " + prod_recursion(2,3));
        System.out.println("Convert Binary to decimal: " + bin2dec(1000, 0));
        int n = 193;
        int[] a = {1, 5, 4, -2, 9};
        if(n<0){
            System.out.println("This is not positive number");
        }
        else{
            System.out.println("Max digit is " + maxDigit(n));
        }
        System.out.println("Max element is the array is " + maxElement(a, a.length));
        if(search(a,a.length,3) == -1){
            System.out.println("This element is not in the array");
        }
        else{
            System.out.println("This element is located at position number " + search(a,a.length,3));
        }
    }

    public static double prod_recursion(int a, int b){// 1 2 -> 2 1 -> 2 + 0 = 2
        if(a == 0 || b == 0){
            return 0;
        }
        else if(a < b){
            return prod_recursion(b, a);
        }
        else{
            return a + prod_recursion(a, b-1);
        }
    }

    public static int bin2dec(int n, int exp){
        if(n == 0){
            return 0;
        }
        else{
            return (int)((n%10)*Math.pow(2,exp) + bin2dec(n/10, exp+1));
        }
    }

    public static int maxDigit(int n){//123 12.3 -> digit = 3 -digit = 2
        int max;
        if(n > 0){
            int digit = n%10;
            max = maxDigit(n/10);
            return Math.max(digit, max);
        }
        else{
            return 0;
        }
    }

    public static int maxElement(int[] a, int n){
        if(n == 1){
            return a[0];
        }
        else{
            return Math.max(a[a.length-1], maxElement(a, n-1));
        }
    }

    public static int search(int[] a, int n, int key){
        if(n == 0){
            return -1;
        }
        if(a[n-1] == key){
            return n-1;
        }
        else{
            return search(a, n-1, key);
        }
    }
}