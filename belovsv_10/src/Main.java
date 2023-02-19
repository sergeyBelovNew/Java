import models.University;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Path path1 = Paths.get
                ("/home//sergeyb/Documents/MIIT/semester_6//java/belovsv_10/src/file1");
        Path path2 = Paths.get
                ("/home//sergeyb/Documents/MIIT/semester_6//java/belovsv_10/src/file2");
        workWithServices(path1, path2);

    }

    public static String createFillList(){
        List <University> universityList = new ArrayList<>();
        Scanner intScanner = new Scanner(System.in);
        Scanner strScanner = new Scanner(System.in);
        System.out.println("Enter your universities(int, str)");
        for(int i = 0; i < 3; i++){
            universityList.add(new University(intScanner.nextInt(), strScanner.nextLine()));
        }
        System.out.println("Your date:");
        for (University iterator:
                universityList
        ) {
            System.out.println(universityList);
        }
        return universityList.toString();
    }

    public static void workWithServices(Path file1, Path file2){
        Service service = new Service();
        service.creteNewFile(file1);
        service.creteNewFile(file2);
        service.saveUniversityList(createFillList(), file1);
        service.readUniversityList(file1);
        service.copyIntDate(file2);
    }

}