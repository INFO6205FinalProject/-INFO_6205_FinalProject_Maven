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

    public static ArrayList<String> read_txt(String addr,int size){
        ArrayList<String> s = new ArrayList<String>();
        try {
            String filePath = addr;// get address
            int num = 0;
            FileInputStream fin = new FileInputStream(filePath);// create a new stream
            InputStreamReader reader = new InputStreamReader(fin);
            BufferedReader buffReader = new BufferedReader(reader);
            String strTmp = "";
            // write strings from file.
            while((strTmp = buffReader.readLine())!=null && num<=size){
                s.add(strTmp);
                num++;
            }

            buffReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    public static void write_txt(String add, ArrayList s){
        try {
            File writename = new File(add); // get a file
            writename.createNewFile(); // create a new file
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            for(Object i : s){
                //i = (String)(i);
                out.write(i + "\r\n");
            }
            out.flush(); // put data in file
            out.close(); // close file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String addr = "src/main/resources//shuffledChinese.txt";
        ArrayList<String> s = read_txt(addr,1000000);
        for(String i : s){
            System.out.println(i);
        }
    }
}
