public class MainController {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        GuiController gui = new GuiController(gameController);
        gameController.start();
    }

}
