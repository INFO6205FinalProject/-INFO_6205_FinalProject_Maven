package team.sort;

import team.MingZi;

public class LSD implements Sort {

    private MingZi[] data;
    public static void LSDSort(MingZi[] arr){//W表示字符串的长度
        preWork(arr);
//        int w = arr[0].getLongest();
        int max = 4;
        int N=arr.length;
        int R=256;
        MingZi[] aux=new MingZi[N];

        //开始循环进行键索引计数排序
        for(int d=max-1;d>=0;d--){  //从低位开始进行

            int count[] =new int[R+1];
            for(int i=0;i<N;i++){
                count[arr[i].getPinYin().charAt(d)+1]+=1;
            }
            for(int r=0;r<R;r++){
                count[r+1]+=count[r];
            }
            for(int i=0;i<N;i++){
                aux[count[arr[i].getPinYin().charAt(d)]++]=arr[i];
            }
            for(int i=0;i<N;i++){
                arr[i]=aux[i];
            }
        }
    }

    static void preWork(MingZi[] arr){
        int max = 4;

        for(int i = 0;i<arr.length;i++){
            while(arr[i].getPinYin().length() < max){
                arr[i].setPinYin(arr[i].getPinYin()+ "0");
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
        LSDSort(this.data);
    }
}
