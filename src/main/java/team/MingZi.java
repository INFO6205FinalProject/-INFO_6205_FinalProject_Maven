package team;

public class MingZi implements Comparable<MingZi>{


    private String pinYin;
    private String hanZi;

    public MingZi(String hanZi) {
        this.hanZi = hanZi;
    }

    public MingZi(String hanZi,boolean convert) {
        this.hanZi = hanZi;
        if(convert) toPinYin();
    }
    // converted to PinYin
    public void toPinYin(){
        ChineseCharToEn.CharacterPinYinConvert convert = new ChineseCharToEn.CharacterPinYinConvert();
        String name = this.getHanZi();
        this.pinYin = convert.toPinYin(name);
    }

    public String getHanZi() {
        return this.hanZi;
    }
    public String getPinYin(){
        return this.pinYin;
    }
    public void setPinYin(String pinYin) {
        this.pinYin = pinYin;
    }


    // add compareTo
    @Override
    public int compareTo(MingZi o) {
        if(this.pinYin.equals(o.getPinYin()))
            return 0;
        else if(this.pinYin.compareTo(o.getPinYin()) > 0)
            return 1;
        else
            return -1;
    }
}

