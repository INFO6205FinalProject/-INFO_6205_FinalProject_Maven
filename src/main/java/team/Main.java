package team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
public class Main {
    public static void main(String[] args) {
        ArrayList<MingZi> mz = new ArrayList<MingZi>();
        ArrayList<String> hz;
        String addr = "/Users/qinhaoyuan/Desktop/INFO 6205/shuffledChinese.txt";
        hz = TXT.read_txt(addr);
        for(int i = 0; i<hz.size(); i++){
            mz.add(new MingZi(hz.get(i)));
        }
        MingZi[] m = new MingZi[mz.size()];
        for(int i = 0; i<mz.size(); i++){
            m[i] = mz.get(i);
        }
        Arrays.sort(m, new Comparator<MingZi>() {
            @Override
            public int compare(MingZi o1, MingZi o2) {
                return o1.getPinYin().compareTo(o2.getPinYin());
            }
        });
        for(int i = 0; i< m.length; i++){
            System.out.println(m[i].getHanZi());
        }
//        String[][] s = new String[mz.size()][2];
//        for(int i = 0; i<mz.size(); i++){
//            s[i][0] = mz.get(i).getPinYin();
//            s[i][1] = mz.get(i).getHanZi();
//        }
//        MingZi m1 = new MingZi("黄星宇");
//        MingZi m2 = new MingZi("秦皓源");
//        int tmp = m1.compareTo(m2);
//        System.out.println(tmp);

    }
}
