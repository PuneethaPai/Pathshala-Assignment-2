import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordCount {
	Map<String, Integer> phrase(String word) {
		String[] split = word.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase().split("\\s+");
		Map<String, Integer> result = new HashMap<String, Integer>();
		for (String x : split) {
			if (result.containsKey(x)) {
				Integer count = result.get(x);
				count += 1;
				result.put(x, count);
			} else {
				result.put(x, 1);
			}
		}
		return result;
	}
}
