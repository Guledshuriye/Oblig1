package com.company;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class  Oblig1 {

    public static void main(String[] args) {
	// write your code here
        int [] b = {3,3,4,5,5,6,7,7,7,8,9,9};
        System.out.println(antallUlikeSortert(b));

        char[] c = "ABCDEFGHIJ".toCharArray();
         rotasjon(c);

        System.out.println(Arrays.toString(c));


//        int [] b = randPerm(3);
//
//        System.out.println(Arrays.toString(b));
//
//        System.out.println(maks(b));
//
//        System.out.println(Arrays.toString(b));
//
//        System.out.println(ombytteringer(b));

    }

    public static void bytt(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void bytt(char[] a, int i, int j){
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    /**
     * Method to produce random array values
     * This is to produce a given number
     * HjelperMethod(This method is from the school konpendium)
     * @return
     */
    public static int[] randPerm(int n){
        Random r = new Random();
        int[] a = new int[n];

        Arrays.setAll(a, i -> i + 1);

        for (int k = n - 1; k > 0 ; k--) {
            int i = r.nextInt(k + 1);
            bytt(a,k,i);
        }return a;
    }

    /**
     *
     * @param a
     * @return
     */
    public static int maks(int[] a){
        if(a.length < 2)
            throw new NoSuchElementException("tabellen er tomt!");

        int størteVerdieBarkerst = a.length -1;
        for (int i = 1; i < a.length; i++) {
            if(a[i - 1] > a[i]){ //Sammenlign førest a[0] og a[1]
                bytt(a, i, i - 1); // Hvis a[0] > a[1] bytter de to verdiene plass
            }
        }
        return a[størteVerdieBarkerst];//Her vi det legger den størte verdi siden den settes bak
    }

    /**
     * Oppgave 1b
     * Method should return the number of changed places or changes
     * between a[i-i] > a[i]
     * @param a
     * @return
     */
    public static int ombytteringer(int[] a){

        int antallOmbyttinger = 1;

        for (int i = 1; i < a.length; i++) {
            if(a[i - 1] > a[i]){ //Sammenlign førest a[0] og a[1]
                bytt(a, i, i - 1); // Hvis a[0] > a[1] bytter de to verdiene plass
                antallOmbyttinger++;
            }
        }return antallOmbyttinger;
    }

    /**
     * This will return the number of similar or numbers that
     * are alike
     * @param a
     * @return
     */
    public static int antallUlikeSortert(int[] a){
        int antallUlikeSortert = 1;
        int i = 1;
        for (; i < a.length; i++) {
            if(a[i - 1] > a[i]){
                throw new IllegalArgumentException("Tabellen er ikke sortert stigende");
            }else {
                if(a[i - 1] < a[i]){
                    antallUlikeSortert++;
                }
            }
        }return antallUlikeSortert;
    }

    public static int antallUlikeUsortert(int[] a){
        int n = a.length;

        int antallULikeUsortert = 1;
        for (int i = 0; i < n; i++) {
            int likeverdie = a[i];
            int j = 1;
            for (; j < n; j++) {
                if(a[j] == likeverdie)break;
            }
            if(j == i) antallULikeUsortert++;
        }
        return antallULikeUsortert;
    }

    public static void rotasjon(char[] a){
        int n = a.length;
        if(n < 2) return;  // tomt eller en verdi i tabellen

       if(a.length > 1) {
           char sistChar = a[n - 1];  //siste element bokstava i tabellen
           for (int i = n - 1; i > 0; i--) { // Starter fra bak siden det er den som skal bytter
                   a[i] = a[i - 1];
               }
               a[0] = sistChar;  // her vi sist bokstav fylt plass med den i posisjon a[0] som er A

       }
    }
}
