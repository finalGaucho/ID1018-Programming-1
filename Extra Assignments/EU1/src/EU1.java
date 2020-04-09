// The min method returns the least element in a sequential
// collection . If the collection is empty an
// IllegalArgumentException is thrown .
import java.util.Arrays;

public class EU1 {
  public static int min(int[] elements)
          throws IllegalArgumentException {
    if (elements.length == 0)
      throw new IllegalArgumentException(" empty collection ");
// Is used in trace printing 2
    int nofIters = 1;
    int[] sequence = elements;
    int nofPairs = sequence.length / 2;
    int nofUnpairedElements = sequence.length % 2;
    int nofPossibleElements = nofPairs + nofUnpairedElements;
    int[] partialSeq = new int[nofPossibleElements];
    int i;
    int j;
    while (nofPairs > 0) {
// extract a partial sequence of possible elements
      i = 0;
      j = 0;
      while (j < nofPairs) {
        partialSeq[j++] = (sequence[i] < sequence[i + 1]) ?
                sequence[i] : sequence[i + 1];
        i += 2;
      }
      if (nofUnpairedElements == 1)
        partialSeq[j] = sequence[nofPairs * 2];
// now turn to the partial sequence
      //sequence = Arrays.copyOfRange(partialSeq, 0, nofPossibleElements);
      sequence = partialSeq;
      nofPairs = nofPossibleElements / 2;
      nofUnpairedElements = nofPossibleElements % 2;
      nofPossibleElements = nofPairs + nofUnpairedElements;

// Trace printing 1 - to follow the sequence
System . out. println ( java . util . Arrays . toString ( sequence ));

// Trace printing 2 - to terminate the loop preemptively
// (to be able to see what happens initially )
 if ( nofIters ++ == 10)
 System . exit (0);
    }
// sequence [0] is the only remaining possible element
// - it is the least element
    return sequence[0];
  }

  public static int updateStrategy (int [] elements) {

    int smallestSoFar = elements[0];
    for (int nextValue: elements)
    {
      if (nextValue < smallestSoFar)
      {
        smallestSoFar = nextValue;
      }
    }

    return smallestSoFar;
  }




  public static void main(String[] args) {
    int[] test = { 32, 40, 17, 54, 12, 55, 77, 15, 34, 88, 46, 65, 33, 96, 11, 38, 43, 10, 39 };
    //int[] test = { 32, 40, 17, 54, 12, 55, 77, 15, 34, 88, 46, 65, 33, 96, 10, 38};
    System.out.println(min(test));
   // System.out.println(updateStrategy(test));
  }
}