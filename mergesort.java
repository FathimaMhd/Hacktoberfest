import java.io.*;
import java.util.*;

public class MergeSort {
    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)           a[k] = aux[j++];
            else if (j > hi)            a[k] = aux[i++];
            else if (aux[j]<aux[i])     a[k] = aux[j++];
            else                        a[k] = aux[i++];
        }
    }
    
    private static void sort(int[] a, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }
    
    public static void sort(int[] a) {
        int aux[] = new int[a.length];
        sort(a, aux, 0, a.length-1);
    }
    private static int[] inputIntArray() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] arr=reader.readLine().split(" ");
		
		int[] intarr=new int[arr.length];

        for(int i=0;i<arr.length;i++)
            intarr[i]=Integer.parseInt(arr[i]);

        return intarr;
    }
    
    private static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
	public static void main (String[] args) throws IOException {
		int arr[] = inputIntArray();
        MergeSort.sort(arr);
        printArray(arr);
	}
}
