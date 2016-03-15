package edu.hawaii.ics211.uhCollection;

import edu.hawaii.ics211.uhCollection.UhBinaryTree.UhBinaryTreeNode;

/** @author Blake Larson
 * 
 * Outter class for Single-Linked List.
 * 
 * @param <E>
 */
public class UhSingleLinkedList<E extends Comparable<E>> {
	private SingleLinkedListNode<E> head = null;
	private int size;

	/**Inner class of UhSingleLinkedList for the Node aspect.
	 * @param <E> Generic type
	 */
	public static final class SingleLinkedListNode<E> {
		public E data;
		private SingleLinkedListNode<E> next;
		
		/**Used to create a single node.
		 * @param dataItem The object/value for the node.
		 */
		private SingleLinkedListNode(E dataItem) {
			data = dataItem;
			next = null;
		}
		
		/**Used to create a single node at a given position.
		 * @param dataItem The object/value of the node.
		 * @param nodeRef The next node after the specific index.
		 */
		private SingleLinkedListNode(E dataItem, SingleLinkedListNode<E> nodeRef) {
			data = dataItem;
			next = nodeRef;
		}
	}
	
	/**Allows the user to add a node to the beginning of the list(head).
	 * @param item The object/value to add to the node.
	 */
	public void addFirst(E item) {
		head = new SingleLinkedListNode <E> (item,head);
		size++;
	}
	
	/**ALlows the user to add an item after a specific node.
	 * @param node The specified index after which to add.
	 * @param item The object/value to add to the node.
	 */
	
	public void addAfter(SingleLinkedListNode<E> node, E item) {
		node.next = new SingleLinkedListNode<E> (item, node.next);
		size++;
	}
	
	public void add(E item) {
		if (size == 0) {
			addFirst(item);
			
		}
		
		if (size > 0) {
			addAfter(getNode(size-1),item);
		}
	}
	
	/**Allows the user to add an item at a specific index.
	 * @param index The specific index at which to add.
	 * @param item The object/value to add to the node.
	 */
	public void add(int index, E item) {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		if(index == 0) {
			addFirst(item);
		} else {
			SingleLinkedListNode<E> node = getNode(index-1);
			addAfter(node, item);
		}
	}
	
	/**Gets the Package information of the specific node.
	 * @param index The specified node.
	 * @return The package of the node.
	 */
	public SingleLinkedListNode<E> getNode(int index) {
		SingleLinkedListNode<E> node = head;
		for(int i = 0; i < index && node != null; i++) {
			node = node.next;
		}
		return node;
	}
	
	/**Returns the value of the specific indexed node.
	 * @param index The specified node.
	 * @return The value of node.
	 */
	public E get(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		SingleLinkedListNode<E> node = getNode(index);
		return node.data;
	}
	
	/**Sets the value of the data at the specific index.
	 * @param index Specific point to set the value.
	 * @param newValue The new value of the index.
	 * @return The value of the data that was previously at that index.
	 */
	public E set(int index, E newValue) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		SingleLinkedListNode<E> node = getNode(index);
		E result = node.data;
		node.data = newValue;
		return result;
	}
	
	/**Allows the user to remove the first node from the list.
	 * @return Either the data of the removed node or nothing.
	 */
	public E removeFirst() {
		SingleLinkedListNode<E> temp = head;
		if(head != null) {
			head = head.next;
		}
		if(temp != null) {
			size--;
			return temp.data;
		} else {
			return null;
		}
	}
	
	/**Allows the user to remove a node at a specific position.
	 * @param node The node before the one to be removed.
	 * @return Either the data of the removed node or nothing.
	 */
	public E removeAfter(SingleLinkedListNode<E> node) {
		SingleLinkedListNode<E> temp = node.next;
		if(temp != null) {
			node.next = temp.next;
			size--;
			return temp.data;
		} else {
			return null;
		}
	}
	
	/** Allows traversal of the single linked list
	 */
	public String toString() {
		SingleLinkedListNode<E> nodeRef = head;
		StringBuilder result = new StringBuilder();
		while(nodeRef.next != null) {
			result.append(nodeRef.data);
			if(nodeRef.next != null) {
				result.append(" ==> ");
			}
			nodeRef = nodeRef.next;
		}
		return result.toString();
	}
	
	/** Starter method find.
	 * Pre: The target object must implement the Comparable interface.
     * @param target The Comparable object being sought.
	 * @return The object, if found, otherwise null.
	 */
	public E find(final E target) {
	   	return find(head, target);
	}
	
	/** Recursive find method.
	 * @param localRoot The local subtree's root.
     * @param target The object being sought.
	 * @return The object, if found, otherwise null.
	 */
	private E find(final SingleLinkedListNode<E> localRoot, final E target) {
		if (localRoot == null || target == null) {
	    	return null;
	    }
	    	
	    //Compare the target with the data field at the root.
	    if (target.equals(localRoot.data)) {
	      return localRoot.data;
	    } else {
		  return find(localRoot.next, target);
		}
	} 
}
