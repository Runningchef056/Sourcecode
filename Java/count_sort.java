import java.util.Arrays;

public class CountSort {
    
    public static void countSort(int[] arr) {
        int n = arr.length;

        // Step 1: Find the maximum and minimum element
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        // Step 2: Create a count array to store the frequency of each element
        int range = max - min + 1;
        int[] count = new int[range];

        // Step 3: Store the frequency of each element in the count array
        for (int i = 0; i < n; i++) {
            count[arr[i] - min]++;
        }

        // Step 4: Modify the count array such that each element at index i
        // contains the position of this element in the output array
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Step 5: Build the output array using the count array
        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        // Step 6: Copy the sorted elements back into the original array
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1, 7};

        System.out.println("Original Array: " + Arrays.toString(arr));
        countSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
