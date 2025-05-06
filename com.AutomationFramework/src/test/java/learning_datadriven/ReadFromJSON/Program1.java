package learning_datadriven.ReadFromJSON;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Program1 {
	public static void main(String[] args) throws IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
		//Object obj = parser.parse(new FileReader("C:\\Users\\KIIT\\OneDrive\\Desktop\\New folder\\commdata.json"));
		
		Object obj = parser.parse(
			    new InputStreamReader(
			        new FileInputStream("path/to/file.json")));

		JSONObject map = (JSONObject) obj;
		
		System.out.println(map.get("url"));
	}

}
