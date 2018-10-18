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
		assertEquals(1, graph.validateVertex(9));
	}
	
	//Test indegree function
	@Test
	public void testIndegree()
	{
		
	}

	//Tests outdegree function
	@Test
	public void testOutdegree()
	{

	}

}
