package eg.edu.alexu.csd.datastructure.linkedList.cs34_cs40;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SinglyLinkedList implements ILinkedList {
	
	public class SNode {
		
		// Creating a SinglyNode
		
		private Object value;
		private SNode next;
		
		public SNode (Object v, SNode n) {
			value= v;
			next = n;
		}
		public Object getValue() {
			return value;
		}
		public SNode getNext() {
			return next;
		}
		public void setValue(Object v) {
			value= v;
		}
		public void setNext(SNode n) {
			next = n;
		}
	}
	
	private int size;
	private SNode head;
	
	public SinglyLinkedList() {
		size=0;
		head= new SNode (null,null);
	}
	
	@Override
	public void add(int index, Object element) {
		SNode insert =  new SNode (element, null);
		SNode current=head;
		if(size==0) {
			head=insert;
			size++;
		}
		else if((index<size)&&(index>=0)) {
			for (int i=0 ; i< index-1; i++) {
				current=current.getNext();
			}
			if(index==0) {
				insert.setNext(head);
				head=insert;
				size++;
			}else {
				insert.setNext(current.getNext());
				current.setNext(insert);
				size++;
			}
		}
		else if (index==size) {
			while(current.getNext()!=null) {
				current=current.getNext();
			}
			current.setNext(insert);
			size++;
		}
	}

	@Override
	public void add(Object element) {
		SNode insert = new SNode (element, null);
		SNode current=head;
		if(size==0) {
			head=insert;
			size++;
		}
		else {
			while(current.getNext()!= null) {
				current=current.getNext();
			}
			current.setNext(insert);
			size++;
		}
	}

	@Override
	public Object get(int index) {
		if((size==0) || (index >= size) || (index<0)) {
			return null;
		}
		else {
			SNode current =  head;
			for(int i=0; i<index ; i++) {
				current=current.getNext();
			}
			return current.getValue();
		}
	}

	@Override
	public void set(int index, Object element) {
		SNode current=head;
		if(index==0 && size==0) {
			head.setValue(element);
			size++;
		}
		else if(index==0) {
			head.setValue(element);
		}
		else if((index<size)&&(index>=0) && size != 0) {
			for (int i=0 ; i< index; i++) {
				current=current.getNext();
			}
			current.setValue(element);
		}
	}

	@Override
	public void clear() {
		SNode current=head;
		if(size>0) {
			for(int i=0; i<size; i++) {
				current.setValue(null);
				current=current.getNext();
			}
			head.setValue(null);
			head.setNext(null);
			size=0;
		}
	}

	@Override
	public boolean isEmpty() {
		if(size==0){
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void remove(int index) {
		SNode current=head;
		if(index==0 && size!=0) {
			head=head.getNext();
			size--;
		}
		else if((index<size)&&(index>=0)) {
			for (int i=0 ; i< index-1; i++) {
				current=current.getNext();
			}
			SNode remove = current.getNext();
			current.setNext(remove.getNext());
			remove.setNext(null);
			remove=null;
			size--;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		if((fromIndex<size) &&(toIndex<size) && (fromIndex>=0) && (toIndex >=0)&& (size !=0) && (toIndex >= fromIndex)) {
			SinglyLinkedList subList = new SinglyLinkedList();
			SNode first = head;
			int point=0;
			for(int i=0; i<fromIndex;) {
				first=first.getNext();
				i++;
				point=i;
			}
			SNode last= new SNode(first.getValue(),null);
			subList.head=last;
			subList.size++;
			while(point<toIndex) {
				first=first.getNext();
				subList.add(first.getValue());
				point++;
			}
			subList.size=toIndex - fromIndex +1;
			return subList;
		}
		else {
			return null;
		}
	}

	@Override
	public boolean contains(Object o) {
		if(size != 0) {
			SNode current = head;
			while((current.getValue() != o) && (current.getNext() != null)) {
				current=current.getNext();
			}
			if(current.getValue() == o) {
				return true;
			}
			else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	@Test
	public void test1() {
		SinglyLinkedList test = new SinglyLinkedList(); 
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		
		test.set(5,'x');
		Object i= test.get(5);
		
		assertEquals('x', i);
	}
	
	@Test
	public void test2() {
		SinglyLinkedList test = new SinglyLinkedList(); 
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		
		int i = test.size();
		
		assertEquals(10, i);
	}

	@Test
	public void test3() {
		SinglyLinkedList test = new SinglyLinkedList(); 
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		
		test.set(0,'x');
		Object i= test.get(0);
		
		assertEquals('x', i);
	}
	
	@Test
	public void test4() {
		SinglyLinkedList test = new SinglyLinkedList(); 
		
		test.set(0, 'x');
		Object i= test.get(0);
		
		assertEquals('x', i);
	}
	
	@Test
	public void test5() {
		SinglyLinkedList test = new SinglyLinkedList(); 
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		
		test.remove(9);
		Object i= test.get(9);
		
		assertEquals(null, i);

	}
	
	@Test
	public void test6() {
		SinglyLinkedList test = new SinglyLinkedList(); 
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		
		test.remove(5);
		Object i= test.get(5);
		
		assertEquals(6, i);

	}
	
	@Test
	public void test7() {
		SinglyLinkedList test = new SinglyLinkedList(); 
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		
		test.remove(0);
		Object i= test.get(0);
		
		assertEquals(1, i);

	}
	
	@Test
	public void test8() {
		SinglyLinkedList test = new SinglyLinkedList(); 
		
		boolean i = test.isEmpty();
		
		assertEquals(true, i);
	}
	
	@Test
	public void test9() {
		SinglyLinkedList test = new SinglyLinkedList(); 
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		
		boolean i = test.isEmpty();
		
		assertEquals(false, i);
	}
	
	@Test
	public void test10() {
		SinglyLinkedList test = new SinglyLinkedList(); 
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		
		Object i= test.get(5);
		
		assertEquals(5, i);

	}
	
	@Test
	public void test11() {
		SinglyLinkedList test = new SinglyLinkedList(); 
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		
		Object i= test.get(15);
		
		assertEquals(null, i);

	}
	
	@Test
	public void test12() {
		SinglyLinkedList test = new SinglyLinkedList(); 
		
		Object i= test.get(0);
		
		assertEquals(null, i);
		
	}
	
	@Test
	public void test13() {
		SinglyLinkedList test = new SinglyLinkedList(); 
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add('x');
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		
		boolean i = test.contains('x');
		
		assertEquals(true, i);
	}
	
	@Test
	public void test14() {
		SinglyLinkedList test = new SinglyLinkedList(); 
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		
		boolean i = test.contains('x');
		
		assertEquals(false, i);
	}
	
	@Test
	public void test15() {
		SinglyLinkedList test = new SinglyLinkedList(); 
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		
		test.clear();
		boolean i = test.isEmpty();
		
		assertEquals(true, i);
	}
	
	@Test
	public void test16() {
		SinglyLinkedList test = new SinglyLinkedList(); 
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		
		test.add(10,'x');
		
		Object i= test.get(10);
		assertEquals('x', i);
	}
	
	@Test
	public void test17() {
		SinglyLinkedList test = new SinglyLinkedList(); 
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		
		test.add(0,'x');
		
		Object i= test.get(0);
		assertEquals('x', i);
	}
	
	@Test
	public void test18() {
		SinglyLinkedList test = new SinglyLinkedList(); 
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		
		test.add(5,'x');
		
		Object i= test.get(5);
		assertEquals('x', i);
	}
	
	@Test
	public void test19() {
		SinglyLinkedList test = new SinglyLinkedList(); 
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		
		int i = test.size();
		
		assertEquals(5, i);
	}
	
	@Test
	public void test20() {
		SinglyLinkedList test = new SinglyLinkedList(); 
		
		int i = test.size();
		
		assertEquals(0, i);
	}
	
	@Test
	public void test21() {
		SinglyLinkedList test = new SinglyLinkedList(); 
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		
		ILinkedList sublist;
		
		sublist= test.sublist(3, 7);
		
		assertEquals(5, sublist.size());
		assertEquals(3, sublist.get(0));
		assertEquals(4, sublist.get(1));
		assertEquals(5, sublist.get(2));
		assertEquals(6, sublist.get(3));
		assertEquals(7, sublist.get(4));
		
	}
	
	@Test
	public void test22() {
		SinglyLinkedList test = new SinglyLinkedList(); 
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		
		ILinkedList sublist;
		
		sublist= test.sublist(0, 10);
		
		assertEquals(null, sublist);
	}
	
	@Test
	public void test23() {
		SinglyLinkedList test = new SinglyLinkedList(); 
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		
		ILinkedList sublist;
		
		sublist= test.sublist(5, 5);
		
		assertEquals(1, sublist.size());
		assertEquals(5, sublist.get(0));
	}
}
