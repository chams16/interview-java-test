package async;

import io.vavr.Tuple2;
import io.vavr.collection.List;
import io.vavr.control.Option;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * You should complete the function in this class
 */

/*
  Really it's the first time that i use CompletableFuture<Option<T value>> even the documentation i read just exemple from Bealdung
  but i don't understand well
  hope that you consider the logic not syntaxe because if i will work with CompletableFuture<Option<Ceo>> in the internship i will try to understand
  it and correct the syntax
   hope that i have an interview with you
*/

class AsyncTest {

  private static List<Enterprise> enterprises = List.of(
      new Enterprise("ent_1", "Google", "ceo_2"),
      new Enterprise("ent_2", "Facebook", "ceo_1")
  );

  private static List<Ceo> ceos = List.of(
      new Ceo("ceo_1", "Mark"),
      new Ceo("ceo_2", "Sundar"),
      new Ceo("ceo_3", "Bill")
  );

  public static CompletableFuture<Option<Ceo>> getCeoById(String ceo_id) {
    CompletableFuture<Option<Ceo>> ceo = new CompletableFuture<>();
    for(Ceo ce:ceos){
      if(ce.id.equals(ceo_id)){
        ceo.complete(Option.some(ce));
      }
    }

    return ceo;
  }

  public static CompletableFuture<Option<Enterprise>> getEnterpriseByCeoId(String ceo_id) {
    CompletableFuture<Option<Enterprise>> entreprise = new CompletableFuture<>();
    for(Enterprise ent:enterprises){
      if(ent.ceo_id.equals(ceo_id)){
        entreprise.complete(Option.some(ent));
      }
    }
    return entreprise;
  }

  public static CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> getCEOAndEnterprise(String ceo_id) throws ExecutionException, InterruptedException {
    CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> res = new CompletableFuture<>();
    CompletableFuture<Option<Enterprise>> entreprise = getEnterpriseByCeoId(ceo_id);
    CompletableFuture<Option<Ceo>> ceo = getCeoById(ceo_id);
    res.complete(ceo.get(),entreprise.get());
    return res;
  }

}
