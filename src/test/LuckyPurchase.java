package test;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;



public class LuckyPurchase {

	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        String buyThis="";
	        int price=1000000000;
	        for(int a0 = 0; a0 < n; a0++){
	            String name = in.next();
	            int value = in.nextInt();
	            String valS= Integer.toString(value);
	            if(valS.contains("4") && valS.contains("7")) {
		            int fours=0;
		            int sevens=0;
	            		for(char c: valS.toCharArray()) {
		            		if (c==4){
		            			fours++;
		            		}
		            		if(c==7) {
		            			sevens++;
		            		}
		            	}
	            		if(fours==sevens) {
	            			if(value<price) {
		            			price=value;
		            			buyThis=name;
	            			}
	            		}
	            		else {
	            			buyThis="none";
	            		}
	            }
	            else {
        			buyThis="none";
        			}
	            
	            
	        }
	        if(buyThis=="none") {
            	System.out.println(-1);
            }
            else {
            	System.out.println(buyThis);
	        }
	        in.close();
	    }
}
