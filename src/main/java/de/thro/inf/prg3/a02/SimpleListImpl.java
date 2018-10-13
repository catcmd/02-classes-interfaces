package de.thro.inf.prg3.a02;

import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable<Object>
{
    /**
     * Globale Variablen
     */
    static Element head = null;

    /**
     * Kettenglieder der Verketetenliste
     */
    private static class Element
    {
        Object payload;
        Element next;

        public Element(Object ubergabe_item)
        {
            this.next = null;
            this.payload = ubergabe_item;
        }

        public Object getPayload() {
            return this.payload;
        }

        public Element getNext() {
            return this.next;
        }

        public void setNext(Element next) {
            this.next = next;
        }
    }

    /**
     * Iterator Innereklasse
     */
    private static class SimpleIteratorImpl implements Iterator
    {
        Element current = head;

        @Override
        public boolean hasNext() {

            if(current.getNext() == null)
            {
                return false;
            }
            else
            {
                return true;
            }
        }

        @Override
        public Object next() {
            Object payload = current.getPayload();
            current = current.getNext();

            return payload;
        }
    }


    @Override
    public void add(Object o) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public SimpleList filter(SimpleFilter filter) {
        return null;
    }

    @Override
    public Iterator<Object> iterator() {
        return null;
    }

}
