import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import team.Benchmark;
import team.GenerateName;
import team.MingZi;
import team.SortMethod;

import java.util.Arrays;
import java.util.concurrent.*;

public class MyTest {

    ThreadPoolExecutor threadPool;

    @Before
    public void before() {

        System.out.println("pre working, prepare data resource");

        System.out.println("preworking finished,");
        System.out.println();
    }

     private MingZi[] orderArr(MingZi[] arr){
         Arrays.sort(arr,(name1,name2)->{
             return name1.compareTo(name2);
         });
         return  arr;
     }

    private MingZi[] reverseOrder(MingZi[] arr){
        Arrays.sort(arr,(name1,name2)->{
            return name2.compareTo(name1);
        });
        return  arr;
    }

    @After
    public void after() {
        System.out.println();
        System.out.println("test end");
        threadPool.shutdown();
    }

    @Test
    public void RandomOneM() {
        threadPool = new ThreadPoolExecutor(5, 6, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        SortCallable timCall= new SortCallable("TimSort",SortMethod.TimSort,1000000, "random");
        SortCallable quickCall= new SortCallable("QuickSort",SortMethod.QuickSort,1000000, "random");
        SortCallable msdCall= new SortCallable("MsdSort",SortMethod.MSDSort,1000000, "random");
        SortCallable lsdCall= new SortCallable("LsdSort",SortMethod.LSDSort,1000000, "random");

        Future<Long> timResult = threadPool.submit(timCall);
        Future<Long> quickResult = threadPool.submit(quickCall);
        Future<Long> msdResult = threadPool.submit(msdCall);
        Future<Long> lsdResult = threadPool.submit(lsdCall);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        try {
            System.out.println();
            System.out.println("TimSort in random  milliseconds:" + timResult.get());
            System.out.println("QuickSort in random  milliseconds:" + quickResult.get());
            System.out.println("LsdSort in random  milliseconds:" + lsdResult.get());
            System.out.println("MsdSort in random  milliseconds:" + msdResult.get());

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    @Test
    public void OrderOneM() {

        threadPool = new ThreadPoolExecutor(5, 6, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        SortCallable timCall= new SortCallable("TimSort",SortMethod.TimSort,1000000,"order");
        SortCallable quickCall= new SortCallable("QuickSort",SortMethod.QuickSort,1000000,"order");
        SortCallable msdCall= new SortCallable("MsdSort",SortMethod.MSDSort,1000000,"order");
        SortCallable lsdCall= new SortCallable("LsdSort",SortMethod.LSDSort,1000000,"order");

        Future<Long> timResult = threadPool.submit(timCall);
        Future<Long> quickResult = threadPool.submit(quickCall);
        Future<Long> msdResult = threadPool.submit(msdCall);
        Future<Long> lsdResult = threadPool.submit(lsdCall);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        try {
            System.out.println();
            System.out.println("TimSort in order  milliseconds:" + timResult.get());
            System.out.println("LsdSort in order  milliseconds:" + lsdResult.get());
            System.out.println("MsdSort in order  milliseconds:" + msdResult.get());
            System.out.println("QuickSort in order  milliseconds:" + quickResult.get());

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void ReverseOneM() {

        threadPool = new ThreadPoolExecutor(5, 6, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        SortCallable timCall= new SortCallable("TimSort",SortMethod.TimSort,1000000,"reverse");
        SortCallable quickCall= new SortCallable("QuickSort",SortMethod.QuickSort,1000000,"reverse");
        SortCallable msdCall= new SortCallable("MsdSort",SortMethod.MSDSort,1000000,"reverse");
        SortCallable lsdCall= new SortCallable("LsdSort",SortMethod.LSDSort,1000000,"reverse");

        Future<Long> timResult = threadPool.submit(timCall);
        Future<Long> quickResult = threadPool.submit(quickCall);
        Future<Long> msdResult = threadPool.submit(msdCall);
        Future<Long> lsdResult = threadPool.submit(lsdCall);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        try {
            System.out.println();
            System.out.println("TimSort in reverse  milliseconds:" + timResult.get());
            System.out.println("LsdSort in reverse  milliseconds:" + lsdResult.get());
            System.out.println("MsdSort in reverse  milliseconds:" + msdResult.get());
            System.out.println("QuickSort in reverse  milliseconds:" + quickResult.get());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    class SortCallable implements Callable<Long> {

        private  String name;
        private  SortMethod sortMethod;
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
            MingZi[] arr = new MingZi[arrSize];

            //data source
            for(int i = 0;i<arr.length;i++){
                arr[i] = new MingZi(GenerateName.randomName());
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
    }


}
