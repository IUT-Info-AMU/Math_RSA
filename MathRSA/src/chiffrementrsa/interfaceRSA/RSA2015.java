package chiffrementrsa.interfaceRSA;

import chiffrementrsa.chiffrement.ChiffrementRSA;
import chiffrementrsa.utils.Config;
import chiffrementrsa.utils.PrimeNumber;
import chiffrementrsa.utils.PrivateKey;
import chiffrementrsa.utils.PublicKey;
import java.awt.*;        
import java.awt.event.MouseAdapter;
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
import javax.swing.JRadioButton;
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
        private ImageIcon FlecheH = new ImageIcon ("./images/flechehaut2.png");
	private ImageIcon FlecheB = new ImageIcon ("./images/flechebas2.png");
        private JTextField champP = new JTextField();
        private JTextField champQ = new JTextField();
        private JTextField champN = new JTextField();
        private JTextField champC = new JTextField();
        private JTextField champM = new JTextField();
        private JTextField champU = new JTextField();
        
        private ChiffrementRSA chiffrement = new ChiffrementRSA();
	
	
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
                                        champP.setText(chiffrement.getPublicKey().getPrimeNumber().getPrimeP()+"");
					petitNord.add(champP);
					champP.setColumns(10);
					JLabel lblInput = new JLabel("1. Génère P "); 
				    petitNord.add(lblInput);
					JLabel lblQ = new JLabel("Q=");
					petitNord.add(lblQ);
					lblQ.setHorizontalAlignment(SwingConstants.CENTER);
                                        champQ.setText(chiffrement.getPublicKey().getPrimeNumber().getPrimeQ()+"");
					petitNord.add(champQ);
					champQ.setColumns(10);

					JLabel lblInput2 = new JLabel("2. Génère Q "); 
				    petitNord.add(lblInput2);
					
					JLabel lblN = new JLabel("N=");
					petitNord.add(lblN);
					lblN.setHorizontalAlignment(SwingConstants.CENTER);
                                        champN.setText(chiffrement.getPublicKey().getPublicKeyN()+"");
					petitNord.add(champN);
					champN.setColumns(10);
					
					JLabel lblInput3 = new JLabel("3. Calcule N "); 
				    petitNord.add(lblInput3);
					JLabel lblE = new JLabel("C=");
					petitNord.add(lblE);
					lblE.setHorizontalAlignment(SwingConstants.CENTER);
                                        champC.setText(chiffrement.getPublicKey().getPublicKeyC()+"");
					petitNord.add(champC);
					champC.setColumns(10);
					JLabel lblInput4 = new JLabel("4. Génère C "); 
				    petitNord.add(lblInput4);
					
                                    JLabel lblM = new JLabel("M=");
					petitNord.add(lblM);
					lblM.setHorizontalAlignment(SwingConstants.CENTER);
                                        champM.setText(chiffrement.getPublicKey().getM()+"");
					petitNord.add(champM);
					champM.setColumns(10);
					JLabel lblInput5 = new JLabel("5. Calcule M "); 
				    petitNord.add(lblInput5);

                                    JLabel lblU = new JLabel("U=");
                                        petitNord.add(lblU);
                                        lblU.setHorizontalAlignment(SwingConstants.CENTER);
                                        champU.setText(chiffrement.getPrivateKey().getPrivateKeyU()+"");
                                        petitNord.add(champU);
                                        champU.setColumns(10);
                                        JLabel lblInput6 = new JLabel("6. Calcule U "); 
				    petitNord.add(lblInput6);

				    lblInput.setHorizontalAlignment(SwingConstants.CENTER);
				    lblInput2.setHorizontalAlignment(SwingConstants.CENTER);
				    lblInput3.setHorizontalAlignment(SwingConstants.CENTER);
				    lblInput4.setHorizontalAlignment(SwingConstants.CENTER);
				    lblInput5.setHorizontalAlignment(SwingConstants.CENTER);
                                    lblInput6.setHorizontalAlignment(SwingConstants.CENTER);
		         
				}
				
				petitCentre = new JPanel();
				JPanel fp = new JPanel(new FlowLayout());
				grandCentre.add(petitCentre, BorderLayout.CENTER);
				petitCentre.setLayout(new GridLayout(2, 2, 0, 0));
				{
					JLabel lblPub = new JLabel("Clé publique=");
					petitCentre.add(lblPub);
					fp.add(lblPub);
                                        JTextField champPub = new JTextField();
                                        champPub.setText("[" + chiffrement.getPublicKey().getPublicKeyN() + "," + chiffrement.getPublicKey().getPublicKeyC() + "]" );
					petitCentre.add(champPub);
					fp.add(champPub);
					champPub.setColumns(10);
					JLabel lblPriv = new JLabel("Clé privée=");
					petitCentre.add(lblPriv);
					fp.add(lblPriv);
                                        JTextField champPriv = new JTextField();
                                        champPriv.setText("[" + chiffrement.getPrivateKey().getPrivateKeyN() + "," + chiffrement.getPrivateKey().getPrivateKeyU() + "]" );
					petitCentre.add(champPriv);
					fp.add(champPriv);
					champPriv.setColumns(10);
					JButton GO = new JButton("GO");
                                        GO.addMouseListener(new MouseAdapter(){
                                            public void mouseClicked(MouseEvent e) {
                                                //Nouvelle Génération de clef public et privée
                                                chiffrement.initPublicKeyAndPrivateKey();
                                                champP.setText(chiffrement.getPublicKey().getPrimeNumber().getPrimeP()+"");
                                                champQ.setText(chiffrement.getPublicKey().getPrimeNumber().getPrimeQ()+"");
                                                champN.setText(chiffrement.getPublicKey().getPublicKeyN()+"");
                                                champC.setText(chiffrement.getPublicKey().getPublicKeyC()+"");
                                                champM.setText(chiffrement.getPublicKey().getM()+"");
                                                champU.setText(chiffrement.getPrivateKey().getPrivateKeyU()+"");
                                                champPub.setText("[" + chiffrement.getPublicKey().getPublicKeyN() + "," + chiffrement.getPublicKey().getPublicKeyC() + "]" );
                                                champPriv.setText("[" + chiffrement.getPrivateKey().getPrivateKeyN() + "," + chiffrement.getPrivateKey().getPrivateKeyU() + "]" );
                                             }
                                        });
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
			decryptLayout.add (champDecrypt);
			decryptLayout.setBorder (BorderFactory.createTitledBorder (BorderFactory.createLineBorder (Color.black, 2), textDecrypt));
                        
			petitSud.setBackground (Color.white);
			petitSud.setLayout (new BorderLayout ());
			petitSud.add (encryptLayout, BorderLayout.NORTH);
			petitSud.add (decryptLayout, BorderLayout.SOUTH);
			
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
                                public void mouseClicked(MouseEvent e) {
                                         ImageIcon Fleche4 = new ImageIcon ("./images/flechehaut4.png");
                                         imageH.setIcon(Fleche4);
                                         imageB.setIcon(FlecheB);
                                         //decryptage
                                         chiffrement.setMessage(chiffrement.decrypt(chiffrement.getMessage()));
                                         System.out.println(chiffrement.getMessage());
                                         champEncrypt.setText(chiffrement.getMessage());
                                }
                        });
                        imageB.addMouseListener(new MouseAdapter(){
                                public void mouseClicked(MouseEvent e) {
                                        // TODO Auto-generated method stub
                                        //cryptage
                                         ImageIcon Fleche4 = new ImageIcon ("./images/flechebas4.png");
                                         imageB.setIcon(Fleche4);
                                         imageH.setIcon(FlecheH);
                                         chiffrement.setMessage(chiffrement.encrypt(champEncrypt.getText()));
                                         System.out.println(chiffrement.getMessage());
                                          champDecrypt.setText(chiffrement.getMessage());
                                }
                        });
                        imageB.setContentAreaFilled(false);
                        imageH.setContentAreaFilled(false);
                        petitpetitSud.add (imageB);	
                        petitpetitSud.setBackground (Color.white);                 

                        petitSud.add(petitpetitSud);
			
		}
		
   }// RSA2015 () 
   
}
