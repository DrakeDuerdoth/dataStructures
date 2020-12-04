package homework;  
import algs41.Graph;
import algs41.GraphGenerator;
import stdlib.*;
import algs13.Queue;


public class DS2GraphDistance {

	int[] eccentricity;         // the eccentricity of each vertex
	int diameter;               // the diameter of the graph
	int radius;	                // the radius of the graph
	private boolean[] marked; // Is a shortest path to this vertex known?
	private int[] edgeTo; // last vertex on known path to this vertex
	private int[] distTo;  
	
	
	public DS2GraphDistance(Graph G) {

		this.eccentricity = new int[G.V()];
		int diameter = Integer.MIN_VALUE;   // this is not the class instance variable
		int radius = Integer.MAX_VALUE;     // this is not the class instance variable   -- see below
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		distTo = new int[G.V()];
		

        for(int vertex = 0; vertex < G.V(); vertex++) {
        	bfs(G, vertex); 															// breadth first search to get the distances
            for(int otherVertex = 0; otherVertex < G.V(); otherVertex++) { 				// gets the adj
                if (otherVertex == vertex) continue; 											// checks to see if the adj is the vertex itself/ self loop / if so continue to next vertex
                eccentricity[vertex] = Math.max(eccentricity[vertex], distTo(otherVertex)); // gets the distance or eccentricity of vertex if it was already found - gets the bigger one out of the two
            }
            if (eccentricity[vertex] > diameter) diameter = eccentricity[vertex]; 															// sets the diameter to the eccentricity if the diameter is less than the eccentricity. This will happen as long as the graph is connected.  The longer/ farther away the vertices are from the start the greater the diameter grows               
            if (eccentricity[vertex] < radius) radius = eccentricity[vertex];																								// sets the radius to eccentricity if radius is greater than eccentricity.
            if(G.V() !=0 && diameter == Integer.MAX_VALUE) 																					// if diameter doesnt get overridden above and it is still the MAX_VALUE then it will throw an exception because the graph is disconnected. In the bfs it sets the disto to MAX_VALUE if the graph is disconnected
            	throw new IllegalArgumentException("Undefined");
        }
        this.diameter = diameter;   //sets the final diameter of the graph
		this.radius   = radius; // sets the final radius of the graph
    }
	
	private void bfs(Graph G, int s) { //Breadth First Search
        Queue<Integer> q = new Queue<Integer>();
        marked = new boolean[G.V()]; // Initializes a new marked/ unmarks the vertices
        
        for (int v = 0; v < G.V(); v++) distTo[v] = Integer.MAX_VALUE;
        
        distTo[s] = 0;
        marked[s] = true;
        q.enqueue(s);

        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }
	
    public int distTo(int v) { // returns distance from vertex
        return distTo[v];
    }
	
	

	// Do not change the following constant time methods
	public int eccentricity(int v) { return eccentricity[v]; }
	public int diameter()          { return diameter; }
	public int radius()            { return radius; }
	public boolean isCenter(int v) { return eccentricity[v] == radius; }

	public static void main(String[] args) {
		// ToDo   test your class with different graphs by commenting in/out graphs below    

		//Graph G = GraphGenerator.fromIn(new In("data/tinyG.txt")); // this is non-connected -- should throw an exception
		//Graph G = GraphGenerator.connected (10, 20, 2); // Random non-connected graph -- should throw an exception
		Graph G = GraphGenerator.fromIn(new In("data/tinyCG.txt")); // diameter=2, radius=2, every node is a center
		//Graph G = GraphGenerator.binaryTree (10); // A complete binary tree  diameter:5, radius 3
		//Graph G = GraphGenerator.path (6); // A path -- diameter=V-1
	    //Graph G = GraphGenerator.connected (20, 40); // Random connected graph, typical diameter 4 or 5, radius: 3 or 4

		StdOut.println(G);       // comment in if you want to see the adj list
		//G.toGraphviz ("g.png");  // comment in if you want a png of the graph and you have graphViz installed

		//  nothing to change below here
		try {
			DS2GraphDistance theGraph = new DS2GraphDistance(G);
			for (int v = 0; v < G.V(); v++)
				StdOut.format ("eccentricity of %d: %d\n", v, theGraph.eccentricity (v));
			StdOut.format ("\ndiameter = %d\n\nradius = %d\n\n", theGraph.diameter(), theGraph.radius() );
			StdOut.format ("checking for centers... \n" );
			for (int i = 0; i < G.V(); i++) {
				if ( theGraph.isCenter(i))
					StdOut.format ("center=%d\n", i);
			}
			StdOut.format ("done. \n" );
		} 
		catch (IllegalArgumentException e) {
			StdOut.println( " Exception was caught: " + e.getMessage());
		}
	}
}
