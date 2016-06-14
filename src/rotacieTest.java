
public class rotacieTest {

	public static void main(String[] args) {

		int rotacie = 13;
		/*
		 * switch(rotacie) { case 0: case 1: case 2: case 3:
		 * 
		 * default: return "Co za den si to tu zadal??"; }
		 */

		if (rotacie % 2 == 0) {
			for (int i = rotacie; i != 0; rotacie = rotacie - 4) {
				if (rotacie == 0) {
					System.out.println(rotacie);
					break;
				} else if (rotacie == 2) {
					System.out.println("sjvbsdv" + rotacie);
					break;
				}
			}
		} else {
			for (int i = rotacie; i != 0; rotacie = rotacie - 4) {
				if (rotacie == 1) {
					System.out.println(rotacie);
					break;
				} else if (rotacie == 3) {
					System.out.println("rrrrrrrrrrrr" + rotacie);
					break;
				}
			}
		
		}
		
		
		
		
		
		// for(int j = 1; j != rotacie+1; j=j+4){
		// if (j != rotacie){
		// System.out.println(j);
		// break;
		// }}
		//
		// for(int k = 2; k != rotacie+1; k=k+4){
		// if (k != rotacie){
		// System.out.println(k);
		// break;
		// }}
		// for(int j = 3; j != rotacie+1; j=j+4){
		// if (j != rotacie){
		// System.out.println(j);
		// break;
		// }}

	}
}