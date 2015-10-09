/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chiffrementrsa;

import chiffrementrsa.utils.MathUtils;
import chiffrementrsa.utils.PrivateKey;
import chiffrementrsa.utils.PublicKey;
import chiffrementrsa.utils.RSAKey;
import java.math.BigInteger;

/**
 *
 * @author Gaëtan
 */
public class ChiffrementRSA {
    
    void createKeys(){
        new PublicKey();
        new PrivateKey();
    }
    
    String encrypt(String messageToEncrypt){
        MathUtils math = new MathUtils();
        String messageEncrypt = new String();
        for(char c : messageToEncrypt.toCharArray()){
            messageEncrypt+= math.mod(math.Power(new BigInteger((int)c+""),7), new BigInteger(5141+"")) + " ";
        }
        return messageEncrypt;

    }
    
    public static void main(String[] args) {
        ChiffrementRSA chiffrement = new ChiffrementRSA();
        chiffrement.createKeys();
        System.out.println(chiffrement.encrypt("Bonjour !"));
        
    }  
}
