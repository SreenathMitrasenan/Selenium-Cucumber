package dataProviders;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.ItemList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import freemarker.core.ParseException;
import managers.FileReaderManager;

public class JsonReader {
	private final String McqModelFilePath = System.getProperty("user.dir")+"/"+FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath();
	
	
	public  HashMap<Integer, String> getDataList(String argFilename, String argData) throws ParseException, org.json.simple.parser.ParseException {
        JSONParser parser = new JSONParser();
        HashMap<Integer, String > hMap = new HashMap();
        try {
            Object obj = parser.parse(new FileReader(McqModelFilePath+"//"+argFilename));
            JSONArray array = (JSONArray) obj;
            int  arrSize=(int) array.size();
            
            for (int i=0;i<arrSize;i++) {
            	JSONObject jsonObject = (JSONObject) array.get(i);
               	 hMap.put(i, (String) jsonObject.get(argData));
               	/*String data = (String) jsonObject.get(argData);
                System.out.println(data);*/
            }
            return hMap;
            /*JSONObject jsonObject = (JSONObject) array.get(0);
            String name = (String) jsonObject.get("Question");
            System.out.println(name); */


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return hMap;
    }
	
}
