package team.sort;

import team.MingZi;

public class LSD implements Sort {

    private MingZi[] data;
    public static void LSDSort(MingZi[] arr){//W表示字符串的长度
        preWork(arr);
        int max = 4;
        int N=arr.length;
        int R=256;
        MingZi[] aux=new MingZi[N];

        //start loop and make count
        for(int d=max-1;d>=0;d--){  //lower start

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

    @Override
    public MingZi[] getData(){
        return this.data;
    }
    @Override
    public void setData(MingZi[] data){
        this.data = data;
    }
    @Override
    public void run() {
        LSDSort(this.data);
    }

    @Override
    public void preWork() {
        for(MingZi n:this.data){
            n.toPinYin();
        }
    }
}
