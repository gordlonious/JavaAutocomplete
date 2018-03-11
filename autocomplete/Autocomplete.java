package autocomplete;

import java.util.Arrays;
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
    // ~ 2*log(n) + 2 + M*log(M)
    // // 2(log(n) + 1) because one call to firstIndexOf and one call to lastIndexOf (both log(n) + 1)
    // // + M*log(M) because we sort the matches (M) by descending weight
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
        Term[] matches = Arrays.copyOfRange(t, fIndex, (lIndex+1));
        Arrays.sort(matches, Term.byReverseWeightOrder);
        return matches;
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
        String filename = (args.length > 0) ? args[0] : "wiktionary.txt";
        int numberOfSuggestions = 10;
        AutocompleteGUI ag = new AutocompleteGUI(filename, numberOfSuggestions);
        ag.setVisible(true);
 } 
}
