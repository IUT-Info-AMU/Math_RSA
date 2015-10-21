/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chiffrementrsa.chiffrement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

/**
 *
 * @author Gaëtan
 */
public class encryptionOfFile {
    public Charset charset = Charset.forName("UTF-8");
    void encrypt(String inputFile, String outputFile){
        FileInputStream inputFileStream = null;
        Writer writer = null;
        try {
            inputFileStream = new FileInputStream(inputFile);
            writer = new OutputStreamWriter(new FileOutputStream(outputFile), charset);
            //nombre de byte lu par tour de boucle
            byte[] buf = new byte[4096];
            int n = 0;
            ChiffrementRSA chiffrement = new ChiffrementRSA();
            while( (n = inputFileStream.read(buf)) >= 0 ){
                writer.write(chiffrement.encrypt(buf.toString()));
            }
                
        } catch (FileNotFoundException e) {
           // Cette exception est levée si l'objet FileInputStream ne trouve
           // aucun fichier
           e.printStackTrace();
        } catch (IOException e) {
           // Celle-ci se produit lors d'une erreur d'écriture ou de lecture
           e.printStackTrace();
        } finally {
           // On ferme nos flux de données dans un bloc finally pour s'assurer
           // que ces instructions seront exécutées dans tous les cas même si
           // une exception est levée !
            try {
                if (inputFileStream != null)
                   inputFileStream.close();
                } catch (IOException e) {
                   e.printStackTrace();
                }

            try {
                if (writer != null)
                     writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
    
    void decrypt(String inputFile, String outputFile){
        FileInputStream inputFileStream = null;
        Writer writer = null;
        try {
            inputFileStream = new FileInputStream(inputFile);
            writer = new OutputStreamWriter(new FileOutputStream(outputFile), charset);
            //nombre de byte lu par tour de boucle
            byte[] buf = new byte[4096];
            int n = 0;
            ChiffrementRSA chiffrement = new ChiffrementRSA();
            while( (n = inputFileStream.read(buf)) >= 0 ){
                writer.write(chiffrement.decrypt(buf.toString()));
            }
                
        } catch (FileNotFoundException e) {
           // Cette exception est levée si l'objet FileInputStream ne trouve
           // aucun fichier
           e.printStackTrace();
        } catch (IOException e) {
           // Celle-ci se produit lors d'une erreur d'écriture ou de lecture
           e.printStackTrace();
        } finally {
           // On ferme nos flux de données dans un bloc finally pour s'assurer
           // que ces instructions seront exécutées dans tous les cas même si
           // une exception est levée !
            try {
                if (inputFileStream != null)
                   inputFileStream.close();
                } catch (IOException e) {
                   e.printStackTrace();
                }

            try {
                if (writer != null)
                     writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

}
