/**
 * 
 */
package no.hvl.dat109.Kontroller;

import no.hvl.dat109.eniteter.StigeSpill;

/**
 * Lager spillkontroller
 * 
 * @author Bendik Simonsen
 *
 */
public class SpillKontroller {

	/**
	 * @param args
	 */
	
	public static void startSpill() {
		
		StigeSpill spill = new StigeSpill();
		SpillerVelger spillervalg = new SpillerVelger(spill);
		
		spill.spill();

	}
	
	public static void main(String[] args) {
		 startSpill();
	}

}
