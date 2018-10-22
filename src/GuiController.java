import javax.swing.*;

public class GuiController extends JFrame{
    private JFrame frame;
    private JPanel panel;

    public void GuiController(){
        frame = new JFrame("Clicker game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);


    }
}
