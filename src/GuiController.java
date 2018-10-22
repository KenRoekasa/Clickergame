import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiController {
    private JFrame frame;
    private JPanel infoPanel;
    private JPanel mainPanel;
    private JPanel bottomPanel;
    private JPanel upgradePanel;
    private JLabel labelCurrency;
    private JButton mainButton, exitButton, upgrade1Button;
    private GameController gameController;

    public GuiController(GameController gameController) {
        this.gameController = gameController;
        frame = new JFrame("Clicker game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        infoPanel = new JPanel();
        mainPanel = new JPanel();
        bottomPanel = new JPanel();
        upgradePanel = new JPanel();

        mainButton = new JButton(new ImageIcon("icons/mince.jpg"));
        mainButton.setPreferredSize(new Dimension(100, 100));
        exitButton = new JButton("EXIT");

        upgrade1Button = new JButton("Oven");

        labelCurrency = new JLabel("Mince Pies: " + gameController.getCurrency());


        infoPanel.add(labelCurrency);

        mainPanel.add(mainButton);

        bottomPanel.add(exitButton);

        upgradePanel.add(upgrade1Button);


        frame.add(infoPanel, BorderLayout.PAGE_START);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(exitButton, BorderLayout.PAGE_END);
        frame.add(upgradePanel, BorderLayout.LINE_END);

        frame.pack();
        frame.setVisible(true);

        mainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.incrementCurrency(gameController.getCurPerClick());
                labelCurrency.setText("Mince Pies: " + gameController.getCurrency());
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.exit();
            }
        });

        //Oven upgrade
        upgrade1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(gameController.decrementCurrency(100)){
                    gameController.increaseCurPerClick(1);
                    labelCurrency.setText("Mince Pies: " + gameController.getCurrency());
                }
            }
        });

    }
}
