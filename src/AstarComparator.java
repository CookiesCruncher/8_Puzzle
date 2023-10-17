import java.util.Comparator;

public class AstarComparator implements Comparator<Board> {
    public int compare(Board s1, Board s2) {
        s1.set_nilsson();
        s2.set_nilsson();
        int i = s1.nilsson;
        int j = s2.nilsson;
        if (i > j)
            return 1;
        else if (i < j)
            return -1;
        return 0;
    }
}
