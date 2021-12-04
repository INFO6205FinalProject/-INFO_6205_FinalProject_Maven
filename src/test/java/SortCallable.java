import team.Benchmark;
import team.GenerateName;
import team.MingZi;
import team.SortMethod;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class SortCallable implements Callable<Long> {

    private  String name;
    private SortMethod sortMethod;
    private  int arrSize;
    private  String sortType;
    public SortCallable(String name, SortMethod sortMethod, int arrSize, String sortType) {
        this.name = name;
        this.sortMethod = sortMethod;
        this.arrSize = arrSize;
        this.sortType = sortType;
    }

    @Override
    public Long call() throws Exception {

        System.out.println(name+ " thread start");
        String[] arr = new String[arrSize];

        for(int i = 0;i<arr.length;i++){

            arr[i] = GenerateName.randomName();
        }

        if(this.sortType.equals("random")){
            //ToDo
        }else if(this.sortType.equals("order")){
            arr = orderArr(arr);
        }else if(this.sortType.equals("reverse")){
            arr = reverseOrder(arr);
        }else{
            System.out.println("SortType Error");
            return null;
        }

        Benchmark tim = new Benchmark(sortMethod, arr);
        tim.runBenchmark();
        long timTime = tim.getTime();
        return timTime;
    }

    private String[] orderArr(String[] arr){
        Arrays.sort(arr,(name1, name2)->{
            return name1.compareTo(name2);
        });
        return  arr;
    }

    private String[] reverseOrder(String[] arr){
        Arrays.sort(arr,(name1,name2)->{
            return name2.compareTo(name1);
        });
        return  arr;
    }
}