
public class Point extends Shape {

	public Point(int x, int y, char fill, char background) {
		super(x, y, fill, background);
	}

	public Point() {
		this(8, 2, '*', '.');
	}

	public void draw() {
		if (getX() < getPociatokX()*(-1) || getY() < getPociatokY()*(-1)) {
			System.out.println("neda sa vykreslit");
		} else {
		posuvanieX();
		posuvanieY();
		System.out.print(getFill());
		for (int v = 0; v < getBackgroundNumber() - getY() - 1 - getPociatokY(); v++) {
			System.out.print(getBackground());
		}
		System.out.println();
		pozadiePodObjektom();
	}
	}

	public String describe() {
		return "Point:   " + super.describe();
	}



}
