package com.amidos.EmailDemo.TestClosestFew;
import java.util.Arrays;
import java.util.List;

import com.amidos.EmailDemo.Intern.Intern;

public class test_closest_few {
    public static void main(String[] args) {
        Intern first = new Intern("First", 1, 2, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Intern different = new Intern("Different", 5, 5, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Intern inTheMiddle = new Intern("InTheMiddle", 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Intern four = new Intern("Four", 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Intern ones = new Intern("Ones", 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

        List<Intern> allInterns = Arrays.asList(first, different, inTheMiddle, four, ones);

        List<Intern> closest = first.getClosestInterns(allInterns, 3);

        System.out.println(closest);
    }
}