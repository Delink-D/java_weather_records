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
			String[] myValues = record.split(" ");

			// if loop is at line 1 or 31 skip them and continue with the loop
        	if (linenum == 0 || linenum == 32) {
        		linenum++;
        		continue;
        	}
        	linenum++;

			// converting the columns values into integers
        	// get only the columns that are needed
        	// remove special characters at the end of some integers
        	Integer max = Integer.valueOf(myValues[1].replace("*",""));
        	Integer min = Integer.valueOf(myValues[2].replace("*",""));

        	int sub = max-min; //subtract each minimum value per day from maximum value

        	result.put(myValues[0], sub); // with our hashMap put in the key=column[0] which is the day and the subtract value as the value
		}

        // get the maximum value in the HashMap
        // store it in a variable of type int
        int maxVal = Collections.max(result.values());

        // geting a key from the maximum value
        // Itarate trough hashmap 
        for(Entry<String, Integer> entry : result.entrySet()){
        	if (entry.getValue() == maxVal) {
        		// print the key with maximum value plus the maximum value itself
        		// result print = day maximum spread
        		System.out.println(entry.getKey() + " " + maxVal);
        	}
        }

        // a method to close the input process
        input.close();
	}
}