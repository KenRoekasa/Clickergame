import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandling{
	public void saveToFile(PlayerData data) {
		try {
			// Sets file names/locations to save to
			FileOutputStream datafile = new FileOutputStream("playerdata.ser");
			
			// Writes the objects clientTable and clientInfoTable to files
			ObjectOutputStream outputObj = new ObjectOutputStream(datafile);
			outputObj.writeObject(datafile);
			
			// Closes output streams
			outputObj.close();
			datafile.close();
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IOException:");
			e.printStackTrace();
		}
	}

	public PlayerData loadPlayerData() {
		try {
			// Sets file names to load from
			String filePath = "playerdata.ser";
			FileInputStream file = new FileInputStream(filePath);
			
			// Reads the object to the file
			ObjectInputStream inputObj = new ObjectInputStream(file);
			PlayerData data = (PlayerData) inputObj.readObject();
			
			// Closes input streams
			inputObj.close();
			file.close();
			
			return data;
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException, assuming no saved messages");
		} catch (IOException e) {
			System.err.println("IOException:");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException:");
			e.printStackTrace();
		}
		return new PlayerData();
	}
}