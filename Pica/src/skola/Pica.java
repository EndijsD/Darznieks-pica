package skola;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Pica {
static boolean info = false;
static String vards, uzvards, adrese = "Nav", izvele, iznākumsT;
static int numurs, atbilde;
static Picērija Picērija = new Picērija();
static double iznākumsL, galaSumma = 0, piegade = 0;
static double[] iznākumsV;
static String[] ja_ne = {"Jā", "Nē"};

	static void informācija() {
		do {
			vards = JOptionPane.showInputDialog("Ievadi savu vārdu: ");
			uzvards = JOptionPane.showInputDialog("Ievadi savu uzvārdu: ");
			numurs = Integer.parseInt(JOptionPane.showInputDialog("Ievadi savu tālruni: "));
			adrese = JOptionPane.showInputDialog("Ievadi savu adresi: ");
			
			info = true;
			
			atbilde = JOptionPane.showOptionDialog(null, "Vārds/uzvārds: "+vards+" "+uzvards+"\n"+
											             "Tālrunis: "+numurs+"\nAdrese: "+adrese,
											             "Vai ievadītā informācija ir pareiza?", 0, JOptionPane.QUESTION_MESSAGE, null, ja_ne, ja_ne[0]);
		}while(atbilde == 1);
	}
	static void izveidotPicu() {
		do {
			do {
				izvele = JOptionPane.showInputDialog("1 - Picas tips | 2 - Picas lielums | 3 - Papildus picas virskārtas/piedevas | 0 - Pabeigt picas taisīšanu");
				
				switch (izvele) {
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
		if(iznākumsT != null) {
			piegade = 0;
			double iznākumsVKopā = 0;
			DecimalFormat df = new DecimalFormat("#.##");
			
			atbilde = JOptionPane.showOptionDialog(null, "Vai vēlaties, lai piegādā uz jūsu norādīto adresi?\nAdrese: "+adrese+"\nPiegāde - 9.99€", "Piegāde", 0, JOptionPane.QUESTION_MESSAGE, null, ja_ne, ja_ne[0]);
				
			if(atbilde == 0)
				piegade = 9.99;
				
			if(iznākumsV != null) {
				for(int i = 0; i < iznākumsV.length; i++)
				iznākumsVKopā = iznākumsVKopā + iznākumsV[i];
			
			galaSumma = piegade + iznākumsL + iznākumsVKopā;
			} else
				galaSumma = piegade + iznākumsL;
			
			String[] opcijas = {"Pasūtīt", "Atcelt"};
			int izvele = JOptionPane.showOptionDialog(null, "Izveidotā pica:\nTips: "+Picērija.iznākumsTips+"\nIzmērs: "+Picērija.iznākumsLielums+"\nPapildus piedevas: "+Picērija.piedevas+"\nPiegāde: "+piegade+"€"+
															"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\tKopsumma euro = "+df.format(galaSumma)+"€", "Gala summa", 0, JOptionPane.INFORMATION_MESSAGE, null, opcijas, opcijas[0]);
			if(izvele == 0)
				if(info == true) {
					Picērija.rakstit();
				} else
					JOptionPane.showMessageDialog(null, "Nav ievadīta kontaktinformācja!", "Ziņa", JOptionPane.INFORMATION_MESSAGE);
		} else
			JOptionPane.showMessageDialog(null, "Nav izveidota pica!", "Ziņa", JOptionPane.INFORMATION_MESSAGE);
	}
	public static void main(String[] args) {
		do{
			izvele = JOptionPane.showInputDialog("1 - Pasūtītāja informācija | 2 - Izveidot picu | 3 - Gala summa | 4 - Veiktie pasūtījumi | x - Apturēt programmu");
			izvele = izvele.toLowerCase();
			
			switch (izvele) {
				case "1": informācija(); break;
				
				case "2": izveidotPicu(); break;
				
				case "3": summa(); break;
				
				case "4": Picērija.nolasit(); break;
				
				case "x": JOptionPane.showMessageDialog(null, "Programma tika apturēta!", "Ziņa", JOptionPane.INFORMATION_MESSAGE); break;
				
				default: JOptionPane.showMessageDialog(null, "Šāda darbība nepastāv!", "Kļūda!", JOptionPane.ERROR_MESSAGE); break;
			}
		}while(!izvele.equals("x"));
	}
}
