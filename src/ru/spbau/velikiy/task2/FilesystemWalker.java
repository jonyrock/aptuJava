package spbau.velikiy.task2;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;

/**
 * Mechanism of listing directory
 *
 * @author Alexey Velikiy
 * @version %I%, %G%
 */
public class FilesystemWalker {

    private final File startingDirectory;
    private final FileFilter filter;
    private final PrintStream outStream;

    /**
     * Constructor from directory path
     *
     * @param path      is path to directory to list
     * @param filter    is filter for matching files
     * @param outStream stream for writing tree
     * @throws FileNotFoundException when cant open directory
     */
    public FilesystemWalker(String path, FileFilter filter, PrintStream outStream)
            throws FileNotFoundException {

        startingDirectory = new File(path);
        
        // yes, it is not good 
        try {
            validateDirectory(startingDirectory);
        } catch (SecurityException s) {
            accessDeniedPrint("", startingDirectory);
        }
        this.filter = filter;
        this.outStream = outStream;

    }

    /**
     * List inner directories and files like tree
     *
     * @throws FileNotFoundException then reading inner folders
     */
    public void list() throws FileNotFoundException {

        outStream.println(startingDirectory.getName());

        getFileListing(getSpacePadding(startingDirectory.getName().length()),
                startingDirectory);

    }

    private void getFileListing(String padding, File aStartingDir) throws FileNotFoundException {

        File[] filesAndDirs = null;

        try {

            if (!aStartingDir.canRead()) {
                accessDeniedPrint(padding, aStartingDir);
                return;
            }

            filesAndDirs = aStartingDir.listFiles();

        } catch (SecurityException e) {
            accessDeniedPrint(padding, aStartingDir);
        }


        if (filesAndDirs == null)
            return;

        Arrays.sort(filesAndDirs);

        for (File file : filesAndDirs) {

            if (!filter.accept(file))
                continue;

            outStream.println(padding + "_" + file.getName());

            if (!file.isFile()) {
                //must be a directory
                //recursive call!
                getFileListing(padding +
                        getSpacePadding(file.getName().length() + 2), file);

            }

        }

    }

    private void accessDeniedPrint(String padding, File aStartingDir) {
        outStream.println(padding + aStartingDir.getName()
                + " (access denied)");
    }

    private void validateDirectory(File aDirectory) throws FileNotFoundException {

        if (aDirectory == null) {
            throw new IllegalArgumentException("Directory should not be null.");
        }
        if (!aDirectory.exists()) {
            throw new FileNotFoundException("Directory does not exist: " + aDirectory);
        }
        if (!aDirectory.isDirectory()) {
            throw new IllegalArgumentException("Is not a directory: " + aDirectory);
        }
        if (!aDirectory.canRead()) {
            throw new IllegalArgumentException("Directory cannot be read: " + aDirectory);
        }

    }

    private String getSpacePadding(long len) {

        StringBuilder paddingBuilder = new StringBuilder();

        for (long i = 1; i <= len; i++) {
            paddingBuilder.append(" ");
        }

        paddingBuilder.append("|");

        return paddingBuilder.toString();

    }

}