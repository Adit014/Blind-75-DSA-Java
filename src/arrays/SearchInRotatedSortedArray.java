public class SearchInRotatedSortedArray {
    public int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                index = mid;
                break;
            }

            if (arr[left] <= arr[mid]) {

                if (arr[left] <= target && target <= arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= arr[right] && arr[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return index;
    }
}
