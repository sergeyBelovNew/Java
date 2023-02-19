import models.University;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Service {

    public void saveUniversityList(String universityList, Path path){
        try {
            FileWriter fileWriter = new FileWriter(path.toString());
            fileWriter.write(universityList.toString());
        } catch (IOException ioException){
            throw new RuntimeException();
        }
    }

    public void readUniversityList(Path path){
        try {
            FileReader fileReader = new FileReader(path.toString());
            fileReader.read();
        } catch (IOException ioException){
            throw new RuntimeException();
        }
    }

    public void copyIntDate(Path path){
        try {
            FileWriter fileWriter = new FileWriter(path.toString());
            fileWriter.write(fileWriter.toString().replaceAll("^0-9$", ""));
        } catch (IOException ioException){
            throw new RuntimeException();
        }
    }

    public void creteNewFile(Path path){
        File fileFullDate = new File(path.toString());
        try {
            boolean created = fileFullDate.createNewFile();
            if(created)
                System.out.println("File has been created");
        }
        catch(IOException ex){
            throw new RuntimeException();
        }
    }

    private static final Path path = Paths.get
            ("/home//sergeyb/Documents/MIIT/semester_6//java/belovsv_10/src/file1");

}
