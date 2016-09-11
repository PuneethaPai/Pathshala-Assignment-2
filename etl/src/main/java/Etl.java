import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etl {
   public Map<String, Integer> transform(Map<Integer, List<String>> old) {
      Map<String, Integer> result = new HashMap<String, Integer>();
      for (Map.Entry<Integer, List<String>> x: old.entrySet()) {
         List<String> list = x.getValue();
         for (String y:list) {
            result.put(y.toLowerCase(),x.getKey());
         }
      }
      return result;
   }
}
