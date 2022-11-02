import java.awt.*;
public class Map {
		public int map[][];
		public static int eggWidth;
		public static int eggHeight;
		int y=50;
		int blx=90,bly=70;
		boolean gol;
		int eggremaining=0,i,j;
		public Map (int row, int col)
		{
			map = new int[row][col];		
			for(int i = 0; i<map.length; i++)
			{
				for(int j =0; j<map[0].length; j++)
				{
					int r=(int)(Math.random()*7+1);
					map[i][j] = 1;
					map[i][j] = r;
				}			
			}
			map[i][j]=4;
			map[i][j]=14;
			eggWidth = 600/col;
			eggHeight = 290/row;
			}
		
		public void draw(Graphics2D g)
		{
			for(int i = 0; i<map.length; i++)
			{
				for(int j =0; j<map[0].length; j++)
				{
				
					if(map[i][j] > 0)
					{
						if(map[i][j]==1) {
							g.setColor(new Color(255,102,102));
						}
						if(map[i][j]==2) {
							g.setColor(new Color(255,204,0));
						}
						if(map[i][j]==3) {
							g.setColor(new Color(255,0,0));
						}
						if(map[i][j]==4) {
							g.setColor(new Color(0,204,0));
						}
						if(map[i][j]==5) {
							g.setColor(new Color(255,204,0));
						}
						if(map[i][j]==6) {
							g.setColor(new Color(153,153,153));
						}
						if(map[i][j]==7) {
							g.setColor(new Color(153, 0 , 0));
						}
					
				
						g.fillOval(j * eggWidth + 50, i * eggHeight + 10, eggWidth, eggHeight);
				      	
						// this is just to show separate brick, game can still run without it
						g.setStroke(new BasicStroke(3));
						g.setColor(new Color(102,0,190));
						
						
						g.drawOval(j * eggWidth + 49, i * eggHeight + 10, eggWidth, eggHeight);		
						
				}}}
		
			 if(gol) {
				g.setColor(Color.orange);
				g.fillOval(90,70,10,10);
				g.setColor(Color.orange);
				g.fillOval(250,250,10,10);
				g.setColor(Color.orange);
				g.fillOval(200,140,10,10);
				g.setColor(Color.orange);
				g.fillOval(400,140,10,10);
				g.setColor(Color.orange);
				g.fillOval(510,180,10,10);
				g.setColor(Color.orange);
				g.fillOval(550,70,10,10);
				g.setColor(Color.orange);
				g.fillOval(170,190,10,10);
				g.setColor(Color.orange);
				g.fillOval(510,250,10,10);
				g.setColor(Color.orange);
				g.fillOval(250,70,10,10);
				g.setColor(Color.orange);
				g.fillOval(400,200,10,10);
				
				}}
			private Color Color(int k, int l, int m) {
		
			return null;
		}
			void move() {
				if(eggWidth==0) {
					y=y+1;
				}
			}
		public void seteggValue(int value, int row, int col)
		{
			map[row][col]= value;
		}

		public int[][] getMapArray() {
		
			return null;
		}
		
	}
