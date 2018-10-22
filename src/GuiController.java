import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiController{
    private JFrame frame;
    private JPanel infoPanel;
    private JPanel mainPanel;
    private JLabel labelCurrency;
    private JButton mainButton;
    private GameController gameController;

    public GuiController(GameController gameController){
        this.gameController = gameController;
        frame = new JFrame("Clicker game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        infoPanel = new JPanel();
        mainPanel= new JPanel();
        mainButton = new JButton("MINCE PIE");
        labelCurrency = new JLabel("Mince Pies: ");
        mainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.incrementCurrency(1);
                System.out.println("Incrementation");
            }
        });

        infoPanel.add(labelCurrency);

        mainPanel.add(mainButton);
        frame.add(infoPanel, BorderLayout.PAGE_START);
        frame.add(mainPanel,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);


    }
}
