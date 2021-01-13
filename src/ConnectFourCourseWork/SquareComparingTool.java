package ConnectFourCourseWork;

import java.util.HashSet;

public class SquareComparingTool {
	private int winningConditions;
	private Grid grid;
	private Square startingSquare;
	private Row startingRow;
	private int comparingSquareNumber;
	private int comparingSquareRowNumber;
	private HashSet<Square> matchingSquaresFloat=new HashSet<Square>();

	public SquareComparingTool(int winningConditions) {
		setWinningConditions(winningConditions);

	}

	public void checkingForFour(String type) {

		//getting the dimensions of the row and grid
		int gridMax=this.grid.getTheGrid().getFirst().getNumber();
		int gridMin=this.grid.getTheGrid().getLast().getNumber();
		int rowMax=this.grid.getTheGrid().getFirst().getTheRow().size();
		int rowMin=this.grid.getTheGrid().getFirst().getTheRow().getFirst().getNumber();


		//As we are looking for four in a row, the search will be done for up to four adjacent squares
		//The row and column number of the square being compared can be either be increasing or decreasing or a combination of the two
		for(int counter=0;counter<this.winningConditions;counter++) {
			//selecting from the availlable options of search
			if(type=="HorrizontalLeft") {
				this.changingTheSquareNumberOnlyDown(counter);
			}else if(type=="HorrizontalRight"){
				this.changingTheSquareNumberOnlyUp(counter);

			}else if(type=="Vertical") {
				this.changingTheRowNumberOnlyDown(counter);

			}else if(type=="DiagonallyALeft") {
				this.changingTheSquareNumberOnlyDown(counter);
				this.changingTheRowNumberOnlyDown(counter);
			}else if(type=="DiagonallyARight") {
				this.changingTheSquareNumberOnlyUp(counter);
				this.changingTheRowNumberOnlyUp(counter);

			}else if(type=="DiagonallyBLeft") {
				this.changingTheSquareNumberOnlyDown(counter);
				this.changingTheRowNumberOnlyUp(counter);
			}else if(type=="DiagonallyBLeft") {
				this.changingTheSquareNumberOnlyUp(counter);
				this.changingTheRowNumberOnlyDown(counter);
			}
			//checking if the values being compared are within the grid
			boolean insideTheRow=(comparingSquareNumber>=rowMin)&&(comparingSquareNumber<=rowMax);
			boolean insideTheColumn=(comparingSquareRowNumber<=gridMax)&&(comparingSquareRowNumber>=gridMin);			
			//checking that the above criteria are met and then checking if the square needed is empty
			if(insideTheRow&&insideTheColumn) {
				if(this.grid.selectRow(comparingSquareRowNumber).selectSquare(comparingSquareNumber).getEmpty()==false) {
					//Finding the specific square to be compared, based on its row and square number
					Square squareForComparison=this.grid.selectRow(comparingSquareRowNumber).selectSquare(comparingSquareNumber);
					//Checking if the colours of the two squares match and adding the compared square to the float
					if(this.startingSquare.getThecolour()==squareForComparison.getThecolour()) {
						this.matchingSquaresFloat.add(squareForComparison);
						//If the criteria set are not met the search stops
					}else {
						break;
					}
				}

			}else {
				break;
			}	
		}
	}

	//initialising the values of the square and row that the square to be compared, are located 
	public void initialisingTheValuesCompared() {
		this.comparingSquareNumber=this.startingSquare.getNumber();
		this.comparingSquareRowNumber=this.startingRow.getNumber();
	}
	//voiding the float
	public void voidingTheFloat() {
		this.matchingSquaresFloat.clear();
	}

	//setting the number of the square compared to increase with counter 
	public void changingTheSquareNumberOnlyUp(int counter) {
		this.comparingSquareNumber= this.startingSquare.getNumber()+counter;
	}
	//setting the number of the square compared to decrease with counter 
	public void changingTheSquareNumberOnlyDown(int counter) {
		this.comparingSquareNumber= this.startingSquare.getNumber()-counter;
	}
	//setting the number of the row compared to increase with counter 
	public void changingTheRowNumberOnlyUp(int counter) {
		this.comparingSquareRowNumber=this.startingRow.getNumber()+counter;
	}
	//setting the number of the row compared to decrease with counter 
	public void changingTheRowNumberOnlyDown(int counter) {
		this.comparingSquareRowNumber=this.startingRow.getNumber()-counter;
	}


	//Getters and setters
	public int getWinningConditions() {
		return this.winningConditions;
	}
	public void setWinningConditions(int winningConditions) {
		this.winningConditions = winningConditions;
	}
	public Grid getGrid() {
		return this.grid;
	}
	public void setGrid(Grid grid) {
		this.grid = grid;
	}
	public Square getStartingSquare() {
		return this.startingSquare;
	}
	public void setStartingSquare(Square startingSquare) {
		this.startingSquare = startingSquare;
	}
	public Row getStartingRow() {
		return this.startingRow;
	}
	public void setStartingRow(Row startingRow) {
		this.startingRow = startingRow;
	}
	public int getComparingSquareNumber() {
		return this.comparingSquareNumber;
	}
	public void setComparingSquareNumber(int comparingSquareNumber) {
		this.comparingSquareNumber = comparingSquareNumber;
	}
	public int getComparingSquareRowNumber() {
		return this.comparingSquareRowNumber;
	}
	public void setComparingSquareRowNumber(int comparingSquareRowNumber) {
		this.comparingSquareRowNumber = comparingSquareRowNumber;
	}
	public HashSet<Square> getMatchingSquaresFloat() {
		return this.matchingSquaresFloat;
	}
	public void setMatchingSquaresFloat(HashSet<Square> matchingSquaresFloat) {
		this.matchingSquaresFloat = matchingSquaresFloat;
	}




}
