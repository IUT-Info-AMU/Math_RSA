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
    /**
     * genere U second membre de la clef privee
     */
    public void generateU(){
        MathUtils math = new MathUtils();
        RSAKey.privateKey.second = math.modInverse((int)RSAKey.publicKey.second, RSAKey.M);
        System.out.println(RSAKey.privateKey.second);
    }
    /**
     * constructeur, appelle simplement generateU()
     */
    public PrivateKey() {
        RSAKey.privateKey.first = RSAKey.publicKey.first;
        generateU();
    }
    
}
