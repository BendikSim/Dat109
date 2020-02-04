/**
 * 
 */
package no.hvl.dat109.Kontroller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import no.hvl.dat109.eniteter.Brikke;
import no.hvl.dat109.eniteter.Spiller;
import no.hvl.dat109.eniteter.StigeSpill;

/**
 * Klasse som definerer navn og farge på spiller
 * @author Bendik Simonsen 
 *
 */
public class SpillerVelger {
	private static List<Spiller> spillere;
	private final static ArrayList<String> FARGER = new ArrayList<>(Arrays.asList("Rød", "Blå", "Grønn", "Gul"));
	private final static String[] ANTALL_SPILLERE = {"2", "3", "4"};
	private final static String[] SPILL_MENY = {"Start spill", "Avslutt"};
	private static StigeSpill spill;
	
	
	public SpillerVelger(StigeSpill spill) {
		spillere = new ArrayList<>();
		this.spill = spill;
	}
	
	public static List<Spiller> startSpill() {
		
	// Lager start meny, enten start spill eller avslutt
	JFrame frame = new JFrame("Velkommen til stigespill");
	int valg = JOptionPane.showOptionDialog(frame,
		    "Stigespill",
		    null,
		    JOptionPane.YES_NO_OPTION,
		    JOptionPane.QUESTION_MESSAGE,
		    null,     
		    SPILL_MENY,  
		    SPILL_MENY[0]);
	
	if(valg==0) {
		
		//bestemmer hvor mange spiller som skal spille
		
			int velgSpillere = JOptionPane.showOptionDialog(
					frame, "Hvor mange spillere?",
					"Stigespill",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					ANTALL_SPILLERE,
					ANTALL_SPILLERE[0]);
			
			int antSpillere = Integer.parseInt(ANTALL_SPILLERE[velgSpillere]);
			
			for(int spiller = 1; spiller < antSpillere + 1; spiller++) {
		        String navn = JOptionPane.showInputDialog(frame, "Spiller" + spiller + ": Skriv inn navn");
		        
				int brikkefarge = JOptionPane.showOptionDialog(
							frame, "Velg farge", "Stigespill",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null,
							FARGER.toArray(), FARGER.get(0));
							
				String farge = FARGER.get(brikkefarge);
				FARGER.remove(brikkefarge);
				
				Brikke b = new Brikke(farge, spill.getBrett());
		        Spiller s = new Spiller(navn, b);
		        spillere.add(s);
			}
		        
			} else {
				//Avslutter spill
				System.out.println("Spill avsluttet...");
				System.exit(0);
			}
	
		return spillere;
	}
}

	

