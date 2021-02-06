package skola;
import java.io.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Picērija {
Object iznākumsObjektā;
String iznākumsTips, iznākumsLielums, piedevas = "", failaAtrasanasVieta;

	double lielums() {
		double summaL = 0;
		
		Object[] options = {"Maza pica: 20-25 cm ar 6 šķēlēm - 11.65€", "Vidēja pica: 30 cm ar 8 šķēlēm - 14.15€",
							"Liela pica: 35 cm ar 10 šķēlēm - 18.31€", "Īpaši liela pica: 40-45 cm ar 12 šķēlēm - 19.98€"};
        iznākumsObjektā = JOptionPane.showInputDialog(null, "Izmērs:", "Izvēlies picas izmēru", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        iznākumsLielums = iznākumsObjektā.toString();
        
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
	String tips() {
		Object[] options = {"Home Alone", "Hawaiian", "Pepperoni", "Hungry Man", "Meat Lovers", "Supreme"};
		
		iznākumsObjektā = JOptionPane.showInputDialog(null, "Veids:", "Izvēlies picas tipu/veidu", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        iznākumsTips = iznākumsObjektā.toString();
        
        return iznākumsTips;
	}
	double[] virskārtas() {
		int ja_ne, i = 0;
		String cena = "";
		piedevas = "";
		
		do {
		ja_ne = 1;
		
		Object[] options = {"Nevienu", "Bekons - 4.19€", "Ananāsi - 2.19€", "Šķiņķis - 4.19€", "BBQ mērce - 3.29€", "Siers - 3.89€", "Sēnes - 2.19€", "Ķiploki - 0.36€", "Tomāti - 2.19€", "Sīpoli - 0.49€", "Melnie pipari - 0.33€", "Zaļie lociņi - 0.49€", "Karija mērce - 1.69€"};
        iznākumsObjektā = JOptionPane.showInputDialog(null, "Piedevas:", "Izvēlies papildus picas virskārtas/piedevas", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        String iznākumsVirskārtas = iznākumsObjektā.toString();
        
        if(iznākumsVirskārtas != "Nevienu") {
        cena = cena + iznākumsVirskārtas.substring(iznākumsVirskārtas.length()-5, iznākumsVirskārtas.length()-1) + " ";
        if(i > 0)
        	piedevas = piedevas + "; ";
        piedevas = piedevas + iznākumsVirskārtas;
        }else {
        	cena += "0 ";
        }
        
        if(iznākumsVirskārtas != "Nevienu") {
        	String[] options1 = {"Jā", "Nē"};
        	ja_ne = JOptionPane.showOptionDialog(null, "Vai vēlaties pievienot vēl kādu piedevu?", "Jautājums", 0, JOptionPane.INFORMATION_MESSAGE, null, options1, options1[0]);
        	i += 1;
        }
		}while(ja_ne == 0 );
		
		if(cena == "0 ")
		i = 1;
		
		double[] summaV = new double[i];
		String[] cenas = cena.split(" ");
		
		for(int x = 0; x < i; x++)
			summaV[x] = Double.parseDouble(cenas[x]);
		
		return summaV;
	}
	void rakstit() {
		failaAtrasanasVieta = JOptionPane.showInputDialog("Ieraksti adresi, kurā saglabāt failu ar veiktajiem pasūtījumiem: ") + "/Pasūtījumi.txt";
		
		try {
			DecimalFormat df = new DecimalFormat("#.##");
			FileWriter fw = new FileWriter(failaAtrasanasVieta, true);
			PrintWriter raksta = new PrintWriter(fw);
			
			if(piedevas == "")
				piedevas = "Nav";
			
			raksta.println("\t\tPasūtījums - Pica:\nTips: "+iznākumsTips+"\nIzmērs: "+iznākumsLielums.substring(0, iznākumsLielums.length())+"\nPapildus piedevas: "+piedevas+
					"\n\t\tGala summa = "+df.format(Pica.galaSumma)+"€\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
			raksta.close();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Kļūda labojot failu!", "Kļūda!", JOptionPane.ERROR_MESSAGE);
		}
	}
	void nolasit() {
		if(failaAtrasanasVieta != null) {
		String teksts, pasūtījumi = "";
		
		try {
			FileReader fr = new FileReader(failaAtrasanasVieta);
			BufferedReader lasa = new BufferedReader(fr);
			
			while((teksts = lasa.readLine()) != null)
				pasūtījumi += teksts + "\n";
			
			JOptionPane.showMessageDialog(null, pasūtījumi, "Veiktie pasūtījumi", JOptionPane.PLAIN_MESSAGE);
			
			lasa.close();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Kļūda nolasot failu!", "Kļūda!", JOptionPane.ERROR_MESSAGE);
		}
		}else
			JOptionPane.showMessageDialog(null, "Nav veikti pasūtījumi!", "Ziņa", JOptionPane.INFORMATION_MESSAGE);
	}
}
