package no.hvl.dat109.eniteter;

import java.util.HashMap;
import java.util.Map;

/**
 * Definerer et brett
 * 
 * @author Bendik Simonsen og Jon Vollset
 *
 */
public class Brett {
	
	private final int ANTALL_RUTER = 100;
	private Map<Integer, Rute> spilleBrett;

	// initialiserer alle rutene på spillebrettet
	public Brett() {
		spilleBrett = new HashMap<>();
		for(int i = 1; i < ANTALL_RUTER; i++) {
			spilleBrett.put(i, new Rute(i));
		}
	}
	
	public Map<Integer, Rute> getSpilleBrett() {
	        return this.spilleBrett;
	    }
	 
	
	/**
	 * Finner og returnerer ruten som er terningkast steg frem for rute.
	 * 
	 * @param rute
	 * @param kast
	 * @return   
	 */
	public Rute finnRute(Rute rute, Integer kast) {
		int pos = rute.getNr();
		int nyPos = pos + kast;
		return spilleBrett.get(nyPos);
	}


	

}
