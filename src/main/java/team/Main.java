package team;

import team.sort.HuskySortDir.MyHuskySortBenchmark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String rawFile = "src/main/resources/shuffledChinese.txt";
        String fileForTim = "src/main/resources/TimsortResult.txt";
        String fileForLSD = "src/main/resources/LSDsortResult.txt";
        String fileForMSD = "src/main/resources/MSDsortResult.txt";
        String fileForQuick = "src/main/resources/QuicksortResult.txt";
        String fileForHusky = "src/main/resources/HuskysortResult.txt";

        List<String> listForSort = TXT.read_txt(rawFile,1000);
        String[] arrForSort = new String[1000];
        for(int i = 0; i < 1000; i++){
            arrForSort[i] = listForSort.get(i);
        }
        String[] arrForTimsort = Arrays.copyOf(arrForSort,1000);
        String[] arrForQuicksort = Arrays.copyOf(arrForSort,1000);
        String[] arrForLSDsort = Arrays.copyOf(arrForSort,1000);
        String[] arrForMSDsort = Arrays.copyOf(arrForSort,1000);
        String[] arrForHuskysort = Arrays.copyOf(arrForSort,1000);

        Benchmark bForTim = new Benchmark(SortMethod.TimSort, arrForTimsort);
        bForTim.runBenchmark();
        arrForTimsort = bForTim.getResult();

        Benchmark bForLSD = new Benchmark(SortMethod.LSDSort, arrForLSDsort);
        bForLSD.runBenchmark();
        arrForLSDsort = bForLSD.getResult();

        Benchmark bForMSD = new Benchmark(SortMethod.MSDSort, arrForMSDsort);
        bForMSD.runBenchmark();
        arrForMSDsort = bForMSD.getResult();

        Benchmark bForQuick = new Benchmark(SortMethod.QuickSort, arrForQuicksort);
        bForQuick.runBenchmark();
        arrForQuicksort = bForQuick.getResult();

        MyHuskySortBenchmark bForHusky = new MyHuskySortBenchmark();
        bForHusky.setData(arrForHuskysort);
        bForHusky.runBenchmark();
        arrForHuskysort = bForHusky.getData();

        TXT.write_txt(fileForTim, new ArrayList<>(Arrays.asList(arrForTimsort)));
        TXT.write_txt(fileForLSD, new ArrayList<>(Arrays.asList(arrForLSDsort)));
        TXT.write_txt(fileForMSD, new ArrayList<>(Arrays.asList(arrForMSDsort)));
        TXT.write_txt(fileForQuick, new ArrayList<>(Arrays.asList(arrForQuicksort)));
        TXT.write_txt(fileForHusky, new ArrayList<>(Arrays.asList(arrForHuskysort)));


    }
}
