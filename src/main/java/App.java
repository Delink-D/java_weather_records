import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class App {

	public static void main(String[] args) throws IOException {

		// initialize DataInputStream and asign it to the data file
    	// using FileInputStream to get the file by passing the file name
		DataInputStream input = new DataInputStream(new FileInputStream("weather.dat"));

		// Declaring of a HashMap that will hold the maxVal and the month
		// month will be in string and the maxVal will be an Integer
		Map<String, Integer> result = new HashMap<String, Integer>();

		String record;
		int linenum = 0; // Each record line count

		// while loop will help loop the entire records
		// the loop also reads in the data line by line
		while ((record = input.readLine()) != null){

			// if loop is at line 1 or 31 skip them and continue with the loop
        	if (linenum == 0 || linenum == 31) {
        		linenum++;
        		continue;
        	}
        	linenum++;

			String[] myValues = record.split(" ");

			// System.out.println(myValues[2]);
			System.out.println(record); // displays all records
		}
	}
}