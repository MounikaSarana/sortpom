package sortpom.wrapper;

import org.jdom.*;

import java.util.*;

public class ElementSortOrderMap {
    /** Contains sort order element names and their index. */
    final Map<String, Integer> elementNameSortOrderMap = new HashMap<String, Integer>();

    public ElementSortOrderMap() {
    }

    public void addElement(Element element, int sortOrder) {
        final String deepName = getDeepName(element);
        elementNameSortOrderMap.put(deepName, sortOrder);

    }

    public boolean containsElement(Element element) {
        String deepName = getDeepName(element);
        return elementNameSortOrderMap.containsKey(deepName);
    }

    public int getSortOrder(Element element) {
        String deepName = getDeepName(element);
        return elementNameSortOrderMap.get(deepName);
    }

    public String getDeepName(final Element element) {
        if (element == null) {
            return "";
        }
        return new StringBuilder().append(getDeepName(element.getParentElement())).append('/')
                .append(element.getName()).toString();
    }

}