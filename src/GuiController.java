import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiController{
    private JFrame frame;
    private JPanel infoPanel;
    private JPanel mainPanel;
    private JPanel bottomPanel;
    private JLabel labelCurrency;
    private JButton mainButton,exitButton;
    private GameController gameController;

    public GuiController(GameController gameController){
        this.gameController = gameController;
        frame = new JFrame("Clicker game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        infoPanel = new JPanel();
        mainPanel= new JPanel();
        bottomPanel = new JPanel();

        mainButton = new JButton(new ImageIcon("icons/mince.jpg"));
        mainButton.setPreferredSize(new Dimension(100,100));
        exitButton = new JButton("EXIT");

        labelCurrency = new JLabel("Mince Pies: " + gameController.getCurrency());

        mainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.incrementCurrency(1);
                labelCurrency.setText("Mince Pies: " + gameController.getCurrency());
            }
        });
        
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.exit();
            }
        });

        infoPanel.add(labelCurrency);

        mainPanel.add(mainButton);

        bottomPanel.add(exitButton);

        frame.add(infoPanel, BorderLayout.PAGE_START);
        frame.add(mainPanel,BorderLayout.CENTER);
        frame.add(exitButton, BorderLayout.PAGE_END);

        frame.pack();
        frame.setVisible(true);


    }
}
