package edu.hawaii.ics211.uhCollection;

/**
 * @author Blake Larson
 * @param <E> Class is generic type.
 */
public class UhStack<E> {
    
  /**The member variable for the stack generic array.
   */
  private E[] stack;
  
  /**The member variable w/value for last item in the stack.
   */
  int topOfStack = -1;
  
  /**The member variable w/ initial value for number of objects in the stack.
   */
  private int elements = 0;
  
  /**The member variable for the how large the stack is.
   */
  private int capacity;

  /**Constructor to create a stack of a given size parameter.
   * @param size The size desired for the stack.
   */
  @SuppressWarnings("unchecked")
  public UhStack(final int size) {
    if (size < 1) {
      throw new IllegalArgumentException();
    }
    stack = (E[]) new Object[size];
    capacity = size;
  }

  /**Reports the maximum capacity of the stack.
   * @return The capacity.
   */
  public int length() {
    return capacity;
  }

  /**Adds an item to the top of the stack.
   * @param item The value for the item to add to the stack.
   * @return The value of the item added.
   */
  public E push(final E item) {
    if (isFull()) {
      throw new IndexOutOfBoundsException();
    }

    if (item == null) {
      throw new IllegalArgumentException();
    }
    topOfStack++;
    elements++;
    stack[topOfStack] = item;
    return item;
  }

  /**Removes the top element of the stack.
   * @return The value of the item.
   */
  public E pop() {
    if (!isEmpty()) {
      elements--;
      return stack[topOfStack--];
    } else {
      return null;
    }
  }

  /**Returns the top element of the stack.
   * @return The value of the element.
   */
  public E top() {
    if (isEmpty()) {
      return null;
    } else {
      return stack[topOfStack];
    }
  }

  /**Return the number of elements in the stack.
   * @return number of elements currently.
   */
  public int size() { // How many elements in the stack
    return (elements);
  }

  /**Return true if the stack is empty or not.
   * @return True or False if empty.
   */
  public boolean isEmpty() {
    return size() == 0;
  }

  /**Return true if the stack is full or not.
   * @return True or False if full.
   */
  public boolean isFull() {
    return (stack.length - 1) == topOfStack;
  }
}
