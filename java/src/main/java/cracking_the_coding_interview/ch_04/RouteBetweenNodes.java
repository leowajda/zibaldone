package cracking_the_coding_interview.ch_04;

import java.util.*;

public class RouteBetweenNodes {

    private static boolean areNodesConnected(GraphNode start, GraphNode end) {

        Queue<GraphNode> queue = new ArrayDeque<>(List.of(start));
        Set<GraphNode> visited = new HashSet<>(List.of(start));

        while (!queue.isEmpty()) {
            var node = queue.remove();

            if (node == end)
                return true;

            for (var child : node.children)
                if (visited.add(child))
                    queue.add(child);
        }

        return false;
    }

}
