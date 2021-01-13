package ConnectFourCourseWork;

public class Square{

	private int number;
	private boolean empty;
	private Disc theDisc;


	//constructor for the square,'emptying its contents'
	public Square(int number) {
		setNumber(number);
		setEmpty(true);

	}
	//Setting a disc in the square, adding a new disc and using its constructor to set the colour.Also turning the square to occupied
	public void setDisc(String colour) {
		this.empty=false;
		this.theDisc = new Disc(colour);		
	}

	//getting the colour of the disc contained in the square
	public String getThecolour() {
		return this.theDisc.getColour();
	}

	//GETTERS AND SETTERS
	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

	public Disc getDisc() {
		return this.theDisc;
	}
	public boolean getEmpty() {
		return this.empty;
	}

}
