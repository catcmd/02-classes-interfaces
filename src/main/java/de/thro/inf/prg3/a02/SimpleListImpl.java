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
    static Element current = null;

    /**
     * Kettenglieder der Verketetenliste
     */
    private static class Element
    {
        Object item;
        Element next;

        public Element getNext() {
            return next;
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
        @Override
        public boolean hasNext() {

            if(SimpleListImpl.current.getNext().equals(null))
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
            Object buffer = new Element();
            buffer = SimpleListImpl.current;
            current = current.getNext();

            return buffer;
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
