/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chiffrementrsa;

import chiffrementrsa.utils.MathUtils;
import chiffrementrsa.utils.PrivateKey;
import chiffrementrsa.utils.PublicKey;
import java.math.BigInteger;

/**
 *
 * @author Gaëtan
 */
public class ChiffrementRSA {
    
    String encrypt(String messageToEncrypt){
        MathUtils math = new MathUtils();
        String messageEncrypt = new String();
        for(char c : messageToEncrypt.toCharArray()){
            messageEncrypt+= math.mod(math.Power(new BigInteger((int)c+""),PublicKey.getInstance().getPublicKeyC()), new BigInteger(PublicKey.getInstance().getPublicKeyN()+"")) + " ";
        }
        return messageEncrypt;

    }
    
    String decrypt(String messageToDecrypt){
        MathUtils math = new MathUtils();
        String messageDecrypt = new String();
        String subMessage = new String();
        for(char c : messageToDecrypt.toCharArray()){
            if(c == ' '){

                messageDecrypt +=(char) (math.mod(math.Power(new BigInteger(subMessage), PrivateKey.getInstance().getPrivateKeyU()),new BigInteger(PrivateKey.getInstance().getPrivateKeyN()+""))).intValue();
                subMessage = "";
            }
            else{
                subMessage += c;
            }
        }
        return messageDecrypt;
    }
    
    public static void main(String[] args) {
        ChiffrementRSA chiffrement = new ChiffrementRSA();
        String message = new String(chiffrement.encrypt("Bravo ! Tu es fort ! Une balade heureuse, dans la nature, par gaëtan"));
        System.out.println(message);
        System.out.println(chiffrement.decrypt(message));
        
    }  
}
