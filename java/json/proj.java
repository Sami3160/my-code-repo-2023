import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// Program for print data in JSON format.
public class proj {
	public static void main(String args[]) throws FileNotFoundException, IOException, ParseException
	{
		// // In java JSONObject is used to create JSON object
		// // which is a subclass of java.util.HashMap.

		// JSONObject file = new JSONObject();

		// file.put("Full Name", "Ritu Sharma");
		// file.put("Roll No.", new Integer(1704310046));
		// file.put("Tution Fees", new Double(65400));

		// // To print in JSON format.
		// System.out.print(file);
		proj.readjson();
	}
	public static void readjson() throws FileNotFoundException, IOException, ParseException
	{
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("jk.json"));
		JSONObject jsonObject =  (JSONObject) obj;
		JSONArray jokes=(JSONArray) jsonObject.get("jokes");
		JSONObject jk=(JSONObject) jokes.get(2);
		String j1=(String) jk.get("joke");
		System.out.println(j1); 
	}
}
