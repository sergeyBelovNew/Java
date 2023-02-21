
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Path;

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

    public String readFile(Path path){
        File file = new File(path.toString());
        try(FileReader fileReader = new FileReader(path.toString())){
            char[] streamIn = new char[(int)file.length()];
            fileReader.read(streamIn);
            return String.copyValueOf(streamIn);
        } catch (IOException ex){
            throw new RuntimeException();
        }
    }

    public void creteNewFile(Path path){
        File fileFullDate = new File(path.toString());
        try {
            boolean created = fileFullDate.createNewFile();
            if(created)
                System.out.println("File has been created");
        } catch(IOException ex){
            throw new RuntimeException();
        }
    }

    public void calculationUrlTegs(String path) {
        try {
            URL url = new URL(path);
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            byte[] buffer = inputStream.readAllBytes();
            String str = new String(buffer);

            int count =  0;
            for(int i = 0; i < str.length(); i++)
                if(str.charAt(i) == '<' && str.charAt(i+1) == 'p'
                        && str.charAt(i+2) == '>')
                    count++;
            System.out.println("Кол-во(наличие) тегов <p> = " + count);
        } catch (IOException ioException) {
            throw new RuntimeException();
        }
    }

}
