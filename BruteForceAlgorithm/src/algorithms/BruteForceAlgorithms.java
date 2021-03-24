package algorithms;

import java.awt.Point;

/**
 * 
 */

/**
 * @author ShelbyVian
 *
 */

public class BruteForceAlgorithms implements BruteForcible {

  @Override
  /**
   * ALGORITHM SelectionSort(A[0..n-1]) Sorts a given array A by selection sort
   * Input: An array of A[0..n-1] of orderable elements Output: Array A[0..n-1]
   * sorted in ascending order for i = 0 to n-2 do min = i; for j=i+1 to n-1 do if
   * A[j] < A[min] min = j swap A[i] and A[min]
   *
   * @param A - Array of orderable elements
   */
  public void selectionSort(int[] A) {
    int min = 0;
    // for i = 0 to n-2 do
    for (int i = 0; i <= A.length - 2; i++) {
      min = i; // min = i;
      // for j=i+1 to n-1 do
      for (int j = i + 1; j <= A.length - 1; j++) {
        // if A[j] < A[min] min = j
        if (A[j] < A[min])
          min = j;
      }
      // swap A[i] and A[min]
      int temp = A[i];
      A[i] = A[min];
      A[min] = temp;
    }
  }

  @Override
  public int sequentialSearch(int[] A, int K) {

    /*
     * ALGORITHM SequentialSearch(A[0..n-1], K) Searches for a given value in a
     * given array by sequential search Input: An array A[0..n-1} and a search key K
     * Output: The index of the first element if A that matches K or -1 if there are
     * no matching elements i = 0 while i < n and A[i] != K do i = i + 1 if i < n
     * return i else return -1
     */
    int i = 0;
    // while i <n and A[i] != K do
    while (i < A.length && A[i] != K) {
      // i = i + 1
      i += 1;
    }
    // if i < n return i
    if (i < A.length) {
      return i;
      // else return -1
    } else {
      return -1;
    }

  }

  @Override
  public int bruteForceStringMatch(String T, String P) {

    /*
     * ALGORITHM BruteForceStringMatch(T[0..n-1], P[0..m-1]) Implements brute-force
     * string matching Input: An array T[0..n-1] of n characters representing a text
     * and an array P[0..m-1] of m characters representing a pattern Output: the
     * index of the first character in the text that starts a matching sub-string or
     * -1 if the search is unsuccessful for i = 0 to n - m do j = 0 while j < m and
     * P[j] = T[i + j] do j = j +1 if j = m return i return -1
     */
    // for i = 0 to n - m do
    for (int i = 0; i <= (T.length() - P.length()); i++) {
      int j = 0;
      // while j < m and P[j] = T[i + j] do
      while (j < P.length() && P.charAt(j) == T.charAt(i + j)) {
        j += 1;
        // if j = m return i
      }
      if (j == P.length()) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public Point[] bruteForceClosestPoints(Point[] P) {

    /*
     * ALGORITHM BruteForceClosestPoints(P) Input: A list P of n (n>=2) points P1 =
     * (x1, y1) .. Pn = (xn, yn) Output: Indices index1 and index2 of the closest
     * pair of points dmin = inf for i = 1 to n - 1 do for j = i + 1 to n do d =
     * sqrt((xi - xj)^2 + (yi - yj)^2) if d < dmin dmin = d; index1 = i; index2 = j
     * return index1, index2
     */
    int index1 = 0, index2 = 0;
    // dmin = inf
    double dmin = Double.POSITIVE_INFINITY;
    // for i = 1 to n - 1 do
    for (int i = 0; i <= (P.length - 1); i++) {
      // for j = i + 1 to n do
      for (int j = i + 1; j <= P.length - 1; j++) {
        // d = sqrt((xi - xj)^2 + (yi - yj)^2)
        double d = Math.sqrt(((P[i].x - P[j].x) * (P[i].x - P[j].x)) + ((P[i].y - P[j].y) * (P[i].y - P[j].y)));
        if (d < dmin) {
          // dmin = d; index1 = i; index2 = j
          dmin = d;
          index1 = i;
          index2 = j;
        }
      }
    }

    // return index1, index2
    // use index1 and index2 to make an array of two points to return
    Point[] closest = new Point[2];
    closest[0] = P[index1];
    closest[1] = P[index2];
    return closest;
  }

  public void printArray(int[] data) {
    for (int i = 1; i <= data.length; i++) {
      System.out.printf("%,9d", data[i - 1]);
      // System.out.printf(Locale.US, "%,d %n", 10000);
      if (i % 20 == 0 && i > 0)
        System.out.println();
    }
  }
}
