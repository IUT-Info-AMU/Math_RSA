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
    
    private int publicKeyN;
    private int publicKeyC;
    private int M;
    private PrimeNumber primeNumber;

    public PrimeNumber getPrimeNumber() {
        return primeNumber;
    }

    public void setPrimeNumber(PrimeNumber primeNumber) {
        this.primeNumber = primeNumber;
    }

    public int getPublicKeyN() {
        return publicKeyN;
    }

    public int getPublicKeyC() {
        return publicKeyC;
    }

    public int getM() {
        return M;
    }

    public void setPublicKeyN(int publicKeyN) {
        this.publicKeyN = publicKeyN;
    }

    public void setPublicKeyC(int publicKeyC) {
       this.publicKeyC = publicKeyC;
    }

    public void setM(int M) {
        this.M = M;
    }
 
    /**
     *Genere M a  partir de p et q avec la formule (p-1)*(q-1) 
     **/
    public void GenerateM(){
        setM((primeNumber.getPrimeP() -1) * (primeNumber.getPrimeQ() -1));
    }
    /**
     * Genere C ayant pour PGCD 1 avec M, il doit etre contneu entre MinC et MaxC
     **/
    public void GenerateC(){
        Random rand = new Random();
        setPublicKeyC(rand.nextInt(Config.MaxC - Config.MinC) + Config.MinC);
        MathUtils math = new MathUtils();
        while (math.PGCD(M,publicKeyC) != 1){
           setPublicKeyC(rand.nextInt(Config.MaxC - Config.MinC) + Config.MinC);
        }
    }
    /**
     * Genere la clef public, N en utilisant la formule N = p*q et les fonctions GenerateM et GenerateC pour Generer M et C
     **/
    public PublicKey(){
        primeNumber = new PrimeNumber();
        GenerateM();
        GenerateC();
        setPublicKeyN(primeNumber.getPrimeP() * primeNumber.getPrimeQ());
        System.out.println(publicKeyN);
        System.out.println(M);
        System.out.println(publicKeyC);
    }
}
