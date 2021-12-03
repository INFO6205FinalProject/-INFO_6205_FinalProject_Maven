package team;

import team.sort.*;
import team.sort.HuskySortCoder.Coder;
import team.sort.HuskySortCoder.EnglishCoder;
import team.sort.HuskySortCoder.UTF8Coder;
import team.sort.HuskySortCoder.UnicodeCoder;

public class Benchmark {

    private static final int BITS_LONG = 64;
    private static final int BIT_WIDTH_ENGLISH = 6;
    private static final int MAX_LENGTH_ENGLISH = BITS_LONG / BIT_WIDTH_ENGLISH;
    private static final int BIT_WIDTH_UNICODE = 16;
    private static final int MAX_LENGTH_UNICODE = BITS_LONG / BIT_WIDTH_UNICODE;

    private Sort sortAlgorithm ;
    private long time;
    public  Benchmark(SortMethod sortMethod, MingZi[] data){

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
                sortAlgorithm = new HuskySort(false, false);
                break;
            default:
                break;
        }
        this.sortAlgorithm.setData(data);
    }
    public  Benchmark(SortMethod sortMethod, MingZi[] data, HuskyEncode encode){
        Coder coder = new EnglishCoder(MAX_LENGTH_ENGLISH);
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
            case HuskySort:{
                switch (encode) {
                    case UTF8:
                        coder = new UTF8Coder(0);
                        break;
                    case English:
                        coder = new EnglishCoder(MAX_LENGTH_ENGLISH);
                        break;
                    case Unicode:
                        coder = new UnicodeCoder(MAX_LENGTH_UNICODE - 1);
                        break;
                }
                sortAlgorithm = new HuskySort(false,false, coder);
            }
                break;
            default:
                break;
        }
        this.sortAlgorithm.setData(data);
    }

    public void runBenchmark() {
        long startTime = System.currentTimeMillis();
        this.sortAlgorithm.preWork();
        this.sortAlgorithm.run();
        long endTime = System.currentTimeMillis();
        this.time = endTime - startTime;
    }

    public long getTime(){
        return this.time;
    }

    public static void main(String[] args) {
        int arrSize = 10;
        MingZi[] arr = new MingZi[arrSize];
        int loop = 50;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new MingZi(GenerateName.randomName());
        }
        Benchmark b = new Benchmark(SortMethod.HuskySort,arr,HuskyEncode.English);
        b.runBenchmark();
        System.out.println(b.getTime());
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i].getPinYin());
        }
    }
}
