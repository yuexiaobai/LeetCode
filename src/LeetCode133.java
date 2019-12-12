import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 133. Clone Graph
 * https://leetcode.com/problems/clone-graph/
 * 常规做法，用hashmap存老的对对象和新的对象，比较简单
 */
public class LeetCode133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (!map.containsKey(node)) {
            Node clone = new Node();
            clone.val = node.val;
            map.put(node, clone);
            if (node.neighbors != null) {
                clone.neighbors = new ArrayList<>();
                for (Node neighbor : node.neighbors) {
                    if (!map.containsKey(neighbor)) {
                        Node cloneNeighbor = cloneGraph(neighbor);
                        clone.neighbors.add(cloneNeighbor);
                    } else {
                        clone.neighbors.add(map.get(neighbor));
                    }
                }
            }
        }
        return map.get(node);
    }
}
