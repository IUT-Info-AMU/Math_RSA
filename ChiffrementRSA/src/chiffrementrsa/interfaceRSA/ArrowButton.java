package chiffrementrsa.interfaceRSA;

import chiffrementrsa.chiffrement.ChiffrementRSA;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ArrowButton {
	private ImageIcon FlecheH = new ImageIcon ("./images/flechehaut2.png");
	private ImageIcon FlecheB = new ImageIcon ("./images/flechebas2.png");

	public JPanel createArrowButton() {
		FlowLayout Fl = new FlowLayout();
		final JRadioButton imageH = new JRadioButton(FlecheH);
		imageH.setBackground(null);
		imageH.setBorderPainted(false);
		JPanel petitpetitSud = new  JPanel();
		petitpetitSud.setLayout(Fl);
		petitpetitSud.add(imageH);
		final JRadioButton imageB = new JRadioButton (FlecheB);
		imageB.setBackground(null);
		imageB.setBorderPainted(false);
		imageH.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				 ImageIcon Fleche4 = new ImageIcon ("./images/flechehaut4.png");
				 imageH.setIcon(Fleche4);
				 imageB.setIcon(FlecheB);
                                 //decryptage
                                 ChiffrementRSA.setMessage(ChiffrementRSA.encrypt("Bravo ! Tu es fort ! Une balade heureuse, dans la nature, par gaëtan"));
                                 System.out.println(ChiffrementRSA.getMessage());
			}
		
			
			
			
		});
		imageB.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//cryptage
				 ImageIcon Fleche4 = new ImageIcon ("./images/flechebas4.png");
				 imageB.setIcon(Fleche4);
				 imageH.setIcon(FlecheH);
                                 ChiffrementRSA.setMessage(ChiffrementRSA.decrypt(ChiffrementRSA.getMessage()));
                                 System.out.println(ChiffrementRSA.getMessage());
			}
			
			
				
			
			
		});
		imageB.setContentAreaFilled(false);
		imageH.setContentAreaFilled(false);
		petitpetitSud.add (imageB);	
		petitpetitSud.setBackground (Color.white);
		return petitpetitSud;
	}
	
}
