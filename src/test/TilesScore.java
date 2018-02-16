package test;

/*
//@ Manjinder Singh   -   msj003@gmail.com 
*/

public class TilesScore {

	public static void main(String args[]) {
		int score=0; 
		int posx=0;
		int posy=1;
		int[][] tiles = new int[3][3];
		for(int i=0;i<3;i++) {
			for(int j = 0; j <3 ;j++) {
				tiles[i][j]=0;
			}
		}
		tiles[0][0]=1;		
		tiles[0][2]=1;
		tiles[1][1]=1;
		tiles[2][1]=1;
		System.out.println("POSITION IS  -----> "+posx+","+posy);
		System.out.println("TILES ARE ");
		System.out.println("-------------------");

		for(int i=0;i<3;i++) {
			for(int j = 0; j <3 ;j++) {
				System.out.print(tiles[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println();
		for(int i=0;i<3;i++) {
			for(int j = 0; j <3 ;j++) {
				if(tiles[i][j]==1 && i==posx) {
					score++;
				}
				if(tiles[i][j]==1 && j==posy) {
					score++;
				}
				if(tiles[i][j]==1 && i==posx && j == posy) {
					score--;
				}
				
			}
		}
		System.out.println("SCORE IS ------>   " + score);
		
	//	Score of all
		
		int score2=0;
		for(int x=0;x<3;x++) {
			
			posx=x;
			for(int y=0;y<3;y++) {
				posy=y;
				score2=0;
				for(int i=0;i<3;i++) {
					for(int j = 0; j <3 ;j++) {
						if(tiles[i][j]==1 && i==posx) {
							score2++;
						}
						if(tiles[i][j]==1 && j==posy) {
							score2++;
						}
						if(tiles[i][j]==1 && i==posx && j == posy) {
							score2--;
						}
					}
					
				}
				System.out.print(score2);
				
			}
			

		System.out.println();
		}
	}
}
