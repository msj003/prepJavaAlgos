package test;

public class TreeTest {
	
	
	
	static class Node{
		String data;
		Node left;
		Node right;
		
		Node(String d){
			this.data=d;
			this.left = null;
			this.right = null;
		}
	}
	
	public static void main(String[] args) {
		Node root=new Node("A");
		Node b = new Node("B");
		Node c= new Node("C");
		Node d= new Node("D");
		Node e= new Node ("E");
		
		root.left=b;
		root.right=c;
		b.left=d;
		b.right=e;
		
		System.out.print("Pre-Order : ");
		preOrder(root);
		System.out.println("");
		System.out.print("In-Order : ");
		inOrder(root);
		System.out.println("");
		System.out.print("Post-Order : ");
		postOrder(root);
		
	}
	
	public static void preOrder(Node node) {
		if(node==null) {
			return;
		}
		System.out.print(node.data);
		
		preOrder(node.left);
		
		preOrder(node.right);
		
	}
	
	public static void inOrder(Node node) {
		if(node==null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.data);
		inOrder(node.right);
	}

	public static void postOrder(Node node) {
		if(node==null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data);
		
	}
	
	
	
}
