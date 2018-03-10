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
        
        @Override
        public int compare(Term t1, Term t2) {
                String sub1 = t1.q.substring(0, Math.min(t1.q.length(), this.n));
		String sub2 = t2.q.substring(0, Math.min(t2.q.length(), this.n));
		return sub1.compareToIgnoreCase(sub2);
         }
    }

    // Compare the terms in lexicographic order by query.
    @Override
    public int compareTo(Term that) {
        return q.compareToIgnoreCase(that.getQuery());
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
        
        // test prefix compare method
        Term p1 = new Term("pre", 3);
        Term p2 = new Term("prefix", 9);  // p1 and p2 should match
        System.out.printf("are equal: %d%n", Term.byPrefixOrder(3).compare(p1, p2));
    }
}
