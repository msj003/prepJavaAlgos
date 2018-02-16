package test;

import java.util.Scanner;

public class ProteinMutation {
	
	public static int getId(char a) {
		//char proteinsArray[]= {'A','B','C','D'};
		if(a=='A') {
			return 0;
		}else if(a=='B') return 1;
		else if(a=='C') return 2;
		else if(a=='D') return 3;
		else return 0;
		
				
	}
	
	public static void main(String args[]) {
		
//		char proteinsArray[]= {'A','B','C','D'};
		char mutations[][] = new char[4][4];
		mutations[0][0]='A';mutations[0][1]='B';mutations[0][2]='C';mutations[0][3]='D';
		mutations[1][0]='B';mutations[1][1]='A';mutations[1][2]='D';mutations[1][3]='C';
		mutations[2][0]='C';mutations[2][1]='D';mutations[2][2]='A';mutations[2][3]='B';
		mutations[3][0]='D';mutations[3][1]='C';mutations[3][2]='B';mutations[3][3]='A';
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        char[] a = new char[n];
        char[] b = new char[n];
        b=a;
        a=in.next().toCharArray();
		//mutation starts here
        int count = 0;
        int id=0;
        int idP = 0;
        for(int m=0; m<d ; m++) {
	        	char pres=a[0];
	        for(int k = 0; k<n;k++) {
	        		id=getId(a[k]);
					if(k+1<n) {
					idP=getId(a[k+1]);
					}else if(k+1 == n) {
						idP=getId(pres);
					}
				a[k]=mutations[id][idP];
	        }
	        if(b==a) {
	        	count++;
	        	System.out.println(count);
	        }
        }
        System.out.println(a);
        in.close();
		}
}
