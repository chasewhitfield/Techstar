import java.util.*;
import java.io.*;


public class Main {
    public static void main (String [] args) throws FileNotFoundException {
        ArrayList<Intern> TechStar = generateList("");
        
        Intern a = new Intern("Chase Whitfield", 5, 5, 5, 5, 5);
        Intern b = new Intern("Ben Coffta", 3, 7, 4, 9, 4);
    }

    static ArrayList<Intern> generateList(String filePath) throws FileNotFoundException {
        ArrayList<Intern> interns = new ArrayList<Intern>();
        File csv = new File(filePath); //might have to change to filepath
        try {
            Scanner sc = new Scanner(csv);
            while (sc.hasNextLine()) {
                String curRow = sc.nextLine();
                String[] cols = curRow.split(",");
                Intern curIntern = new Intern(cols[0].concat(cols[1]), Integer.parseInt(cols[2]), Integer.parseInt(cols[3]), Integer.parseInt(cols[4]), Integer.parseInt(cols[5]), Integer.parseInt(cols[6]));
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
