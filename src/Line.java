
public class Line extends Shape implements Rotable{

	int length;
	boolean horizontal;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public boolean isHorizontal() {
		return horizontal;
	}

	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	public Line(int x, int y, char fill, char background, int length, boolean horizontal) {
		super(x, y, fill, background);
		this.length = length;
		this.horizontal = horizontal;
	}

	public Line() {
		this(0, 0, '+', '.', 15, true);
	}

	public void draw() {
		if (getX() < getPociatokX()*(-1) || getY() < getPociatokY()*(-1)) {
			System.out.println("neda sa vykreslit");
		} else {
			posuvanieX();
			if (isHorizontal() == true) {
				posuvanieY();
				for (int k = 0; k < getLength(); k++) {
					System.out.print(getFill());
				}

				for (int n = 0; n < getBackgroundNumber() - getY() - getLength()  - getPociatokY(); n++) {
					System.out.print(getBackground());

				}
				System.out.println();
			} else {
				for (int m = 0; m < getLength(); m++) {
					posuvanieY();
					System.out.print(getFill());
					for (int n = 1; n < getBackgroundNumber() - getY() - 1  - getPociatokY(); n++) {
						System.out.print(getBackground());
					}
					System.out.println(getBackground());
				}
			}
			pozadiePodObjektom();
		}
	}

	public String describe() {
		return "Line:   " + super.describe() + "   dåžka = " + getLength() + "   je horizontálna = " + isHorizontal();
	}

	public void rotateClockwise(int pocetRotacii) {
		if (isHorizontal() == true && pocetRotacii % 2 == 0) {
			setHorizontal(true);
		} else if (isHorizontal() == false && pocetRotacii % 2 == 0) {
			setHorizontal(false);
		} else if (isHorizontal() == true && pocetRotacii % 2 != 0) {
			setHorizontal(false);
		} else if (isHorizontal() == false && pocetRotacii % 2 != 0) {
			setHorizontal(true);
		}

	}
	

}
