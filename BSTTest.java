import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BSTTest
{

	@Test
	public void testIsEmpty()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();

		//Test for empty bst
		assertTrue(bst.isEmpty());

		//Test for bst with one node
		bst.put(7, 7);
		assertFalse(bst.isEmpty());

		//Test for bst with multiple nodes
		bst.put(8, 8);
		bst.put(3, 3);
		bst.put(1, 1);   
		bst.put(2, 2);   
		bst.put(6, 6);   
		bst.put(4, 4);   
		bst.put(5, 5);

		assertFalse(bst.isEmpty());
	}

	@Test
	public void testContains()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();

		//Test for empty bst
		int sampleKey = 1;
		assertFalse(bst.contains(sampleKey));

		//Test for non-empty bst
		bst.put(sampleKey, 1);
		assertTrue(bst.contains(sampleKey));

		int absentKey = 3;
		assertFalse(bst.contains(absentKey));
	}

	@Test
	public void testGet()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		BST<Integer, Integer> bst2 = new BST<Integer, Integer>();

		//Test for empty bst
		assertEquals(null, bst.get(1));

		//Test for bst with key in right subtree of root
		bst.put(7, 7);  //    7
		bst.put(8, 8);  //     \
		bst.put(9,9);   //      8
		bst.put(10, 10);//       \
		bst.put(11, 11);//        9
				        //         \
		               //           10
		               //            \
		                //            11
		assertEquals(9, bst.get(9).intValue());

		//Tests for bst with key in left subtree of root
		bst2.put(7, 7);//            7
		bst2.put(6, 6);//           /
		bst2.put(5, 5);//          6
		bst2.put(4, 4);//         /
		bst2.put(3, 3);//        5
		               //       /
		               //      4
		               //     /
		               //    3
		assertEquals(5, bst2.get(5).intValue());

	}

	@Test
	public void testPut()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();

		//Test for bst with node put in right subtree of root
		bst.put(7, 7);  //    7
		bst.put(8, 8);  //     \
		//      8
		assertTrue(bst.contains(8));

		//Test for bst with node put in left subtree of root
		              //            7
		bst.put(6, 6);//           / \
		               //         6   8
		assertTrue(bst.contains(6));

		//Test for node with null value
		bst.put(5, null);
		assertFalse(bst.contains(5));

	}

	@Test
	public void testSize()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();

		//Test for empty bst
		assertEquals(0, bst.size());

		//Test for bst with one node
		bst.put(7, 7);
		assertEquals(1, bst.size());

		//Test for bst with multiple nodes
		bst.put(8, 8);
		bst.put(3, 3);
		bst.put(1, 1);   
		bst.put(2, 2);   
		bst.put(6, 6);   
		bst.put(4, 4);   
		bst.put(5, 5);

		assertEquals(8, bst.size()); 
	}

	@Test
	public void testHeight()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();

		//Test for empty bst
		assertEquals(-1, bst.height());

		bst.put(7, 7); 
		//Test for bst with one node
		assertEquals(0, bst.height());

		bst.put(8, 8);
		bst.put(3, 3); 

		//Test for bst with height 1
		assertEquals(1, bst.height());

		bst.put(1, 1);   
		bst.put(2, 2);   
		bst.put(6, 6);   
		bst.put(4, 4);   
		bst.put(5, 5);

		//Test for bst with height > 1
		assertEquals(4, bst.height());
	}

	@Test 
	public void testMedian()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		BST<Integer, Integer> bst2 = new BST<Integer, Integer>();
		BST<Integer, Integer> bst3 = new BST<Integer, Integer>();

		//Test for empty bst
		assertNull(bst.median());

		//Test for bst with one node
		bst2.put(7, 7); 
		assertEquals(7, bst2.median().intValue());

		//Test for bst with median in right subtree of root
		                 //    7
		bst2.put(8, 8);  //     \
		bst2.put(9,9);   //      8
		bst2.put(10, 10);//       \
		bst2.put(11, 11);//        9
		                 //         \
		                 //          10
		                 //           \
		                 //            11
		assertEquals(9, bst2.median().intValue());

		//Tests for bst with median in left subtree of root
		bst3.put(7, 7);//            7
		bst3.put(6, 6);//           /
		bst3.put(5, 5);//          6
		bst3.put(4, 4);//         /
		bst3.put(3, 3);//        5
		               //       /
		               //      4
		               //     /
		               //    3
		assertEquals(5, bst3.median().intValue());

		//Test for bst with nodes in both the left and right subtrees of the root
		bst.put(7, 7);   //        _7_
		bst.put(8, 8);   //      /     \
		bst.put(3, 3);   //    _3_      8
		bst.put(1, 1);   //  /     \
		bst.put(2, 2);   // 1       6
		bst.put(6, 6);   //  \     /
		bst.put(4, 4);   //   2   4
		bst.put(5, 5);   //        \
		//         5
		assertEquals(4, bst.median().intValue());


	}

	@Test
	public void testPrintKeysInOrder()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();

		//Test for empty bst
		assertEquals("()", bst.printKeysInOrder());

		//Test for bst with one node
		bst.put(7, 7);
		assertEquals("(()7())", bst.printKeysInOrder());

		//Test for bst with more than one node
		//       _7_
		bst.put(8, 8);   //      /     \
		bst.put(3, 3);   //    _3_      8
		bst.put(1, 1);   //  /     \
		bst.put(2, 2);   // 1       6
		bst.put(6, 6);   //  \     /
		bst.put(4, 4);   //   2   4
		bst.put(5, 5);	  //        \
		//         5		
		assertEquals("(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());

	}

}

