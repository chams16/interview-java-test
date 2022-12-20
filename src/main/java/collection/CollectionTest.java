package collection;

import basic.BasicTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * You should complete the function in this class
 * <p>
 * Feel free to define any method and / or class you want
 */
class CollectionTest {


  /**
   * operation : x -> ((x * 2) + 3) ^ 5
   */
  public static List<Double> compute1(List<Integer> input) {
    List<Double> list = new ArrayList<>();
    if(input.isEmpty()){
      return list;
    }
    for(Integer x:input){
      list.add(PowerClass.power((x*2)+3,5).get());
    }
    return list;
  }

  public static void main(String[] args) {
//    Integer[] tab = {0, 1, 2, 5, 10};
    List<String> list = new ArrayList<>();
    list.add("abc");
    compute2(list);
  }

  /**
   * operation : abc -> AbcAbc
   */
  public static List<String> compute2(List<String> input) {
    List<String> list1 ;
    List<String> resultat = new ArrayList<>();

    if(input.isEmpty()){
      return resultat;
    }else if(input.size() ==1 && input.get(0).equals("")){
      resultat.add("");
      return resultat;
    }
    list1=convert(input);
    for (String str:list1) {
      resultat.add(str);
    }
    for (String str:list1) {
      resultat.add(str);
    }
    System.out.println(resultat.toString());
    return resultat;

  }

  public static List<String> convert(List<String> in){
    List<String> list = new ArrayList<>();
    String str = in.toString();
    char ch = in.toString().charAt(1);
    char ch1 = Character.toUpperCase(ch);
    StringBuilder sb = new StringBuilder();
    sb.append(ch1);
    sb.append(in.toString().substring(2,str.length()-1));
    list.add(sb.toString());
    for (int i=1;i<in.size();i++){
      list.add(in.get(i));
    }
    return list;
  }

}
