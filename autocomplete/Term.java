/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autocomplete;
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
    //public static Comparator<Term> byReverseWeightOrder = (a, b) -> { return a.compareTo(b); };  // TODO

    // Compare the terms in lexicographic order but using only the first r characters of each query.
    //public static Comparator<Term> byPrefixOrder(int r) = (r) -> { return return ; }; // TODO

    // Compare the terms in lexicographic order by query.
    public int compareTo(Term that) {
        return q.compareTo(that.getQuery());
    }

    // Return a string representation of the term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
        return String.format("%f \t %s", w, q);
    }
    
    public static void main(String[] args) {
        Term t1 = new Term("query1", 10);
        Term t2 = new Term("query2", 7);
        Term t3 = new Term("query3", 1);
    }
}
