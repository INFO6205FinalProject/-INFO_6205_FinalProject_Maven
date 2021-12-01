import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import team.Benchmark;
import team.GenerateName;
import team.MingZi;
import team.SortMethod;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class MyTest {
    MingZi[] oneM,twoM,fourM,eigM;

    int k = 0;
    @Before
    public void before() {

        System.out.println("pre working, prepare data resource");
        oneM  = new MingZi[1000000];
        //twoM  = new MingZi[2000000];

//        twoM  = new MingZi[2000000];
//        fourM  = new MingZi[4000000];
//        eigM  = new MingZi[8000000];

        for(int i = 0;i<oneM.length;i++){
            String name = GenerateName.randomName();
            oneM[i] = new MingZi(name);
        }

//        for(int i = 0;i<twoM.length;i++){
//            String name = GenerateName.randomName();
//            twoM[i] = new MingZi(name);
//        }
//
//        for(int i = 0;i<fourM.length;i++){
//            String name = GenerateName.randomName();
//            fourM[i] = new MingZi(name);
//        }
//
//        for(int i = 0;i<eigM.length;i++){
//            String name = GenerateName.randomName();
//            eigM[i] = new MingZi(name);
//        }

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
        System.out.println("test end");
    }

    @Test
    public void RandomOneM() {

        Benchmark tim = new Benchmark(SortMethod.TimSort, oneM);
        Benchmark msd = new Benchmark(SortMethod.MSDSort, oneM);
        Benchmark lsd = new Benchmark(SortMethod.LSDSort, oneM);
        Benchmark dq = new Benchmark(SortMethod.QuickSort, oneM);

        tim.runBenchmark();
        msd.runBenchmark();
        lsd.runBenchmark();
        dq.runBenchmark();

        long timTime = tim.getTime();
        long msdTime = msd.getTime();
        long lsdTime = lsd.getTime();
        long dqTime = dq.getTime();

        System.out.println("TimSort in random  milliseconds:" + timTime);
        System.out.println("MsdTime in random  milliseconds:" + msdTime);
        System.out.println("LsdTime in random milliseconds:" + lsdTime);
        System.out.println("DqTime in  random  milliseconds:" + dqTime);

    }

    @Test
    public void OrderOneM() {

        MingZi[] arr = orderArr(oneM);

        Benchmark tim = new Benchmark(SortMethod.TimSort, arr);
        Benchmark msd = new Benchmark(SortMethod.MSDSort, arr);
        Benchmark lsd = new Benchmark(SortMethod.LSDSort, arr);
        Benchmark dq = new Benchmark(SortMethod.QuickSort, arr);

        tim.runBenchmark();
        msd.runBenchmark();
        lsd.runBenchmark();
        dq.runBenchmark();

        long timTime = tim.getTime();
        long msdTime = msd.getTime();
        long lsdTime = lsd.getTime();
        long dqTime = dq.getTime();

        System.out.println("TimSort in order  milliseconds:" + timTime);
        System.out.println("MsdTime in order  milliseconds:" + msdTime);
        System.out.println("LsdTime in order milliseconds:" + lsdTime);
        System.out.println("DqTime in  order  milliseconds:" + dqTime);
    }

    @Test
    public void ReverseOneM() {

        MingZi[] arr = reverseOrder(oneM);

        Benchmark tim = new Benchmark(SortMethod.TimSort, arr);
        Benchmark msd = new Benchmark(SortMethod.MSDSort, arr);
        Benchmark lsd = new Benchmark(SortMethod.LSDSort, arr);
        Benchmark dq = new Benchmark(SortMethod.QuickSort, arr);

        tim.runBenchmark();
        msd.runBenchmark();
        lsd.runBenchmark();
        dq.runBenchmark();

        long timTime = tim.getTime();
        long msdTime = msd.getTime();
        long lsdTime = lsd.getTime();
        long dqTime = dq.getTime();


        System.out.println("TimSort in reverse  milliseconds:" + timTime);
        System.out.println("MsdTime in reverse  milliseconds:" + msdTime);
        System.out.println("LsdTime in reverse milliseconds:" + lsdTime);
        System.out.println("DqTime in  reverse  milliseconds:" + dqTime);

    }

//    @Test
//    public void testSum2() {
//       // int result = SumUtil.sum2(1, 2,3);
//        //Assert.assertEquals(result, 5);
//    }
}
