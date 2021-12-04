package team;

import java.util.ArrayList;
import team.sort.HuskySortCombo.sort.huskySort.*;
import team.sort.HuskySortCombo.sort.huskySortUtils.HuskyCoderFactory;

public class BenchmarkForHuskySort {
    private long time;

//    public void runBenchmark() {
//        long startTime = System.currentTimeMillis();
//        this.sortAlgorithm.preWork();
//        this.sortAlgorithm.run();
//        long endTime = System.currentTimeMillis();
//        this.time = endTime - startTime;
//    }

    public long getTime(){
        return this.time;
    }

    public static void main(String[] args) {
        ArrayList<String> hz;
        String addr = "D:\\Northeastern\\INFO6205\\shuffledChinese.txt";
        hz = TXT.read_txt(addr);
        String[] arr = new String[1000];
        for(int i = 0; i < 1000; i++){
            arr[i] = hz.get(i);
        }

        final PureHuskySort<String> sorter = new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false);
        sorter.sort(arr);
        for(String j : arr){
            System.out.println(j);
        }
    }

}
