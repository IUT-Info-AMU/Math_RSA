/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chiffrementrsa.utils;

import java.util.Random;

/**
 *
 * @author Gaëtan
 */
public class PublicKey {
    
    private static int publicKeyN;
    private static int publicKeyC;
    private static int M;
    private final static PublicKey instance = new PublicKey();

    public static int getPublicKeyN() {
        return publicKeyN;
    }

    public static int getPublicKeyC() {
        return publicKeyC;
    }

    public static int getM() {
        return M;
    }

    public static PublicKey getInstance() {
        return instance;
    }
 
    /**
     *Genere M a  partir de p et q avec la formule (p-1)*(q-1) 
     **/
    public void GenerateM(){
        M = (PrimeNumber.getPrimeP() -1) * (PrimeNumber.getPrimeQ() -1);
    }
    /**
     * Genere C ayant pour PGCD 1 avec M, il doit etre contneu entre MinC et MaxC
     **/
    public void GenerateC(){
        Random rand = new Random();
        publicKeyC = rand.nextInt(Config.MaxC - Config.MinC) + Config.MinC;
        MathUtils math = new MathUtils();
        while (math.PGCD(M,publicKeyC) != 1){
            publicKeyC = rand.nextInt(Config.MaxC - Config.MinC) + Config.MinC;
        }
    }
    /**
     * Genere la clef public, N en utilisant la formule N = p*q et les fonctions GenerateM et GenerateC pour Generer M et C
     **/
    private PublicKey(){
        GenerateM();
        GenerateC();
        publicKeyN = PrimeNumber.getPrimeP() * PrimeNumber.getPrimeQ();
        System.out.println(publicKeyN);
        System.out.println(M);
        System.out.println(publicKeyC);
    }
    
    public static void main(String[] args) {
        PublicKey pub = new PublicKey();
    }
}
