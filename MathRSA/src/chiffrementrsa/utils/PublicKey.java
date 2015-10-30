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
    
    /**
     * Retourne la donnée membre primeNumber
     * @return primeNumber de type PrimeNumber
     **/
    public PrimeNumber getPrimeNumber() {
        return primeNumber;
    }
    /**
     * Assigne une nouvelle valeur à primeNumber
     * @param primeNumber un entier, la nouvelle valeur
     **/
    public void setPrimeNumber(PrimeNumber primeNumber) {
        this.primeNumber = primeNumber;
    }

    /**
     * Retourne la valeur de N de la clef publique
     * @return publicKeyN de type int
     **/
    public int getPublicKeyN() {
        return publicKeyN;
    }

    /**
     * Retourne la valeur de C de la clef publique
     * @return publicKeyC de type int
     **/
    public int getPublicKeyC() {
        return publicKeyC;
    }

    /**
     * Retourne la valeur de M
     * @return M de type int
     **/
    public int getM() {
        return M;
    }
    
    /**
     * Assigne une nouvelle valeur à PublicKeyN
     * @param publicKeyN un entier, la nouvelle valeur
     **/
    public void setPublicKeyN(int publicKeyN) {
        this.publicKeyN = publicKeyN;
    }

    /**
     * Assigne une nouvelle valeur à PublicKeyC
     * @param publicKeyC un entier, la nouvelle valeur
     **/
    public void setPublicKeyC(int publicKeyC) {
       this.publicKeyC = publicKeyC;
    }
    /**
     * Assigne une nouvelle valeur à M
     * @param M un entier, la nouvelle valeur
     **/
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
     * Genere C ayant pour PGCD 1 avec M, il doit etre contenu entre MinC et MaxC
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
