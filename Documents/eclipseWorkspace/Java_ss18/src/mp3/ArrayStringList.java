package mp3;

/**
 * An array list to store strings.
 * 
 * @author Marcus
 */
public class ArrayStringList implements StringList {

	/**
	 * The items in the list.
	 */
	private String[] items = new String[0];
	
	/**
	 * Creates a new empty list.
	 */
	public ArrayStringList() {
		super();
	}

	@Override
	public void appendString(String text) {
		// TODO: implement
		if(items.length == 0) {
			items = new String[] {text};
		}else {
			String[] neu = new String[items.length + 1];
			for(int x = 0; x < items.length; x++) {
				neu[x] = items[x];
			}
			
			neu[items.length] = text;
			items = neu;
		}
	
	}

	@Override
	public String getStringAt(int i) {
		// TODO: implement
		if(i < items.length) {
			return items[i];
		}else {
			return null;
		}
	}
	

	@Override
	public void insertStringAt(int i, String text) {
		// TODO: implement
		String[] items2 = new String[items.length + 1];
		if( i >= items.length) {
			
		}else if(items.length == 0) {
			items = new String[] {text};
		}else {
			for(int j = 0; j < i - 1; j++) {
				items2[j] = items[j];
			}
			
			items2[i - 1] = text;
			
			for(int j = i ; i < items2.length; j++) {
				items2[j] = items[j - 1];
			}
			
			items = items2;
			}
		}
	

	@Override
	public void insertStringListAt(int i, StringList list) {
		// TODO: implement
		int temp = 0;
		String newString[] = new String[items.length + list.countElements()];
		if(i > items.length) {
			
		}else{
			for(int j = 0; j < newString.length; j++) {
				while(j < i - 1) {
					newString[j] = items[j];
				}
				while(j >= i - 1 && j <= i - 1 + list.countElements()) {
					newString[j] = list.getStringAt(temp);
					temp++;
				}
				while(j >= i  + list.countElements()) {
					newString[j] = items[j - i];
				}
			}
			
		}
		
	}

	@Override
	public String replaceStringAt(int i, String text) {
		// TODO: implement
		String alt = getStringAt(i);
		
		for(int j = 0; j < items.length; j++) {
			if(j == i ) {
			
				items[j] = text;
			}
		}
		return alt;
	}
	
	@Override
	public String removeStringAt(int i) {
		// TODO: implement
		String alt = new String();
		String[] temp = new String[items.length - 1];
		for(int j = 0; j < items.length; j++) {
			while( j < i) {
				temp[j] = items[j];
			}
			while(j == i) {
				alt = items[j];
				items[j] = null;
			}
			while(j > i) {
				temp[j] = items[j];
			}
		}
		return alt;
	}

	@Override
	public String getFirstString() {
		// TODO: implement
		if(items[0] == null) {
			return null;
		}else {
			return items[0];
		}
	}

	@Override
	public String getLastString() {
		// TODO: implement
		if(items[items.length - 1] == null) {
			return null;
		}else {
			return items[items.length - 1];
		}
	}

	@Override
	public StringList reverseStringList() {
		// TODO: implement
		StringList neu = new ArrayStringList();
		for(int j = items.length - 1; j >= 0; j--) {
			neu.appendString(items[j]);
		}
		return neu;
	}

	@Override
	public int getIndexOfString(String text, int from) {
		// TODO: implement
		for(int j = from; j < items.length; j++) {
			if(items[j].equals(text) == true) {
				return j;
			}
			
		}
		return -1;
	}

	@Override
	public int countElements() {
		return items.length ;
	}

	@Override
	public String[] toStringArray() {
		String[] neu = new String[items.length];
		for(int i = 0; i < items.length; i++) {
			neu[i] = items[i];
		}
		return neu;
	}
	
	
}
