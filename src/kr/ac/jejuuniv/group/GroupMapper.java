package kr.ac.jejuuniv.group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupMapper<K, V> {

	private Map<K, List<V>> map;

	public GroupMapper() {
		map = new HashMap<K, List<V>>();
	}

	public void groupMapper(K key, V value) {
		List<V> values = map.get(key);
		if (values == null) {
			values = new ArrayList<V>();
			map.put(key, values);
		}
		values.add(value);
	}

	public Map<K, List<V>> getGroupMapper() {
		return this.map;
	}
}
