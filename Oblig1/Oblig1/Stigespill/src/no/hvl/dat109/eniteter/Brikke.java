package no.hvl.dat109.eniteter;

/**
 * Definerer en brikke
 * 
 * @author Bendik Simonsen og Jon Vollset
 *
 */
public class Brikke {
	
	private String farge;
	private Rute rute;
	private Brett brett;
	
	
	/**
	 * Kontruktør for Brikke
	 * 
	 * @param farge 
	 * @param brett
	 */
	public Brikke(String farge, Brett brett) {
		this.brett = brett;
		this.rute = brett.getSpilleBrett().get(1);
		this.farge = farge;
	}
	
	
	/** 
	 * Flytter brikken et gitt antall steg
	 * 
	 * @param sum
	 */
	public void flytt(int kast) {
		if(rute.getNr() + kast <= 100) {
			Rute nyRute = brett.finnRute(rute, kast);
			setRute(nyRute);
		}	
	}
	
	public void flyttTilStart() {
        Rute nyRute = brett.getSpilleBrett().get(1);
        setRute(nyRute);
    }
	
	public Brett getBrett() {
		return brett;
	}


	public void setBrett(Brett brett) {
		this.brett = brett;
	}


	public Rute getRute() {
		return rute;
	}


	private void setRute(Rute rute) {
		this.rute = rute;
	}


	public String getFarge() {
		return farge;
	}


	public void setFarge(String farge) {
		this.farge = farge;
	}


	
}
