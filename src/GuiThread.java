import javax.swing.*;

public class GuiThread extends Thread{
    private JLabel currencyLabel;
    private PlayerData data;
    private int updateGui = 10;

    public GuiThread(JLabel currencyLabel, PlayerData data){
        this.currencyLabel = currencyLabel;
        this.data = data;
    }
    @Override
    public synchronized void run() {
        while (true){
            currencyLabel.setText("Mince Pies: " + data.getCurrency());
            try {
                Thread.sleep(updateGui);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
