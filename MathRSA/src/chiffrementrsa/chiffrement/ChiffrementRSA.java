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
    
    /**
     * Constructeur, utilise simplement la fonction initPublicKeyAndPrivateKey()
     **/
    public ChiffrementRSA(){
        initPublicKeyAndPrivateKey();
    }
    
    /**
     * Retourne la donnée membre publicKey
     * @return publicKey de type PublicKey
     **/
    public PublicKey getPublicKey() {
        return publicKey;
    }

    /**
     * Initialise la clef publique et privée
     **/
    public void initPublicKeyAndPrivateKey() {
        message = null;
        this.publicKey = new PublicKey();
        this.privateKey = new PrivateKey(this.publicKey);
    }
    
    /**
     * Retourne la donnée membre privateKey
     * @return privateKey de type PrivateKey
     **/
    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    /**
     * Retourne la donnée membre message
     * @return message de type string
     **/
    public String getMessage() {
        return message;
    }
    
    /**
     * Assigne une nouvelle valeur à message
     * @param message de type string
     **/
    public void setMessage(String message) {
        this.message = message;
    }
    
    /**
     * Retourne le message crypté
     * @param messageToEncrypt de type string, la chaine à crypter
     * @return messageEncrypt de type string, le message crypté
     **/
    public String encrypt(String messageToEncrypt){
        MathUtils math = new MathUtils();
        String messageEncrypt = new String();
        for(char c : messageToEncrypt.toCharArray()){
            messageEncrypt+= math.mod(math.Power(new BigInteger((int)c+""),publicKey.getPublicKeyC()), new BigInteger(publicKey.getPublicKeyN()+"")) + " ";
        }
        math = null;
        return messageEncrypt;

    }
    
    /**
     * Retourne le message Décrypté
     * @param messageToDecrypt de type string, la chaine à Décrypter
     * @return messageDecrypt de type string, le message Décrypté
     **/
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
        math = null;
        subMessage = null;
        return messageDecrypt;
    }

}
