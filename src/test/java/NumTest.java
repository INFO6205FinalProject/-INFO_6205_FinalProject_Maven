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
    public void OneM() {

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
            System.out.println("TimSort in 1M random  milliseconds:" + timResult.get());
            System.out.println("QuickSort in 1M random  milliseconds:" + quickResult.get());
            System.out.println("LsdSort in 1M random  milliseconds:" + lsdResult.get());
            System.out.println("MsdSort in 1M random  milliseconds:" + msdResult.get());

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

        threadPool = new ThreadPoolExecutor(5, 6, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        SortCallable timCall= new SortCallable("TimSort",SortMethod.TimSort,2000000, "random");
        SortCallable quickCall= new SortCallable("QuickSort",SortMethod.QuickSort,2000000, "random");
        SortCallable msdCall= new SortCallable("MsdSort",SortMethod.MSDSort,2000000, "random");
        SortCallable lsdCall= new SortCallable("LsdSort",SortMethod.LSDSort,2000000, "random");

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
            System.out.println("TimSort in 2M random  milliseconds:" + timResult.get());
            System.out.println("QuickSort in 2M random  milliseconds:" + quickResult.get());
            System.out.println("LsdSort in 2M random  milliseconds:" + lsdResult.get());
            System.out.println("MsdSort in 2M random  milliseconds:" + msdResult.get());

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

        threadPool = new ThreadPoolExecutor(5, 6, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        SortCallable timCall= new SortCallable("TimSort",SortMethod.TimSort,4000000, "random");
        SortCallable quickCall= new SortCallable("QuickSort",SortMethod.QuickSort,4000000, "random");
        SortCallable msdCall= new SortCallable("MsdSort",SortMethod.MSDSort,4000000, "random");
        SortCallable lsdCall= new SortCallable("LsdSort",SortMethod.LSDSort,4000000, "random");

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
            System.out.println("TimSort in 4M random  milliseconds:" + timResult.get());
            System.out.println("QuickSort in 4M random  milliseconds:" + quickResult.get());
            System.out.println("LsdSort in 4M random  milliseconds:" + lsdResult.get());
            System.out.println("MsdSort in 4M random  milliseconds:" + msdResult.get());

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    @Test
    public void eigM() {


        threadPool = new ThreadPoolExecutor(5, 6, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        SortCallable timCall= new SortCallable("TimSort",SortMethod.TimSort,8000000, "random");
        SortCallable quickCall= new SortCallable("QuickSort",SortMethod.QuickSort,8000000, "random");
        SortCallable msdCall= new SortCallable("MsdSort",SortMethod.MSDSort,8000000, "random");
        SortCallable lsdCall= new SortCallable("LsdSort",SortMethod.LSDSort,8000000, "random");

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
            System.out.println("LsdSort in 8M random  milliseconds:" + lsdResult.get());
            System.out.println("MsdSort in 8M random  milliseconds:" + msdResult.get());
            System.out.println("TimSort in 8M random  milliseconds:" + timResult.get());
            System.out.println("QuickSort in 8M random  milliseconds:" + quickResult.get());

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


}
