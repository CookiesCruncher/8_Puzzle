import java.util.Comparator;

public class DistanceComparator implements Comparator<Board> {
    public int compare(Board s1, Board s2) {
        s1.setManhattan_distance();
        s2.setManhattan_distance();
        int i = s1.manhattan_distance;
        int j = s2.manhattan_distance;
        if (i > j)
            return 1;
        else if (i < j)
            return -1;
        return 0;
    }
}