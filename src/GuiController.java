import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiController {
    private JFrame frame;
    private JPanel infoPanel, mainPanel, bottomPanel, upgradePanel;
    private JLabel labelCurrency, labelPerSecond;
    private JButton mainButton, exitButton, upgrade1Button, upgrade2Button, upgrade3Button, upgrade4Button;
    private GameController gameController;

    public GuiController(GameController gameController) {
        this.gameController = gameController;
        frame = new JFrame("Clicker game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //JPanel creation
        infoPanel = new JPanel();
        mainPanel = new JPanel();
        bottomPanel = new JPanel();
        upgradePanel = new JPanel();

        //Main button Settings
        mainButton = new JButton(new ImageIcon("icons/mince.jpg"));
        mainButton.setPreferredSize(new Dimension(100, 100));
        exitButton = new JButton("EXIT");

        //Upgrades Buttons
        upgrade1Button = new JButton("Oven");
        upgrade2Button = new JButton("BUY ALL");
        upgrade3Button = new JButton("Mum");
        upgrade4Button = new JButton("BUY ALL");

        //Labels
        labelCurrency = new JLabel("Mince Pies: " + gameController.getPlayerData().getCurrency());
        labelPerSecond = new JLabel("per second: " + gameController.getPlayerData().getCurPerTick());

        BoxLayout boxLayout = new BoxLayout(infoPanel, BoxLayout.Y_AXIS) ;
        infoPanel.setLayout(boxLayout);
        //Adding label to info panel
        infoPanel.add(labelCurrency);
        infoPanel.add(labelPerSecond);

        mainPanel.add(mainButton);

        bottomPanel.add(exitButton);

        //Adding upgrade
        upgradePanel.add(upgrade1Button);
        upgradePanel.add(upgrade2Button);
        upgradePanel.add(upgrade3Button);
        upgradePanel.add(upgrade4Button);

        upgradePanel.setLayout(new GridLayout(2, 3));

        //Add Panel to main frame
        frame.add(infoPanel, BorderLayout.PAGE_START);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(exitButton, BorderLayout.PAGE_END);
        frame.add(upgradePanel, BorderLayout.LINE_END);

        frame.pack();
        frame.setVisible(true);

        //Thread for updating the gui
        GuiThread guiThread = new GuiThread(labelCurrency, labelPerSecond ,gameController.getPlayerData());
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

        //Oven BuyAll
        upgrade2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.buyAllOven();
            }
        });

        //Mum upgrade
        upgrade3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.increaseCurPerTick(1);
            }
        });

        //Mum buyall
        upgrade4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.buyAllMum();
            }
        });

    }
}

