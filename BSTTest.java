import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BSTTest
{

	//Tests binary search tree constructor
	@Test
	public void testBSTConstructor()
	{
		//Test construction of bst
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertTrue(bst.isEmpty());
		assertEquals("An empty tree should have size 0.",0,bst.size());
		
	}
	
	//Finds the lowest common ancestor of two nodes in a binary search tree
	@Test
	public void testLCAEmpty()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		
		//Tests findLCA for empty binary tree
		assertNull("There should be no lca as the tree is empty",bst.findLCA(1, 2));
		
	}
	
	//Tests findLCA for various non-empty binary trees
	@Test
	public void testLCA()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		bst.put(7, 7);
		bst.put(8, 8);
		bst.put(6, 6);
		bst.put(6,9);
		
		
		//Tests findLCA for non-empty binary trees
		assertEquals("The lca of these nodes should be 7.",bst.get(7), bst.findLCA(6, 8));
		
		BST<Integer, Integer> bst2 = new BST<Integer, Integer>();
		bst2.put(7, 7);
		bst2.put(6, 6);
		bst2.put(5, 5);
		bst2.put(4, 4);
		bst2.put(3, 3);
		
		assertEquals("The lca of these nodes should be 4.",bst2.get(4), bst2.findLCA(3, 4));
		
		BST<Integer, Integer> bst3 = new BST<Integer, Integer>();
		bst3.put(7, 7);
		bst3.put(10,10);
		bst3.put(6, 6);
		bst3.put(5, 5);
		bst3.put(4, 4);
		bst3.put(3, 3);
		
		assertEquals("The lca of these nodes should be 7.",bst3.get(7), bst3.findLCA(6, 10));
		
		BST<Integer, Integer> bst4 = new BST<Integer, Integer>();
		bst4.put(7, 7);   //        _7_
		bst4.put(8, 8);   //      /     \
		bst4.put(3, 3);   //    _3_      8
		bst4.put(1, 1);   //  /     \
		bst4.put(2, 2);   // 1       6
		bst4.put(6, 6);   //  \     /
		bst4.put(4, 4);   //   2   4
		bst4.put(5, 5);   //        \
		                 //         5
		
		assertEquals("The lca of these nodes should be 7.",bst4.get(7), bst4.findLCA(8,5));
		assertEquals("The lca of these nodes should be 3.",bst4.get(3), bst4.findLCA(2,4));
		
		BST<Integer, Integer> bst5 = new BST<Integer, Integer>();
		bst5.put(7, 7);  //    7
		bst5.put(8, 8);  //     \
		bst5.put(9,9);   //      8
		bst5.put(10, 10);//       \
		bst5.put(11, 11);//        9
				        //         \
		               //           10
		               //            \
		                //            11
		assertEquals("The lca of these nodes should be 10.",bst5.get(10), bst5.findLCA(11, 10));
		assertEquals("The lca of these nodes should be 7.",bst5.get(7), bst5.findLCA(7, 8));
		
		BST<Integer, Integer> bst6 = new BST<Integer, Integer>();
		bst6.put(7, 7);//            7
		bst6.put(6, 6);//           /
		bst6.put(5, 5);//          6
		bst6.put(4, 4);//         /
		bst6.put(3, 3);//        5
		               //       /
		               //      4
		               //     /
		               //    3
		
		assertEquals("The lca of these nodes should be 6.",bst6.get(6), bst6.findLCA(5,6));
		assertEquals("The lca of these nodes should be 4.",bst6.get(4), bst6.findLCA(4,3));
		
	}
	
	//Tests findLCA for parameters ordered differently
	@Test
	public void testLCAOrderSwap()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		bst.put(7, 7);   //        _7_
		bst.put(8, 8);   //      /     \
		bst.put(3, 3);   //    _3_      8
		bst.put(1, 1);   //  /     \
		bst.put(2, 2);   // 1       6
		bst.put(6, 6);   //  \     /
		bst.put(4, 4);   //   2   4
		bst.put(5, 5);   //        \
		                 //         5
		
		assertEquals("The lca of these nodes should be 3.",bst.get(3), bst.findLCA(2,4));
		assertEquals("The lca of these nodes should also be 3.",bst.get(3), bst.findLCA(4,2));
	}
	
	//Tests findLCA for node(s) not in tree
	@Test
	public void testLCAAbsentNode()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		bst.put(7, 7);   //        _7_
		bst.put(8, 8);   //      /     \
		bst.put(3, 3);   //    _3_      8
		bst.put(1, 1);   //  /     \
		bst.put(2, 2);   // 1       6
		bst.put(6, 6);   //  \     /
		bst.put(4, 4);   //   2   4
		bst.put(5, 5);   //        \
		                 //         5
		
		//Both of the passed nodes absent
		assertNull("Nodes with value 1 and 12 both absent.",bst.findLCA(1, 12));
		
		//One of the passed nodes absent
		assertNull("Nodes with value 14 absent.",bst.findLCA(7, 14));
		
	}
	
	//Test findLCA for negative integer parameters
	@Test
	public void testLCANegativeInteger()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		bst.put(7, 7);   //        _7_
		bst.put(8, 8);   //      /     \
		bst.put(3, 3);   //    _3_      8
		bst.put(1, 1);   //  /     \
		bst.put(2, 2);   // 1       6
		bst.put(6, 6);   //  \     /
		bst.put(4, 4);   //   2   4
		bst.put(5, 5);   //        \
		                 //         5
		
		assertNull("Value absent from tree.", bst.findLCA(-2, -5));
	}
	
	@Test
	public void testIsEmpty()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();

		//Test for empty bst
		assertTrue("Binary tree should be empty.",bst.isEmpty());

		//Test for bst with one node
		bst.put(7, 7);
		assertFalse("Binary tree should not be empty",bst.isEmpty());

		//Test for bst with multiple nodes
		bst.put(8, 8);
		bst.put(3, 3);
		bst.put(1, 1);   
		bst.put(2, 2);   
		bst.put(6, 6);   
		bst.put(4, 4);   
		bst.put(5, 5);

		assertFalse("Binary tree should not be empty",bst.isEmpty());
	}

	@Test
	public void testContains()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();

		//Test for empty bst
		int sampleKey = 1;
		assertFalse("Binary tree should not yet contain the sample key",bst.contains(sampleKey));

		//Test for non-empty bst
		bst.put(sampleKey, 1);
		assertTrue("Binary tree should contain the sample key",bst.contains(sampleKey));

		int absentKey = 3;
		assertFalse("Binary tree should not contain the absent key",bst.contains(absentKey));
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
		assertEquals("The binary tree should have the node with value 9",9, bst.get(9).intValue());

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
		assertEquals("The binary tree should have the node with value 5", 5, bst2.get(5).intValue());

	}

	@Test
	public void testPut()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();

		//Test for bst with node put in right subtree of root
		bst.put(7, 7);  //    7
		bst.put(8, 8);  //     \
		//      8
		assertTrue("The binary tree should contain the value 8.",bst.contains(8));

		//Test for bst with node put in left subtree of root
		               //           7
		bst.put(6, 6);//           / \
		             //           6   8
		assertTrue("The binary tree should contain the value 6.",bst.contains(6));

		//Test for node with null value
		bst.put(5, null);
		assertFalse("The binary tree should not contain the value 5.",bst.contains(5));

	}

	@Test
	public void testSize()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();

		//Test for empty bst
		assertEquals("The binary tree should have size 0",0, bst.size());

		//Test for bst with one node
		bst.put(7, 7);
		assertEquals("The binary tree should have size 1.",1, bst.size());

		//Test for bst with multiple nodes
		bst.put(8, 8);
		bst.put(3, 3);
		bst.put(1, 1);   
		bst.put(2, 2);   
		bst.put(6, 6);   
		bst.put(4, 4);   
		bst.put(5, 5);

		assertEquals("The binary tree should have size 8.",8, bst.size()); 
	}

	@Test
	public void testHeight()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();

		//Test for empty bst
		assertEquals("The binary tree should have height -1.",-1, bst.height());

		bst.put(7, 7); 
		//Test for bst with one node
		assertEquals("The binary tree should have height 0.",0, bst.height());

		bst.put(8, 8);
		bst.put(3, 3); 

		//Test for bst with height 1
		assertEquals("The binary tree should have height 1.",1, bst.height());

		bst.put(1, 1);   
		bst.put(2, 2);   
		bst.put(6, 6);   
		bst.put(4, 4);   
		bst.put(5, 5);

		//Test for bst with height > 1
		assertEquals("The binary tree should have height 4.",4, bst.height());
	}

	@Test 
	public void testMedian()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		BST<Integer, Integer> bst2 = new BST<Integer, Integer>();
		BST<Integer, Integer> bst3 = new BST<Integer, Integer>();

		//Test for empty bst
		assertNull("The empty binary tree should have no median.",bst.median());

		//Test for bst with one node
		bst2.put(7, 7); 
		assertEquals("The binary tree should have median 7.",7, bst2.median().intValue());

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
		assertEquals("The binary tree should median 9.",9, bst2.median().intValue());

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
		assertEquals("The binary tree should have median 5.",5, bst3.median().intValue());

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
		assertEquals("The binary tree should have median 4.",4, bst.median().intValue());


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

	@Test
	public void testDelete()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		bst.put(7, 7);
		bst.put(8, 8);
		bst.put(6, 6);
		
		bst.delete(8);
		assertNull("The tree does not contain the value 8.",bst.get(8));
		assertFalse("The tree does not contain the value 8.",bst.contains(8));
		
		BST<Integer, Integer> bst2 = new BST<Integer, Integer>();
		bst2.put(7, 7);
		bst2.put(6, 6);
		bst2.put(5, 5);
		bst2.put(4, 4);
		bst2.put(3, 3);
		
		bst2.delete(7);
		assertNull("The tree does not contain the value 7.",bst2.get(7));
		assertFalse("The tree does not contain the value 7.",bst2.contains(7));
		
		BST<Integer, Integer> bst3 = new BST<Integer, Integer>();
		bst3.put(7, 7);   //        _7_
		bst3.put(8, 8);   //      /     \
		bst3.put(3, 3);   //    _3_      8
		bst3.put(1, 1);   //  /     \
		bst3.put(2, 2);   // 1       6
		bst3.put(6, 6);   //  \     /
		bst3.put(4, 4);   //   2   4
		bst3.put(5, 5);   //        \
		                 //         5
		
		bst3.delete(7);
		bst3.delete(3);
		bst3.delete(5);
		bst3.delete(1);
		bst3.delete(10);
		
		assertFalse("The tree does not contain the value 7.",bst3.contains(7));
		assertFalse("The tree does not contain the value 3.",bst3.contains(3));
		assertFalse("The tree does not contain the value 5.",bst3.contains(5));
		assertFalse("The tree does not contain the value 1.",bst3.contains(1));
		assertFalse("The tree does not contain the value 10.",bst3.contains(10));
		assertTrue("The tree contains the value 8.",bst3.contains(8));
		
		BST<Integer, Integer> bst4 = new BST<Integer, Integer>();
		bst4.put(7, 7);  //    7
		bst4.put(8, 8);  //     \
		bst4.put(9,9);   //      8
		bst4.put(10, 10);//       \
		bst4.put(11, 11);//        9
				        //         \
		               //           10
		               //            \
		                //            11
		bst4.delete(7);
		bst4.delete(3);
		bst4.delete(5);
		
		assertFalse("The tree does not contain the value 7.",bst4.contains(7));
		assertFalse("The tree does not contain the value 3.",bst4.contains(3));
		assertFalse("The tree does not contain the value 5.",bst4.contains(5));
		
	}
}

