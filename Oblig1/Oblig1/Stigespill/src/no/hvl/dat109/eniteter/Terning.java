/**
 * 
 */
package no.hvl.dat109.eniteter;

/**
 * Definerer en terning
 * 
 * @author Bendik Simonsen og Jon Vollset
 *
 */
public class Terning {
	
	private static Integer verdi;

	public Integer getVerdi() {
		return verdi;
	}

	//triller terningen
	public static int trill() {
		return verdi = (int)(Math.random()*6+1);
	}
	
	public static void main(String[] args) {
		System.out.println(trill());
	}
}
