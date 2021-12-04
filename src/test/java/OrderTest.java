import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import team.Benchmark;
import team.GenerateName;
import team.MingZi;
import team.SortMethod;

import java.util.Arrays;
import java.util.concurrent.*;

public class OrderTest {

    ThreadPoolExecutor threadPool;

    @Before
    public void before() {

        System.out.println("pre working, prepare data resource");

        System.out.println("preworking finished,");
        System.out.println();
    }


    @After
    public void after() {
        System.out.println();
        System.out.println("test end");
        threadPool.shutdown();
    }

    @Test
    public void RandomOneM() {
        int arrSize = 1000000;
        String sortType = "random";
        threadPool = new ThreadPoolExecutor(5, 6, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        SortCallable timCall= new SortCallable("TimSort",SortMethod.TimSort,arrSize, sortType);
        SortCallable quickCall= new SortCallable("QuickSort",SortMethod.QuickSort,arrSize, sortType);
        SortCallable msdCall= new SortCallable("MsdSort",SortMethod.MSDSort,arrSize, sortType);
        SortCallable lsdCall= new SortCallable("LsdSort",SortMethod.LSDSort,arrSize, sortType);
        SortCallable huskyCall= new SortCallable("HuskySort",SortMethod.HuskySort,arrSize, sortType);

        Future<Long> timResult = threadPool.submit(timCall);
        Future<Long> quickResult = threadPool.submit(quickCall);
        Future<Long> msdResult = threadPool.submit(msdCall);
        Future<Long> lsdResult = threadPool.submit(lsdCall);
        Future<Long> HuskyResult = threadPool.submit(huskyCall);

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
            System.out.println("HuskySort in random  milliseconds:" + HuskyResult.get());

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
        int arrSize = 500000;
        String sortType = "order";
        threadPool = new ThreadPoolExecutor(5, 6, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        SortCallable timCall= new SortCallable("TimSort",SortMethod.TimSort,arrSize,sortType);
        SortCallable quickCall= new SortCallable("QuickSort",SortMethod.QuickSort,arrSize,sortType);
        SortCallable msdCall= new SortCallable("MsdSort",SortMethod.MSDSort,arrSize,sortType);
        SortCallable lsdCall= new SortCallable("LsdSort",SortMethod.LSDSort,arrSize,sortType);
        SortCallable huskyCall= new SortCallable("HuskySort",SortMethod.HuskySort,arrSize, sortType);

        Future<Long> timResult = threadPool.submit(timCall);
        Future<Long> quickResult = threadPool.submit(quickCall);
        Future<Long> msdResult = threadPool.submit(msdCall);
        Future<Long> lsdResult = threadPool.submit(lsdCall);
        Future<Long> HuskyResult = threadPool.submit(huskyCall);

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
            System.out.println("HuskySort in order  milliseconds:" + HuskyResult.get());
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
        int arrSize = 500000;
        String sortType = "reverse";
        threadPool = new ThreadPoolExecutor(5, 6, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        SortCallable timCall= new SortCallable("TimSort",SortMethod.TimSort,arrSize,sortType);
        SortCallable quickCall= new SortCallable("QuickSort",SortMethod.QuickSort,arrSize,sortType);
        SortCallable msdCall= new SortCallable("MsdSort",SortMethod.MSDSort,arrSize,sortType);
        SortCallable lsdCall= new SortCallable("LsdSort",SortMethod.LSDSort,arrSize,sortType);
        SortCallable huskyCall= new SortCallable("HuskySort",SortMethod.HuskySort,arrSize, sortType);

        Future<Long> timResult = threadPool.submit(timCall);
        Future<Long> quickResult = threadPool.submit(quickCall);
        Future<Long> msdResult = threadPool.submit(msdCall);
        Future<Long> lsdResult = threadPool.submit(lsdCall);
        Future<Long> HuskyResult = threadPool.submit(huskyCall);

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
            System.out.println("HuskySort in reverse  milliseconds:" + HuskyResult.get());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
