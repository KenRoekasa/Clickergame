//Controller
public class GameController {
    private PlayerData data;
    private GuiController gui;
    private FileHandling fileHandler = new FileHandling();

    public GameController() {
        this.data = fileHandler.loadPlayerData();
        this.gui = gui;
    }

    public void incrementCurrency(int amount) {
        int finalValue = data.getCurrency() + amount;
        data.setCurrency(finalValue);
    }

    private void increaseCurPerTick(int amount){
        int finalValue = data.getCurPerTick() + amount;
        data.setCurPerTick(finalValue);

    }

    private void increaseTickPerSec(int amount){
        int finalValue = data.getTickPerSec() + amount;
        data.setTickPerSec(finalValue);
    }
    
    private void exit() {
    	fileHandler.saveToFile(data);
    	System.exit(0);
    }


}
