/******************************************************************************
 *  Name: Gordon Portzline
 *  NetID:    
 *  Precept:  
 *
 *  Partner Name: Shawn Neville
 *  Partner NetID:      
 *  Partner Precept:    
 *
 *  Hours to complete assignment (optional):
 *
 ******************************************************************************/

Programming Assignment 3: Autocomplete


/******************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that equals the search key.
 *****************************************************************************/
firstIndexOf rejects any null arguments then uses the classic binary search implementation with one exception.
Once firstIndexOf encounters a search hit it immediately checks the item to the left of the hit to see if it 
is a duplicate. If it is it knows that we are not at the first index of the search key. So, we continue searching
as if the key was not equal to the search key and the key was less than the hit. We basically continue searching
the same way binary search normally would in the first 'less than case'.
'
/******************************************************************************
 *  What is the order of growth of the number of compares (in the
 *  worst case) that each of the operations in the Autocomplete
 *  data type make, as a function of the number of terms n and the
 *  number of matching terms m?
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower-order terms, e.g., m^2 + m log n.
 *****************************************************************************/

constructor: N*LOG(N)  /* We use Arrays.sort that Sedgewick vouches for since it picks an appropriate sorting algorithm for the given type */

allMatches(): LOG(N) + M*LOG(M)  /* We call into BinarySearchDeluxe twice and sort the number of matches */

numberOfMatches():  /* We call into BinarSearchDeluxe twice */




/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/

We were able to eliminate all known bugs and limitations! (more formal bug-hunting could reveal some currently unknown issues of course)

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 *****************************************************************************/
We received help from Aidan Hubert when we got stuck trying to optimize our BinarySearchDeluxe class. Before we reached out
for help our firstIndexOf and lastIndexOf each took LOG(N) + K in the worst case.

/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
We tried to implement the prefix comparator compare method accurately by handling cases like the case where the prefix
is actually bigger than the Term we were comparing it to in separate control flow blocks. Those implementations were full
of bugs and did not help us. Once we realized that using Math.min to come up with the correct substrings to compare things
were much better.

We were stuck quite a while with LOG(N) + K  performance where K = the number of logical duplicates determined by the prefix
comparator for our firstIndexOf and lastIndexOf methods.

/******************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 *****************************************************************************/

We followed class protocol for sure!

We both contributed and pair-programmed on all java files.

/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/

I really enjoyed doing this assignment and would have loved messing around more with the GUI code if we wouldn't have
had some performance and comparison bugs that took us awhile to fix.
