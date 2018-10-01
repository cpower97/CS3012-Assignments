import java.util.NoSuchElementException;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
/* This implementation of the lowest common ancestor problem is based on code I had written 
 * for a module last year in which I built a binary search tree API with basic functions
 * implemented, such as get and put. For this assignment I then added a function to find the 
 * lowest common ancestor of two nodes.
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST

    /**
     * Private node class.
     */
    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int N;             // number of nodes in subtree

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public Value findLCA(Key k1, Key k2)
    {
    	if(root == null) return null;
    	
    	if(!this.contains(k1) || !this.contains(k2)) return null;
    	
    	return findLCA(root, k1, k2);
    }
    
    private Value findLCA(Node node, Key k1, Key k2)
    {
    	
    	if(node.key.compareTo(k1) > 0 && node.key.compareTo(k2) > 0)
    		return findLCA(node.left, k1, k2);
    	
    	if(node.key.compareTo(k1) < 0 && node.key.compareTo(k2) < 0)
    		return findLCA(node.right, k1, k2);
    	
    	return node.val;
    }
    // is the symbol table empty?
    public boolean isEmpty() { return size() == 0; }

    // return number of key-value pairs in BST
    public int size() { return size(root); }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) { return get(root, key); }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }

    public void put(Key key, Value val) {
        if (val == null) { delete(key); return; }
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }
    
    public int height()
    {
    	return height(root);
    }

    public int height(Node x)
    {
    	if (x == null)
    	{
    		return -1;
    	}

    	else if(height(x.left) > height(x.right))
    	{
    		return 1 + height(x.left); 
    	}
    	else return 1 + height(x.right); 
    }

    public Key median() 
    {
    	if (isEmpty()) return null;
    	int size = (size(root));
    	int median = ((size+1)/2)-1;
    	return median(root, median).key;
    	
    }
    
    private Node median(Node x, int k)
    {
   
    	int t = size(x.left);
    	if (t > k)
    	{
    		return median(x.left, k);
    	}
    	else if (t < k)
    	{
    		return median(x.right, k-t-1);
    	}
    	else return x;
    }
   



    public String printKeysInOrder() {
    	if (isEmpty()){
    		return "()";
    	}
    	else
    	{
    		String str = printKeysInOrder(root);
    		return str;
    	}
    }

    private String printKeysInOrder(Node x)
    {
    	if(x == null)
    	{
    		return "()";
    	}
    	else
    	{
    		return "(" + printKeysInOrder(x.left) + x.key.toString() + printKeysInOrder(x.right) + ")";
    	}
    }

    public void delete(Key key) {
    	root = delete(root, key);
    }

    private Node delete(Node x, Key key)
    {
    	if(x == null)
    	{
    		return null;
    	}
    	int cmp = key.compareTo(x.key);
    	if(cmp < 0)
    	{
    		x.left = delete(x.left, key);
    	}
    	else if(cmp > 0)
    	{
    		x.right = delete(x.right, key);
    	}
    	else
    	{
    		if(x.right == null)
    		{
    			return x.left;
    		}
    		if(x.left == null)
    		{
    			return x.right;
    		}

    		Node t = x;
    		x = findMax(t.left);
    		x.left = deleteMax(t.left);
    		x.right = t.right;
    	}
    	x.N = 1 + size(x.left) + size(x.right);
    	return x;
    }

    private Node deleteMax(Node x)
    {
    	if(x.right == null)
    	{
    		return x.left;
    	}
    	x.right = deleteMax(x.right);
    	x.N = 1 + size(x.left) + size(x.right);
    	return x;
    }

    private Node findMax(Node x)
    {
    	if(x.right != null)
    	{
    		return findMax(x.right);
    	}
    	else return x;
    }

}