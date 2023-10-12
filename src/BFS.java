import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    Queue <Board> q;
    int node;

    public BFS(){
        q = new LinkedList<>();
        node = 0;
    }

    public int alg(Board puzzle){
        while(!puzzle.goal_check() && node < 10) {
            puzzle.avail_paths();

            for(String key : puzzle.paths.keySet()) {
                q.add(puzzle.paths.get(key));
            }

            while(!q.isEmpty()){
                node++;
                alg(q.remove());
            }

        }
        puzzle.print();
        return node;
    }
}
