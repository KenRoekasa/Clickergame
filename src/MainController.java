public class MainController {
    public static void main(String[] args){
        PlayerData data = new PlayerData();
        GameController gameController = new GameController(data);
        GuiController gui = new GuiController(gameController);
    }

}
