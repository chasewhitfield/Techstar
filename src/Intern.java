public class Intern {

    private String name;
    private int globe1, globe2, globe3, globe4, globe5;
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
}
