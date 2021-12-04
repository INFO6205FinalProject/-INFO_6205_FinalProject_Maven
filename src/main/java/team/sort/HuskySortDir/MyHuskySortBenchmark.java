package team.sort.HuskySortDir;
import com.ibm.icu.text.Collator;
//import java.text.Collator;
import java.util.Locale;

import team.GenerateName;
import team.sort.HuskySortDir.HuskySortCombo.sort.huskySort.*;
import team.sort.HuskySortDir.HuskySortCombo.sort.huskySortUtils.HuskyCoderFactory;

public class MyHuskySortBenchmark {
    private long time;
    private String[] data;
    private PureHuskySort<String> sorter;
    public MyHuskySortBenchmark(){
        this.sorter = new PureHuskySort<>(HuskyCoderFactory.chineseEncoder, false, false, Collator.getInstance(Locale.CHINA));
    }
    public void warmup() {
        for(int i = 0; i < 10; i++){
            String[] warm = new String[20];
            for(int j = 0;j < 20; j++){
                warm[j] = GenerateName.randomName();
            }
            this.sorter.sort(warm);
        }

    }
    public void runBenchmark() {
        warmup();
        long startTime = System.currentTimeMillis();
        this.sorter.sort(this.data);
        long endTime = System.currentTimeMillis();
        this.time = endTime - startTime;
    }

    public void setData(String[] data){
        this.data = data;
    }
    public long getTime(){
        return this.time;
    }
}
