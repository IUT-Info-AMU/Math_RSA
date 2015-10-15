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
    
    String decrypt(String messageToDecrypt){
        MathUtils math = new MathUtils();
        String messageDecrypt = new String();
        String subMessage = new String();
        for(char c : messageToDecrypt.toCharArray()){
            if(c == ' '){
                messageDecrypt += (char)(math.mod(math.Power(new BigInteger(Integer.parseInt(subMessage.substring(0))+""),4279), new BigInteger(5141+""))).intValue();
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
        chiffrement.createKeys();
        String message = new String(chiffrement.encrypt("Bravo"));
        System.out.println(message);
        System.out.println(chiffrement.decrypt(message));
        
    }  
}
