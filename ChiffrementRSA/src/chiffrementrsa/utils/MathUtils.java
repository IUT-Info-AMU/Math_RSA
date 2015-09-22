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
public class MathUtils {    
    /**
     * calcule la puissance avec la base et l'exposant en parametre 
     * @param base la base de la puissance, un int
     * @param exp  l'exposant de la puissance, un int
     * @return le resultat de base Ã  la puissance exp, un int
     **/
    public int Power(int base, int exp){
        int powerResultat = 1;
        if(exp == 1) return base;
        if(exp == 0) return base;
        for(int i = 0; i < exp; ++i){
            powerResultat *= base;
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
    public int mod(int a,int b){
        return ( a -( (a/b)*b) );
    }
    
    
    public static void main(String[] args) {
        /*
        MathUtils math = new MathUtils();
        System.out.println(math.Power(2, 2));
        System.out.println(math.PGCD(10, 2));
        System.out.println(math.mod(9, 4));
        //ceci est un test !
        */
    }
}
