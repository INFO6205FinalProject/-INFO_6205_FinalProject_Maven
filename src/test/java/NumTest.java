import org.junit.Before;
import org.junit.Test;
import team.Benchmark;
import team.GenerateName;
import team.MingZi;
import team.SortMethod;

public class NumTest {
    MingZi[] oneM,twoM,fourM,eigM;

    int k = 0;
    @Before
    public void before() {

        System.out.println("pre working, prepare data resource");
        oneM  = new MingZi[1000000];
        twoM  = new MingZi[2000000];
        fourM  = new MingZi[4000000];
        eigM  = new MingZi[8000000];

        for(int i = 0;i<oneM.length;i++){
            String name = GenerateName.randomName();
            oneM[i] = new MingZi(name);
        }

        for(int i = 0;i<twoM.length;i++){
            String name = GenerateName.randomName();
            twoM[i] = new MingZi(name);
        }

        for(int i = 0;i<fourM.length;i++){
            String name = GenerateName.randomName();
            fourM[i] = new MingZi(name);
        }

        for(int i = 0;i<eigM.length;i++){
            String name = GenerateName.randomName();
            eigM[i] = new MingZi(name);
        }
    }

    @Test
    public void OneM() {

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
    public void twoM() {

        Benchmark tim = new Benchmark(SortMethod.TimSort, twoM);
        Benchmark msd = new Benchmark(SortMethod.MSDSort, twoM);
        Benchmark lsd = new Benchmark(SortMethod.LSDSort, twoM);
        Benchmark dq = new Benchmark(SortMethod.QuickSort, twoM);

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
    public void fourM() {

        Benchmark tim = new Benchmark(SortMethod.TimSort, fourM);
        Benchmark msd = new Benchmark(SortMethod.MSDSort, fourM);
        Benchmark lsd = new Benchmark(SortMethod.LSDSort, fourM);
        Benchmark dq = new Benchmark(SortMethod.QuickSort, fourM);

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
    public void eigM() {

        Benchmark tim = new Benchmark(SortMethod.TimSort, eigM);
        Benchmark msd = new Benchmark(SortMethod.MSDSort, eigM);
        Benchmark lsd = new Benchmark(SortMethod.LSDSort, eigM);
        Benchmark dq = new Benchmark(SortMethod.QuickSort, eigM);

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
}
