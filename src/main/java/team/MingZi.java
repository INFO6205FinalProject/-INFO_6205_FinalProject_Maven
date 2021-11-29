package team;

public class MingZi implements Comparable<MingZi>{
    private String PinYin;
    private String HanZi;
    private static int longest = 0;
    public MingZi(String HanZi) {
        this.HanZi = HanZi;
        toPinYin();
    }
    // converted to PinYin
    private void toPinYin(){
        ChineseCharToEn.CharacterPinYinConvert convert = new ChineseCharToEn.CharacterPinYinConvert();
        String name = this.getHanZi();
        PinYin = convert.toPinYin(name);
        set_longest(PinYin.length());

    }
    // add zero at the end of pinyin to make the same length
    public void add_zero(){
        while(PinYin.length() < longest){
            PinYin = PinYin + "0";
        }
    }
    public String getHanZi() {
        return HanZi;
    }
    public String getPinYin(){
        return PinYin;
    }
    // refresh the longest
    private void set_longest(int i){
        longest = Math.max(longest,i);
    }
    public static void main(String[] args) {
        MingZi name = new MingZi("王二大");
        MingZi name2 = new MingZi("王二啊丫");
        System.out.println(name.getPinYin());
        System.out.println(longest);
    }

    public static int getLongest() {
        return longest;
    }

    // add compareTo
    @Override
    public int compareTo(MingZi o) {
        if(PinYin.equals(o.PinYin))
            return 0;
        else if(PinYin.compareTo(o.PinYin) > 0)
            return 1;
        else
            return -1;
    }
}

