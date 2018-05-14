package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
		List<UndirectedGraphNode> neighbors;

		return cloneGraph(node);
	}

//	public UndirectedGraphNode search(Set<UndirectedGraphNode> visited,
//			UndirectedGraphNode node) {
//		if (visited.contains(node))
//			return null;
//		else {
//			
//		}
//	}
}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}