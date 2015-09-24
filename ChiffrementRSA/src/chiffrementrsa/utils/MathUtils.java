/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chiffrementrsa.utils;

import java.math.BigInteger;

/**
 *
 * @author Gaëtan
 */
public class MathUtils {    
    /**
     * calcule la puissance avec la base et l'exposant en parametre 
     * @param base la base de la puissance, un BigInteger
     * @param exp  l'exposant de la puissance, un int
     * @return le resultat de base Ã  la puissance exp, un int
     **/
    public BigInteger Power(BigInteger base, int exp){
        BigInteger powerResultat = new BigInteger("1");
        if(exp == 1) return base;
        if(exp == 0) return base;
        for(int i = 0; i < exp; ++i){
            powerResultat = powerResultat.multiply(base);
        }
        return powerResultat;
    }
    
    /**
     * Fonction PGCD
     * @param a un entier
     * @param b un netier
     * @return retourne le PGCD de a et b
     **/
    public int PGCD(int a, int b){
        int r;
            while (b != 0){
                r = a%b;
                a = b;
                b = r;
            }
        return a;
    }
    
    /**
     * Fonction modulo
     * @param a un int
     * @param b un int
     * @return le modulo de a par b, un int
     */
    public BigInteger mod(BigInteger a,BigInteger b){
        return ( a.subtract((a.divide(b)).multiply(b)) );
    }
    
    /**
     * pow of Fermat’s Little Theorem
     * @param a un int
     * @param b un int
     * @param MOD un int
     * @return int
     */
    int pow(int a, int b, int MOD) {
        int x = 1, y = a;
            while(b > 0) {
                if(b%2 == 1) {
                    x=(x*y);
                    if(x>MOD) x%=MOD;
                }
                y = (y*y);
                if(y>MOD) y%=MOD;
                b /= 2;
            }
        return x;
    }
    
    /**
     * Inverse modulaire, Fermat’s Little Theorem
     * @param a un int
     * @param m un int
     * @return l'inverse modulaire de a par m
     */
    int modInverse(int a, int m) {
        return pow(a,m-2,m);
    }
    
    public static void main(String[] args) {
        /*
        MathUtils math = new MathUtils();
        System.out.println(math.Power(2, 2));
        System.out.println(math.PGCD(10, 2));
        System.out.println(math.mod(9, 4));
        System.out.println(math.modInverse(123,4567));
        //ceci est un test !
        */
        
    }
}
