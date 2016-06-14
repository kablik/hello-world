
public class TestShape {

	public static void main(String[] args) {

		Point bod = new Point(0, 0, 'o', '.');

		Line ciara = new Line(3, 2, 'I', '.', 10, true);

		Triangle trojuholnik = new Triangle(2, 2, '/', '.', 9, true);

		Rectangle obdlznik = new Rectangle(2, 2, '#', '.', 2, 12, false);

		bod.move(5, 5);
		ciara.move(-5, 1);
		//ciara.rotateClockwise(1);
		//obdlznik.rotateClockwise(2);
		//obdlznik.move(5, 5);
		//trojuholnik.rotateClockwise(3);

		/*Shape[] pole = { bod, ciara, trojuholnik, obdlznik };

		
		for (int i = 0; i < pole.length; i++) {
			System.out.println("______________________________________________________________________");
			pole[i].draw();
			System.out.println();
			System.out.println("" + pole[i].describe());
			System.out.println();
			System.out.println();
		}*/
		
		
		Rotable[] poleNew = { ciara, trojuholnik, obdlznik};
		
		for(Rotable p : poleNew){
			p.rotateClockwise(1);
		}
		ciara.draw();
		
	

	}

}
