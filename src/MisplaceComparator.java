import java.util.Comparator;

public class MisplaceComparator implements Comparator<Board> {
    public int compare(Board s1, Board s2) {
        s1.setMisplace();
        s2.setMisplace();
        int i = s1.misplace;
        int j = s2.misplace;
        if (i > j)
            return 1;
        else if (i < j)
            return -1;
        return 0;
    }
}
