package test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class CostBalancing {

	/*Anita and her friends, go on a trip. Now, they are back home and need to balance their expenses. During the trip, they perform many transactions but don't divide the expenses equally all the time. The total expenses should be balanced in such a way that everyone pays an equal amount. Given the information about the transactions, Anita needs to find who owes others and who should get money.

Anita has an ID number of  and her friends are represented by IDs from  to .

There will be  transactions, each consisting of a person's ID and the amount of money that he/she paid. Note that, the required payment for all might be fractional. To avoid this situation, Anita has decided to pay some extra money (if needed) so that everybody has to pay a whole amount after that.

For example, if an amount of  units is split across  people(Anita, Bret and Cathy) each has a share of 33.33 per person. To make the amount a whole number Anita decides to pay  extra unit, thus making her share to be . And for Bret and Cathy, the share becomes  each.

Input Format

The first line contains two space-separated integers  and , denoting total number of transactions and total number of friends in the group.

Each of the next  lines contains two space-separated integers, first one is the ID of the friend and second one denotes the amount paid.

Constraints



ID numbers will be all the numbers from 1 to .
Output Format

For each ID from  to  print a line with two space separated integers, first one is the ID of the friend and second one is the amount that the person owes or gets.

Note that, a positive amount next to an ID indicates that the person should receive that amount, while a negative amount indicates that he/she owes that amount to the rest of the group.

Sample Input 0

7 5
1 200
2 200
3 100
4 10
5 54
5 54
3 100
Sample Output 0

1 54
2 57
3 57
4 -133
5 -35
Explanation 0

Total spending of each friend is:-

ID	Amount
1	200
2	200
3	200
4	10
5	108
Sum of Transactions = 200 + 200 + 200 + 10 + 108 = 718

The equity would be = 

Everbody will pay a whole part, so everybody will have to pay  and the total payment would be = . Anita will pay the extra amount of  to balance the cost.

Required payment for everybody,

Anita = 143 + 3 = 146

Rest of all = 143

Finally(shown in required output order):

ID	Amount	Final Amount
1	200 - 146	54
2	200 - 143	57
3	200 - 143	57
4	10 - 143	-133
5	108 -143	-35
*/
	
	
	
public static void main(String args[]) {
	
	Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
     HashMap<Integer, Integer> spendMap = new HashMap<Integer,Integer>();
    int total = 0;
 	for(int a0 = 1; a0 <= m; a0++){
        spendMap.put(a0, 0);
    }
    for(int a0 = 0; a0 < n; a0++){
        int id_number = in.nextInt();
        int amount = in.nextInt();
        spendMap.replace(id_number,spendMap.get(id_number)+amount );
        total+=amount;
    }
    HashMap<Integer,Integer> shareMap = new HashMap<Integer, Integer>();
    int equity = total/m;
    for(int a0 = 1; a0 <= m; a0++){
    	        shareMap.put(a0, spendMap.get(a0)-equity);
    	    }
    	 int equityAnita = equity+(total-(equity*m));
    	 shareMap.put(1,spendMap.get(1)-equityAnita);
    	 for(Integer sh : shareMap.keySet() ) {
    		 System.out.println(sh+" "+shareMap.get(sh));
    	 }
   in.close();    
}
}
