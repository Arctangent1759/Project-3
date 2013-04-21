package PrimeGen;
import Constants.Constants;
public class PrimeGen{
  public static int first_prime_over(int n){
    int out;
    for(out = n; !isPrime(out);out++){}
    return out;
  }
  public static boolean isPrime(int n){
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
  public static void main(String args[]){
    for (int i = 2; i <= 100; i++){
      System.out.println(first_prime_over(i)%i);
    }
  }
}
