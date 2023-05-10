package utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TempStorage {

//its useful for us to store temp info

    private static Map<String, String> storage = new HashMap<>();

    public static void addData(String key, String value){
        storage.put(key,value);

    }




    public static  String getData(String key){
        return  storage.get(key);
    }
 private static String globalKey;

    public static String getKey(){
        return globalKey;
    }
}
