import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiController{
    private JFrame frame;
    private JPanel panel;
    private JButton mainButton;
    private GameController gameController;

    public GuiController(GameController gameController){
        this.gameController = gameController;
        frame = new JFrame("Clicker game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        mainButton = new JButton("MINCE PIE");
        mainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.incrementCurrency(1);
                System.out.println("INcrementation");
            }
        });
        frame.add(panel);
        frame.add(mainButton);
        frame.pack();
        frame.setVisible(true);


    }
}
