//Controller
public class GameController extends Thread {
    private PlayerData data;
    private FileHandling fileHandler = new FileHandling();

    public GameController() {
        this.data = fileHandler.loadPlayerData();
    }

//    @Override
//    public synchronized void start() {
//        while (true){
//            incrementCurrency();
//        }
//    }

    public void incrementCurrency(int amount) {
        int finalValue = data.getCurrency() + amount;
        data.setCurrency(finalValue);
    }

    public void increaseCurPerTick(int amount) {
        int finalValue = data.getCurPerTick() + amount;
        data.setCurPerTick(finalValue);

    }

    public void increaseCurPerClick(int amount) {
        int finalValue = data.getCurPerClick() + amount;
        data.setCurPerClick(finalValue);
    }


    public boolean decrementCurrency(int amount) {
        int finalValue = data.getCurrency() - amount;
        if (finalValue >= 0) {
            data.setCurrency(finalValue);
            return true;
        } else {
            return false;
        }
    }

    public void exit() {
        fileHandler.saveToFile(data);
        System.exit(0);
    }


    public int getCurrency() {
        return data.getCurrency();
    }

    public int getCurPerClick() {
        return data.getCurPerClick();
    }
}
