package sortpom.wrapper.content;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * En wrapper lets its element be sorted in alphabetical order
 *
 * @author Bjorn
 */
public class AlphabeticalSortedWrapper implements Wrapper<Element> {
    private final Element element;

    public AlphabeticalSortedWrapper(final Element element) {
        this.element = element;
    }

    @Override
    public Element getContent() {
        return element;
    }

    @Override
    public boolean isBefore(final Wrapper<? extends Node> wrapper) {
        return wrapper instanceof AlphabeticalSortedWrapper
                && isBeforeAlphabeticalSortedWrapper((AlphabeticalSortedWrapper) wrapper);
    }

    private boolean isBeforeAlphabeticalSortedWrapper(AlphabeticalSortedWrapper wrapper) {
        return wrapper.getContent().getNodeName().compareTo(getContent().getNodeName()) > 0;
    }

    @Override
    public String toString() {
        return "AlphabeticalSortedWrapper{" +
                "element=" +
                element +
                '}';
    }
}
