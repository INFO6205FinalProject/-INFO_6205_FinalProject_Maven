package team.sort;

public class Timsort implements Sort {

    static int MIN_MERGE = 32;

    private String[] data;
    public static int minRunLength(int n)
    {
        assert n >= 0;
        int r = 0;
        while (n >= MIN_MERGE)
        {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    public static void insertionSort(String[] arr, int left, int right)
    {
        for (int i = left + 1; i <= right; i++)
        {
            String temp = arr[i];
            int j = i - 1;
            //while (j >= left && arr[j].charAt(0) > temp.charAt(0))
            while (j >= left && arr[j].compareTo(temp) > 0 )
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }
    public static void merge(String[] arr, int l, int m, int r)
    {
        int len1 = m - l + 1, len2 = r - m;
        String[] left = new String[len1];
        String[] right = new String[len2];
        for (int x = 0; x < len1; x++)
        {
            left[x] = arr[l + x];
        }
        for (int x = 0; x < len2; x++)
        {
            right[x] = arr[m + 1 + x];
        }

        int i = 0;
        int j = 0;
        int k = l;
        while (i < len1 && j < len2)
        {
            //if (left[i].charAt(0) <= right[j].charAt(0))
            if(left[i].compareTo(right[j]) <= 0)
            {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < len1)
        {
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < len2)
        {
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    public static void timSort(String[] arr, int n) {
        int minRun = minRunLength(MIN_MERGE);

        for (int i = 0; i < n; i += minRun) {
            insertionSort(arr, i, Math.min((i + MIN_MERGE - 1), (n - 1)));
        }

        for (int size = minRun; size < n; size = 2 * size) {
            for (int left = 0; left < n;
                 left += 2 * size) {

                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1),
                        (n - 1));

                if (mid < right)
                    merge(arr, left, mid, right);
            }
        }
    }

    public Timsort(){

    }
    public static void main(String[] args) {
        String str[] = {"Walmart",
                "Amazon",
                "Apple Inc.",
                "CVS Health",
                "ExxonMobil",
                "UnitedHealth Group",
                "Berkshire Hathaway",
                "McKesson Corporation",
                "AmerisourceBergen",
                "Alphabet Inc.",
                "AT&T",
                "Cigna",
                "Ford Motor Company",
                "Costco",
                "FedEx",
                "Chevron Corporatio",
                "Cardinal Health",
                "Microsoft",
                "JPMorgan Chase",
                "General Motors",
                "Walgreens Boots Alnois",
                "Verizon Communicatk",
                "Marathon Petroleum",
                "Kroger",
                "Fannie Mae",
                "Bank of America"};
        timSort(str,str.length);
        for(String i: str){
            System.out.println(i);
        }
    }

    @Override
    public void setData(String[] data){
        this.data = data;
    }
    @Override
    public void run() {
        timSort(this.data, this.data.length);
    }
}
