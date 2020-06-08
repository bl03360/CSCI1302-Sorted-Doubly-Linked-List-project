
package cs1302.projects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Brandon Lewis
 *
 */
public class SortedDblList<T extends Comparable<T>> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int size;
	private transient Node<T> head;
	private transient Node<T> tail;
	
	/**
	 * This method is the default constructor
	 */
	public SortedDblList() {
		setSize(0);
		setHead(null);
		setTail(null);
	}
	
	public SortedDblList(Node<T> head, Node<T> tail, int size) {
		this.head = head;
		this.tail = tail;
		this.size = size;
	}
	
	/**
	 * This method returns the element at the specified position in this list.
	 * @param index -  index of element to return
	 * @return the element at the specified position in this list.
	 * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index>= size()).
	 */
	public T get(int index) throws IndexOutOfBoundsException {
		if (!(getHead().equals(null))) {
			int i = 0;
			Node<T> head = getHead();
			while(head != null) {
				if(index == i) {
					return head.getData();
				}
				head = head.getNext();
				i++;
			}
		}
		return null;
	}
	
	/**
	 * The method will take an instance of the type variable T as the parameter,
	 * and it will insert it at the correct place within the list using element's 
	 * method. This method should not allow null elements or duplicates be added
	 * to the list. The method returns true if successful and false otherwise. 
	 * Therefore, the method does NOT throw exceptions in case the argument is 
	 * null or the element already exists in the list.
	 * @param element - data to be added to the list
	 * @return true if added successfully, false otherwise
	 */
	public boolean add(T element) {
		
		Node n = new Node(element);
		
		if(isEmpty()) {
			setHead(n);
		    setTail(n);
			head.setNext(null);
			tail.setPrev(null);
		    size++;
			return true;
		}//list is empty
		
		else if(!(isEmpty())) {
			
			Node<T> head = getHead();
			Node<T> tail = getTail();
			
			if(head.getData().compareTo(element) == 1) {
				while(head != null && tail != null) {
					if(head.getNext() == null) {
						head.setNext(n);
						n.setPrev(head);
						setTail(n);
						size++;
						return true;
					}//one element in list
					else if(tail.getData().compareTo(element) == -1 && head.getNext() == tail) {
						n.setNext(tail);
						n.setPrev(head);
						tail.setPrev(n);
						head.setNext(n);
						size++;
						return true;
					}//two elements in list and adding between head and tail
					else if(tail.getData().compareTo(element) == 1) {
						n.setPrev(tail);
						tail.setNext(n);
						setTail(n);
						size++;
						return true;
					}
					head = head.getNext();
					tail = tail.getPrev();
					if(head.getData().compareTo(element) == 1 && tail.getData().compareTo(element) == -1) {
						head.setNext(n);
						n.setPrev(head);
						tail.setPrev(n);
						n.setNext(tail);
						size++;
						return true;
					}
				}
			}
			else if(head.getData().compareTo(element) == -1) {
					head.setPrev(n);
					n.setNext(head);
					setHead(n);
					size++;
					return true;
			}//id of element is less than head
			
			else
				return false;
		}
		return false;
	}
	/**
	 * This method removes the first item with its id matching the ID value 
	 * of the parameter, and returns true if this list contained the 
	 * specified element. This method should return false if the item 
	 * is not found! REMEMBER: Use the method to find the item to remove! 
	 * You implementation of equals should use the method. If this list 
	 * does not contain the element, it is unchanged. More formally, 
	 * the method removes the element with the lowest index i such that get(i).equals(o) == true.
	 * @param o - the object to be removed
	 * @return true if removed successfully, false otherwise
	 */
	public boolean remove(Object o) {
		if(!isEmpty()) {
			if(get(getSize()-1).equals(o) && get(0).equals(o)) {
				setHead(null);
				setTail(null);
				size--;
				return true;
			}
			else if(get(0).equals(o)) {
				setHead(head.getNext());
				head.setPrev(null);
				size--;
				return true;
			}
			else if(get(getSize()-1).equals(o)) {
				setTail(tail.getPrev());
				tail.setNext(null);
				size--;
				return true;
			}
			Node<T> head = getHead();
			Node<T> temp = getHead();
			for (int i = 0;i < getSize(); i++) {
				while(head != null) {
					temp = temp.getNext();
					if(get(i).equals(o)) {
						temp.setPrev(head.getPrev());
						(head.getPrev()).setNext(temp);
						size--;
						return true;
					}
					i++;
					head = head.getNext();
				}
			}

		}
		return false;
	}
	
	/**
	 * This method returns whether or not the list is empty (true or false)
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}	
	
	/**
	 * This method returns a new SortedDblList that is the union of the 
	 * current list and "otherList" while maintaining sortedness.
	 * @param otherList -  the other list to be unioned with
	 * @return a sorted doubly linked list
	 */
	public SortedDblList<T> union(SortedDblList<? extends T> otherList) {
		SortedDblList newList = new SortedDblList();
		
		Node<T> a = getHead();
		Node<T> b = (Node<T>) otherList.getHead();
		
		while(a != null) {
			newList.add(a.getData());
			a = a.getNext();
		}
		
		while(b != null) {
			newList.add(b.getData());
			b = b.getNext();
		}
		
		return newList;
	}
	
	/**
	 * this method returns a new SortedDblList that is the intersection
	 * of the current list and "otherList" while maintaining sortedness.
	 * @param otherList - the other list to get intersection with
	 * @return a sorted doubly linked list	
	 */
	public SortedDblList<T> intersection(SortedDblList<? extends T> otherList) {
		SortedDblList newList = new SortedDblList(); 

		Node<T> a = getHead();
		Node<T> b = (Node<T>) otherList.getHead();
		
		while(a != null) {
			newList.add(a.getData());
			a = a.getNext();
		}
		
		while(a != null) {
			while(b != null) {
				if(b.getData().compareTo(a.getData()) == -1 || b.getData().compareTo(a.getData()) == 1) {
					newList.remove(a.getData());
				}
				b = b.getNext();
			}
			a = a.getNext();
		}
		
		
		return newList;
		
	}
	/**
	 * This method will print all elements of the list to the screen; one element 
	 * per line. That is, for each element of the list it should call the
	 * method of the element, and then append a newline character to the result, 
	 * and print the result to the screen. As an example, a list of two 
	 * Integers 3 and 4 should be printed to the screen as follows: 
	 * 3
	 * 4
	 */
	public void printList() {
		try {
			if(isEmpty()) {
				System.out.println("List is empty add elements");
			}
			Node<T> head = getHead();
			int i = 1;
			while (head != null) {
				System.out.println(i + " " + (head.getData()).toString());
				head = head.getNext();
				i++;
			}
		}
		catch (NullPointerException e) {
			System.out.println("Sorry the list is empty.");
		}
	}
	
	
	/**
	 * This method returns the index in this list of the first occurrence of 
	 * the specified element, or -1 if this list does not contain this element.
	 * @param o - the object that its index must be found
	 * @return the index of the object, -1 otherwise
	 */
	public int indexOf(Object o) {
		for(int i = 0;i < getSize(); i++) {
			if(get(i).equals(o)) {
				return i;
			}
			else if(!get(i).equals(o)) {
				return -1;
			}
		}
		return -1;
	}
	
	
	/**
	 * This method writes the value of size and then each element (but not nodes!) of the list to the given stream.
	 * @param fileName -  file name that will be created to store items
	 */
	public void saveListObjects(String fileName) { 		
		try {
			SortedDblList newList = new SortedDblList(); 
			
			
			
			while(head != null) {
				newList.add(head.getData());
				head = head.getNext();
			}
			File file = new File(fileName);
			FileOutputStream f = new FileOutputStream(fileName);
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(newList);
			o.write(getSize());
			newList.printList();
			System.out.println("Size: " + newList.getSize());
			System.out.println("The above object has been serialized...");
			System.out.println();
			o.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	
	/**
	 * This method reads the value of size and then each element of the list from the given stream and add them to the list.
	 * @param fileName - name of the input file that will be read to fetch items
	 */
	public void loadListObjects(String fileName) {
		File file = new File(fileName);
		try {
			FileInputStream f = new FileInputStream(fileName);
			ObjectInputStream o = new ObjectInputStream(f);
			SortedDblList k = (SortedDblList) o.readObject();
			System.out.println("Deserialization of object...");
			k.printList();
			System.out.println("Size: " + k.getSize());
			o.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException h) {
			h.printStackTrace();
		}
		catch(ClassCastException i) {
			i.printStackTrace();
		}
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the head
	 */
	public Node<T> getHead() {
		return head;
	}

	/**
	 * @param head the head to set
	 */
	public void setHead(Node<T> head) {
		this.head = head;
	}

	/**
	 * @return the tail
	 */
	public Node<T> getTail() {
		return tail;
	}

	/**
	 * @param tail the tail to set
	 */
	public void setTail(Node<T> tail) {
		this.tail = tail;
	}

}
