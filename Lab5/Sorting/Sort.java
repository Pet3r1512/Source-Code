public class Sort {
    public static void main (String[] args) {
        int[] a = {9, 2, 1, -12, 3, 5};
        print(SelectionSort(a));
        print(BubleSort(a));
        print(InsertionSort(a));
    }

    public static void print(int[] a){
        int n = a.length;
        System.out.print("[" + a[0]);
        for(int i=1; i<n; i++){
            System.out.print(" " + a[i]);
        }
        System.out.println("]");
    }

    public static int[] SelectionSort(int[] a){
        int n = a.length;
        for(int i=0; i<n-1; i++){
            int min_index = i;
            for(int j=i+1; j<n; j++){
                if(a[j] < a[min_index]){
                    min_index = j;
                }
            }
            int tmp = a[min_index];
            a[min_index] = a[i];
            a[i] = tmp;
        }
        return a;
    }

    public static int[] BubleSort(int[] a){
        int n = a.length;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(a[j] > a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
        return a;
    }

    public static int[] InsertionSort(int[] a){
        int n = a.length;
        for(int i=1; i<n-1; i++){
            int key = a[i];
            int j = i-1;
            while(j>=0 && a[j] > key){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
        }
        return a;
    }
}
