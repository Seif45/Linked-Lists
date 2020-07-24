package eg.edu.alexu.csd.datastructure.linkedList.cs34_cs40;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DoublyLinkedList implements ILinkedList {
	
	public class DNode {
		
		//Creating a DoublyNode
		
		private Object value;
		private DNode next,prev;
		
		public DNode(Object v , DNode n , DNode p) {
			value = v;
			next = n;
			prev = p;
		}
		
		public Object getValue() {
			return value;
		}
			
		public DNode getNext() {
			return next;
		}
			
		public DNode getPrev() {
			return prev;
		}
			
		public void setValue(Object v) {
			value = v ;
		}
			
		public void setNext(DNode n) {
			next = n ;
		}
			
		public void setPrev(DNode p) {
			prev = p ;
		}
	}
	
	// Creating a DoublyLinkedList using previously created DNode
	
	private int size;
	private DNode header,trailer;
	
	public DoublyLinkedList() {
		size = 0;
		header = new DNode(null,null,null);
		trailer = new DNode(null,null,header);
		header.setNext(trailer);
	}
	
	@Override
	public void add(int index, Object element) {
		if ((index <= size)&&(index >= 0)) {
			DNode insert = new DNode(element , null , null);
			DNode current = header;
			for (int i = 0 ; i < index ; i ++) {
				current = current.getNext();
			}
			insert.setNext(current.getNext());
			current.getNext().setPrev(insert);
			insert.setPrev(current);
			current.setNext(insert);
			size++;
		}
	}

	@Override
	public void add(Object element) {
		DNode insert = new DNode (element,trailer,trailer.getPrev());
		trailer.getPrev().setNext(insert);
		trailer.setPrev(insert);
		size++;
	}

	@Override
	public Object get(int index) {
		if ( (index >= size) || (index < 0) || (size == 0) ) {
			return null;
		}
		else {
			DNode current = header.getNext();
			for (int i = 0 ; i < index ; i ++) {
				current = current.getNext();
			}
			return current.getValue();
		}
	}

	@Override
	public void set(int index, Object element) {
		if ((index < size) && (index >= 0) && (size != 0)) {
			DNode current = header.getNext();
			for (int i = 0 ; i < index ; i ++) {
				current = current.getNext();
			}
			current.setValue(element);
		}
	}

	@Override
	public void clear() {
		if (size > 0) {
			header.getNext().setPrev(null);
			header.setNext(trailer);
			trailer.getPrev().setNext(null);
			trailer.setPrev(header);
			size = 0;
		}
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void remove(int index) {
		if ((index < size) && (index >= 0) && (size != 0)) {
			DNode current = header;
			for (int i = 0 ; i < index ; i++) {
				current = current.getNext();
			}
			DNode remove = current.getNext();
			remove.getNext().setPrev(current);
			current.setNext(remove.getNext());
			remove.setNext(null);
			remove.setPrev(null);
			size--;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		if ((fromIndex < size) && (toIndex < size) && (fromIndex >=0) && (toIndex >=0) && (size != 0) && (toIndex >= fromIndex)) {
			DoublyLinkedList subList = new DoublyLinkedList();
			DNode current = header;
			for (int i = 0 ; i <= toIndex ; i++) {
				current = current.getNext();
				if (i == fromIndex) {
					DNode first = current;
					subList.header.setNext(first);
					first.setPrev(subList.header);
				}
			}
			DNode last = new DNode (current.getValue(),null,null);
			subList.trailer.setPrev(last);
			last.setNext(subList.trailer);
			subList.size = toIndex - fromIndex + 1;
			return subList;
		}
		else {
			return null;
		}
	}

	@Override
	public boolean contains(Object o) {
		if (size != 0) {
			DNode current = header.getNext() ;
			while ((current.getValue() != o) && (current.getNext() != trailer)) {
				current = current.getNext();
			}
			if (current.getValue() == o) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	@Test
	public void test1() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.add(0);
		list.add(1);
		list.add(2);
		assertEquals(0,list.get(0));
		assertEquals(1,list.get(1));
		assertEquals(2,list.get(2));
		assertEquals(null,list.get(3));
		assertEquals(null, list.get(-1));
	}
	
	@Test
	public void test2() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(2, 4);
		assertEquals(4, list.get(2));
		assertEquals(3, list.get(4));
		assertEquals(null, list.get(5));
	}
	
	@Test
	public void test3() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4, 4);	
		list.add(5);
	
		assertTrue(list.contains(4));
		assertFalse(list.contains(6));
	}
	
	@Test
	public void test4() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4, 4);	
		list.add(5);
		
		list.clear();
		
		assertEquals(0,list.size());
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void test5() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4, 4);	
		list.add(5);
		
		list.remove(3);
		
		assertEquals(5,list.size());
		assertEquals(4,list.get(3));
		assertNotEquals(3, list.get(3));
	}
	
	@Test
	public void test6() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.set(2, 8);
		assertEquals(8,list.get(2));
	}
	
	@Test
	public void test7() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4, 4);	
		list.add(5);
		ILinkedList subList;
		subList = list.sublist(1, 4);
		assertEquals(4 , subList.size());
		
		assertEquals(1 , subList.get(0));
		assertEquals(2 , subList.get(1));
		assertEquals(3 , subList.get(2));
		assertEquals(4 , subList.get(3));
	}

	@Test
	public void test8() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.add(1);
		list.add(2);
		ILinkedList sub = list.sublist(1, 1);
		assertEquals(2,sub.get(0));
	}
}
