import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Main {
    public static void main (String [] args)
    {
        ArrayList<Intern> TechStar = generateList(args[0]);
    }

    static ArrayList<Intern> generateList(String filePath) {
        ArrayList<Intern> interns = new ArrayList<Intern>();
        File csv = new File(filePath); //might have to change to filepath
        try {
            Scanner sc = new Scanner(csv);
            while (sc.hasNextLine()) {
                String curRow = sc.nextLine();
                String[] cols = curRow.split(",");
                Intern curIntern = new Intern(cols[0].concat(cols[1]), cols[2], cols[3], cols[4], cols[5]);
                interns.add(curIntern);
                System.out.println(curIntern.getName() + "has been added!");
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            throw e;
        }
        return interns;
    }
}
