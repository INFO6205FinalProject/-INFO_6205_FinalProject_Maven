package team;

import team.sort.*;

public class Benchmark {

    private Sort sortAlgorithm ;
    private long time;
    public Benchmark(SortMethod sortMethod, MingZi[] data){
        switch (sortMethod) {
            case TimSort:
                sortAlgorithm = new Timsort();
                break;
            case LSDSort:
                sortAlgorithm = new LSD();
                break;
            case MSDSort:
                sortAlgorithm = new MSD();
                break;
            case QuickSort:
                sortAlgorithm = new DualQuicksort();
                break;
            case HuskySort:
                break;
            default:
                break;
        }
        this.sortAlgorithm.setData(data);
    }

    public void runBenchmark() {
        long startTime = System.currentTimeMillis();
        this.sortAlgorithm.run();
        long endTime = System.currentTimeMillis();

        this.time = endTime - startTime;
    }

    public long getTime(){
        return this.time;
    }

    public static void main(String[] args) {

        MingZi[] str = new MingZi[]{new MingZi("典中典"),new MingZi("东百往事")};

        Benchmark test = new Benchmark(SortMethod.TimSort, str);

        test.runBenchmark();
        long time = test.getTime();

        System.out.println("time in  milliseconds:" + time);
    }
}
