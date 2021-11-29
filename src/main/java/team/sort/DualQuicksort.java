package team.sort;

import team.MingZi;

public class DualQuicksort implements Sort {


    private MingZi[] data;
    static void swap(MingZi[] arr, int i, int j)
    {
        MingZi temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void dualPivotQuickSort(MingZi[] arr, int low, int high)
    {
        if (low < high)
        {
            int[] piv;
            piv = partition(arr, low, high);

            dualPivotQuickSort(arr, low, piv[0] - 1);
            dualPivotQuickSort(arr, piv[0] + 1, piv[1] - 1);
            dualPivotQuickSort(arr, piv[1] + 1, high);
        }
    }

    static int[] partition(MingZi[] arr, int low, int high)
    {
        if (arr[low].compareTo( arr[high])>0)
            swap(arr, low, high);

        int j = low + 1;
        int g = high - 1, k = low + 1;
        MingZi  p = arr[low], q = arr[high];

        while (k <= g)
        {

            if (arr[k].compareTo(p)<0)
            {
                swap(arr, k, j);
                j++;
            }else if (arr[k].compareTo(q)>=0) {
                while (arr[g].compareTo(q)>0 && k < g)
                    g--;

                swap(arr, k, g);
                g--;

                if (arr[k].compareTo(p)<0)
                {
                    swap(arr, k, j);
                    j++;
                }
            }
            k++;
        }
        j--;
        g++;

        swap(arr, low, j);
        swap(arr, high, g);

        return new int[] { j, g };
    }

    // Driver code
    public static void main(String[] args)
    {

        MingZi[] str = new MingZi[] { new MingZi("黄佳佳"),new MingZi("蓝果果"),new MingZi("绿泡泡") ,new MingZi("红彤彤") ,new MingZi("绿泡泡"), new MingZi("李好"),new MingZi("泰勒"), new MingZi("阿里巴巴")};

        dualPivotQuickSort(str, 0, str.length-1);

        System.out.print("Sorted array: ");
        for (int i = 0; i < str.length; i++)
            System.out.print(str[i].getPinYin() + " ");

    }

    @Override
    public void setData(MingZi[] data){
        this.data = data;
    }
    @Override
    public void run() {
        dualPivotQuickSort(this.data, 0, this.data.length - 1);
    }
}
