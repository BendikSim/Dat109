/**
 * 
 */
package no.hvl.dat109.eniteter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import no.hvl.dat109.Kontroller.SpillerVelger;

import static java.lang.Thread.sleep;

/**
 * Klasse som definerer et Stigespill
 * 
 * @author Bendik Simonsen og Jon Vollset
 *
 */
public class StigeSpill {
	
	private Brett brett;
	private List<Spiller> spillere;
	private Terning terning;
	private boolean vunnet;
	
	public StigeSpill() {
		brett = new Brett();
		terning = new Terning();
		spillere = new ArrayList<>();
		vunnet = false;
	}
	
	/**
	* Setter i gang stigespillet
    */
	public void spill() {
		
		//Starter spillet, og oppretter spillerne 
		spillere = SpillerVelger.startSpill();
				
		int rundenr = 1;
		System.out.println("Starter spill...");
				
		while(!vunnet) {
			System.out.println("_____Runde " + rundenr + " ___________________");
			spillRunde();

			rundenr++;
		try {
				sleep(500);
		} catch (InterruptedException e) {
						e.printStackTrace();
					}
		}
	    }
	 	
	/**
	* Spiller en runde Stigespill.
    */
	private void spillRunde() {
		for(Spiller spiller : spillere) {
			spiller.spillTrekk(terning);
			if(spiller.getBrikke().getRute().getNr() == 100) {
				System.out.println(spiller.getNavn() + " Vunnet spill");
				vunnet = true;
				
			}
		}
	}
	
	public void setSpillere(ArrayList<Spiller> spillere) {
		this.spillere = spillere;
	}

	public Brett getBrett() {
		return brett;
	}

}
