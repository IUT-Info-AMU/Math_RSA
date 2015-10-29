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

    public int getPrivateKeyU() {
        return privateKeyU;
    }

    public int getPrivateKeyN() {
        return privateKeyN;
    }


    public void setPrivateKeyN(int privateKeyN) {
        this.privateKeyN = privateKeyN;
    }

    public void setPrivateKeyU(int privateKeyU) {
        this.privateKeyU = privateKeyU;
    }
    
    /**
     * genere U second membre de la clef privee
     */
    public void generateU(PublicKey publicKey){
        MathUtils math = new MathUtils();
        setPrivateKeyU(MathUtils.modInverse(publicKey.getPublicKeyC(), publicKey.getM()));
        System.out.println(privateKeyU);
    }
    /**
     * constructeur, appelle simplement generateU()
     */
    public PrivateKey(PublicKey publicKey) {
        setPrivateKeyN(publicKey.getPublicKeyN());
        generateU(publicKey);
    }
    
}
