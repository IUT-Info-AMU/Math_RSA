package chiffrementrsa.interfaceRSA;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonGo extends JButton{
	public ButtonGo(){
		super("GO");
		addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//generer clef

			}	
		});
	}
}
