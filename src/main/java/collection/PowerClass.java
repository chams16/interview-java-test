package collection;

import io.vavr.control.Option;

public class PowerClass {

    public static Option<Double> power(Integer i, Integer n) {
        double res=1;

        if(n==0){
            return Option.of(1.0);
        }else if(i==0){
            return Option.of(0.0);
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
}
