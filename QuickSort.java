public class QuickSort {

    /**
     *
     * Use the provided random object to select your pivots.
     * For example if you need a pivot between a (inclusive)
     * and b (exclusive) where b > a, use the following code:
     *
     * int pivotIndex = rand.nextInt(b - a) + a;
     *
     * It should be:
     *  in-place
     *
     * Have a worst case running time of:
     *  O(n^2)
     *
     * And a best case running time of:
     *  O(n log n)
     *
     * Note that there may be duplicates in the array, but they may not
     * necessarily stay in the same relative order.
     * 
     *
     * @throws IllegalArgumentException if the array or comparator or rand is
     * null
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @param rand the Random object used to select pivots
     */
    public static <T> void quickSort(T[] arr, Comparator<T> comparator,
                                     Random rand) {
        if (arr == null || comparator == null || rand == null) {
            throw new IllegalArgumentException("null input arguments");
        }
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr, comparator, rand, low, high);
    }

    /**
     * Private helper method of quickSort.
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @param rand the Random object used to select pivots
     * @param low the left most bound of the array.
     * @param high the right most bound of the array.
     */
    private static <T> void quickSort(T[] arr, Comparator<T> comparator,
            Random rand, int low, int high) {
        if (high - low <= 0) {
            return;
        }
        T temp;
        int random = rand.nextInt(high - low) + low;
        T pivot = arr[random];
        temp = arr[low];
        arr[low] = arr[random];
        arr[random] = temp;
        int i = low + 1;
        int j = high;
        while (i <= j) {
            while (i <= j && comparator.compare(arr[i], pivot) < 0) {
                i++;
            }
            while (i < j && comparator.compare(arr[j], pivot) > 0) {
                j--;
            }
            if (i == j) {
                j--;
            } else if (i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;  
        quickSort(arr, comparator, rand, low, j - 1);
        quickSort(arr, comparator, rand, i, high);
    }
}