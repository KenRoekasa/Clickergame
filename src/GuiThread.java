import javax.swing.*;

public class GuiThread extends Thread {
    private JLabel perSecondLabel;
    private JLabel currencyLabel;
    private JButton upgrade1Button;
    private JButton upgrade2Button;
    private JButton upgrade3Button;
    private JButton upgrade4Button;
    private PlayerData data;
    private GameData gameData;
    private int updateGui = 10;


    //TODO reduce passing many variables
    public GuiThread(JLabel currencyLabel, JLabel perSecondLabel, JButton upgrade1Button, JButton upgrade2Button, JButton upgrade3Button, JButton upgrade4Button,PlayerData data, GameData gameData) {
        this.currencyLabel = currencyLabel;
        this.perSecondLabel = perSecondLabel;
        this.upgrade1Button = upgrade1Button;
        this.upgrade2Button = upgrade2Button;
        this.upgrade3Button = upgrade3Button;
        this.upgrade4Button = upgrade4Button;
        this.data = data;
        this.gameData = gameData;
    }

    @Override
    public synchronized void run() {
        while (true) {
            updateLabels();
            updateButtons();
            try {
                Thread.sleep(updateGui);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateLabels() {
        currencyLabel.setText("Mince Pies: " + data.getCurrency());
        perSecondLabel.setText("per second: " + data.getCurPerTick());
    }

    private void updateButtons() {
        if (data.getCurrency() < gameData.getOvenCost()) {
            upgrade1Button.setEnabled(false);
            upgrade2Button.setEnabled(false);
        } else {
            upgrade1Button.setEnabled(true);
            upgrade2Button.setEnabled(true);
        }
        if(data.getCurrency() < gameData.getMumCost()){
            upgrade3Button.setEnabled(false);
            upgrade4Button.setEnabled(false);
        }else{
            upgrade3Button.setEnabled(true);
            upgrade4Button.setEnabled(true);
        }
    }

}
