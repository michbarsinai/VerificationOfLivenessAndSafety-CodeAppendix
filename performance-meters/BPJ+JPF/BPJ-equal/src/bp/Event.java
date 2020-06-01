package bp;

import java.util.ArrayList;
import java.util.Iterator;

import bp.eventSets.EventSetInterface;
import bp.eventSets.RequestableInterface;
import bp.exceptions.BPJRequestableSetException;

/**
 * A base class for events
 */
public class Event implements EventSetInterface, RequestableInterface {

	private String name = this.getClass().getSimpleName();

	@Override
	public boolean contains(Object o) {
		return this.equals(o);
	}

	public Iterator<RequestableInterface> iterator() {
		return new SingleEventIterator(this);
	}

	public Event() {
	}

	public Event(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Event get(int index) {
		if (index == 0)
			return (this);
		throw (new ArrayIndexOutOfBoundsException());
	}

	public boolean add(RequestableInterface r) throws BPJRequestableSetException {
		throw new BPJRequestableSetException();

	}

	public boolean isEvent() {
		return true;
	}

	public int size() {
		return 1;
	}

	public Event getEvent() throws BPJRequestableSetException {

		return this;
	}
	public ArrayList<Event> getEventList() {
		ArrayList<Event> list = new ArrayList<Event>();
		this.addEventsToList(list);
		return list;
	}

	public void addEventsToList(ArrayList<Event> list) {
		list.add(this); 
	}

}

/**
 * An iterator over a single event object. Allows to view an event as a
 * (singleton) set.
 */
class SingleEventIterator implements Iterator<RequestableInterface> {
	Event e;

	public SingleEventIterator(Event e) {
		this.e = e;
	}

	@Override
	public boolean hasNext() {
		return e != null;
	}

	@Override
	public Event next() {
		Event tmp = e;
		e = null;
		return tmp;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
