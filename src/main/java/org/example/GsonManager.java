package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class GsonManager {

    private String jsonFile = "";
    private Object object = null;

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public GsonManager(){}

    public Object getObject(){ return this.object;}
    public String getJsonFile(){return this.jsonFile;}

    public void setObject(Object inObject){this.object = inObject;}
    public void setJsonFile(String inJsonFile){this.jsonFile = inJsonFile;}


    //Create/Write to a Json File, Serialize Object to Json
    public void serializeObj2J(Object object, String jsonFile) throws IOException {
        FileWriter writer = new FileWriter(jsonFile);
        String jString = gson.toJson(object);
        writer.write(jString);
        writer.close();
    }
    // Read from a Jason File with Generic Object
    public Object deSerializeJ2Obj(String jsonFile, Object object) throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFile));
        Object freshMan = gson.fromJson(bufferedReader, object.getClass());
        return freshMan;
    }



}
