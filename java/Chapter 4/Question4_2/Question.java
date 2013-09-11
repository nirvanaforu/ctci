package Question4_2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question {
	public enum State {
		Unvisited, Visited, Visiting;
	} 

	public static void main(String a[])
	{
		Graph g = createNewGraph();
		Node[] n = g.getNodes();
		Node start = n[0];
		Node end = n[5];
		//created to record the route
		LinkedList<Node> route = new LinkedList<Node>();
		System.out.println("Node:"+start.getVertex()+" and Node:"+end.getVertex()+" has a route to connect");
	    boolean route_exist = search(g, start, end, route);
	    if (route_exist) {
	        System.out.println("route exists as follows:");
	        for (Node nn: route) {
	            System.out.println(nn.getVertex()+"-->");
	        }
	    } else {
	        System.out.println("route NOT exists");
	    }		
	}
	
	public static Graph createNewGraph()
	{
		Graph g = new Graph();        
		Node[] temp = new Node[6];

		temp[0] = new Node("a", 3);
		temp[1] = new Node("b", 0);
		temp[2] = new Node("c", 0);
		temp[3] = new Node("d", 1);
		temp[4] = new Node("e", 1);
		temp[5] = new Node("f", 0);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		for (int i = 0; i < 6; i++) {
			g.addNode(temp[i]);
		}
		return g;
	}

    // use queue for BFS, stack for DFS
	public static boolean search(Graph g,Node start,Node end, LinkedList<Node> route) {  
        LinkedList<Node> q = new LinkedList<Node>();
        //Queue<Node> q = new LinkedList<Node>();        
        for (Node u : g.getNodes()) {
            u.state = State.Unvisited;
        }
        start.state = State.Visiting;
        q.add(start);
        route.addLast(start);
        Node u;
        while(!q.isEmpty()) {
            u = q.removeFirst();
            //u = q.remove();
            if (u != null) {
	            for (Node v : u.getAdjacent()) {	                
	                if (v.state == State.Unvisited) {	                    
	                    if (v == end) {
	                        return true;
	                    } else {
	                        v.state = State.Visiting;
	                        route.addLast(v);
	                        q.add(v);
	                    }
	                }
	            }
	            u.state = State.Visited;
	            route.remove(u);
            }
        }
        return false;
    }
}
