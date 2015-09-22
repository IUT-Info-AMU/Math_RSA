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
public class RSAKey {
    public static int primeP = 0;
    public static int primeQ = 0;
    public static Pair primePAndQ = new Pair(primeP,primeQ);
    public static int N = 0;
    public static int C = 0;
    public static int M = 0;
    public static Pair publicKey = new Pair(N,C);
    public static int U = 0;
    public static Pair privateKey = new Pair(N,U);
}
