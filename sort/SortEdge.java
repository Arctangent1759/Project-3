package sort;
import Constants.Constants;

/**
 *  SortEdge class is functionally available as a means to
 *  sort an array of comparable Edges.
 **/
public class SortEdge {
  public static void sort(Comparable a[]){
    if (a.length < 40) { //insertion sort short lists
      insertionSort(a);
    } else {
      quicksort(a);
    }
  }

  /**
   *  quicksort()[1 param] is a driver for quicksort()[3 param].
   *  See quicksort()[3 param].
   *
   *  @param a array of comparable items to be sorted.
   **/
  public static void quicksort(Comparable a[]) {
    quicksort(a,0,a.length-1);
  }

  /**
   *  quicksort() sorts an array of comparable items from least to
   *  greatest using the quicksort algorithm. The given array will
   *  be mutated.
   *
   *  Running time: O(nlogn)
   *  @param a array of comparable items to be sorted.
   *  @param low the lower bound of the partition to be sorted.
   *  @param high the upper bound of the partition to be sorted.
   **/
  @SuppressWarnings("unchecked")
  public static void quicksort(Comparable a[], int low, int high) {
    if (low < high) {
      int pivotIndex = randomPivot(low, high);
      Comparable pivot = a[pivotIndex];
      Comparable swap; //Use this for swapping a[i] and a[j]
      a[pivotIndex] = a[high]; //Swap pivot with last item
      a[high] = pivot;

      int i = low - 1;
      int j = high;
      do {
        do { i++; } while (a[i].compareTo(pivot) < 0);
        do { j--; } while (a[j].compareTo(pivot) > 0 && (j > low));
        if (i < j) {
          swap = a[i];
          a[i] = a[j];
          a[j] = swap;
        }
      } while (i < j);

      a[high] = a[i];
      a[i] = pivot;
      quicksort(a, low, i-1);
      quicksort(a, i+1, high);
    }
  }

  /**
   *  randomPivot() produces a random, numerical pivot index suitable 
   *  for quicksort given a numerical range for the partition. Given
   *  an upper bound U and a lower bound L, an integer in the range 
   *  of [L,U] is returned.
   *
   *  @param lowerBound the numerical lower bound of the partition.
   *  @param upperBound the numerical upper bound of the partition.
   *  @return random number in the range [L,U]
   **/
  private static int randomPivot(int lowerBound, int upperBound) {
    return (int)(Math.random() * (upperBound+1 - lowerBound))+ lowerBound;
  }

  private static String arrStr(Comparable[] a){
    String out = "[";
    for (Comparable i: a){
      out+=" "+i.toString()+" ";
    }
    return out+"]";
  }

  private static String arrStr(Comparable[] a, int l, int h){
    String out = "[";
    for (int i = l; i<=h; i++){
      out+=" "+a[i].toString()+" ";
    }
    return out+"]";
  }

  /**
   *  insertionSort() sorts a given array from least to greatest using
   *  the insertion sort algorithm. The given array will be mutated.
   *
   *  Running time: O(n) [best-case]
   *                O(n^2) [worst/average-case]
   *  @param a an array of comparables to be sorted.
   **/
  @SuppressWarnings("unchecked")
  public static void insertionSort(Comparable a[]) {
    Comparable temp;
    int j;
    for(int i=0; i<a.length;i++) { //iterate over all items in array
      temp = a[i]; //save an item
      j = i;
      for(;(j>0)&&(temp.compareTo(a[j-1]) < 0);j--) { //look at items from end
        a[j] = a[j-1]; //swap if necessary
      }
      a[j] = temp;
    }
  }
}
