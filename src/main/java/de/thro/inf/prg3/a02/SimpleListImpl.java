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
    private Element head; //by static würde die liste erweitert werden weil alle anderen static elemente auf diese variable
    //zu greifen und so lange auf dieses element gezeigt wird kann es nicht gelöscht werden
    private int elementCounter = 0;

     /**
     * Kettenglieder der Verketetenliste
     */
    private static class Element
    {
        private Object payload;
        private Element next;

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

    private class SimpleIteratorImpl implements Iterator<Object>
    {
        private Element current = head;

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
    public void add(Object object)
    {
        if(head == null) //sets first Element to 0
        {
            head = new Element(object); //if head is 0 then we give it an Object
        }
        else
        {
            Element current = head; // searches for the last Element in list

            while(current.getNext() !=  null)
            {
                current = current.getNext();//moves through the Elements to find NULL
            }

            current.setNext(new Element(object)); //adds new Element to NULL aka list end
        }

        elementCounter++; //counts length of list
    }

    @Override
    public int size() {
        return elementCounter;
    }

    @Override
    public SimpleList filter(SimpleFilter filter) {
        SimpleList result = new SimpleListImpl(); /*erstellt neue leere liste*/
        for(Object o : this){ //Foreach schleife berührt alle obj typ simplelistimpl
            if(filter.include(o)){//include operationsaufruf welche returned true or false bool if true
                //if true actuelle obj zu liste hinzugefügt, läuft durch bis alle obj berührt
                //
                result.add(o);
            }
        }
        return result;
    }

    @Override
    public Iterator iterator() {
        return new SimpleIteratorImpl();
    }


    /**
     * @param item Object to evaluate
     * @return true if the referenced object should be included.
     */
    @Override
    public boolean include(Object item) {

        return false;
    }

}
