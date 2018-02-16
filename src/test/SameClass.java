package test;

public class SameClass {
	private Integer a;
	private Integer b[];
	public SameClass(Integer a) {
		this.a=a;
	}
	public SameClass(Integer a, Integer b[]) {
		this.a=a;
		this.b=b;
	}
	public static void main(String args[]) {
		Integer a = new Integer(5);
		Integer b[] = {2,5};
	//	Integer c[] = {99,100};
		
		// create two different objects
		SameClass sam = new SameClass(a);
		SameClass samB = new SameClass(a,b);
		//change values in local variables
		a=7;
		b[0]= 8;
		//b=c;
	
		//print values 
		System.out.println(sam.a);
		System.out.println(samB.b[0] + " " + samB.a);
	}
}
