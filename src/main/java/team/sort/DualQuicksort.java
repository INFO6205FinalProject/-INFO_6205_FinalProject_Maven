package team.sort;

import team.Benchmark;
import team.GenerateName;
import team.MingZi;

import java.util.Arrays;

import static team.SortMethod.MSDSort;
import static team.SortMethod.QuickSort;

public class DualQuicksort implements Sort {


    private MingZi[] data;
    static void swap(MingZi[] arr, int i, int j)
    {
        MingZi temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void dualPivotQuickSort(MingZi[] arr,
                                   int low, int high)
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
        if (arr[low].compareTo(arr[high])>0)
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

        MingZi[] k = new MingZi[1000000];

        for(int i = 0;i<1000000;i++){
            k[i] = new MingZi(GenerateName.randomName());
        }
        Arrays.sort(k,(name1, name2)->{
            return  name2.compareTo(name1);
        });

        Benchmark benchmark = new Benchmark(QuickSort,k);
        benchmark.runBenchmark();

        System.out.println(benchmark.getTime());

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
