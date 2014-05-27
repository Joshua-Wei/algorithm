package string;

import java.util.*;

/**
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end,
 * such that:
 * 1.Only one letter can be changed at a time
 * 2.Each intermediate word must exist in the dictionary
 * 
 * For example, 
 * 
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * 
 * Return
 *   [
 *     ["hit","hot","dot","dog","cog"],
 *     ["hit","hot","lot","log","cog"]
 *   ]
 * 
 * Note:
 * - All words have the same length.
 *  - All words contain only lowercase alphabetic characters.
 * 
 * @author Joshua Wei
 */
public class WordLadder2 {
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		
		if (start == null || end == null || dict == null) return result;
		dict.remove(start);
		
		// word => lastWords
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		Queue<String> currentLevel = new LinkedList<String>();
		Queue<String> nextLevel = new LinkedList<String>();
		
		currentLevel.offer(start);
		map.put(start, new ArrayList<String>());
		
		boolean done = false;
		while (!done && !currentLevel.isEmpty()) {
			while (!currentLevel.isEmpty()) {
				String currentWord = currentLevel.poll();
				char[] currentChars = currentWord.toCharArray();

				for (int i = 0; i < currentChars.length; i++) {
					char tmp = currentChars[i];
					for (char c = 'a'; c <= 'z'; c++) {
						currentChars[i] = c;
						String nextWord = new String(currentChars);
						
						if (nextWord.equals(end)) {
							if (!map.containsKey(nextWord)) map.put(nextWord, new ArrayList<String>());
							map.get(nextWord).add(currentWord);
							done = true;
							continue;
						}
						
						if (dict.contains(nextWord)) {
							if (!map.containsKey(nextWord)) map.put(nextWord, new ArrayList<String>());
							map.get(nextWord).add(currentWord);
							if (!nextLevel.contains(nextWord)) nextLevel.offer(nextWord);
						}
					}
					currentChars[i] = tmp;
				}
			}
			
			if (done) {
				result.addAll(getResults(end, map));
				break;
			}
			
			dict.removeAll(nextLevel); // a word can appear on different paths - do this after processing level
			Queue<String> swap = currentLevel;
			currentLevel = nextLevel;
			nextLevel = swap;
		}
		return result;
    }
	
	// reverse paths
	private ArrayList<ArrayList<String>> getResults(String word, Map<String, List<String>> map) {
		ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
		for (String last : map.get(word)) {
			for (ArrayList<String> list: getResults(last, map)) {
				list.add(word);
				results.add(list);
			}
		}
		if (results.isEmpty()) {
			results.add(new ArrayList<String>());
			results.get(0).add(word);
		}
		return results;
	}
}
