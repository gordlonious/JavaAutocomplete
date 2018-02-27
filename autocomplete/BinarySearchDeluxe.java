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
public class BinarySearchDeluxe {
    // Return the index of the first key in a[] that equals the search key, or -1 if no such key.
    public static int firstIndexOf(Term[] a, Term key, Comparator<Term> comparator) { 
        int lo = 0;
        int hi = a.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(comparator.compare(key, a[mid]) < 0) hi = mid -1;
            else if(comparator.compare(key, a[mid]) > 0) lo = mid + 1;
            else return mid;
        }
        return -1; 
    }

    // Return the index of the last key in a[] that equals the search key, or -1 if no such key.
     public static int lastIndexOf(Term[] a, Term key, Comparator<Term> comparator) { 
        int lo = 0;
        int hi = a.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(comparator.compare(key, a[mid]) < 0) hi = mid - 1;
            else if(comparator.compare(key, a[mid]) > 0) lo = mid + 1;
            else {
                while(comparator.compare(key, a[(mid+1)]) == 0) {
                    mid++;
                }
                return mid;
            }
        }
        return -1; 
     }
    
    public static void main(String[] args) {
        // test firstIndexOf method
        Term[] t1 = new Term[5];
        t1[0] = new Term("query", 5);
        t1[1] = new Term("abcd", 100);
        t1[2] = new Term("zzzz", 24);
        t1[3] = new Term("Wayward Soul", 50);
        t1[4] = new Term ("Test Data", 50);
        Arrays.sort(t1, Term.byReverseWeightOrder);
        int index = -1;
        index = firstIndexOf(t1, new Term("Test Data", 50), Term.byReverseWeightOrder);
        if(index > -1) System.out.printf("found it: %s%n", t1[index].toString());
        else System.out.println("couldn't find the Term");
        
        System.out.println("Testing lastIndex of...");
        Term[] t2 = new Term[6];
        t2[0] = new Term ("Test Data", 50);
        t2[1] = new Term("query", 5);
        t2[2] = new Term("abcd", 100);
        t2[3] = new Term("zzzz", 24);
        t2[4] = new Term("Wayward Soul", 50);
        t2[5] = new Term ("Test Data", 50);
        Arrays.sort(t2, Term.byReverseWeightOrder);
        for(Term t: t2) {
            System.out.println(t.toString());
        }
        int lastIndex = -1;
        lastIndex = lastIndexOf(t2, new Term("Test Data", 50), Term.byReverseWeightOrder);
        System.out.printf("the last index is: %d%n", lastIndex);
    }

}
