package basic;


import io.vavr.control.Option;



/**
 * For this basic test, you should not use any library. e.g. you should not use Math.pow for power method
 */
public class BasicTest {

  /**
   * return i ^ n for positive Integer, None otherwise
   * alse return None in case of errors
   */
  public static Option<Integer> power(Integer i, Integer n) {
    int res=1;

    if(n==0){
      return Option.of(1);
    }else if(i==0){
      return Option.of(0);
    }else {
      for(int var=0;var<n;var++){
        res=res*i;
      }
      if(res<Integer.MAX_VALUE && res>0){
        return Option.of(res);
      }
      return Option.none();
    }
  }

  public static void main(String[] args) {
    System.out.println(power(2, 9898909));
  }
}
