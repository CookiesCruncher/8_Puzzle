import java.util.*;

public class BFS {
    Queue <Board> q;
    int node;
    ArrayList <String> visited;

    public BFS(){
        q = new LinkedList<>();
        node = 0;
        visited = new ArrayList<>();
    }

    public Board alg(Board puzzle){
        puzzle.print();
        if(puzzle.goal_check()){
            System.out.println("SOLUTION FOUND!!!!\n");
            return puzzle;
        }

        if(!puzzle.goal_check()) {
            puzzle.avail_paths();

            for(String key : puzzle.paths.keySet()) {
                q.add(puzzle.paths.get(key));
            }

            while(!q.isEmpty()) {
                node++;
                Board nextPuzzle = q.remove();

                if (!visited.contains(Arrays.deepToString(nextPuzzle.table))) {

                    visited.add(Arrays.deepToString(nextPuzzle.table));
                    Board result = alg(nextPuzzle);

                    if (result != null) {
                        return result;
                    }
                }
            }
        }
        return null;
    }
}
