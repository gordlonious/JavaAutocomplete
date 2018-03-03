/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autocomplete;
import java.util.Arrays;
import java.util.Comparator;
/**
 *
 * @author gordl
 */
public class Term implements Comparable<Term> {
    private String q;
    private double w;
    // Initialize a term with the given query string and weight.
    public Term(String query, double weight) {
        if (query == null) throw new NullPointerException("query parameter cannot be null (Term constructor)");
        if (!(weight >= 0)) throw new IllegalArgumentException("weight parameter must be nonnegative (Term constructor)");
        q = query;
        w = weight;
    }
    
    public String getQuery() {
        return q;
    }
    
    public double getWeight() {
        return w;
    }

    // Compare the terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder = (a, b) -> { return new Double (b.getWeight()).compareTo(a.getWeight()); }; // Java 8 syntax

    // Compare the terms in lexicographic order but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r) {
        if(r < 0) { throw new IllegalArgumentException("no negative paramaters allowed in byPrefixOrder constructor"); }
        return new PrefixCompare(r); 
    }
    
    public static class PrefixCompare implements Comparator<Term> {
        private int n;
        PrefixCompare(int r) { n = r; }
        public int compare(Term t1, Term t2) {
            if(t1.getQuery().length() <= n) {
                System.out.println("Trying to compare two strings based on a prefix that is bigger than each string being compared");
                return 0;
            }
             String st1 = t1.getQuery().substring(0, n);
             String st2 = t2.getQuery().substring(0, n);
             return st1.compareTo(st2);
         }
    }

    // Compare the terms in lexicographic order by query.
    public int compareTo(Term that) {
        return q.compareTo(that.getQuery());
    }

    // Return a string representation of the term in the following format:
    // the weight, followed by a tab, followed by the query.
    @Override
    public String toString() {
        return String.format("%f \t %s", w, q);
    }
    
    public static void main(String[] args) {
        // test natural order
        System.out.println("Natural Order Test...");
        Term t1 = new Term("zanbjds", 10);
        Term t2 = new Term("zanziyt", 7);
        Term t3 = new Term("zanadefg", 1);
        Term[] at = new Term[3];
        at[0] = t1;
        at[1] = t2;
        at[2] = t3;
        Arrays.sort(at);
        for(Term t: at) { System.out.println(t); }
        
        // test reverse weight order
        System.out.println("Reverse Weight Order Test...");
        Arrays.sort(at, Term.byReverseWeightOrder);
        for(Term t: at) { System.out.println(t); }
        
        // test reverse weight order
        System.out.println("Prefix Order Test...");
        Arrays.sort(at, Term.byPrefixOrder(3));
        for(Term t: at) { System.out.println(t); }
    }
}
