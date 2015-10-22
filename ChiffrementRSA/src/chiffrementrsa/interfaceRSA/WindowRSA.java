package chiffrementrsa.interfaceRSA;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;

public class WindowRSA extends JFrame {
	
	private RSA2015 Interface = new RSA2015 ();
	
	WindowRSA () {
		
		super ();
		setLayout (new BorderLayout ());
		add (Interface);
	}

	public static void main (String[] args) {
		
		WindowRSA Window = new WindowRSA ();
		Window.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		Window.setTitle ("RSA2015");
		Window.pack ();
		Window.setVisible (true);
	}

}
