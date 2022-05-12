import java.util.*;
import java.io.*;


public class Main {
    public static void main (String [] args) throws FileNotFoundException {
        ArrayList<Intern> TechStar = generateList("intern.csv");

        Intern a = new Intern("Chase Whitfield", 5, 5, 5, 5, 5, 5, 5,
                5, 5, 5, 5, 5, 5, 5, 5, 5, 5
        , 5, 5);

        List<Intern> partners = a.getClosestInterns(TechStar, 2);
        for (Intern partner : partners) {
            System.out.println(partner.generateEmail());
            System.out.println("Distance from you: " + partner.distanceToOtherIntern(a));
        }
    }

    static ArrayList<Intern> generateList(String filePath) throws FileNotFoundException {
        ArrayList<Intern> interns = new ArrayList<Intern>();
        File csv = new File(filePath); //might have to change to filepath
        try {
            Scanner sc = new Scanner(csv);
            while (sc.hasNextLine()) {
                String curRow = sc.nextLine();
                String[] cols = curRow.split(",");
                Intern curIntern = new Intern(cols[0], Integer.parseInt(cols[1]), Integer.parseInt(cols[2]), Integer.parseInt(cols[3]), Integer.parseInt(cols[4]), Integer.parseInt(cols[5]),
                        Integer.parseInt(cols[6]), Integer.parseInt(cols[7]), Integer.parseInt(cols[8]), Integer.parseInt(cols[9]),
                        Integer.parseInt(cols[10]), Integer.parseInt(cols[11]), Integer.parseInt(cols[12]), Integer.parseInt(cols[13]),
                        Integer.parseInt(cols[14]), Integer.parseInt(cols[15]), Integer.parseInt(cols[16]), Integer.parseInt(cols[17]),
                        Integer.parseInt(cols[18]), Integer.parseInt(cols[19]));
                interns.add(curIntern);
                System.out.println(curIntern.getName() + " has been added!");
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            throw e;
        }
        return interns;
    }
}
