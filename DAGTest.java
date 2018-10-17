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

}
