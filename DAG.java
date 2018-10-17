import java.util.LinkedList;
import java.util.Iterator;
import java.util.ArrayList;

/* Various aspects of this code are based on Sedgewick and Wayne's 
 * implementation of a directed graph. However, instead of using a bag
 * data structure, I have chosen to use an array list to represent the
 * adjacency list for a vertex.
 */
public class DAG 
{
	private int E; //No. of edges
	private int V; //No. of vertices
	private int[] indegree;
	private int[] outdegree;
	private boolean[] visited;
	private boolean[] stack;
	private boolean hasCycle;
	private ArrayList<Integer>[] adj;
	
	public DAG(int V)
	{
		if(V < 0) throw new IllegalArgumentException("No. of vertices in a Digraph must be nonnegative");
		
		this.E = 0; //Initialize no. of edges to zero
		this.V = V; // Initialize no. of vertices
		visited = new boolean[V];
		indegree = new int[V];
		stack = new boolean[V];
		adj = new ArrayList[V];
		
		//Intialize adjacency lists for each vertex
		for(int i = 0; i < V; i++)
			adj[i] = new ArrayList<Integer>();
					
	}
	
	//Returns number of vertices in digraph
	public int V() {return V;}
	//Returns number of edges in digraph
	public int E() {return E;}
	
	public boolean isEmpty()
	{
		if(V == 0) return true;
		else return false;
	}
	
}
