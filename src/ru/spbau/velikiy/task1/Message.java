package spbau.velikiy.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class to storage massage as list of lines
 *
 * @author Alexey Velikiy
 * @version %I%, %G%
 */
public class Message {

    /**
     * Default constructor
     */
    public Message() {

        content = new ArrayList<String>();

    }

    /**
     * Append all lines from another message to content by string
     *
     * @param m source message
     */
    public void append(Message m) {

        content.addAll(m.getLines());

    }

    /**
     * Append one line to content by string
     *
     * @param s line to add
     */
    public void append(String s) {
        content.add(s);
    }

    /**
     * Get content in  list of content lines
     *
     * @return unmodifiable list of content lines
     */
    List<String> getLines() {

        return Collections.unmodifiableList(content);

    }

    /**
     * Holder for lines of text
     */
    protected List<String> content;

}
