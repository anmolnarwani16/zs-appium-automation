package utiles;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonFileRederUtils {
	
	 public static JSONObject readJSONFromFile(String filename) throws IOException, org.json.simple.parser.ParseException {
	        JSONParser parser = new JSONParser();
	        try (FileReader reader = new FileReader(filename)) {
	            Object obj = parser.parse(reader);
	            return (JSONObject) obj;
	        }
	    }

}
