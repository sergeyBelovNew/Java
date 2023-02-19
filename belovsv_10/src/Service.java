import models.University;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Service {

    public void saveUniversityList(String universityList, Path path){
        try( FileWriter fileWriter = new FileWriter(path.toString())) {
            fileWriter.write(universityList);
        } catch (IOException ioException){
            throw new RuntimeException();
        }
    }

    public void copyIntDate(Path pathNew, String originalDate){
        try(FileWriter fileWriter = new FileWriter(pathNew.toString())) {
            fileWriter.write(originalDate.replaceAll("[a-zA-Z{}=,']", ""));
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

}
