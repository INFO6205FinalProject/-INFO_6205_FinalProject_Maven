package team;

import team.sort.*;

public class Benchmark {

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
            default:
                break;
        }
        this.data = data;
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

}
