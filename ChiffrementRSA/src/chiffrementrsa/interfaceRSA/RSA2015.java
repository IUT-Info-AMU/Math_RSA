package chiffrementrsa.interfaceRSA;

import chiffrementrsa.chiffrement.ChiffrementRSA;
import java.awt.*;        
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
 

public class RSA2015 extends JPanel {
   /**
	 * 
	 */
	private static final long serialVersionUID = -1248729126482607229L;
	
	private JPanel grandCentre;
	private JPanel petitNord;
	private JPanel petitCentre;
	
	private String textEncrypt = "Texte à crypter";
	private String textDecrypt = "Texte à décrypter";
	private JTextArea champEncrypt = new JTextArea ();
	private JTextArea champDecrypt = new JTextArea ();
	
	
   /** Constructor to setup the UI components and event handling */
   public RSA2015 () 
   {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		{
			grandCentre = new JPanel();
			
			add(grandCentre, BorderLayout.CENTER);
			grandCentre.setLayout(new BorderLayout(0, 0));
			{
				petitNord = new JPanel();
				petitNord.setBackground(Color.WHITE);
				grandCentre.add(petitNord, BorderLayout.NORTH);
				petitNord.setLayout(new GridLayout(7, 3, 1, 10));
				{
					JLabel lblP = new JLabel("P=");
					petitNord.add(lblP);
					lblP.setHorizontalAlignment(SwingConstants.CENTER);
					JTextField champP = new JTextField();
					petitNord.add(champP);
					champP.setColumns(10);
					JLabel lblInput = new JLabel("1. Génère P "); 
				    petitNord.add(lblInput);
					
					JLabel lblQ = new JLabel("Q=");
					petitNord.add(lblQ);
					lblQ.setHorizontalAlignment(SwingConstants.CENTER);
					JTextField champQ = new JTextField();
					petitNord.add(champQ);
					champQ.setColumns(10);

					JLabel lblInput2 = new JLabel("2. Génère Q "); 
				    petitNord.add(lblInput2);
					
					JLabel lblN = new JLabel("N=");
					petitNord.add(lblN);
					lblN.setHorizontalAlignment(SwingConstants.CENTER);
					JTextField champN = new JTextField();
					petitNord.add(champN);
					champN.setColumns(10);
					
					JLabel lblInput3 = new JLabel("3. Calcule N "); 
				    petitNord.add(lblInput3);
					JLabel lblE = new JLabel("E=");
					petitNord.add(lblE);
					lblE.setHorizontalAlignment(SwingConstants.CENTER);
					JTextField champE = new JTextField();
					petitNord.add(champE);
					champE.setColumns(10);
					JLabel lblInput4 = new JLabel("4. Génère E "); 
				    petitNord.add(lblInput4);
					JLabel lblD = new JLabel("D=");
					petitNord.add(lblD);
					lblD.setHorizontalAlignment(SwingConstants.CENTER);
					JTextField champD = new JTextField();
					petitNord.add(champD);
					champD.setColumns(10);
					JLabel lblInput5 = new JLabel("5. Calcule D "); 
				    petitNord.add(lblInput5);
				    lblInput.setHorizontalAlignment(SwingConstants.CENTER);
				    lblInput2.setHorizontalAlignment(SwingConstants.CENTER);
				    lblInput3.setHorizontalAlignment(SwingConstants.CENTER);
				    lblInput4.setHorizontalAlignment(SwingConstants.CENTER);
				    lblInput5.setHorizontalAlignment(SwingConstants.CENTER);			    
		         
				}
				
				petitCentre = new JPanel();
				JPanel fp = new JPanel(new FlowLayout());
				grandCentre.add(petitCentre, BorderLayout.CENTER);
				petitCentre.setLayout(new GridLayout(2, 2, 0, 0));
				{
					JLabel lblPriv = new JLabel("Clé privée=");
					petitCentre.add(lblPriv);
					fp.add(lblPriv);
					JTextField champPub = new JTextField();
					petitCentre.add(champPub);
					fp.add(champPub);
					champPub.setColumns(10);
					
					JLabel lblPub = new JLabel("Clé publique=");
					petitCentre.add(lblPub);
					fp.add(lblPub);
					JTextField champPriv = new JTextField();
					petitCentre.add(champPriv);
					fp.add(champPriv);
					champPriv.setColumns(10);
					ButtonGo GO = new ButtonGo();
					petitCentre.add(GO);
					fp.add(GO);
				    petitCentre.add(BorderLayout.CENTER,fp);
				    petitCentre.setBackground(Color.WHITE);
				    fp.setBackground(Color.WHITE);
				}
				
			}
			
			
			JPanel petitSud = new JPanel ();
			grandCentre.add(petitSud, BorderLayout.SOUTH);
			
			
			JPanel encryptLayout = new JPanel ();
			encryptLayout.setBackground (Color.white);
			champEncrypt.setPreferredSize (new Dimension (500,100));
			champEncrypt.setLineWrap (true);
			encryptLayout.add (champEncrypt);
			encryptLayout.setBorder (BorderFactory.createTitledBorder (BorderFactory.createLineBorder (Color.black, 2), textEncrypt));
			
			JPanel decryptLayout = new JPanel ();
			decryptLayout.setBackground (Color.white);
			champDecrypt.setPreferredSize (new Dimension (500, 100));
			champDecrypt.setLineWrap (true);
                        if(ChiffrementRSA.getMessage() != null){
                            champDecrypt.setText(ChiffrementRSA.getMessage());
                            System.out.println(ChiffrementRSA.getMessage());
                        } 
			decryptLayout.add (champDecrypt);
			decryptLayout.setBorder (BorderFactory.createTitledBorder (BorderFactory.createLineBorder (Color.black, 2), textDecrypt));
                        
			petitSud.setBackground (Color.white);
			petitSud.setLayout (new BorderLayout ());
			petitSud.add (encryptLayout, BorderLayout.NORTH);
			petitSud.add (decryptLayout, BorderLayout.SOUTH);
			
			petitSud.add(new ArrowButton().createArrowButton());
			
		}
		
   }// RSA2015 () 
   
   public static void main (String[] args) {
	   
	   //new RSA2015 ();
   }  
   
}
