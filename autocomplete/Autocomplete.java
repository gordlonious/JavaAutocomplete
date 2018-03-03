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
    public Autocomplete(Term[] terms) {
        t = terms;
    }
    
    // Return all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix) { 
        int fIndex = BinarySearchDeluxe.firstIndexOf(t, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
        int lIndex = BinarySearchDeluxe.lastIndexOf(t, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
        if(fIndex == -1) System.out.println("Could not find first index of prefix");
        if(lIndex == -1) System.out.println("Could not find last index of prefix");
        if(fIndex == -1 || lIndex == -1) return new Term[0];
        return Arrays.copyOfRange(t, fIndex, lIndex);
    }
    // Return the number of terms that start with the given prefix.
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
 } 
}
