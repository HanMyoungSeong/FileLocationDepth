package kr.ac.jejuuniv.searcher;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileDirectoryPathSearcher {

	private List<String> fileDirectoryPaths;

	public FileDirectoryPathSearcher() {
		fileDirectoryPaths = new ArrayList<String>();
	}

	public void searchDirectory(String path) {
		File rootDirectory = new File(path);
		File[] files = rootDirectory.listFiles();
		for (File file : files) {
			if (file.isFile() && getExtension(file.getAbsolutePath()).equals(".txt")) {
				fileDirectoryPaths.add(file.getAbsolutePath());
			} else if (file.isDirectory()) {
				searchDirectory(file.getAbsolutePath());
			}
		}
	}

	public String getExtension(String path) {
		return path.substring(path.lastIndexOf('.'));
	}

	public List<String> getDirectoryPaths() {
		return fileDirectoryPaths;
	}
}
