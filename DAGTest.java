import static org.junit.Assert.*;

import org.junit.Test;

public class DAGTest {

	//Tests empty DAG
	@Test
	public void testEmpty() 
	{
		DAG graph = new DAG(0);
		assertTrue(graph.isEmpty());
	}
	
	//Test DAG with negative amount of vertices
	@Test(expected=IllegalArgumentException.class)
	public void testNegativeVertices()
	{
		DAG graph = new DAG(-1);
	}
	
	//Tests edge getter fucntion
	@Test
	public void testEdgeGetter()
	{
		DAG graph = new DAG(10);
		graph.addEdge(1,2);
		graph.addEdge(2,3);
		graph.addEdge(3,4);
		graph.addEdge(4,5);
		
		assertEquals("This graph has 4 edges", 4, graph.E());
	}

	//Test the DAG constructor
	@Test
	public void testGraphConstructor()
	{
		DAG graph = new DAG(0);
		assertEquals("This graph has no vertices", 0, graph.V());
		assertEquals("This graph has no edges", 0, graph.E());
		assertNull("The adjacency list is empty",graph.adj(0));
		
		
		graph = new DAG(1);
		assertEquals("This graph has 1 vertex", 1, graph.V());
		assertEquals("This graph has no edges", 0, graph.E());
		assertNotNull("The adjacency list is not empty", graph.adj(0));
		
		graph = new DAG(1000);
		assertEquals("This graph has 1000 vertices", 1000, graph.V());
		assertEquals("This graph has no edges", 0, graph.E());
		assertNotNull("The adjacency list is not empty", graph.adj(999));
		
	}
	
	//Test isEmpty function
	@Test
	public void testIsEmpty()
	{
		DAG graph = new DAG(0);
		assertTrue("This graph is empty", graph.isEmpty());
		
		graph = new DAG(1);
		assertFalse("This graph is not empty",graph.isEmpty());
	}
	
	//Tests validateVertex function
	@Test
	public void testValidateVertex()
	{
		DAG graph = new DAG(10);
		assertEquals(-1, graph.validateVertex(-1));
		assertEquals(-1, graph.validateVertex(11));
		assertEquals(-1, graph.validateVertex(10));
		assertEquals(1, graph.validateVertex(9));
		assertEquals(1, graph.validateVertex(0));
	}
	
	//Test indegree function
	@Test
	public void testIndegree()
	{
		DAG graph = new DAG(10);
		graph.addEdge(1,2);
		graph.addEdge(2,3);
		graph.addEdge(3,4);
		graph.addEdge(4,5);
		
		assertEquals("This vertex has an indegree of 0", 0, graph.indegree(1));
		assertEquals("This vertex has an indegree of 1", 1, graph.indegree(2));
		assertEquals("This vertex has an indegree of 0", 0, graph.indegree(6));
		assertEquals("This vertex does not exist", -1, graph.indegree(-2));
		assertEquals("This vertex has an indegree of 0", 0, graph.indegree(0));
		
	}

	//Tests outdegree function
	@Test
	public void testOutdegree()
	{
		DAG graph = new DAG(10);
		graph.addEdge(1,2);
		graph.addEdge(2,3);
		graph.addEdge(3,4);
		graph.addEdge(4,5);
		
		assertEquals("This vertex has an outdegree of 1", 1, graph.outdegree(1));
		assertEquals("This vertex has an outdegree of 1", 1, graph.outdegree(2));
		assertEquals("This vertex has an outdegree of 0", 0, graph.outdegree(5));
		assertEquals("This vertex has an outdegree of 0", 0, graph.outdegree(6));
		assertEquals("This vertex does not exist", -1, graph.outdegree(-2));
		assertEquals("This vertex has an outdegree of 0", 0, graph.outdegree(0));
	}
	
	//Tests addEdge function
	@Test
	public void testAddEdge()
	{
		DAG graph = new DAG(10);
		graph.addEdge(1,2);
		graph.addEdge(2,3);
		graph.addEdge(3,4);
		graph.addEdge(4,5);
		graph.addEdge(-1,-2);

		assertEquals("This graph has 4 edges", 4, graph.E());
		assertFalse(graph.E() == 5);
	}
	
	//Tests hasCycle and findCycle functions
	@Test
	public void testHasCycle()
	{
		DAG graph = new DAG(10);
		graph.addEdge(0,1);
		graph.addEdge(1,2);
		graph.addEdge(2,3);
		graph.addEdge(3,4);
		graph.addEdge(4,5);
		
		graph.findCycle(0);
		assertFalse("Graph does not have cycle",graph.hasCycle());
		
		DAG graph2 = new DAG(10);
		graph2.addEdge(0,1);
		graph2.addEdge(1,2);
		graph2.addEdge(2,0);
		graph2.addEdge(2,3);
		graph2.addEdge(3,4);
		graph2.addEdge(4,5);
		
		graph2.findCycle(0);
		assertTrue("Graph has cycle",graph2.hasCycle());
		
	}
	
	

}
