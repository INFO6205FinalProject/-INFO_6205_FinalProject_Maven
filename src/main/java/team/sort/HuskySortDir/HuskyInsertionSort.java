package team.sort.HuskySortDir;

import team.MingZi;

class HuskyInsertionSort {

    public static void sort(MingZi[] arr)
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            MingZi key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}

