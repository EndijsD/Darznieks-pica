package skola;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Pica {
static boolean info = false;
static String vards, uzvards, numurs, adrese, izvele, iznākumsT;
static Picērija Picērija = new Picērija();
static double iznākumsL;
static double[] iznākumsV;

	static void informācija() {
		vards = JOptionPane.showInputDialog("Ievadi savu vārdu: ");
		uzvards = JOptionPane.showInputDialog("Ievadi savu uzvārdu: ");
		numurs = JOptionPane.showInputDialog("Ievadi savu tālruni: ");
		adrese = JOptionPane.showInputDialog("Ievadi savu adresi: ");
		info = true;
		
		String[] options = {"Jā", "Nē"};
		int pareizi = JOptionPane.showOptionDialog(null, "Vārds/uzvārds: "+vards+" "+uzvards+"\n"+
										                 "Tālrunis: "+numurs+"\nAdrese: "+adrese,
										                 "Vai ievadītā informācija ir pareiza?", 0, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		if(pareizi == 1)
			informācija();
	}
	static void izveidotPicu() {
		do {
		do {
			izvele = JOptionPane.showInputDialog("1 - Picas tips | 2 - Picas lielums | 3 - Papildus picas virskārtas/piedevas | 0 - Pabeigt picas taisīšanu");
			
			switch(izvele.toLowerCase()){
				case "1": iznākumsT = Picērija.tips(); break;
				
				case "2": iznākumsL = Picērija.lielums(); break;
				
				case "3": iznākumsV = Picērija.virskārtas(); break;
				
				case "0": if(iznākumsT != null && iznākumsL != 0) JOptionPane.showMessageDialog(null, "Pica tika izveidota!", "Ziņa", JOptionPane.INFORMATION_MESSAGE); break;
				
				default: JOptionPane.showMessageDialog(null, "Šāda darbība nepastāv!", "Kļūme!", JOptionPane.ERROR_MESSAGE); break;
			}
			
		}while(!izvele.equals("0"));
		if(iznākumsT == null)
				JOptionPane.showMessageDialog(null, "Nav izvēlēts picas tips!", "Ziņa", JOptionPane.INFORMATION_MESSAGE);
		if(iznākumsL == 0)
			JOptionPane.showMessageDialog(null, "Nav izvēlēts picas lielums!", "Ziņa", JOptionPane.INFORMATION_MESSAGE);
		}while(iznākumsT == null || iznākumsL == 0);
	}
	static void summa() {
		if(iznākumsT != null && iznākumsL != 0) {
		double galaSumma = 0, piegade = 0;
		String[] options = {"Jā", "Nē"};
		DecimalFormat df = new DecimalFormat("#.##");
		
			int n = JOptionPane.showOptionDialog(null, "Vai vēlaties, lai piegādā uz norādīto adresi?\nPiegāde - 9.99€", "Piegāde", 0, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
			
			if(n == 0)
				piegade = 9.99;
		if(iznākumsV != null)
		for(int i = 0; i < iznākumsV.length; i++)
			galaSumma = piegade + iznākumsL + iznākumsV[i];
		else
			galaSumma = piegade + iznākumsL;
			
		String[] options1 = {"Pasūtīt", "Atcelt"};
		int izvele = JOptionPane.showOptionDialog(null, "Kopsumma euro = "+df.format(galaSumma), "Gala summa", 0, JOptionPane.INFORMATION_MESSAGE, null, options1, options1[0]);
		
		switch (izvele) {
			case 0: 
				if(info == true) {
					
				}else
					JOptionPane.showMessageDialog(null, "Nav ievadīta kontaktinformācja!", "Ziņa", JOptionPane.INFORMATION_MESSAGE); break;
		}
		}else
			JOptionPane.showMessageDialog(null, "Nav izveidota pica!", "Ziņa", JOptionPane.INFORMATION_MESSAGE);
	}
	public static void main(String[] args) {
		
		do{
			izvele = JOptionPane.showInputDialog("1 - Pasūtītāja informācija | 2 - Izveidot picu | 3 - Gala summa | x - Apturēt programmu");
			
			switch(izvele.toLowerCase()){
				case "1": informācija(); break;
				
				case "2": izveidotPicu(); break;
				
				case "3": summa(); break;
				
				case "x": JOptionPane.showMessageDialog(null, "Programma tika apturēta!", "Ziņa", JOptionPane.INFORMATION_MESSAGE); break;
				
				default: JOptionPane.showMessageDialog(null, "Šāda darbība nepastāv!", "Kļūme!", JOptionPane.ERROR_MESSAGE); break;
			}
		}while(!izvele.equals("x"));
	}
}
