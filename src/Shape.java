
public abstract class Shape {

	int x;
	int y;
	char fill;
	char background;

	int pociatokX = 5;
	int pociatokY = 10;
	int backgroundNumber = 100;

	public int getBackgroundNumber() {
		return backgroundNumber;
	}

	public void setBackgroundNumber(int backgroundNumber) {
		this.backgroundNumber = backgroundNumber;
	}

	public int getPociatokX() {
		return pociatokX;
	}

	public int getPociatokY() {
		return pociatokY;
	}

	public Shape(int pociatokX, int pociatokY) {
		super();
		this.pociatokX = pociatokX;
		this.pociatokY = pociatokY;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public char getFill() {
		return fill;
	}

	public void setFill(char fill) {
		this.fill = fill;
	}

	public char getBackground() {
		return background;
	}

	public void setBackground(char background) {
		this.background = background;
	}

	public Shape(int x, int y, char fill, char background) {
		this.x = x;
		this.y = y;
		this.fill = fill;
		this.background = background;
	}

	public String describe() {
		return "x-ová = " + getX() + "   y-ová = " + getY() + "   fill = " + getFill() + "   background = "
				+ getBackground();
	}

	public void posuvanieX() {
		for (int i = 0; i < getX() + getPociatokX(); i++) {
			for (int c = 0; c < getBackgroundNumber(); c++) {
				System.out.print(getBackground());
			}
			System.out.println();
		}
	}

	public void posuvanieY() {
		for (int j = 0; j < getY() + getPociatokY(); j++) {
			System.out.print(getBackground());
		}
	}

	public void pozadiePodObjektom() {
		for (int g = 0; g < getX() + getPociatokX(); g++) {
			for (int c = 0; c < getBackgroundNumber(); c++) {
				System.out.print(getBackground());
			}
			System.out.println();
		}
	}

	public void move(int dx, int dy) {
		setX(getX() + dx);
		setY(getY() + dy);
	}

	public abstract void draw();
	
	




}
