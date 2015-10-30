package chiffrementrsa.interfaceRSA;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

public class WindowRSA extends JFrame {
	private JPanel principal = new JPanel();
	private RSA2015 Interface = new RSA2015 ();
	private ConfigPanel configPanel = new ConfigPanel();
	WindowRSA () {
		
		super ();
		setLayout (new BorderLayout ());
                principal.setLayout(new OverlayLayout(principal));
                principal.add (Interface);
                Interface.setVisible(true);
                principal.add(configPanel);
                configPanel.setVisible(false);
                add(principal);
                createMenu();
	}
        
        public void createMenu(){
            JMenuBar menubar = new JMenuBar();
            JMenu menuFile = new JMenu("Fichier");
            JMenuItem menuFilePrincipal = new JMenuItem("RSA");
            menuFilePrincipal.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    configPanel.setVisible(false);
                    Interface.setVisible(true);
                    
                }        
            });
            JMenuItem menuFileClose = new JMenuItem("Fermer");
            menuFileClose.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    System.exit(0);
                }        
            });
            menuFile.add(menuFilePrincipal);
            menuFile.add(menuFileClose);
            
            JMenu menuUtil = new JMenu("Outils");
            JMenuItem menuUtilConfig = new JMenuItem("Config");
            menuUtilConfig.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    //modification config
                    Interface.setVisible(false);
                    configPanel.setVisible(true);
                }        
            });
            JMenuItem menuUtilJavaDoc = new JMenuItem("JavaDoc");
            menuUtilJavaDoc.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    try {
                        //ouvre la javadoc
                        Desktop desktop = Desktop.getDesktop(); 
                        desktop.open(new File("./javadoc/index.html"));
                    } catch (IOException ex) {
                        Logger.getLogger(WindowRSA.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("Impossible d'ouvrir la javadoc !");
                    }
                }       
            });
            menuUtil.add(menuUtilConfig);
            menuUtil.add(menuUtilJavaDoc);
            
            menubar.add(menuFile);
            menubar.add(menuUtil);
            this.setJMenuBar(menubar);
        }

	public static void main (String[] args) {
		
		WindowRSA Window = new WindowRSA ();
		Window.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		Window.setTitle ("RSA2015");
		Window.pack ();
		Window.setVisible (true);
	}

}
