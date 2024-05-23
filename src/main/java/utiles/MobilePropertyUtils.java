package utiles;

import enums.ConfigProperties;
import frameConstatnt.MobileFrameConstant;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;


public class MobilePropertyUtils {
	
	private MobilePropertyUtils() {

	}
	static FileInputStream file;
	private static Properties properties = new Properties();
	private static final Map<String ,String>CONFIGMAP=new HashMap<String, String>();
	static {
		try {
			file = new FileInputStream(MobileFrameConstant.getConfigFilePath().trim());
			properties.load(file);

			for(Map.Entry<Object, Object>entry:properties.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public static String get(ConfigProperties key) throws Exception {
		if(Objects.isNull(key)||Objects.isNull(CONFIGMAP.get(key.toString().toLowerCase()))) {
			throw new Exception("Properties name " + key + " is not found please check config properties");
			
		}
		
		return CONFIGMAP.get(key.name().toLowerCase());
	}

}
