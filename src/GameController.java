public class GameController {
    private int currency;
    private int curPerTick;
    private int  tickPerSec;

    public GameController(PlayerData data){
        this.currency = data.currency;
        this.curPerTick = data.curPerTick;
        this.tickPerSec = data.tickPerSec;
    }

    private void increaseCurPerTick(int amount){
        curPerTick += amount;
    }

    private void increaseTickPerSec(int amount){
        tickPerSec += amount;
    }

}
