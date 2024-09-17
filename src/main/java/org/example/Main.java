package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;


public class Main {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static void main(String[] args){

        GsonManager tester = new GsonManager();

        //Create a Student Object
        Student student = new Student();
        student.setAge(46);
        student.setName("Shmulavitch");

        tester.setObject(student);
        tester.setJsonFile("src\\main\\resources\\newStudent.json");

        try{
            // Write/Create to th Json File.
            tester.serializeObj2J(tester.getObject(), tester.getJsonFile());
            // the mehod toJson
            String jString = gson.toJson(student);
            System.out.println("Serializing an Object to json, results in the following:" + "\n" + jString);
            //read from Json file and create an Object for the java code to operate on/with.
            Object student1 = tester.deSerializeJ2Obj(tester.getJsonFile(),tester.getObject());
            System.out.println("Desrializing a Json file to Java Object, results in the following:" + "\n" +student1);
        } catch(FileNotFoundException e1) {
            e1.printStackTrace();
        }catch(IOException e2){
            e2.printStackTrace();
        }



    }
}
