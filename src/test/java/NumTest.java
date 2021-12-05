import org.junit.Before;
import org.junit.Test;
import team.Benchmark;
import team.GenerateName;
import team.MingZi;
import team.SortMethod;

import java.util.concurrent.*;

public class NumTest {

    ThreadPoolExecutor threadPool;

    @Before
    public void before() {

        System.out.println("pre working, prepare data resource");

    }

    @Test
    public void twoFiveK() {
        int arrSize = 250000;
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
            System.out.println("TimSort in 250K random  milliseconds:" + timResult.get());
            System.out.println("QuickSort in 250k random  milliseconds:" + quickResult.get());
            System.out.println("LsdSort in 250k random  milliseconds:" + lsdResult.get());
            System.out.println("MsdSort in 250k random  milliseconds:" + msdResult.get());
            System.out.println("HuskySort in 250k random  milliseconds:" + HuskyResult.get());

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    @Test
    public void FiveHundredK() {
        int arrSize = 500000;
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
            System.out.println("TimSort in 500k random  milliseconds:" + timResult.get());
            System.out.println("QuickSort in 500k random  milliseconds:" + quickResult.get());
            System.out.println("LsdSort in 500k random  milliseconds:" + lsdResult.get());
            System.out.println("MsdSort in 500k random  milliseconds:" + msdResult.get());
            System.out.println("HuskySort in 500k random  milliseconds:" + HuskyResult.get());

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Test
    public void oneM() {
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
            System.out.println("TimSort in 1M random  milliseconds:" + timResult.get());
            System.out.println("QuickSort in 1M random  milliseconds:" + quickResult.get());
            System.out.println("LsdSort in 1M random  milliseconds:" + lsdResult.get());
            System.out.println("MsdSort in 1M random  milliseconds:" + msdResult.get());
            System.out.println("HuskySort in 1M random  milliseconds:" + HuskyResult.get());

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    @Test
    public void twoM() {
        int arrSize = 2000000;
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
            System.out.println("LsdSort in 2M random  milliseconds:" + lsdResult.get());
            System.out.println("MsdSort in 2M random  milliseconds:" + msdResult.get());
            System.out.println("TimSort in 2M random  milliseconds:" + timResult.get());
            System.out.println("QuickSort in 2M random  milliseconds:" + quickResult.get());
            System.out.println("HuskySort in 2M random  milliseconds:" + HuskyResult.get());

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void fourM() {
        int arrSize = 4000000;
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
            System.out.println("LsdSort in 4M random  milliseconds:" + lsdResult.get());
            System.out.println("MsdSort in 4M random  milliseconds:" + msdResult.get());
            System.out.println("TimSort in 4M random  milliseconds:" + timResult.get());
            System.out.println("QuickSort in 4M random  milliseconds:" + quickResult.get());
            System.out.println("HuskySort in 4M random  milliseconds:" + HuskyResult.get());

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
