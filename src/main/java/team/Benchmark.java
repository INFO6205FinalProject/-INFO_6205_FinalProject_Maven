package team;

import team.sort.*;
import team.sort.HuskySortCoder.Coder;
import team.sort.HuskySortCoder.EnglishCoder;
import team.sort.HuskySortCoder.UTF8Coder;
import team.sort.HuskySortCoder.UnicodeCoder;

import java.util.ArrayList;

public class Benchmark {

    private static final int BITS_LONG = 64;
    private static final int BIT_WIDTH_ENGLISH = 6;
    private static final int MAX_LENGTH_ENGLISH = BITS_LONG / BIT_WIDTH_ENGLISH;
    private static final int BIT_WIDTH_UNICODE = 16;
    private static final int MAX_LENGTH_UNICODE = BITS_LONG / BIT_WIDTH_UNICODE;

    private Sort sortAlgorithm ;
    private Sort warmupSort;
    private String[] data;
    private String[] result;
    private long time;
    public  Benchmark(SortMethod sortMethod, String[] data){

        switch (sortMethod) {
            case TimSort:
                sortAlgorithm = new Timsort();
                warmupSort = new Timsort();
                break;
            case LSDSort:
                sortAlgorithm = new LSD();
                warmupSort = new LSD();
                break;
            case MSDSort:
                sortAlgorithm = new MSD();
                warmupSort = new MSD();
                break;
            case QuickSort:
                sortAlgorithm = new DualQuicksort();
                warmupSort = new DualQuicksort();
                break;
            case HuskySort:
                sortAlgorithm = new HuskySort(false, false);
                break;
            default:
                break;
        }
        this.data = data;
    }
    public  Benchmark(SortMethod sortMethod, MingZi[] data, HuskyEncode encode){
        Coder coder = new EnglishCoder(MAX_LENGTH_ENGLISH);
        switch (sortMethod) {
            case TimSort:
                sortAlgorithm = new Timsort();
                warmupSort = new Timsort();
                break;
            case LSDSort:
                sortAlgorithm = new LSD();
                warmupSort = new LSD();
                break;
            case MSDSort:
                sortAlgorithm = new MSD();
                warmupSort = new MSD();
                break;
            case QuickSort:
                sortAlgorithm = new DualQuicksort();
                warmupSort = new DualQuicksort();
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

    public void warmup(){
        for(int i = 0; i<10; i++) {
            MingZi[] m = new MingZi[20];
            for (int j = 0; j < 20; j++) {
                m[j] = new MingZi(GenerateName.randomName());
            }
            this.warmupSort.setData(m);
            this.warmupSort.preWork();
            this.warmupSort.run();
        }

    }

    public String[] getResult(){
        return this.result;
    }
    public void runBenchmark() {
        warmup();
        long startTime = System.currentTimeMillis();
        MingZi[] m = new MingZi[this.data.length];
        for(int i = 0; i < this.data.length; i++){
            m[i] = new MingZi(this.data[i]);
        }
        this.sortAlgorithm.setData(m);
        this.sortAlgorithm.preWork();
        this.sortAlgorithm.run();
        MingZi[] re = this.sortAlgorithm.getData();
        this.result = new String[re.length];
        for(int i = 0; i < re.length; i++){
            this.result[i] = re[i].getHanZi();
        }
        long endTime = System.currentTimeMillis();
        this.time = endTime - startTime;
    }

    public long getTime(){
        return this.time;
    }

    public static void main(String[] args) {
        int arrSize = 10;
//        MingZi[] arr = new MingZi[arrSize];
//        int loop = 50;
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = new MingZi(GenerateName.randomName());
//        }
        String[] arr = new String[arrSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = GenerateName.randomName();
        }
        Benchmark b = new Benchmark(SortMethod.LSDSort,arr);
        b.runBenchmark();
        System.out.println(b.getTime());
        String[] r = b.result;
        for(int i = 0; i < r.length; i++){
            System.out.println(r[i]);
        }
    }
}
