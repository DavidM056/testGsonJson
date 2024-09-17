
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.GsonManager;
import org.example.Student;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;


public class GsonManagerTest {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();


    @Test
    public void testGsonManager(){

        GsonManager tester = new GsonManager();
        assumeFalse(null == tester);
        assumeTrue(tester instanceof GsonManager);

        //Create a Student Object
        Student student = new Student();
        assumeFalse(null == student);
        assumeTrue(student instanceof Student);


        student.setAge(36);
        student.setName("David");

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
