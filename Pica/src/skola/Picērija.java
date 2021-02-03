package skola;
import javax.swing.JOptionPane;

public class Picērija {
	double lielums() {
		double summaL = 0;
		Object[] options = {"Maza pica: 20-25 cm ar 6 šķēlēm - 11.65€", "Vidēja pica: 30 cm ar 8 šķēlēm - 14.15€",
							"Liela pica: 35 cm ar 10 šķēlēm - 18.31€", "Īpaši liela pica: 40-45 cm ar 12 šķēlēm - 19.98€"};
        Object iznākumsObjektā = JOptionPane.showInputDialog(null, "Izmērs:", "Izvēlies picas izmēru", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        String iznākumsLielums = iznākumsObjektā.toString();
        
        if(iznākumsLielums.contains("11.65"))
        	summaL = 11.65;
        else if(iznākumsLielums.contains("14.15"))
        	summaL = 14.15;
        else if(iznākumsLielums.contains("18.31"))
        	summaL = 18.31;
        else
        	summaL = 19.98;
        
        return summaL;
	}
	void tips() {
		
	}
	void virskārtas() {
		
	}
}
