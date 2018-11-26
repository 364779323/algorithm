import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int n = input.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = input.nextInt();

            mergesort(arr, 0, n - 1);
            for (int i = 0; i < n; i++) {
                if (i == n - 1)
                    System.out.println(arr[i]);
                else
                    System.out.print(arr[i] + " ");
            }

        }
    }

    public static void mergesort(int[] arr, int left, int right) {
        if (left == right) return;
        else {
            int mid = (left + right) >> 1;
            mergesort(arr, left, mid);
            mergesort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while (i <= mid)
            temp[k++] = arr[i++];
        while (j <= right)
            temp[k++] = arr[j++];

        for (int x = 0; x < temp.length; x++)
            arr[x + left] = temp[x];
        
        temp=null；//释放临时数组的空间

    }

}
