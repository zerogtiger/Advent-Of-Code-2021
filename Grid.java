

public class Grid {

	Integer[][] grid = new Integer[5][5];
	
	public Grid() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				grid[i][j] = -1;
			} 
		}
	}
	
	public Grid(int[] S) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				grid[i][j] = S[i*5+j];
			} 
		}
	}
	
	public void remove(int num) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(grid[i][j] == num) {
					grid[i][j] = -1;
				}
			} 
		}
	}
	
	public boolean isBingo() {
		boolean isBingo = false;
		for (int i = 0; i < 5; i++) {
			if(grid[i][0] == -1 && grid[i][1] == -1 && grid[i][2] == -1 && grid[i][3] == -1 && grid[i][4] == -1) {
				isBingo = true;
			}
			if(grid[0][i] == -1 && grid[1][i] == -1 && grid[2][i] == -1 && grid[3][i] == -1 && grid[4][i] == -1) {
				isBingo = true;
			}
		}
		return isBingo;
	}
	
	public int sum() {
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(!(grid[i][j] == -1)) {
					sum += grid[i][j];
				}
			} 
		}
		return sum;
	}
	
	public String toString() {
		String s ="";
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				s += grid[i][j].toString() + " ";
			} 
			s += "\n";
		}
		return s;
	}
	
}
