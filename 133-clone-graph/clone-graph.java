/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;

        Set<Integer> visited = new HashSet<>();
        Map<Integer, Node> nodeMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        Node returnNode = null;

        while(!queue.isEmpty()){

            Node current = queue.poll();
            int nodeValue = current.val;

            if(!visited.contains(nodeValue)){

                Node newNode;
                if(!nodeMap.containsKey(nodeValue)){
                    newNode = new Node(nodeValue);
                    nodeMap.put(nodeValue, newNode);
                }
                else
                    newNode = nodeMap.get(nodeValue);

                List<Node> newNeighbors = newNode.neighbors;
                for(Node neighbor : current.neighbors){
                    Node newNeighbor;
                    if(!nodeMap.containsKey(neighbor.val)){
                        newNeighbor = new Node(neighbor.val);
                        nodeMap.put(neighbor.val, newNeighbor);
                    } else
                        newNeighbor = nodeMap.get(neighbor.val);
                    newNeighbors.add(newNeighbor);
                    if(!visited.contains(neighbor.val))
                        queue.offer(neighbor);
                }
                visited.add(nodeValue);
                if(returnNode==null)
                    returnNode = newNode;
            }
        }
        return returnNode;
    }
}