package team;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<MingZi> mz = new ArrayList<>();
        ArrayList<String> hz;
        String addr = "/Users/qinhaoyuan/Desktop/INFO 6205/shuffledChinese.txt";
        hz = TXT.read_txt(addr);
        for(int i = 0; i<hz.size(); i++){
            mz.add(new MingZi(hz.get(i)));
        }
    }
}
