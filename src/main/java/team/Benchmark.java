package team;

import team.sort.*;

public class Benchmark {

    private Sort sortAlgorithm ;
    private long time;
    public Benchmark(SortMethod sortMethod, String[] data){
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
        Benchmark test = new Benchmark(SortMethod.TimSort, str);
        test.runBenchmark();
        long time = test.getTime();
        System.out.println("time in  milliseconds:" + time);
    }
}
