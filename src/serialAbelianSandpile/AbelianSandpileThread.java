package serialAbelianSandpile;
import java.util.concurrent.RecursiveTask;

public class AbelianSandpileThread extends RecursiveTask<Boolean>{
    public int startRow;
	public int endRow;
	public int col;
	int [][] grid; 
	int [][] updateGrid;

	static final int SEQUENTIAL_CUTOFF = 5000;

    public AbelianSandpileThread (int startRow, int endRow, int columns, int[][] grid, int[][] updateGrid){
        this.startRow = startRow;
        this.col = columns;
        this.grid = grid;
        this.updateGrid = updateGrid;
		this.endRow = endRow-1;
    }

	@Override
    protected Boolean compute(){
		if((endRow-startRow)*(endRow-startRow) <= SEQUENTIAL_CUTOFF ){
			return update();
		}
		int midRow = (startRow + endRow)/2;
		AbelianSandpileThread left = new AbelianSandpileThread(startRow, midRow ,col, grid, updateGrid);
		left.startRow = startRow;
		left.endRow = midRow;
		left.fork();	
		AbelianSandpileThread right = new AbelianSandpileThread(midRow, endRow,col, grid, updateGrid);    
		right.startRow = midRow;
		right.endRow = endRow;  
		boolean rightAns = right.compute();
		boolean leftAns = left.join();
		return leftAns || rightAns;
    }

	private boolean update(){
		boolean result=false;
		//do not update border
		for( ; startRow<endRow; startRow++ ) {
			for( int j = 1; j<col-1; j++ ) {
				updateGrid[startRow][j] = (grid[startRow][j] % 4) + 
						(grid[startRow-1][j] / 4) +
						grid[startRow+1][j] / 4 +
						grid[startRow][j-1] / 4 + 
						grid[startRow][j+1] / 4;
				if (grid[startRow][j]!=updateGrid[startRow][j]) {  
					result=true;
				}
			}
		} //end nested for
		return result;
	}
}
