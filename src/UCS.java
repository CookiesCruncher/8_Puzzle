import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Set;

public class UCS {
    private PriorityQueue<Board> avail_paths;
    private static Set<String> visited;
    int node;
    public UCS(){
        avail_paths = new PriorityQueue<>(new DistanceComparator());
        node = 0;
        visited = new HashSet<>();
    }

    public Board alg(Board puzzle){
        setAvail_paths(puzzle);

        while(!avail_paths.isEmpty()) {
            node++;
            Board nextPuzzle = avail_paths.remove();

            if (!nextPuzzle.check_goal_d()) {
                setAvail_paths(nextPuzzle);
            }
            else {
                System.out.println("Uniform Cost Search:\nNode visited: "+node);
                return nextPuzzle;
            }
        }
        System.out.println("NO SOLUTION!!!!");
        return null;
    }

    private void setAvail_paths(Board puzzle) {
        Board temp = new Board(puzzle.table);
        puzzle.z_index();

        if(puzzle.z.y < 2){
            Board i = puzzle.move("DOWN");
            check_path(i);
        }
        if(puzzle.z.y > 0){
            Board i = puzzle.move("UP");
            check_path(i);
        }
        if(puzzle.z.x > 0){
            Board i = puzzle.move("LEFT");
            check_path(i);
        }
        if(puzzle.z.x < 2){
            Board i = puzzle.move("RIGHT");
            check_path(i);
        }
    }

    private void check_path(Board i) {
        if(!visited.contains(Arrays.deepToString(i.table))) {
            avail_paths.add(i);
            visited.add(Arrays.deepToString(i.table));
        }
    }
}
