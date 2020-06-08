/**
 * 
 */
package cs1302.projects;

/**
 * @author mehdi
 *
 */
public class Node<T> {
	
	private T data;
	private Node<T> prev;
	private Node<T> next;
	
	
	public Node(T data) {
		this.data = data;
		prev = null;
		next = null;
	}
	
	
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}


	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}


	/**
	 * @return the prev
	 */
	public Node<T> getPrev() {
		return prev;
	}


	/**
	 * @param prev the prev to set
	 */
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}


	/**
	 * @return the next
	 */
	public Node<T> getNext() {
		return next;
	}


	/**
	 * @param next the next to set
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	

}
