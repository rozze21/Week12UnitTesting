import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class TestDemoTest {

  private TestDemo testDemo;
  
  @BeforeEach
  void setUp() {
    testDemo = new TestDemo();
  }

  @ParameterizedTest
  @MethodSource("TestDemoTest#argumentsForAddPositive") 
  //returns 4 parameters int a, int b, int expected and Boolean
  void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, 
      Boolean expectException) {
       
    if(!expectException) { 

      assertThat(testDemo.addPositive(a, b)).isEqualTo(expected); 
      
    }else
      assertThatThrownBy(
          () ->  testDemo.addPositive(a, b)) 
           .isInstanceOf(IllegalArgumentException.class); 
  }
 
  //test arguments
  static Stream<Arguments> argumentsForAddPositive() {
    //@formatter:off
    return Stream.of(arguments(2, 4, 6, false),
        arguments(3, 10, 13, false),
        arguments(1, 6, 7, false),
        arguments(-5, 10, 5, true),
        arguments(-3, -4, -7, true)
    );
    //formatter:on    
  }
 //
  @Test
  void assertThatNumberSquaredIsCorrect() {

  TestDemo mockDemo = spy(testDemo);
  doReturn(5).when(mockDemo).getRandomInt(); 
  int fiveSquared = mockDemo.randomNumberSquared(); 
  
  assertThat(fiveSquared).isEqualTo(25); 
  
}

}