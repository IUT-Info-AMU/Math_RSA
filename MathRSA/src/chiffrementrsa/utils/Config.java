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
public class Config {
    public static int generatePrimeMin = 20;
    public static int generatePrimeMax = 120;
    public static int MaxC = 15;
    public static int MinC = 5;

    /**
     * Assigne une nouvelle valeur à generatePrimeMin
     * @param generatePrimeMin un entier, la valeur min du nombre premier généré
     **/
    public static void setGeneratePrimeMin(int generatePrimeMin) {
        Config.generatePrimeMin = generatePrimeMin;
    }
    
    /**
     * Assigne une nouvelle valeur à generatePrimeMax
     * @param generatePrimeMax un entier, la valeur max du nombre premier généré
     **/
    public static void setGeneratePrimeMax(int generatePrimeMax) {
        Config.generatePrimeMax = generatePrimeMax;
    }

    /**
     * Assigne une nouvelle valeur à MaxC
     * @param MaxC un entier, la valeur max de C de la clef publique
     **/
    public static void setMaxC(int MaxC) {
        Config.MaxC = MaxC;
    }
    /**
     * Assigne une nouvelle valeur à MaxC
     * @param MinC un entier, la valeur min de C de la clef publique
     **/
    public static void setMinC(int MinC) {
        Config.MinC = MinC;
    }

    /**
     * Retourne la valeur de generatePrimeMin
     * @return generatePrimeMin, un entier
     **/
    public static int getGeneratePrimeMin() {
        return generatePrimeMin;
    }

    /**
     * Retourne la valeur de generatePrimeMax
     * @return generatePrimeMax, un entier
     **/
    public static int getGeneratePrimeMax() {
        return generatePrimeMax;
    }
    
    /**
     * Retourne la valeur de MaxC
     * @return MaxC, un entier
     **/
    public static int getMaxC() {
        return MaxC;
    }
    
    /**
     * Retourne la valeur de MinC
     * @return MinC, un entier
     **/
    public static int getMinC() {
        return MinC;
    }
    
}
