import java.util.*;

public class Main {
    public static void main (String [] args)
    {
        List <Intern> interns = new ArrayList<Intern>();
        Intern i = new Intern("Chase", 5, 5, 5, 5, 5);
        interns.add(i);

        System.out.println(i.getName());
    }
}
