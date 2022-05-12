public class Intern {

    private final String name;
    public final int globe1, globe2, globe3, globe4, globe5;
    public Intern(String name, int globe1, int globe2, int globe3, int globe4, int globe5)
    {
        this.name = name;
        this.globe1 = globe1;
        this.globe2 = globe2;
        this.globe3 = globe3;
        this.globe4 = globe4;
        this.globe5 = globe5;
    }

    public String getName()
    {
        return this.name;
    }

    public double distanceToOtherIntern(Intern other) {
        /**
         *  Calculates the Euclidean/L2 distance between this Intern and the
         *  provided Intern, using their 5 "globe" attributes as dimensions.
         **/

        return sqrt(pow(this.globe1 - other.globe1, 2) +
        pow(this.globe2 - other.globe2, 2) +
        pow(this.globe3 - other.globe3, 2) +
        pow(this.globe4 - other.globe4, 2) +
        pow(this.globe5 - other.globe5, 2));
    }

    public List<Intern> getClosestInterns(List<Intern> others, int howMany) {
        /**
         * Given a list of other Interns (which may include this Intern), find the closest
         * Interns to this one.
         * 
         * If the provided List includes this Intern, that item isn't considered.
         */
        // Set up a comparator to compare by distance to this Intern
        Comparator<Intern> comparator = (i1, i2) -> this.distanceToOtherIntern(i1).compareTo(this.distanceToOtherIntern(i2));
        return others.stream()
        // Filter out any list entries that correspond to this Intern (their names will match)
        .filter(other -> !other.name.equals(this.name))
        // Sort by distance to this Intern
        .sorted(comparator)
        // Take only the first few Interns, depending on the parameter
        .limit(howMany)
        // Convert the result to a List
        .collect(Collectors.toList());
    }
}
