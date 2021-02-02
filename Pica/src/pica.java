import javax.swing.JOptionPane;

public class pica {

	
	static void informācija() {
		
	}
	static void lielums() {
		
	}
	static void tips() {
		
	}
	static void virskārta() {
		
	}
	static void summa() {
		
	}
	public static void main(String[] args) {
		String izvele;
		
		do{
			izvele = JOptionPane.showInputDialog("1 - Pasūtītāja informācija | 2 - Picas lielums | 3 - Picas tips | 4 - Picas virskārtas/piedevas | 5 - Gala summa | x - Apturēt programmu");
			
			switch(izvele.toLowerCase()){
				case "1": informācija(); break;
				
				case "2": lielums(); break;
				
				case "3": tips(); break;
				
				case "4": virskārta(); break;
				
				case "5": summa(); break;
				
				case "x": JOptionPane.showMessageDialog(null, "Programma tika apturēta!"); break;
				
				default: JOptionPane.showMessageDialog(null, "Šāda darbība nepastāv!", "Kļūme!", JOptionPane.ERROR_MESSAGE); break;
			}
		}while(!izvele.equals("x"));
	}
}
