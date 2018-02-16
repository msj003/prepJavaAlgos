package test;

/*
//@ Manjinder Singh   -   msj003@gmail.com 
*/
public class LinkedList {

	Node head;
	 static Node end;
	
	static class Node{
	
		int data;
		Node next;
		
		Node(int d){
			this.data=d;
			this.next = null;
		}
		
		public String toString() {
			String s = new String();
			s=data+"";
			return s;
		}
		
	}
	
	public String toString() {
		String s = new String();
		Node n = head;
		
		
		while(n != null) {
		
		//s+=n.toString();
			//System.out.println(n.toString());
			s=s+" "+n.toString();
			n=n.next;
		}
		return s;
	}
	public void append(int data) {
		Node appendNode = new Node(data);
		Node n = head;
		while(n.next != null) {
			//System.out.println(n.toString());
			//s+=n.toString();
			n=n.next;
			//last=n;	
				
			}
		n.next=appendNode;
		
	}
	
	public void deleteAt(int pos) {
		Node temp;
		temp=head;
		for(int i=0; temp!=null && i < pos-1; i++) {
			temp=temp.next;
		}
		Node next=temp.next.next;
		temp.next=next;
	}
	public static void main(String args[]) {
		LinkedList list1=new LinkedList();
		list1.head= new Node(1);
		Node secondNode= new Node(2);
		list1.head.next=secondNode;
		Node thirdNode= new Node(3);
		Node forthNode= new Node(4);
		secondNode.next=thirdNode;
		thirdNode.next=forthNode;
		//forthNode.next=end;
		list1.append(5);
		list1.append(6);
		list1.deleteAt(3);   // delete node
		System.out.println(list1.toString());

		//System.out.println(forthNode.next);
	}
	
}
