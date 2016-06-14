import java.text.DecimalFormat;

public class Triangle extends Shape implements Rotable{

	int lengthOdvesna;
	int numbersOfRotation;
	boolean fillingUsed;

	public boolean isFillingUsed() {
		return fillingUsed;
	}

	public void setFillingUsed(boolean fillingUsed) {
		this.fillingUsed = fillingUsed;
	}

	public int getLengthOdvesna() {
		return lengthOdvesna;
	}

	public void setLength(int lengthOdvesna) {
		this.lengthOdvesna = lengthOdvesna;
	}

	public int getNumbersOfRotation() {
		return numbersOfRotation;
	}

	public void setNumbersOfRotation(int numbersOfRotation) {
		this.numbersOfRotation = numbersOfRotation;
	}

	public Triangle(int x, int y, char fill, char background, int lengthOdvesna, boolean fillingUsed) {
		super(x, y, fill, background);
		this.lengthOdvesna = lengthOdvesna;
		this.fillingUsed = fillingUsed;
	}

	public Triangle() {
		this(0, 0, '-', '.', 10, true);
	}

	public void draw() {
		if (getX() < getPociatokX()*(-1) || getY() < getPociatokY()*(-1)) {
			System.out.println("neda sa vykreslit");
		} else {
			if (numbersOfRotation == 0) {
				posuvanieX();
				int pomocna = getLengthOdvesna();
				for (int k = getLengthOdvesna(); k > 0; k--) {
					posuvanieY();
					for (int m = 0; m < pomocna; m++) {
						System.out.print(getFill());
					}
					for (int v = 0; v < getBackgroundNumber() - getY() - pomocna  - getPociatokY(); v++) {
						System.out.print(getBackground());
					}
					System.out.println();
					pomocna--;
				}
				pozadiePodObjektom();

			} else if (numbersOfRotation == 1) {

			} else if (numbersOfRotation == 2) {
				System.out.println("sdj hcv sb dh csd");
			} else if (numbersOfRotation == 3) {
				posuvanieX();
				int pomocna = getLengthOdvesna() - 1;
				for (int k = 0; k < getLengthOdvesna(); k++) {
					posuvanieY();
					for (int m = 0; m < getLengthOdvesna() - pomocna; m++) {
						System.out.print(getFill());
					}
					for (int v = 0; v < getBackgroundNumber() - getY() - (getLengthOdvesna() - pomocna  - getPociatokY()); v++) {
						System.out.print(getBackground());
					}
					System.out.println();
					pomocna--;
				}
				pozadiePodObjektom();
			}
		}
	}

	private static DecimalFormat df2 = new DecimalFormat(".##");

	public String describe() {
		return "Triangle:   " + super.describe() + "   dåžka odvesny = " + getLengthOdvesna() + "   pocet pootoceni = "
				+ getNumbersOfRotation() +

				"   obvod = " + df2.format((2 * (double) getLengthOdvesna()
						+ Math.sqrt(2 * ((double) getLengthOdvesna() * (double) getLengthOdvesna()))))
				+

				"   obsah = " + df2.format((double) getLengthOdvesna() * (double) getLengthOdvesna() / 2);
	}

	public void rotateClockwise(int pocetRotacii) {
		if (pocetRotacii % 2 == 0) {
			for (int i = pocetRotacii; i != 0; pocetRotacii = pocetRotacii - 4) {
				if (pocetRotacii == 0) {
					setNumbersOfRotation(0);
					break;
				} else if (pocetRotacii == 2) {
					setNumbersOfRotation(2);
					break;
				}
			}
		} else {
			for (int i = pocetRotacii; i != 0; pocetRotacii = pocetRotacii - 4) {
				if (pocetRotacii == 1) {
					setNumbersOfRotation(1);
					break;
				} else if (pocetRotacii == 3) {
					setNumbersOfRotation(3);
					break;
				}
			}

		}
	}

}
