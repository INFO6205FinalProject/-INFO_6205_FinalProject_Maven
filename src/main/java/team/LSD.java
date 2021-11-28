package team;

public class LSD {

    public static void LSD_sort(String[] a){//W表示字符串的长度
        int w = a[0].length();
        int N=a.length;
        int R=256;
        String[] aux=new String[N];

        //开始循环进行键索引计数排序
        for(int d=w-1;d>=0;d--){  //从低位开始进行

            int count[] =new int[R+1];
            for(int i=0;i<N;i++){
                count[a[i].charAt(d)+1]+=1;
            }
            for(int r=0;r<R;r++){
                count[r+1]+=count[r];
            }
            for(int i=0;i<N;i++){
                aux[count[a[i].charAt(d)]++]=a[i];
            }
            for(int i=0;i<N;i++){
                a[i]=aux[i];
            }
        }
    }
    public static void main(String[] args) {

        // Input String
        String str[] = { "midni", "badge",  "baggg", "workr", "banne", "wande" };
        System.out.print("Unsorted array : ");
        // Print the unsorted array
        for(String i: str){
            System.out.print(i + " ");
        }
        // Function Call
        LSD_sort(str);
        System.out.print("Sorted array : ");

        // Print the sorted array
        for(String i: str){
            System.out.print(i + " ");
        }
    }
}
