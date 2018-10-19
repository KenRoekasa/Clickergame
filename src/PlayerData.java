//Model
public class PlayerData {
    private int currency = 0;
    private int curPerTick = 1;
    private int tickPerSec = 1;

    public int getCurrency() {
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

    public int getTickPerSec() {
        return tickPerSec;
    }

    public void setTickPerSec(int tickPerSec) {
        this.tickPerSec = tickPerSec;
    }


}
