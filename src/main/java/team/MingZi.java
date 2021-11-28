package team;

public class MingZi {
    private String PinYin;
    private String HanZi;
    private static int longest = 0;
    public MingZi(String HanZi) {
        this.HanZi = HanZi;
        toPinYin();
    }
    private void toPinYin(){
        ChineseCharToEn.CharacterPinYinConvert convert = new ChineseCharToEn.CharacterPinYinConvert();
        String name = this.getHanZi();
        PinYin = convert.toPinYin(name);
        set_longest(PinYin.length());
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
    private void set_longest(int i){
        longest = Math.max(longest,i);
    }

    public static void main(String[] args) {
        MingZi name = new MingZi("王二大");
        MingZi name2 = new MingZi("王二啊丫");
        System.out.println(name.getPinYin());
        System.out.println(longest);
    }
}
