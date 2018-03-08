/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autocomplete;

import java.util.Arrays;
import edu.princeton.cs.algs4.In;

/**
 *
 * @author gordl
 */
public class Autocomplete {
    private Term[] t;
    
    // Initialize the data structure from the given array of terms.
    // ~n*log(n) based on some generalizations we can make about Arrays.sort using either quicksort or mergesort
    public Autocomplete(Term[] terms) {
        t = terms;
        Arrays.sort(t);
    }
    
    // Return all terms that start with the given prefix, in descending order of weight.
    // ~ 2(log(n) + 1) + M
    // // 2(log(n) + 1) because one call to firstIndexOf and one call to lastIndexOf (both log(n) + 1)
    // // + M because Arrays.copyOfRange is given a range of indexes and must copy `each Match` (M) to a new Array
    public Term[] allMatches(String prefix) { 
        int fIndex = BinarySearchDeluxe.firstIndexOf(t, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
        int lIndex = BinarySearchDeluxe.lastIndexOf(t, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
        if(fIndex == -1) System.out.println("Could not find first index of prefix");
        if(lIndex == -1) System.out.println("Could not find last index of prefix");
        if(fIndex == -1 || lIndex == -1) return new Term[0];
        if(fIndex == lIndex) { 
            Term[] singleMatch = new Term[1];
            singleMatch[0] = t[fIndex];
            return singleMatch;
        }
        return Arrays.copyOfRange(t, fIndex, (lIndex+1));
    }
    // Return the number of terms that start with the given prefix.
    // // 2(log(n) + 1) because one call to firstIndexOf and one call to lastIndexOf (both ~log(n) + 1)
    // returns a trivial computation after that
    public int numberOfMatches(String prefix) { 
        int fIndex = BinarySearchDeluxe.firstIndexOf(t, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
        int lIndex = BinarySearchDeluxe.lastIndexOf(t, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
        System.out.printf("number of matches was %d", (lIndex - fIndex + 1));
        return (lIndex - fIndex + 1);
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        USE GUI
        String filename = "";
        int numberOfSuggestions = 10;
        AutocompleteGUI ag = new AutocompleteGUI("wiktionary.txt", numberOfSuggestions);
        ag.setVisible(true);

//        SPIT OUT MATCHES THROUGH CONSOLE
//          In in = new In();
//          while(!in.isEmpty()) {
//              String q = in.readLine();
//              System.out.println(Arrays.toString())
//          }

        //figure out copyOfRange
//        Term[] t1 = new Term[6];
//        t1[0] = new Term ("Test", 50);
//        t1[1] = new Term("query", 5);
//        t1[2] = new Term("abcd", 100);
//        t1[3] = new Term("abzz", 24);
//        t1[4] = new Term("Wayward Soul", 50);
//        t1[5] = new Term ("Test Data", 50);
//        Term[] t2 = Arrays.copyOfRange(t1, 0, 1);
//        for (Term trm : t2) {
//            System.out.println(trm.toString());
//        }
 } 
}
