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

    public void alg(Board puzzle){
        puzzle.print();
        if(puzzle.goal_check()){
            System.out.println("FOUND SOLUTION STOP!!!!!");
        }

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
    }
}
