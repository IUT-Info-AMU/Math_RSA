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
    private static int privateKeyN;
    private static int privateKeyU;
    private static PrivateKey instance = new PrivateKey();

    public static int getPrivateKeyU() {
        return privateKeyU;
    }

    public static int getPrivateKeyN() {
        return privateKeyN;
    }

    public static PrivateKey getInstance() {
        return instance;
    }
    
    /**
     * genere U second membre de la clef privee
     */
    public void generateU(){
        MathUtils math = new MathUtils();
        privateKeyU = MathUtils.modInverse(PublicKey.getPublicKeyC(), PublicKey.getM());
        System.out.println(privateKeyU);
    }
    /**
     * constructeur, appelle simplement generateU()
     */
    public PrivateKey() {
        privateKeyN = PublicKey.getPublicKeyN();
        generateU();
    }
    
}
