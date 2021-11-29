package team.sort;

import team.MingZi;

public class LSD implements Sort {

    private MingZi[] data;
    public static void LSD_sort(MingZi[] a){//W表示字符串的长度
        int w = a[0].getLongest();
        int N=a.length;
        int R=256;
        MingZi[] aux=new MingZi[N];

        //开始循环进行键索引计数排序
        for(int d=w-1;d>=0;d--){  //从低位开始进行

            int count[] =new int[R+1];
            for(int i=0;i<N;i++){
                count[a[i].getPinYin().charAt(d)+1]+=1;
            }
            for(int r=0;r<R;r++){
                count[r+1]+=count[r];
            }
            for(int i=0;i<N;i++){
                aux[count[a[i].getPinYin().charAt(d)]++]=a[i];
            }
            for(int i=0;i<N;i++){
                a[i]=aux[i];
            }
        }
    }
    public static void main(String[] args) {

        // Input String
        MingZi[] str = new MingZi[] { new MingZi("黄佳佳"),new MingZi("蓝果果"),new MingZi("绿泡泡") ,new MingZi("红彤彤") ,new MingZi("绿泡泡"), new MingZi("李好"),new MingZi("泰勒"), new MingZi("阿里巴巴")};
        System.out.print("Sorted array : ");

        // Print the sorted array

    }

    public LSD(){}

    @Override
    public void setData(MingZi[] data){
        this.data = data;
    }
    @Override
    public void run() {
        LSD_sort(this.data);
    }
}
