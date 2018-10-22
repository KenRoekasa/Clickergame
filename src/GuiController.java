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
    private JButton mainButton, exitButton, upgrade1Button, upgrade2Button;
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
        upgrade2Button = new JButton("BUY ALL");

        labelCurrency = new JLabel("Mince Pies: " + gameController.getPlayerData().getCurrency());


        infoPanel.add(labelCurrency);

        mainPanel.add(mainButton);

        bottomPanel.add(exitButton);

        upgradePanel.add(upgrade1Button);
        upgradePanel.add(upgrade2Button);


        frame.add(infoPanel, BorderLayout.PAGE_START);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(exitButton, BorderLayout.PAGE_END);
        frame.add(upgradePanel, BorderLayout.LINE_END);

        frame.pack();
        frame.setVisible(true);

        GuiThread guiThread = new GuiThread(labelCurrency, gameController.getPlayerData());
        guiThread.start();

        mainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.incrementCurrency(gameController.getPlayerData().getCurPerClick());
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
            	gameController.addOven();
            	labelCurrency.setText("Mince Pies: " + gameController.getPlayerData().getCurrency());
            }
        });
        
        upgrade2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	gameController.buyAll();
            }
        });

    }
}

