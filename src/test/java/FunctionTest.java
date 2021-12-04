import org.junit.Assert;
import org.junit.Test;
import team.GenerateName;
import team.MingZi;
import team.sort.*;
import team.sort.HuskySortDir.HuskySortBenchmark;

import java.util.Arrays;

public class FunctionTest {
    int arrSize = 10;

    @Test
    public void MsdTest() {
        MingZi[] arr = new MingZi[arrSize];
        MingZi[] test = new MingZi[arrSize];
        boolean flag = true;
        int loop = 50;
        while(loop>0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = new MingZi(GenerateName.randomName(),true);
                test[i] = arr[i];
            }

            MSD.MSDSort(arr);
            Arrays.sort(test);

            for (int i = 0; i < arr.length; i++) {
                if (!arr[i].getHanZi().equals(test[i].getHanZi())) {
                    flag = false;
                    break;
                }

            }
            if(!flag) break;
            loop--;
        }

        Assert.assertEquals(true,flag);
    }

    @Test
    public void TimSortTest() {
        MingZi[] arr = new MingZi[arrSize];
        MingZi[] test = new MingZi[arrSize];
        boolean flag = true;
        int loop = 50;
        while(loop>0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = new MingZi(GenerateName.randomName(),true);
                test[i] = arr[i];
            }

            Timsort.TimSort(arr);
            Arrays.sort(test);

            for (int i = 0; i < arr.length; i++) {
                if (!arr[i].getHanZi().equals(test[i].getHanZi())) {
                    flag = false;
                    break;
                }

            }
            if(!flag) break;
            loop--;
        }
        Assert.assertEquals(true,flag);
    }
    @Test
    public void HuskySortTest() {
        String[] arr = new String[arrSize];
        MingZi[] test = new MingZi[arrSize];
        boolean flag = true;
        int loop = 1;
        while(loop>0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = GenerateName.randomName();
                test[i] = new MingZi(arr[i],true);
            }

            HuskySortBenchmark hs = new HuskySortBenchmark();
            hs.setData(arr);
            hs.runBenchmark();

            Arrays.sort(test);

            for (int i = 0; i < arr.length; i++) {
                if (!arr[i].equals(test[i].getHanZi())) {
                    flag = false;
                    break;
                }
            }
            if(!flag) break;
            loop--;
        }

        Assert.assertEquals(true,flag);
    }
    @Test
    public void LsdTest() {

        MingZi[] arr = new MingZi[arrSize];
        MingZi[] test = new MingZi[arrSize];
        boolean flag = true;
        int loop = 10;
        while(loop>0){
            for(int i = 0;i<arr.length;i++){
                arr[i] = new MingZi(GenerateName.randomName(),true);
                test[i] = arr[i];
            }

            LSD.LSDSort(arr);
            Arrays.sort(test);

            for(int i = 0;i<arr.length;i++){
                if(!arr[i].getHanZi().equals(test[i].getHanZi())){
                    flag = false;
                    break;
                }
            }
            if(!flag) break;
            loop--;
        }

        Assert.assertEquals(true,flag);

    }
    @Test
    public void DualQuicksortTest() {
        MingZi[] arr = new MingZi[arrSize];
        MingZi[] test = new MingZi[arrSize];
        boolean flag = true;

        int loop = 50;
        while(loop>0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = new MingZi(GenerateName.randomName(),true);
                test[i] = arr[i];
            }

            DualQuicksort.DualPivotQuickSort(arr, 0, arr.length - 1);

            Arrays.sort(test);

            for (int i = 0; i < arr.length; i++) {
                if (!arr[i].getHanZi().equals(test[i].getHanZi())) {
                    flag = false;
                    break;
                }
            }
            if(!flag) break;
            loop--;
        }
        Assert.assertEquals(true,flag);
    }
}

