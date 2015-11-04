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

    private MathUtils() {
    }

    /**
     * calcule la puissance avec la base et l'exposant en parametre
     *
     * @param base la base de la puissance, un BigInteger
     * @param exp l'exposant de la puissance, un int
     * @return le resultat de base Ã  la puissance exp, un int
     *
     */
    static public BigInteger Power(BigInteger base, int exp) {
        BigInteger powerResultat = new BigInteger("1");
        if (exp == 1) {
            return base;
        }
        if (exp == 0) {
            return powerResultat;
        }
        for (int i = 0; i < exp; ++i) {
            powerResultat = powerResultat.multiply(base);
        }
        return powerResultat;
    }

    /**
     * Fonction PGCD
     *
     * @param a un entier
     * @param b un netier
     * @return retourne le PGCD de a et b
     *
     */
    static public int PGCD(int a, int b) {
        int r;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    /**
     * Fonction modulo
     *
     * @param a un entier
     * @param b un entier
     * @return le modulo de a par b, un int
     */
    static public BigInteger mod(BigInteger a, BigInteger b) {
        return (a.subtract((a.divide(b)).multiply(b)));
    }

    /**
     * Calcule la classe canonique de n modulo mod
     *
     * @param n L'entier qui va réduire modulo mod
     * @param mod le modulo
     * @return un entier qui vaut m ayant pour valeur "n modulo mod" ou bien m +
     * mod
     */
    /* source : http://www.liafa.univ-paris-diderot.fr/~carton/Enseignement/CalculFormel/Style/ModArith/Gcd.java*/
    public static int reduce(int n, int mod) {
        int m = n % mod;	// -mod < m < mod

        if (m >= 0) {
            return m;
        } else {
            return m + mod;
        }
    }

    /**
     * Calcule le plus grand diviseur commun et les coefficients de l'égalité
     * Bezout.
     *
     * @param m un entier
     * @param n un entier
     * @return Un tableau g de 3 entiers. g à la position 0 est le PGCD de m et
     * n. G à la position 1 et G à la position 2 sont deux entiers tels que g à
     * la position 0 = mg à la position 1 + ng à la position 2.
     */
    /* source : http://www.liafa.univ-paris-diderot.fr/~carton/Enseignement/CalculFormel/Style/ModArith/Gcd.java*/
    public static int[] extgcd(int m, int n) {
	// Both arrays ma and na are arrays of 3 integers such that
        // ma[0] = m ma[1] + n ma[2] and na[0] = m na[1] + n na[2]
        int[] ma = new int[]{m, 1, 0};
        int[] na = new int[]{n, 0, 1};
        int[] ta;		// Temporary variable 
        int i;			// Loop index
        int q;			// Quotient
        int r;			// Rest

        // Exchange ma and na if m < n
        if (m < n) {
            ta = na;
            na = ma;
            ma = ta;
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
     * Calcule l'inverse modulaire
     *
     * @param n le nombre entier à inverser
     * @param mod le modulo
     * @return l'entier -1 si n et mod ne sont pas premiers entre eux ou bien le
     * résultat de reduce(int,int)
     */
    /* source : http://www.liafa.univ-paris-diderot.fr/~carton/Enseignement/CalculFormel/Style/ModArith/Gcd.java*/
    public static int modInverse(int n, int mod) {
        int[] g = extgcd(mod, n);
        if (g[0] != 1) {
            return -1;		// n et mod ne sont pas premiers entre eux
        } else {
            return reduce(g[2], mod);
        }
    }
}
