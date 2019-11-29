package io_samples;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 
 * @author Russ
 *
 * Show listing files and folders (detect which are folders)
 */
public class FolderAndFilesDemo {

	public static void main(String[] args) {

		// Change this path to something on your C drive.
		Path dir = FileSystems.getDefault().getPath("C:\\git\\PROG1400\\Eclipse_WS\\Module_01_Basics\\src");
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
		    for (Path file: stream) {
				System.out.println(file.getFileName() +" ... is it a Directory?   ..."+ Files.isDirectory(file) );
				System.out.println("Name: "+file.getName(0) );
				System.out.println("Name: "+file.getName(1) );
				System.out.println("Name: "+file.getName(2) );
				System.out.println("Name: "+file.getName(file.getNameCount()-1) );
		    }
		} catch (IOException | DirectoryIteratorException x) {
		    // IOException can never be thrown by the iteration.
		    // In this snippet, it can only be thrown by newDirectoryStream.
		    System.err.println(x);
		}
		
	}

}
