package learning_datadriven.ReadFromJSON;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Program3 {
	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException, IOException, ParseException {
		
		JSONParser jp = new JSONParser();
		
		Object obj = jp.parse(new InputStreamReader(new FileInputStream("C:\\Users\\KIIT\\OneDrive\\Desktop\\New folder\\commdata.json"),"UTF-8"));
		
		JSONArray arr = (JSONArray) obj;
		
		JSONObject 	map=(JSONObject) arr.get(0);
		JSONObject 	map1=(JSONObject) arr.get(1);
		
		
		System.out.println(map.get("browser"));
		System.out.println(map.get("url"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("timeOuts"));
		
		System.out.println();
		
		System.out.println(map1.get("browser1"));
		System.out.println(map1.get("url1"));
		System.out.println(map1.get("username1"));
		System.out.println(map1.get("password1"));
		System.out.println(map1.get("timeOuts1"));
	}

}
