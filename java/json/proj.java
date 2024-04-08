import java.io.*;
import java.text.*;

// Program for print data in JSON format.
public class proj {
	public static void main(String args[]) throws FileNotFoundException, IOException, ParseException
	{
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
