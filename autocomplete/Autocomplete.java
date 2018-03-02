/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autocomplete;

import java.util.Arrays;

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
        return Arrays.copyOfRange(t, fIndex, lIndex);
    }
    // Return the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) { 
        int fIndex = BinarySearchDeluxe.firstIndexOf(t, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
        int lIndex = BinarySearchDeluxe.lastIndexOf(t, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
        return (lIndex - fIndex + 1);
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String filename = "";
        int numberOfSuggestions = 10;
        AutocompleteGUI ag = new AutocompleteGUI("wiktionary.txt", numberOfSuggestions);
    }
    
}
