package edu.hawaii.ics211.uhCollection;

/** @author Blake Larson 
 * 
 * Class for a Binary Tree that stores type <E> objects.
 * 
 * @param <E> The Binary Tree is type <E>.
 */
public class UhBinaryTree<E extends Comparable<E>> {
	
  /** Return the value from the public add method.	
   */
  protected boolean addReturn;
  
  /** The root of the binary tree.
   */
  protected UhBinaryTreeNode<E> root;

  /** Class to encapsulate a tree node.
   * @author Blake Larson
   * @param <E> Node is type <E>.
   */
  public static class UhBinaryTreeNode<E> {
	  
    /** The information stored in this node.
     */
    E data = null;
      
    /** Reference to the left child.
     */
    UhBinaryTreeNode<E> left;
      
    /** Reference to the right child.
     */
    UhBinaryTreeNode<E> right;
      
    /** Construct a node with given data and no children.
     * @param data The data to store in this node.
     */
    public UhBinaryTreeNode(E data) {
      this.data = data;
      left = null;
   	  right = null;
    }
      
    /** Return a string representation of the node.
     * @return A string representation of the data fields.
     */
    public String toString() {
	  return data.toString();
    }
  }
  
  /** No-parameter constructor that sets the data field root to null.
   */
  public UhBinaryTree() {
    	root = null;
  }
    
  /** Constructor that takes a Node as a parameter.
   * @param root The Node.
   */
  protected UhBinaryTree(UhBinaryTreeNode<E> root) {
    this.root = root;
  }
    
  /** Constructs a new binary tree with data in its root leftTree .
   *  as its left subtree and rightTree as its right subtree.
   * @param data The node.
   * @param leftTree Left node of the root.
   * @param rightTree Right node of the root.
   */
  public UhBinaryTree(E data, UhBinaryTree<E> leftTree, UhBinaryTree<E> rightTree) {
   	root = new UhBinaryTreeNode<E>(data);
    if (leftTree != null) {
      root.left = leftTree.root;
    } else {
      root.left = null;
    }
    
    if (rightTree != null) {
   	  root.right = rightTree.root;
    } else {
   	  root.right = null;
    }
  }
  
  /** Starter method add.
   *  The object to insert must implement the Comparable interface.
   * @param item The object being inserted.
   * @return TRUE if the object is inserted, 
   * 		   FALSE if the object already exists in the tree.
   */
  public boolean add(E item) {
  	root = add(root, item);
  	//System.out.println("Adding " + item);
    return addReturn;
  }
  
  /** Recursive add method.
   *  The data field addReturn is set 
   *  TRUE if the item is added to the tree,
   *  FALSE if the item is already in the tree.
   * @param localRoot The local root of the subtree.
   * @param item The object to be inserted.
   * @return The new local root that now contains the inserted item.
   */
  private UhBinaryTreeNode <E> add(UhBinaryTreeNode<E> localRoot, E item) {
  	if(localRoot == null) {
  	  addReturn = true;
      return new UhBinaryTreeNode<E> (item);
    } else if (item.compareTo(localRoot.data) == 0) {
      addReturn = false;
      return localRoot;
    } else if (item.compareTo(localRoot.data) < 0) {
   	  localRoot.left = add(localRoot.left, item);
      return localRoot;
    } else {
      localRoot.right = add(localRoot.right, item);
      return localRoot;
      }
  }
    
  /** Creates a StringBuilder and calls preOrderTraverse passing 
   *  root and 1 as arguments.
   */
  public String toString() {
   	StringBuilder sb = new StringBuilder();
   	preOrderTraverse(root, 1, sb);
   	return sb.toString();
  }
    
  /** Creates a StringBuilder and calls preOrderTraverse passing 
   *  root and 1 as arguments.
   */
  public String preOrderTraverse() {
   	StringBuilder sb = new StringBuilder();
   	preOrderTraverse(root, 1, sb);
   	return sb.toString();
  }
    
  /** Perform a preorder traversal of the binary tree.
   * @param node The local root.
   * @param depth The depth.
   * @param sb The String buffer to save the output.
   */
  private void preOrderTraverse(final UhBinaryTreeNode<E> node, final int depth, final StringBuilder sb) {
    for (int i = 1; i < depth; i++) {
	  //sb.append("  ");
    }
    if (node == null) {
      //sb.append("null\n");
    } else {
      sb.append(node.toString() + " ");
      //sb.append("\n");
      preOrderTraverse(node.left, depth + 1, sb);
   	  preOrderTraverse(node.right, depth + 1, sb);
      }
  }
    
  /** Creates a StringBuilder and calls inOrderTraverse passing 
   *  root and 1 as arguments.
   */
  public String inOrderTraverse() {
    StringBuilder sb = new StringBuilder();
    inOrderTraverse(root, 1, sb);
    return sb.toString();
  }
    
  /** Perform a inorder traversal of the binary tree.
   * @param node The local root.
   * @param depth The depth.
   * @param sb The String buffer to save the output.
   */
  private void inOrderTraverse(final UhBinaryTreeNode<E> node, final int depth, final StringBuilder sb) {
    for (int i = 1; i < depth; i++) {
   	  //sb.append("  ");
    }
    if (node == null) {
      //sb.append("null\n");
    } else {
      //sb.append("\n");
      inOrderTraverse(node.left, depth + 1, sb);
      sb.append(node.toString() + " ");
      inOrderTraverse(node.right, depth + 1, sb);
    }
  }
    
  /** Creates a StringBuilder and calls postOrderTraverse passing
   *  root and 1 as arguments.
   */
  public String postOrderTraverse() {
   	StringBuilder sb = new StringBuilder();
   	postOrderTraverse(root, 1, sb);
   	return sb.toString();
  }
    
  /** Perform a postorder traversal of the binary tree.
   * @param node The local root.
   * @param depth The depth.
   * @param sb The String buffer to save the output.
   */
  private void postOrderTraverse(final UhBinaryTreeNode<E> node, final int depth, final StringBuilder sb) {
   	for (int i = 1; i < depth; i++) {
	  //sb.append("  ");
    }
    if (node == null) {
      //sb.append("null\n");
    } else {
      //sb.append("\n");
      postOrderTraverse(node.left, depth + 1, sb);
      postOrderTraverse(node.right, depth + 1, sb);
      sb.append(node.toString() + " ");
      }
  }
    
  /** Performs a traversal of the binary tree while counting all non-null nodes.
   * @param node The starting node for the count.
   * @param depth The starting depth for the count.
   * @return The total node count of the binary tree.
   */
  public int countNodes(final UhBinaryTreeNode<E> node, final int depth){
   	int count = 0;
    if(node == null){
      return 0;
    } else {
      count++;
      return (count + countNodes(node.left, depth + 1) + countNodes(node.right, depth + 1)); //Recursion
      }
  }
    
  /** Starter method find.
   * Pre: The target object must implement the Comparable interface.
   * @param target The Comparable object being sought.
   * @return The object, if found, otherwise null.
   */
  public E find(final E target) {
   	return find(root, target);
  }
    
  /** Recursive find method.
   * @param localRoot The local subtree's root.
   * @param target The object being sought.
   * @return The object, if found, otherwise null.
   */
  private E find(final UhBinaryTreeNode<E> localRoot, final E target) {
    if (localRoot == null || target == null) {
      return null;
    }
    	
    //Compare the target with the data field at the root.
    int compResult = target.compareTo(localRoot.data);
    if (compResult == 0) {
      return localRoot.data;
    } else if (compResult < 0) {
      return find(localRoot.left, target);
    } else {
	  return find(localRoot.right, target);
	}
  }
}
