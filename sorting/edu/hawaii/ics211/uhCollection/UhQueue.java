package edu.hawaii.ics211.uhCollection;

/**
 * @author Blake Larson
 * @param <E>
 */
public class UhQueue<E> {
    
  /**Member variable reference for the head of the queue.
   */
  private SingleLinkedListNode<E> head = null;
  
  /**Memeber variable reference for the tail of the queue.
   */
  private SingleLinkedListNode<E> tail = null;
  
  /**Initial value of the number of the elements in the queue.
   */
  private int size = 0;

  /**
   * @author Blake Larson
   * @param <E> Single Linked List Nodes are of generic type.
   */
  private static final class SingleLinkedListNode<E> {
      
      /**The member variable reference to the node's value.
       */
    private E data;
    
    /**The member variable reference to the node's following neighbor node.
     */
    private SingleLinkedListNode<E> next;  
      
    /**constructor for a single linked list for tail nodes leading to null.
     * @param dataItem The object/value for the node.
     */
    private SingleLinkedListNode(final E dataItem) {
      data = dataItem;
      next = null;
    }
    
    /**Constructor for a single linked list for non-tail nodes.
     * @param dataItem What nodes value is.
     * @param nodeRef What the node after the one created is.
     */
    private SingleLinkedListNode(final E dataItem, 
            final SingleLinkedListNode<E> nodeRef) {
      data = dataItem;
      next = nodeRef;
      }
  }
  
  /**Creates an empty queue as a starting point.
   */
  public UhQueue() {
  }

  /**Allows the user to add an item to the tail end of the queue.
   * @param item The object/ value to add to the end of the queue.
   */
  public void enqueue(final E item) {
    if (item == null) {
      throw new IllegalArgumentException();
    }
    if (head == null) {
      tail = new SingleLinkedListNode<E>(item);  
      head = tail;
    } else {
      tail.next = new SingleLinkedListNode<E>(item);
      tail = tail.next;
    }
    size++;
  }

  /**Removes the head object and make the next one the new head.
   * @return null if no object exists at the head of the queue.
   */
  public E dequeue() {
    SingleLinkedListNode<E> temp = head;
    if (head != null) {
      head = head.next;
    }
    if (temp != null) {
      size--;
      return temp.data;
    } else {
      return null;
    }
  }

  /**Removes elements of a specific name from the queue.
   * @param item The specific object/ value to remove from the queue.
   * @return null for the value removed.
   */
  public E remove(final E item) {
    if (item == null) {
      throw new IllegalArgumentException();
    }
    for (int i = 0; i < size; i++) {
      if (item.equals(get(i))) {
        removeAfter(getNode(i));    
      }        
    }
    return null;
  }

  /** Returns the element at the head of the queue.
   * @return The front element of the queue.
   */
  public E head() {
    return head.data;
  }

  /**Returns the how many elements are in the queue.
   * @return Number of queue elements.
   */
  public int size() {
    return (this.size);
  }

  /**Returns true if the queue is empty and false if not.
   * @return Whether this.size method is true or not.
   */
  public boolean isEmpty() {
    return this.size <= 0;
  }
  
  /**Gets the Package information of the specific node.
   * @param index The specified node.
   * @return The package of the node.
   */
  public SingleLinkedListNode<E> getNode(final int index) {
    SingleLinkedListNode<E> node = head;
    for (int i = 0; i < index && node != null; i++) {
      node = node.next;
    }
    return node;
  }
  
  /**Returns the value of the specific indexed node.
   * @param index The specified node.
   * @return The value of node.
   */
  public E get(final int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(Integer.toString(index));
    }
    SingleLinkedListNode<E> node = getNode(index);
    return node.data;
  }
  
  
  /**Allows the user to remove a node at a specific position.
   * @param node The node before the one to be removed.
   * @return Either the data of the removed node or nothing.
   */
  public E removeAfter(final SingleLinkedListNode<E> node) {
    SingleLinkedListNode<E> temp = node.next;

    if (temp != null) {
        node.next = temp.next;
        size--;
        return temp.data;
      } else {
        node.next = tail;
        size--;
        return null;
      }
  }
}
