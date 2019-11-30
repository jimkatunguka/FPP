package prog13_1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * //PSEUDO-CODE boolean searchForFile(Object file, Object startDir) { Object[]
 * fileSystemObjects = startDir.getContents(); for(Object o: fileSystemObjects)
 * { //base case if(isFile(o) && isSameFile(o,f)) { return true; }
 * 
 * if(isDirectory(o)) { searchForFile(file, o); } } //file not found in startDir
 * return false; }
 */
public class FileSearch {
	static boolean found = false;
	// Store the text that is found in the
	// file that is found in this String variable
	static String discoveredText = null;

	public static boolean searchForFile(String fileName, String startDir) {
		File startDirectory = new File(startDir);
		File file = null;
		if (startDirectory.exists()) {
			List<File> folderContent = new ArrayList<>();
			folderContent = createFolderContent(startDirectory, folderContent);
			for (File f : folderContent) {
				String foundFileName = f.getName();
				if (foundFileName != null && foundFileName.trim().equals(fileName)) {
					file = new File(f.getAbsolutePath());
					if (file.isFile()) {
						printFileContent(file);
						return found = true;
					}
				}
			}
		}
		return false;
	}

	static List<File> createFolderContent(File file, List<File> list) {
		File[] children = file.listFiles();
		if (children != null) {
			for (File child : children) {
				list.add(child);
				createFolderContent(child, list);
			}
		}
		return list;
	}

	public static void printFileContent(File file) {
		try {
			discoveredText = "";
			Scanner sc = new Scanner(file);
			String line = null;
			while (sc.hasNextLine()) {
				line = sc.nextLine();
				discoveredText += line;
				System.out.println(line);
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
