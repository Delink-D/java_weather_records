import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class App {

	public static void main(String[] args) throws IOException {
		DataInputStream input = new DataInputStream(new FileInputStream("weather.dat"));

		String record;

		while ((record = input.readLine()) != null){
			String[] myValues = record.split(" ");

			System.out.println(record); // displays all records
		}
	}
}