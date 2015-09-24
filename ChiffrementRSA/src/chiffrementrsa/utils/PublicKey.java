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
    /**
     *Genere M a  partir de p et q avec la formule (p-1)*(q-1) 
     **/
    public void GenerateM(){
        RSAKey.M = ((int) RSAKey.primePAndQ.first -1) * ((int) RSAKey.primePAndQ.second -1);
    }
    /**
     * Genere C ayant pour PGCD 1 avec M, il doit etre contneu entre MinC et MaxC
     **/
    public void GenerateC(){
        Random rand = new Random();
        RSAKey.publicKey.second = rand.nextInt(Config.MaxC - Config.MinC) + Config.MinC;
        MathUtils math = new MathUtils();
        while (math.PGCD(RSAKey.M,(int)RSAKey.publicKey.second) != 1){
            RSAKey.publicKey.second = rand.nextInt(Config.MaxC - Config.MinC) + Config.MinC;
        }
    }
    /**
     * Genere la clef public, N en utilisant la formule N = p*q et les fonctions GenerateM et GenerateC pour Generer M et C
     **/
    public PublicKey(){
        PrimeNumber primeNumber = new PrimeNumber();
        primeNumber.GeneratePrimePAndQ(Config.generatePrimeMin,Config.generatePrimeMax);
        GenerateM();
        GenerateC();
        RSAKey.publicKey.first = (int) RSAKey.primePAndQ.first * (int) RSAKey.primePAndQ.second;
        System.out.println(RSAKey.publicKey.first);
        System.out.println(RSAKey.M);
        System.out.println(RSAKey.publicKey.second);
    }
    
    public static void main(String[] args) {
        PublicKey pub = new PublicKey();
    }
}
