package test;

public class StackTest {
 
	private static final int MAX = 100;
	int stackArray[] = new int[MAX];
	int top;
	
	public StackTest(){
		top = -1;
	}
	
	public void push(int a) {
		if(top+1<MAX) {
			stackArray[++top]=a;
		}
	}
	
	public int pop() {
		return stackArray[top--];
	}
	
	public void display() {
		for(int i=0;i<=top;i++) {
			System.out.print(stackArray[i]+" ");
		}
	}
	
	public static void main(String args[]) {
		
		StackTest sT = new StackTest();
		sT.push(4);
		sT.push(5);
		sT.push(6);
		sT.display();
		sT.pop();
		System.out.println(" ");
		sT.display();
		sT.push(666);
		System.out.println(" ");
		sT.display();
		
		
	}
	
}
