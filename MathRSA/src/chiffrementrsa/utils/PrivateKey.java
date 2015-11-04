/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chiffrementrsa.utils;

/**
 *
 * @author Gaëtan
 */
public class PrivateKey {
    private int privateKeyN;
    private int privateKeyU;
    
    /**
     * Retourne la valeur de U de la clef privée
     * @return PrivateKeyU de type int
     **/
    public int getPrivateKeyU() {
        return privateKeyU;
    }
    /**
     * Retourne la valeur de N de la clef privée
     * @return PrivateKeyN de type int
     **/
    public int getPrivateKeyN() {
        return privateKeyN;
    }

    /**
     * Assigne une nouvelle valeur à PrivateKeyN
     * @param privateKeyN un entier, la nouvelle valeur
     **/
    public void setPrivateKeyN(int privateKeyN) {
        this.privateKeyN = privateKeyN;
    }

    /**
     * Assigne une nouvelle valeur à PrivateKeyU
     * @param privateKeyU un entier, la nouvelle valeur
     **/
    public void setPrivateKeyU(int privateKeyU) {
        this.privateKeyU = privateKeyU;
    }
    
    /**
     * genere U second membre de la clef privee
     * @param publicKey de type PublicKey
     */
    public void generateU(PublicKey publicKey){
        setPrivateKeyU(MathUtils.modInverse(publicKey.getPublicKeyC(), publicKey.getM()));
        System.out.println(privateKeyU);
    }
    /**
     * constructeur, utilise les fonctions setPrivateKeyN(int) generateU(PublicKey)
     * @param publicKey de type PublicKey
     */
    public PrivateKey(PublicKey publicKey) {
        setPrivateKeyN(publicKey.getPublicKeyN());
        generateU(publicKey);
    }
    
}
