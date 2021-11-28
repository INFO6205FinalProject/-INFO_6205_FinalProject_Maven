package team;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.List;

public class TXT {

    public static ArrayList<String> read_txt(String addr){
        ArrayList<String> s = new ArrayList<String>();
        try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
            /* 读入TXT文件 */
            String filePath = addr;
            FileInputStream fin = new FileInputStream(filePath);
            InputStreamReader reader = new InputStreamReader(fin);
            BufferedReader buffReader = new BufferedReader(reader);
            String strTmp = "";
            while((strTmp = buffReader.readLine())!=null){
                s.add(strTmp);
            }
            buffReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    public static void write_txt(String add, ArrayList s){
        try {
            File writename = new File(add); // 相对路径，如果没有则要建立一个新的output。txt文件
            writename.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            for(Object i : s){
                //i = (String)(i);
                out.write(i + "\r\n");
            }
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String addr = "/Users/qinhaoyuan/Desktop/INFO 6205/shuffledChinese.txt";
        ArrayList<String> s = read_txt(addr);
        for(String i : s){
            System.out.println(i);
        }
    }
}
