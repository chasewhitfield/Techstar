import java.util.Arrays;
import java.util.List;

public class test_closest_few {
    public static void main(String[] args) {
        Intern first = new Intern("First", 1, 2, 1, 2, 1);
        Intern different = new Intern("Different", 5, 5, 5, 5, 5);
        Intern inTheMiddle = new Intern("InTheMiddle", 3, 3, 3, 3, 3);
        Intern four = new Intern("Four", 4, 4, 4, 4, 4);
        Intern ones = new Intern("Ones", 1, 1, 1, 1, 1);

        List<Intern> allInterns = Arrays.asList(first, different, inTheMiddle, four, ones);

        List<Intern> closest = first.getClosestInterns(allInterns, 3);

        System.out.println(closest);
    }
}