package com.railway.Common;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonUtils {
    public static JSONArray getJSONList(String path){
        JSONParser jsonParser = new JSONParser();
        JSONArray objectList = new JSONArray();
        try (FileReader reader = new FileReader(path)) {
            objectList = (JSONArray) jsonParser.parse(reader);
            reader.close();
        }
        catch (Exception e){
        }
        return objectList;
    }
    //    Đọc dữ liệu Json từ tệp
    public static void setJSONList(String path, JSONArray list){
        try (FileWriter file = new FileWriter(path)) {
            file.write(list.toJSONString());
            file.flush();
            file.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
//    Ghi dữ liệu vào tệp

    public static JSONObject getJSONObjectByIndex(JSONArray list , int index ) {
        return (JSONObject)(list.get(index));
    }
//Truy xuất đối tượng Json vào từ danh sách theo index
}
//Mục đích của Class này Đọc, ghi , và truy xuất dữ liệu Json



