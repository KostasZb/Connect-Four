package ConnectFourCourseWork;

public class Game {
	private Player player;
	private Grid grid;
	private int winningConditions=4;
	SquareComparingTool compare=new SquareComparingTool(this.winningConditions);

	public Game() {
		grid=new Grid();
	}
	//RELATED TO CHECKING FOR FOUR IN A ROW
	public boolean usingTheChecker(int input) {
		boolean fourConnected=false;
		compare.setGrid(this.grid);
		compare.setStartingSquare(this.grid.selectRow(this.grid.findTheRowWhereTheSquareWent(input)).selectSquare(input));
		compare.setStartingRow(this.grid.selectRow(this.grid.findTheRowWhereTheSquareWent(input)));
		compare.initialisingTheValuesCompared();
		//checking horizontally
		compare.checkingForFour("HorrizontalLeft");
		compare.checkingForFour("HorrizontalRight");
		if(compare.getMatchingSquaresFloat().size()>=winningConditions) {
			fourConnected=true;
		}else {
			compare.voidingTheFloat();
			compare.initialisingTheValuesCompared();
			//checking Vertically
			compare.checkingForFour("Vertical");
			if(compare.getMatchingSquaresFloat().size()>=winningConditions) {
				fourConnected=true;
			}else {
				compare.voidingTheFloat();
				compare.initialisingTheValuesCompared();
				//checking diagonally from bottom to top
				compare.checkingForFour("DiagonallyALeft");
				compare.initialisingTheValuesCompared();
				compare.checkingForFour("DiagonallyARight");
				if(compare.getMatchingSquaresFloat().size()>=winningConditions) {
					fourConnected=true;
				}else {
					compare.voidingTheFloat();
					compare.initialisingTheValuesCompared();
					//checking diagonally from top to bottom
					compare.checkingForFour("DiagonallyBLeft");
					compare.initialisingTheValuesCompared();
					compare.checkingForFour("DiagonallyBRight");
					if(compare.getMatchingSquaresFloat().size()>=winningConditions) {
						fourConnected=true;
					}else {
						compare.voidingTheFloat();
						compare.initialisingTheValuesCompared();
					}
				}
			}
		}
		return fourConnected;
	}

	//RELATED TO CHANGING THE DISPLAY OF THE ERROR WINDOW
	public String errorMessage(int input) {
		String message="";
		if(checkingIfInputIsValid(input)==false) {
			message="please choose between 1 and 7";
		}else {
			message="please a column that has free space";
		}
		return message;
	}

	//RELATED TO CHECKING IF THE INPUT IS WITHIN LIMITS OF THE GRID
	public boolean checkingIfInputIsValid(int input) {
		boolean inputValid=true;
		if(input<this.grid.getTheGrid().getFirst().getTheRow().getFirst().getNumber()||input>this.grid.getTheGrid().getFirst().getTheRow().size()) {
			inputValid=false;
		} 
		return inputValid;
	}

	//RELATED TO CHECKING IF THE GRID IS FULL
	public boolean seeIfGridFull() {
		boolean gridFull=true;
		for(Row row:this.grid.getTheGrid()) {
			for(Square square:row.getTheRow()) {
				if(square.getEmpty()==true) {
					gridFull=false;
				}
			}
		}
		return gridFull;
	}

	//RELATED TO CHECKING IF THE SELECTED COMLUMN IS FULL
	public boolean columnFull(int input) {
		boolean columnFull=true;
		for(Row row:this.getGrid().getTheGrid()) {
			if(row.selectSquare(input).getEmpty()) {
				columnFull=false;
			}
		}
		return columnFull;
	}

	//RELATED TO SQUARE SELECTION, DISC INSERTION AND PRINTING THE GRID
	//Adding a disc to the first available row
	public void addAdisc(int input) {
		int rowNumber=this.grid.findingTheRowNumberWithEmptySquare(input);
		this.grid.selectRow(rowNumber).selectSquare(input).setDisc(player.getColour());

	}

	//printing the grid
	public String printTheGrid() {
		return this.grid.printGrid();
	}



	//GETTERS AND SETTERS 

	//getter for the grid
	public void setGrid(Grid grid) {
		this.grid=grid;
	}
	//setter for the grid
	public Grid getGrid() {
		return this.grid;
	}
	//setter for the player
	public void setPlayer(Player player) {
		this.player=player;

	}
	//getter for player
	public Player getPlayer() {
		return this.player;
	}
}
