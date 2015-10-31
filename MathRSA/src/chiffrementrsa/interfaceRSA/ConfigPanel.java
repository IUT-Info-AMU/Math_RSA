/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chiffrementrsa.interfaceRSA;

import chiffrementrsa.utils.Config;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Gaëtan
 */
public class ConfigPanel extends JPanel{
	
    private JTextField champPrimeNumberMin = new JTextField();
    private JTextField champPrimeNumberMax = new JTextField();
    private JTextField champCMin = new JTextField();
    private JTextField champCMax = new JTextField();
    
    public ConfigPanel(){
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setBackground(Color.WHITE);
        setLayout(new GridLayout(7, 3, 1, 10));
        JButton lblP = new JButton("Valeur minimale des nombres premiers = ");
        add(lblP);
        lblP.setHorizontalAlignment(SwingConstants.CENTER);
        champPrimeNumberMin.setText(Config.getGeneratePrimeMin()+"");
        lblP.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
               int newGeneratePrimeMin = Integer.parseInt(champPrimeNumberMin.getText());
               JOptionPane popup = new JOptionPane();
               if(newGeneratePrimeMin > Config.getGeneratePrimeMax() || newGeneratePrimeMin <= 0){
                   popup.showMessageDialog(null, "Mauvaise valeur", "Erreur", JOptionPane.ERROR_MESSAGE);
                   System.out.println("Mauvaise valeur");
                   champPrimeNumberMin.setText(Config.getGeneratePrimeMin()+"");
               }          
               else{
                   Config.setGeneratePrimeMin(newGeneratePrimeMin);
                   popup.showMessageDialog(null, "Valeur changé", "Information", JOptionPane.INFORMATION_MESSAGE);
                   System.out.println("Valeur changé");
               }      
             }
        });
        add(champPrimeNumberMin);
        champPrimeNumberMin.setColumns(10);

        JButton lblQ = new JButton("Valeur maximale des nombres premiers = ");
        add(lblQ);
        lblQ.setHorizontalAlignment(SwingConstants.CENTER);
        champPrimeNumberMax.setText(Config.getGeneratePrimeMax()+"");
        lblQ.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
               JOptionPane popup = new JOptionPane();
               int newGeneratePrimeMax = Integer.parseInt(champPrimeNumberMax.getText());
               if(newGeneratePrimeMax < Config.getGeneratePrimeMin() || newGeneratePrimeMax <= 0){
                   popup.showMessageDialog(null, "Mauvaise valeur", "Erreur", JOptionPane.ERROR_MESSAGE);
                   System.out.println("Mauvaise valeur");
                   champPrimeNumberMax.setText(Config.getGeneratePrimeMax()+"");
               } 
               else{
                   Config.setGeneratePrimeMax(newGeneratePrimeMax);
                   popup.showMessageDialog(null, "Valeur changé", "Information", JOptionPane.INFORMATION_MESSAGE);
                   System.out.println("Valeur changé");
               }      

             }
        });
        add(champPrimeNumberMax);
        champPrimeNumberMax.setColumns(10);


        JButton lblN = new JButton("Valeur minimale de C = ");
        add(lblN);
        lblN.setHorizontalAlignment(SwingConstants.CENTER);
        champCMin.setText(Config.getMinC()+"");
        lblN.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
               JOptionPane popup = new JOptionPane();
               int newGeneratePrimeMinC = Integer.parseInt(champCMin.getText());
               if(newGeneratePrimeMinC > Config.getMaxC() || newGeneratePrimeMinC <= 0){
                   popup.showMessageDialog(null, "Mauvaise valeur", "Erreur", JOptionPane.ERROR_MESSAGE);
                   System.out.println("Mauvaise valeur");
                   champCMin.setText(Config.getMinC()+"");
               }   
               else{
                   Config.setMinC(newGeneratePrimeMinC);
                   popup.showMessageDialog(null, "Valeur changé", "Information", JOptionPane.INFORMATION_MESSAGE);
                   System.out.println("Valeur changé");
               }      

             }
        });
        add(champCMin);
        champCMin.setColumns(10);


        JButton lblE = new JButton("Valeur maximale de C = ");
        add(lblE);
        lblE.setHorizontalAlignment(SwingConstants.CENTER);
        champCMax.setText(Config.getMaxC()+"");
        lblE.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
               JOptionPane popup = new JOptionPane();
               int newGeneratePrimeMaxC = Integer.parseInt(champCMax.getText());
               if(newGeneratePrimeMaxC < Config.getMinC() || newGeneratePrimeMaxC <= 0){
                   popup.showMessageDialog(null, "Mauvaise valeur", "Erreur", JOptionPane.ERROR_MESSAGE);
                   System.out.println("Mauvaise valeur");
                   champCMax.setText(Config.getMaxC()+"");
               }
               else{
                   Config.setMaxC(newGeneratePrimeMaxC);
                   popup.showMessageDialog(null, "Valeur changé", "Information", JOptionPane.INFORMATION_MESSAGE);
                   System.out.println("Valeur changé");
               }

             }
        });
        add(champCMax);
        champCMax.setColumns(10);;
    }
}

