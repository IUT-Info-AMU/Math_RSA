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
public class Pair <F,S>{
    public F first;
    public S second;
    /**
     * Creer la paire
     * @param first
     * @param second 
     */
    public Pair(F first, S second){
        this.first = first;
        this.second = second;
    }
    /**
     * Retourne le premier element de la paire
     * @return first 
     */
    public F getFirst(){
        return first;
    }
    /**
     * Retourne le deuxieme element de la paire
     * @return second
     */
    public S getSecond(){
        return second;
    }
}
