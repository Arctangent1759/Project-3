package dict;
/**
 *  Hashtable extends the Dictionary abstract class.
 *  It implements hashing and chaining. What this means 
 *  is that if two entries either hash or compress to the 
 *  same array index, they will be stored in a list at that
 *  index.
 **/

public class Hashtable extends Dictionary{

  /**
   *  Member Variables.
   *
   *  table the array that contains DList chains for hashed entries.
   **/
  private DList table[];
  private int collisions;

  /**
   *  Hashtable constructor creates a hashtable of a
   *  size close to the value specified.
   *
   *  @param sizeEstimate size estimated for this hashtable.
   **/
  public Hashtable(int sizeEstimate) {
    int size = nextPrime(sizeEstimate);
    this.table = new DList[size];
    this.collisions = 0;
  }

  /**
   *  Hashtable creates an empty hashtable of a small size.
   **/
  public Hashtable() {
    this(100);
  }

  /**
   *
   **/
  @Override
  public Object find(Object key) {
    
  }

  /**
   *
   **/
  @Override
  public void insert(Object key, Object value) {
    
  }

  /**
   *
   **/
  private int compress(int code) {
    int bigPrime = 16908799;

    if (this.table.length < bigPrime) {
      return ((code % bigPrime + bigPrime) % bigPrime) % this.table.length;
    } else {
      return (code % this.table.length + this.table.length) % this.table.length;
    }
  }

  /**
   *  nextPrime() gives the next prime number greater than or equal 
   *  to the input number.
   *  ex: nextPrime(20) == 23
   *      nextPrime(31) == 31
   *
   *  @param val the value for to look for the next sequential prime.
   *  @return the next prime number at or after the given input.
   **/
  private static int nextPrime(int val) {
    //320 is the largest gap between prime numbers in the range of int32
    int maxSearch = 320 + val;
  }

  public int getCollisions() {
  }

  public float getLoadFactor() {
  }


  private static int first_prime_over(int n){
    int out;
    for(out = n; !isPrime(out);out++){}
    return out;
  }
  /**
   *  isPrime() indicates if a number is prime.
   *
   *  @param val the number in question.
   *  @return whether the given number is prime or not.
   **/

  private static boolean isPrime(int n){
    if ((n%2)==0){
      return false;
    }
    for (int i = 3; i < Math.sqrt(n); i+=2){
      if (n%i==0){
        return false;
      }
    }
    return true;
  }
}
