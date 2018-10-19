public class MainController {
    public static void main(String[] args){
        GuiController gui = new GuiController();
        PlayerData data = new PlayerData();
        GameController gameController = new GameController(data, gui);
    }

}
