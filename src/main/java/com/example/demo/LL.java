package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class LL {

	private Node head;
	private Node tail;
	private int size;
	
	
	public void deleteFirst() {
		
		head=head.next;
	}
	
	public void deleteLast() {
		Node temp=head;
		while(temp.next.next!=null) {
			temp=temp.next;
		}
		temp.next=null;
	}
	
	public void deleteAtPos(int pos) {
		if(pos==0) {
			deleteFirst();
		}
		int size=getSize();
		if(pos==size-1) {
			deleteLast();
		}
		int counter=0;
		Node temp=head;
		while(temp.next!=null) {
		if(counter==pos-1) {
			temp.next=temp.next.next;
		}
		temp=temp.next;
		counter++;
		}
	}
	
	public void removeDuplicateSorted() {
		
		Node temp=head;
		while(temp.next!=null) {
			if(temp.getValue()==temp.next.getValue()) {
				temp.next=temp.next.next;
			}
			else {
				temp=temp.next;
			}
		}
		
	}
	
	public void insertAtFirst(int val) {
		Node node=new Node(val);
		node.next=head;
		head=node;
		if(tail==null) {
			tail=head;
		}
		size=size+1;
	}
	
	public void insertAtPos(int value,int pos) {
		Node node=new Node(value);
		if(pos==0) {
			insertAtFirst(value);
			return;
		}
		int size = getSize();
		if(pos==size-1) {
			insertAtLast(value);
			return;
		}
		Node temp=head;
		int counter=0;
		while(temp!=null) {
			if(counter==pos-1) {
				node.next=temp.next;
				temp.next=node;
			}
			temp=temp.next;
			counter++;
		}
	}
	
	public int getSize() {
		Node temp=head;
		int size=0;
		while(temp!=null) {
			temp=temp.next;
			size++;
		}
		return size;
	}

	public void display() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.getValue()+"->");
			temp=temp.next;
		}
		System.out.print("Null");
		System.out.println();
	}
	 public void insertAtLast(int val) {
		 if(head==null) {
			 insertAtFirst(val);
			 return;
		 }
		 Node temp=head;
		 Node node=new Node(val);
		 while(temp.next!=null) {
		 temp=temp.next;
		 
		 }
		 temp.next=node;
	 }
	 public void insertAtLastWithoutTail(int val) {
		 Node node=new Node(val);
		 Node temp=head;
		 if(head==null) {
			 insertAtFirst(val);
			 return;
		 }
		 while(temp.next!=null) {
			 temp=temp.next;
		 }
		 temp.next=node;
		 size++;
	 }
	
	class Node{
		private int value;
		private Node next;
		
		public Node(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public Node(int value, Node next) {
			super();
			this.value = value;
			this.next = next;
		}
		public Node() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
	}

	public void reverse() {
		Node prev=null;
		Node present=head;
		Node next=present.next;
		while(present!=null) {
			
			present.next=prev;
			prev=present;
			present=next;
			if(next!=null) {
				next=next.next;
			}
		}
		head=prev;
	}
	
	public LL merge2SortedList(LL list1,LL list2) {
		
		LL ansList=new LL();
		Node temp1=list1.head;
		Node temp2=list2.head;
		
		while(temp1!=null && temp2!=null) {
			if(temp1.getValue()<temp2.getValue()) {
				ansList.insertAtLastWithoutTail(temp1.getValue());
				temp1=temp1.next;
			}else {
				ansList.insertAtLastWithoutTail(temp2.getValue());
				temp2=temp2.next;
			}
		}
		while(temp1!=null) {
			ansList.insertAtLastWithoutTail(temp1.getValue());
			temp1=temp1.next;
		}
		while(temp2!=null) {
			ansList.insertAtLastWithoutTail(temp2.getValue());
			temp2=temp2.next;
		}
		return ansList;
	}
	
	public void display(LL listSort) {
		Node temp=listSort.head;
		while(temp!=null) {
			System.out.print(temp.getValue()+"->");
			temp=temp.next;
		}
		System.out.print("Null");
		System.out.println();
		
	}

	public void displayCircular(LL list) {
		Node temp=list.head;
		while(temp.next!=null) {
			System.out.print(temp.getValue()+"->");
			temp=temp.next;
		}
		temp.next=head.next;
		System.out.println();
		
	}
	
	public void isPallindrome() {
		
		Node temp=head;
		while(temp.next!=null) {
			
		}
	}
	
	public boolean isCycle(LL list) {
		
		Node slow=head;
		Node fast=head;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(fast==slow) {
				return true;
			}
		}
		return false;
	}
	
	public int cycleLength(LL list) {
		Node slow=head;
		Node fast=head;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(fast==slow) {
				int length=0;
				Node temp=slow;
				do {
					temp=temp.next;
					length++;
				}while(temp!=slow);
				return length;
			}
		}
		return 0;
		
	}
	
	public Node startNode(LL list) {
		Node slow=head;
		Node fast=head;
		int length=0;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(fast==slow) {
				length=cycleLength(list);
				break;
			}
		}
		if(length==0) {
			return null;
		}
		Node s=head;
		Node f=head;
		while(length>0) {
			s=s.next;
			length--;
		}
		while(s!=f) {
			slow=slow.next;
			fast=fast.next;
		}
		
		return s;
	}
}
