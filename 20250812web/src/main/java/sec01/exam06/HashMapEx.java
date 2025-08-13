package sec01.exam06;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx {

	public static void main(String[] args) {
		Map<String,Integer> map =new HashMap<String, Integer>();
//		Map<String,Integer> map =new Hashtable<String, Integer>();
		
		map.put("신용권", 85);
		map.put("홍길동", 90);	//키값 같음
		map.put("동장군", 80);
		map.put("홍길동", 95);	//키값은 같음 마지막으로 추가한걸로 대체됨
		System.out.println("총 Entry 수: "+map.size());
		
		
		System.out.println("\t홍길동 : "+map.get("홍길동"));
		System.out.println();
		
		//객체를 하나씩 처리 keySet 사용
		System.out.println("*******************");
		for (String name : map.keySet()) {
			System.out.println(map.get(name));
		}
		System.out.println("*******************");
		Set<String> KeySet = map.keySet(); 
		Iterator<String> KeyIterator = KeySet.iterator();
		while(KeyIterator.hasNext()) {
			String key = KeyIterator.next();
			Integer value = map.get(key);
			System.out.println("\t" + key + " : " + value);
		}
		
		
		System.out.println();
		
		map.remove("홍길동");
		System.out.println("총 Entry 수: "+map.size());
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		
		while(entryIterator.hasNext()) {
			Map.Entry<String, Integer>entry = entryIterator.next();
			String Key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("\t" + Key + " : " + value);
		}
		System.out.println();
		
		map.clear();
		System.out.println("총 Entry 수: "+map.size());
	}

}
