import java.util.Random;
import com.google.common.annotations.VisibleForTesting;
  

public class TestDemo {

//instance method takes two ints and returns an int
  public int addPositive(int a, int b) {
  int sum = a + b;
  if (a <= 0 || b <= 0) {
  //throws and IllegalArgumentExcpetion if a number is not positive 
    throw new IllegalArgumentException("Both parameters must be positive!");
  //else it returns the sum
  }else 
    return sum;
  
  
  } 
 

//method returns an int
  public int randomNumberSquared() {
    
   //random method
    int random = getRandomInt();
   //returns random * random for it to be the square.
   return random*random;
 }  
 @VisibleForTesting  //method made visible so the test can see it.  
   int getRandomInt() { 

    Random random = new Random(); 
    
     return random.nextInt(10) + 1; 
  
  }
 } 
 

