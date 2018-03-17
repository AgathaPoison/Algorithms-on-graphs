package algorythms;

public class test_graph_a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] Array1 = {{0,1,1,0,0,0,0},{1,0,0,1,1,0,0},{1,0,0,1,0,1,1},{0,1,1,0,1,0,0},{0,1,0,1,0,0,0},{0,0,1,0,0,0,0},{0,0,1,0,0,0,0}};
		int[][] Array2 = {{0, 2, 1, 3, 0, 6, 0}, {2, 0 , 0, 1, 3, 0 ,0 }, {1, 0, 0, 2, 0, 3,0 }, {3, 1, 2, 0, 0, 0, 1}, {0, 3, 0, 0, 0, 0, 4}, {6, 0, 3, 0, 0, 0, 7}, {0, 0, 0, 1, 4, 7, 0} };		
		graph_a test = new graph_a();
		int v = 0;
		System.out.println("Depth-first search algorithm, start from vertex " +(v+1)+":" );
		test.DeepSearch(Array1, v);
		System.out.println("\nBreadth-first search algorithm, start with vertex " + (v+1) + ": ");
		test.WideSearch(Array1, v);
		System.out.println("\nFloyd-Warshall algorithm: ");
		test.FloydsAlg(Array2);
		v=3;
		System.out.println("\nDijkstra's algorithm, sart with vertex " + (v+1) + ": " );
		test.Dij(Array2, v);
		v=4;
		System.out.println("\nPrima's algorithm, start with vertex " + (v+1) +":");
		test.PrimasAlg(Array2, v);
		System.out.println("\nKruskal's algorithm:");
		test.Kruskal(Array2);
	}
}