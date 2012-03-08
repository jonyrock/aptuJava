package spbau.velikiy.task2;

import java.io.*;
import java.util.regex.*;

/**
 * Regex filter
 *
 * @author Alexey Velikiy
 * @version %I%, %G%
 */
public class PatternFilter implements FileFilter {

    /**
     * Matching regex pattern
     */
    public final Pattern pattern;

    /**
     * Constructor from pattern
     * @param pattern Matching regex pattern
     */
    public PatternFilter(String pattern){
        this.pattern = Pattern.compile(pattern);
    }

    /**
     * Checking file
     * @param file file to check
     * @return either true if matched with regex or false if not
     */
    public boolean accept(File file){
        Matcher matcher = pattern.matcher(file.getName());
        return matcher.matches();
    }
    
}
