/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chiffrementrsa.utils;

import static java.lang.Math.pow;
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
        if(exp == 0) return powerResultat;
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
     * Computes the canonical class of n modulo mod
     * @param n the integer to reduce modulo mod
     * @param mod the modulo
     * @return the integer k such that k = n [mod] et 0 <= k < mod
     */
    public static int reduce(int n, int mod)
    {
	int m = n % mod;	// -mod < m < mod

	if (m >= 0 )
	    return m;
	else 
	    return m + mod;
    }
    /**
     * Computes the GCD of the two integers.
     * @param m the first integer
     * @param n the second integer 
     * @return the GCD of m and n
     */
    public static int gcd(int m, int n) 
    {
	int r;

	// Exchange m and n if m < n
	if (m < n) {
	    r = n;  n = m; m = r;
	}
	// It can be assumed that m >= n
	while (n > 0) {
	    r = m % n;
	    m = n;
	    n = r;
	}
	return m;
    }
    /**
     * Computes the GCD and the coefficients of the Bezout equality.
     * @param m the first integer
     * @param n the second integer 
     * @return an array g of 3 integers.  g[0] is the GCD of m and n.
     *  g[1] and g[2] are two integers such that g[0] = m g[1] + n g[2].
     */
    public static int[] extgcd(int m, int n) 
    {
	// Both arrays ma and na are arrays of 3 integers such that
	// ma[0] = m ma[1] + n ma[2] and na[0] = m na[1] + n na[2]
	int[] ma = new int[]  {m, 1, 0};
	int[] na = new int[]  {n, 0, 1};
	int[] ta;		// Temporary variable 
	int i;			// Loop index
	int q;			// Quotient
	int r;			// Rest

	// Exchange ma and na if m < n
	if (m < n) {
	    ta = na;  na = ma; ma = ta;
	}
	
	// It can be assumed that m >= n
	while (na[0] > 0) {
	    q = ma[0] / na[0];	// Quotient
	    for (i = 0; i < 3; i++) {
		r = ma[i] - q * na[i];
		ma[i] = na[i];
		na[i] = r;
	    }
	}
	return ma;
    }
    /**
     * Computes the modular inverse
     * @param n the integer to inverse
     * @param mod the modula
     * @return the integer 0 <= m < mod such that nm = 1 [mod] or
     *         -1 if if n and mod are not coprime
     */
    public static int modInverse(int n, int mod)
    {
	int[] g = extgcd(mod, n);
	if (g[0] != 1)
	    return -1;		// n and mod not coprime
	else 
	    return reduce(g[2], mod);
    }
    
    public static void main(String[] args) {
        MathUtils math = new MathUtils();
        System.out.println(math.Power(new BigInteger(472+""), 7));
        System.out.println(math.mod(math.Power(new BigInteger(472+""), 4849),new BigInteger(5429+"")));
        System.out.println(math.modInverse(7, 2376));
        //ceci est un test !
        
    }
}
