package ConnectFourCourseWork;
import java.util.LinkedList;

public class Grid{

	private LinkedList <Row> theGrid = new LinkedList <Row> ();
	//Constructor for the grid,creating 6 rows for it
	public Grid() {
		int height=7;
		Row tempRow;

		for(int loop = 1; loop < height; loop++) {
			tempRow = new Row(loop);
			this.theGrid.addFirst(tempRow);
		}
	}

	//RELATED TO SQUARE COMPARISON
	//Finding the row that the last disc was inserted
	public int findTheRowWhereTheSquareWent(int input) {
		int tempRowNumber=this.theGrid.getFirst().getNumber();
		for(Row row:this.theGrid) {
			if(row.squareIsEmpty(input)!=true) {
				tempRowNumber=row.getNumber();
				break;
			}
		}
		return tempRowNumber;
	}
	//RELATED TO SQUARE SELECTION, DISC INSERTION AND PRINTING THE GRID	
	//Finding the row number that has space.
	public int findingTheRowNumberWithEmptySquare(int input) {
		int tempRowNumber=this.theGrid.getFirst().getNumber();
		//The rows are added backwards so the the first row in the loop is the one with 1 as its number 
		for(Row row:this.theGrid) {
			if(row.squareIsEmpty(input)) {
				tempRowNumber=row.getNumber();
			}			
		}		
		return tempRowNumber;
	}
	//selecting a row by number
	public Row selectRow(int rowNumber) {
		Row temprow=this.theGrid.getFirst();
		for(Row row:this.theGrid) {
			if (row.getNumber()==rowNumber) {
				temprow=row;
				break;
			}
		}
		return temprow;
	}
	public String printGrid() {
		String output="";
		for(Row row:this.theGrid) {
			output=output+"\n"+row.printRow()+"\n";			
		}
		return output;
	}

	//GETTERS AND SETTERS

	public void setTheGrid(LinkedList<Row> theGrid) {
		this.theGrid=theGrid;
	}
	public LinkedList<Row> getTheGrid(){
		return this.theGrid;
	}


}