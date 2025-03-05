import java.io.*;
import java.util.*;

public class Main { 
	
	static int n;
	static int maxDist;
	static int maxDistNum;
	static boolean[] visited;
	
	static class Node {	
		int num; //노드번호
		int ga; //가중치
		Node parent;
		List<Node> children=  new ArrayList<>();
		
		Node(int num) {
			this.num = num;
		}
		
		void setParent(Node parent, int ga) {
			this.parent = parent;
			this.ga = ga;
		}
		
		void insert(Node node) {
			children.add(node);
		}
		
	}
	
	static void dfs(Node node, int dist) {
		
		visited[node.num] = true;
		
		if (dist > maxDist) {
			maxDist = dist;
			maxDistNum = node.num;
		}
		
		for (Node child : node.children) {
			if (!visited[child.num]) {
				dfs(child, dist + child.ga);
			}
		}
		
		if (node.parent != null && !visited[node.parent.num]) {
			dfs(node.parent, dist + node.ga);
		}
		
	}

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	// init
    	n = Integer.parseInt(br.readLine());
    	Node[] arr = new Node[n + 1];
    	
    	for (int i = 1; i <= n; i++) {
    		arr[i] = new Node(i);
    	}
    	
    	for (int i = 0; i < n -1; i++) {
    		st = new StringTokenizer(br.readLine());
    		int parent = Integer.parseInt(st.nextToken());
    		int child = Integer.parseInt(st.nextToken());
    		int ga = Integer.parseInt(st.nextToken());
    		
    		Node pNode = arr[parent];
    		Node cNode = arr[child];
    		    		
    		cNode.setParent(pNode, ga);
    		pNode.insert(cNode);
    	}
    	
    	// process
    	maxDistNum = 1;
    	visited = new boolean[n + 1];
    	dfs(arr[1], 0);
    	
    	maxDist = 0;
    	visited = new boolean[n + 1];
    	dfs(arr[maxDistNum], 0);
    	
    	System.out.println(maxDist);
    }
}