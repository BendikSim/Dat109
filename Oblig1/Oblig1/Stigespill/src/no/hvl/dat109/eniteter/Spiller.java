package no.hvl.dat109.eniteter;

/**
 * Klasse som definerer en spiller
 * @author Bendik Simonsen og Jon Vollset
 *
 */
public class Spiller {

	private Brikke brikke;
	private String navn;
	
	
	/**
	 * Lager en ny spiller
	 * 
	 * @param
	 */
	public Spiller(String navn, Brikke brikke) {
		this.navn = navn;
		this.brikke = brikke;
	}
	
	/**
	 * Spiller et trekk for spilleren
	 */
	public void spillTrekk(Terning terning) {
		int seksere = 0;
		int verdi;
		
		/**
		 * 
		 */
		do {
		verdi = Terning.trill();
		
		//Sjekker når brikke + terningkast < 100 så skal den flyttes på vanlig måte
		if(verdi + brikke.getRute().getNr() < 100) {
			brikke.flytt(verdi);
			System.out.println("("+ navn.toUpperCase() + ") Trillet:" + verdi + " |Flytter fra " 
					+ (brikke.getRute().getNr()-verdi)+ "->" + brikke.getRute().getNr());
			
			//Sjekker hvis spilleren får en sekser
			if(verdi == 6) {
				System.out.println("***Du fikk 6 heldiggris, nytt kast!***");
				seksere++;
				
				//Hvis du får 3 seksere på rad så skal du flyttes tilbake til start
				if(seksere == 3) {
					brikke.flyttTilStart();
					System.out.println("Tre seksere på rad " + navn + " du flyttes til start" );
					break;
				}
				
			}
			//Hvis terningkast + verdi > 100 skal brikken stå på det samme stedet
		}else if(verdi + brikke.getRute().getNr() > 100){
			
			brikke.getRute().getNr();
			System.out.println("("+ navn.toUpperCase() + ") Trillet:" + verdi + " |Står på samme rute " 
					+ (brikke.getRute().getNr()));
			
				//Når en spiller når akkurat 100, skriver ut navn og brikkefarge og avslutter programmet
			}else {
				
				
				System.out.println("**Wohoo " + navn +" med "+ brikke.getFarge() + " brikke vant spillet** ");
				System.out.println("Avslutter spill...");
				System.exit(0);
		}
		
		
				/**
				 * Sjekker om spiller får terningkast 6,
				 * da blir det nytt kast. 
				 * Ved 3 seksere på rad flyttes spiller til start
				 */
			}while(verdi == 6);
		
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public void setBrikke(Brikke brikke) {
		this.brikke = brikke;
	}
	
	public Brikke getBrikke() {
		return brikke;
	}

	

}
