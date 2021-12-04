package team.sort;

import team.MingZi;

public interface Sort {
    public abstract void run();
    public abstract void setData(MingZi[] data);
    public abstract MingZi[] getData();

    void preWork();
}
