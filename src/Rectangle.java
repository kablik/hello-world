
public class Rectangle extends Shape implements Rotable{

	int lengthA;
	int lengthB;
	boolean fillingUsed;
	int pomocna;

	public int getPomocna() {
		return pomocna;
	}

	public void setPomocna(int pomocna) {
		this.pomocna = pomocna;
	}

	public boolean isFillingUsed() {
		return fillingUsed;
	}

	public void setFillingUsed(boolean fillingUsed) {
		this.fillingUsed = fillingUsed;
	}

	public int getLengthA() {
		return lengthA;
	}

	public void setLengthA(int lengthA) {
		this.lengthA = lengthA;
	}

	public int getLengthB() {
		return lengthB;
	}

	public void setLengthB(int lengthB) {
		this.lengthB = lengthB;
	}

	public Rectangle(int x, int y, char fill, char background, int lengthA, int lengthB, boolean fillingUsed) {
		super(x, y, fill, background);
		this.lengthA = lengthA;
		this.lengthB = lengthB;
		this.fillingUsed = fillingUsed;
	}

	public Rectangle() {
		this(0, 0, ',', '.', 10, 5, true);
	}

	public void draw() {
		if (getX() < getPociatokX()*(-1) || getY() < getPociatokY()*(-1)) {
			System.out.println("neda sa vykreslit");
		} else {
			if (isFillingUsed() == true) {

				posuvanieX();

				for (int k = getLengthA(); k > 0; k--) {
					posuvanieY();
					for (int m = getLengthB(); m > 0; m--) {
						System.out.print(getFill());

					}
					for (int v = 0; v < getBackgroundNumber() - getY() - getLengthB() - getPociatokY(); v++) {
						System.out.print(getBackground());
					}
					System.out.println();
				}
				pozadiePodObjektom();

			} else {
				posuvanieX();

				for (int k = getLengthA(); k > 0; k--) {
					posuvanieY();
					if (k == 1 || k == getLengthA()) {
						for (int m = getLengthB(); m > 0; m--) {
							System.out.print(getFill());
						}
					} else {

						if (k > 1 && k < getLengthA()) {
							for (int m = getLengthB(); m > 0; m--) {
								if (m == getLengthB() || m == 1) {
									System.out.print(getFill());
								} else {
									System.out.print(getBackground());
								}
							}
						}
					}
					for (int v = 0; v < getBackgroundNumber() - getY() - getLengthB()  - getPociatokY(); v++) {
						System.out.print(getBackground());
					}
					System.out.println();
				}
				pozadiePodObjektom();

			}
		}
	}

	public String describe() {
		return "Rectangle:   " + super.describe() + "   dåžka strany A = " + getLengthA() + "   dåžka strany B = "
				+ getLengthB() + "   obvod = " + (2 * getLengthB() + 2 * getLengthA()) + "   obsah = "
				+ getLengthB() * getLengthA();
	}

	public void rotateClockwise(int pocetRotacii) {
		if (pocetRotacii % 2 == 0) {
		} else {
			setPomocna(getLengthA());
			setLengthA(getLengthB());
			setLengthB(getPomocna());
		}

	}

}
