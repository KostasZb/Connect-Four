package ConnectFourCourseWork;
import java.util.LinkedList;


public class Row {
	private int number;
	private LinkedList <Square> theRow = new LinkedList <Square> ();


	//constructor for the row,creating 7 squares for it
	public Row(int number) {
		int length=8;
		Square tempSquare;
		setNumber(number);
		for(int loop = 1; loop < length; loop++) {
			tempSquare = new Square(loop);
			this.theRow.addLast(tempSquare);
		}
	}

	//RELATED TO SQUARE SELECTION, DISC INSERTION AND PRINTING THE GRID
	//see if the selected square of the row is empty
	public boolean squareIsEmpty(int input) {
		boolean empty=false;
		for(Square square:this.theRow) {
			if(square.getNumber()==input) {
				empty=square.getEmpty();
				break;
			}
		}
		return empty;

	}
	//selecting the requested Square
	public Square selectSquare(int input) {
		Square tempsquare=this.theRow.getFirst();
		for(Square square:this.theRow) {
			if(square.getNumber()==input) {
				tempsquare=square;
				break;
			}
		}
		return tempsquare;
	}
	//Getting the colour of all the squares of the row
	public String printRow() {
		String output="";
		for(Square square:this.theRow) {
			if(square.getEmpty()) {
				output=output+"|_____|";
			}else {
				output=output+"|"+square.getDisc().getColour()+"|";
			}
		}
		return output;
	}

	//GETTERS AND SETTERS

	public void setNumber(int number) {
		this.number = number;
	}
	public void setTheRow(LinkedList<Square> theRow) {
		this.theRow=theRow;
	}
	public int getNumber() {
		return this.number;
	}
	public LinkedList<Square> getTheRow(){
		return this.theRow;
	}

}

