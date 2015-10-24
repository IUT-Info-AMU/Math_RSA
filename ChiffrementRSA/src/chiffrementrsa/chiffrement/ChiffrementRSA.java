/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chiffrementrsa.chiffrement;

import chiffrementrsa.utils.MathUtils;
import chiffrementrsa.utils.PrivateKey;
import chiffrementrsa.utils.PublicKey;
import java.math.BigInteger;

/**
 *
 * @author Gaëtan
 */
public class ChiffrementRSA {
    private static String message = null;
    private static ChiffrementRSA instance;

    public static ChiffrementRSA getInstance() {
        return instance;
    }

    public static String getMessage() {
        return message;
    }

    public static void setMessage(String message) {
        ChiffrementRSA.message = message;
    }
    
    public static String encrypt(String messageToEncrypt){
        MathUtils math = new MathUtils();
        String messageEncrypt = new String();
        for(char c : messageToEncrypt.toCharArray()){
            messageEncrypt+= math.mod(math.Power(new BigInteger((int)c+""),PublicKey.getPublicKeyC()), new BigInteger(PublicKey.getPublicKeyN()+"")) + " ";
        }
        return messageEncrypt;

    }
    
    public static String decrypt(String messageToDecrypt){
        MathUtils math = new MathUtils();
        String messageDecrypt = new String();
        String subMessage = new String();
        for(char c : messageToDecrypt.toCharArray()){
            if(c == ' '){

                messageDecrypt +=(char) (math.mod(math.Power(new BigInteger(subMessage), PrivateKey.getPrivateKeyU()),new BigInteger(PrivateKey.getPrivateKeyN()+""))).intValue();
                subMessage = "";
            }
            else{
                subMessage += c;
            }
        }
        return messageDecrypt;
    }

}
