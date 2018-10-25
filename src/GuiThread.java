import javax.swing.*;

public class GuiThread extends Thread{
    private JLabel perSecondLabel;
    private JLabel currencyLabel;
    private PlayerData data;
    private int updateGui = 10;

    public GuiThread(JLabel currencyLabel, JLabel perSecondLabel, PlayerData data){
        this.currencyLabel = currencyLabel;
        this.perSecondLabel = perSecondLabel;
        this.data = data;
    }
    @Override
    public synchronized void run() {
        while (true){
            currencyLabel.setText("Mince Pies: " + data.getCurrency());
            perSecondLabel.setText("per second: " + data.getCurPerTick());
            try {
                Thread.sleep(updateGui);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
