import java.io.Serializable;

//Model
public class PlayerData implements Serializable {

    private int currency = 0;
    private int curPerTick = 0;
    //TODO change tick per second
    private final int TICKPERSEC = 1;

    public int getCurPerClick() {
        return curPerClick;
    }

    public void setCurPerClick(int curPerClick) {
        this.curPerClick = curPerClick;
    }

    private int curPerClick = 1;

    public int  getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public int getCurPerTick() {
        return curPerTick;
    }

    public void setCurPerTick(int curPerTick) {
        this.curPerTick = curPerTick;
    }



}
