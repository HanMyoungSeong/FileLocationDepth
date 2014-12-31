package kr.ac.jejuuniv;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import kr.ac.jejuuniv.group.GroupMapper;
import kr.ac.jejuuniv.searcher.FileDirectoryPathSearcher;

public class Main {

	private static GroupMapper<String, String> groupMapper = new GroupMapper<String, String>();

	public static void main(String[] args) {
		FileDirectoryPathSearcher fileDirectoryPathSearcher = new FileDirectoryPathSearcher();

		fileDirectoryPathSearcher.searchDirectory("/Users/hms/Desktop/textfile");

		for (String fileDirectoryPath : fileDirectoryPathSearcher.getDirectoryPaths()) {

			String filePathKey = fileDirectoryPath.substring(0, fileDirectoryPath.lastIndexOf("/"));
			String fileNameValue = fileDirectoryPath.substring(fileDirectoryPath.lastIndexOf("/") + 1);
			groupMapper.groupMapper(filePathKey, fileNameValue);
		}

		print();
	}

	private static void print() {
		Map<String, List<String>> fileDirectoryMap = groupMapper.getGroupMapper();
		Set<String> keySet = fileDirectoryMap.keySet();
		Iterator<String> iterator = keySet.iterator();

		while (iterator.hasNext()) {
			String next = iterator.next();
			System.out.println(next);
			for (String fileName : fileDirectoryMap.get(next)) {
				String tab = "";
				for (int i = 0; i < next.length(); i++) {
					tab += " ";
				}
				System.out.println(tab + "¤¤ " + fileName);
			}
		}
	}

}
