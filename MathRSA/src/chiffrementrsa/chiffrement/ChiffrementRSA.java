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
    private String message = null;
    private PublicKey publicKey;
    private PrivateKey privateKey;

    public ChiffrementRSA(){
        initPublicKeyAndPrivateKey();
    }
    
    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void initPublicKeyAndPrivateKey() {
        this.publicKey = new PublicKey();
        this.privateKey = new PrivateKey(this.publicKey);
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String encrypt(String messageToEncrypt){
        MathUtils math = new MathUtils();
        String messageEncrypt = new String();
        for(char c : messageToEncrypt.toCharArray()){
            messageEncrypt+= math.mod(math.Power(new BigInteger((int)c+""),publicKey.getPublicKeyC()), new BigInteger(publicKey.getPublicKeyN()+"")) + " ";
        }
        return messageEncrypt;

    }
    
    public String decrypt(String messageToDecrypt){
        MathUtils math = new MathUtils();
        String messageDecrypt = new String();
        String subMessage = new String();
        for(char c : messageToDecrypt.toCharArray()){
            if(c == ' '){

                messageDecrypt +=(char) (math.mod(math.Power(new BigInteger(subMessage), privateKey.getPrivateKeyU()),new BigInteger(privateKey.getPrivateKeyN()+""))).intValue();
                subMessage = "";
            }
            else{
                subMessage += c;
            }
        }
        return messageDecrypt;
    }

}
