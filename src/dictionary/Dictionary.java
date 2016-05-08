package dictionary;

import exceptions.ChildlessNodeException;
import exceptions.InvalidRootException;
import exceptions.WordNotFoundException;
import node.Node;

public class Dictionary implements IDictionary {
	private static Dictionary _instance;
	private Node _root;
	
	private Dictionary() {
		_root = new Node();
		_root._parent = _root;
	}
	
	public static Dictionary getInstance() {
		if (_instance == null) {
			_instance = new Dictionary();
		}
		
		return _instance;
	}

	public void addWord(String word) {
		Node currentNode = _root;
		String subWord = word;
		while (!subWord.isEmpty()) {
			char currentLink = subWord.charAt(0);
			if (!currentNode.hasChild(currentLink)) {
				currentNode.addChild(currentLink);				
			}
			currentNode = currentNode.getChild(currentLink);
			subWord = subWord.substring(1);
		}
		
		currentNode._data = word;
	}

	public void removeWord(String word) {
		Node wordContainerNode = null;
		try {
			wordContainerNode = Node.getByWord(word, _root);
		} catch (InvalidRootException e) {
			System.err.println("Malformed Tree!");
			e.printStackTrace();
		} catch (WordNotFoundException e) {
			System.err.println(e.getMessage());
			return;
		}
		
		wordContainerNode._data = null;
		if (!wordContainerNode.hasChildren()) {
			Node parent = wordContainerNode._parent;
			char link = 0;
			try {
				link = Node.findLink(parent, wordContainerNode);
			} catch (ChildlessNodeException e) {
				// Pass...
			}
			parent.removeChild(link);
		}
	}

	public void printAllWords(String word) {
		try {
			Node wordContainerNode = Node.getByWord(word, _root);
			printAllWords(wordContainerNode);
		} catch (InvalidRootException e) {
			e.printStackTrace();
		} catch (WordNotFoundException e) {
			System.err.println("\"" + word + "\" is not present in the dictionary!");
		}
	}

	private void printAllWords(Node node) {
		if (node._data != null) {
			System.out.println(node._data);
		}

		if (!node.hasChildren()) {			
			return;
		}
				
		for (Node child : node.getChildren()) {
			if (child != null) {
				printAllWords(child);
			}
		}
		
		return;
	}

}
