package mp3;

/**
 * A linked list to store strings.
 * 
 * @author Marcus
 */
public class LinkedStringList implements StringList {

	/**
	 * An item in the linked list.
	 * 
	 * @author Marcus
	 */
	public static class Item {

		/**
		 * The string stored in the item.
		 */
		private final String string;
		
		/**
		 * The next element in the list or
		 * null, if this is the last element.
		 */
		private Item next;
		
		/**
		 * Creates an item to store the string.
		 * 
		 * @param string The string to store.
		 */
		public Item(String string) {
			this.string = string;
		}
		
		/**
		 * Returns the string stored in the item.
		 * 
		 * @return The string stored in the item.
		 */
		public String getString() {
			return string;
		}
		
		/**
		 * Returns the next item in the list or
		 * null, if this is the last item.
		 * 
		 * @return The next item.
		 */
		public Item getNext() {
			return next;
		}
		
		/**
		 * Sets the next item of the list.
		 * 
		 * @param next The value for the next item.
		 */
		public void setNext(Item next) {
			this.next = next;
		}
		
	}
	
	/**
	 * The head (i.e. first element) of the
	 * list or null, if the list is empty.
	 */
	private Item head;
	
	/**
	 * Creates a new, empty list.
	 */
	public LinkedStringList() {
		super();
	}

	@Override
	public String getFirstString() {
		// check if empty
		if (head == null) return null;
		// else return string in first element
		return head.getString();
	}
	
	@Override
	public void appendString(String text) {
		// TODO: implement
		Item temp = head;
		if(head == null) {
			head = new Item(text);
		}else {
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(new Item(text));
		}
	}

	@Override
	public String getStringAt(int i) {
		// TODO: implement
		Item temp = head;
		String ziel = new String();
		int j = 0;
		if(head == null || istElementNull(i) == false) {
			return null;
		}else {
			while(temp.getNext() != null) {
				temp = temp.getNext();
				j++;
				if(j == i) {
					ziel = temp.getString();
				}
			}
			return ziel;
		}
	}

	@Override
	public void insertStringAt(int i, String text) {
		// TODO: implement
		if(head == null || istElementNull(i) == false) {
		
		}else {
			if(i == 0) {
				Item newHead = new Item(text);
				newHead.setNext(head);
				head = newHead;
			}else {
				Item newItem = new Item(text);
				Item prev = getItemAt(i - 1);
				
				if(prev != null) {
					newItem.setNext(prev.getNext());
					prev.setNext(newItem);
				}
			}
		}
	}

	@Override
	public void insertStringListAt(int i, StringList list) {
		// TODO: implement
		
		for(int j = 0; j < list.countElements(); j++) {
			insertStringAt(j + i, list.getStringAt(i));
		}
		
	}

	@Override
	public String replaceStringAt(int i, String text) {
		// TODO: implement
		Item temp = new Item(text);
		String oldString = getStringAt(i);
		if(istElementNull(i) == false) {
			return null;
		}else {
			if(i == 0) {
				Item newItem = new Item(text);
				newItem.setNext(head);
				head = newItem;
			}else {
				Item prev = getItemAt(i - 1);
				Item ziel = getItemAt(i);
				
				if(prev != null) {
					temp.setNext(ziel.getNext());
					prev.setNext(temp);
				}
			}
		}
		return oldString;
	}
	
	@Override
	public String removeStringAt(int i) {
		// TODO: implement
		if(istElementNull(i) == false || i == 0) {
			return null;
		}else {
			Item prev = getItemAt(i - 1);
			Item ziel = getItemAt(i);
			String zielString = ziel.getString();
			
			if(prev != null) {
				prev.setNext(ziel.getNext());
				
			}
			return zielString;
		}
	}

	@Override
	public String getLastString() {
		// TODO: implement
		if(head == null) {
			return null;
		}else {
			String lastString = getStringAt(countElements() - 1);
			return lastString;
		}
	}

	@Override
	public StringList reverseStringList() {
		// TODO: implement
		StringList reversedStringlist = new LinkedStringList();
		
		for(int i = countElements();i >= 0; i++) {
			String currentString = getStringAt(i);
			
			if(currentString != null) {
				reversedStringlist.appendString(currentString);
			}
		}
		return reversedStringlist;
	}

	@Override
	public int getIndexOfString(String text, int from) {
		// TODO: implement
		Item currentItem = getItemAt(from - 1);
		int index = 0;
		if(head == null || from > countElements()) {
			return -1;
		}else {
			for(int i = from; i < countElements(); i++) {
					currentItem = currentItem.getNext();
					
					if(currentItem.getString() == text) {
						 index = i;
					
				}
			}
			return index;
		}
	}

	@Override
	public int countElements() {
		int i = 0;
		Item temp = head;
		if(head == null) {
			return 0;
		}else {
			while(temp != null) {
				temp = temp.getNext();
				i++;
			}
			return i;
		}
	}

	@Override
	public String[] toStringArray() {
		return new String[0];
	}
	
	private boolean istElementNull(int i) {
		if(head != null && i >= 0 && i < countElements()) {
			return true;
		}else {
			return false;
		}
	}
	
	private Item getItemAt(int i) {
		if(istElementNull(i) == false) {
			return null;
		}else {
			Item currentItem = head;
			if(i == 0) {
				return head;
			}else {
				int j = 0;
				while(currentItem.getNext() != null) {
					currentItem = currentItem.getNext();
					j++;
					if(j == i) {
						break;
					}
				}
			}
			return currentItem;
		}
	}
	
	
}
