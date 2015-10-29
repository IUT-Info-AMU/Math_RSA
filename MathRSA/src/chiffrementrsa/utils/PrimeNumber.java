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
public class PrimeNumber {
   
    private int primeP;
    private int primeQ;

    public PrimeNumber() {
        GeneratePrimePAndQ(Config.generatePrimeMin,Config.generatePrimeMax);
    }

    public int getPrimeP() {
        return primeP;
    }

    public int getPrimeQ() {
        return primeQ;
    }

    public void setPrimeP(int primeP) {
        this.primeP = primeP;
    }

    public void setPrimeQ(int primeQ) {
        this.primeQ = primeQ;
    }
    /**
     * Renvoie si un entier passe un parametre est un nombre premier ou pas
     * @param n un entier
     * @return true si n est premier ou false si n n'est pas premier
     **/
    static boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n%2==0) return false;
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }
    /**
     * Genere un nombre premier compris entre min et max
     * @param min un entier minimum
     * @param max un entier maximum
     * @return un nombre premier
     **/
    public int GeneratePrimeNumber(int min,int max){
        if (min < 0)
            throw new IllegalArgumentException("min must be positive.");
        if (min >= max)
            throw new IllegalArgumentException("min must be smaller the max.");
        Random rand = new Random();
        int primeNumber = rand.nextInt(max - min) + min;
        while(!isPrime(primeNumber) || primeP == primeNumber){
            primeNumber = rand.nextInt(max - min) + min;
        }
        return primeNumber;
    }
    /**
     * Genere P et Q deux nombres premiers
     * @param min un entier minimum
     * @param max un entier maximum
     */
    public void GeneratePrimePAndQ(int min,int max){
        int firstPrimeNumber = GeneratePrimeNumber(min,max);
        setPrimeP(firstPrimeNumber);
        setPrimeQ(GeneratePrimeNumber(min + firstPrimeNumber,max + firstPrimeNumber));
        System.out.println(primeP + " " + primeQ);
    }
}
