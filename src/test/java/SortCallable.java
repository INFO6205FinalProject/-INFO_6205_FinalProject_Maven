import team.*;
import team.sort.HuskySortDir.HuskySortCombo.sort.huskySort.HuskySortBenchmark;
import team.sort.HuskySortDir.MyHuskySortBenchmark;

import java.util.ArrayList;
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

        int loop = arrSize/1000000;

        arrSize = arrSize % 1000000;
        if(arrSize == 0){
            arrSize = 1000000;
        }

        String addr = "src/main/resources/shuffledChinese.txt";
        ArrayList<String> list = TXT.read_txt(addr,arrSize);

        if(loop>1){
            while(loop>1){
                for(int i = 0;i<1000000;i++) {
                    list.add(list.get(i));
                }
                loop--;
            }
        }

        String[] arr = new String[list.size()];

        for(int i = 0;i<list.size();i++) {
            arr[i] = list.get(i);
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
        long timTime;

        if(sortMethod == SortMethod.HuskySort){
            MyHuskySortBenchmark tim = new MyHuskySortBenchmark();
            tim.setData(arr);
            tim.runBenchmark();
            timTime = tim.getTime();

        }else{
            Benchmark tim = new Benchmark(sortMethod, arr);
            tim.runBenchmark();
            timTime = tim.getTime();
        }

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