package node;

import dictionary.AlphabetEnum;
import exceptions.ChildlessNodeException;
import exceptions.InvalidRootException;
import exceptions.WordNotFoundException;

public class Node implements INode {
	public String _data;
	public Node _parent;
	private final Node[] _children = new Node[AlphabetEnum.values().length];
	
	public Node(String data, Node parent) {
		_data = data;
		_parent = parent;
	}
	
	public Node() {
		this(null, null);
	}

	public boolean hasChildren() {
		for (Node child : _children) {
			if (child != null) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean hasChild(char linkId) {
		return _children[linkId - 'a'] != null;
	}
	
	public Node getChild(char linkId) {
		return _children[linkId - 'a'];
	}
			
	public void removeChild(char linkId) {
		_children[linkId - 'a'] = null;
	}
	
	public void addChild(char linkId) {
		Node newChild = new Node(null, this);
		_children[linkId - 'a'] = newChild;
	}
	
	public Node[] getChildren() {
		return _children;
	}

	public static Character findLink(Node parentNode, Node childNode) throws ChildlessNodeException {
		if (!parentNode.hasChildren()) {
			throw new ChildlessNodeException();
		}
		
		Node[] children = parentNode.getChildren();
		for (int i = 0; i < children.length; i++) {
			if (children[i].equals(childNode)) {
				return new Character((char)('a' + i));
			}
		}
		
		return null;
	}
	
	public static Node getByWord(String word, Node rootNode) throws InvalidRootException, WordNotFoundException {
		if (!rootNode._parent.equals(rootNode)) {
			throw new InvalidRootException();
		}
		
		Node currentNode = rootNode;
		String subWord = word;
		while (!subWord.isEmpty()) {
			char currentLink = subWord.charAt(0);
			if (currentNode.hasChild(currentLink)) {
				currentNode = currentNode.getChild(currentLink);
				subWord = subWord.substring(1);
			} else {
				throw new WordNotFoundException();
			}
		}
		
		return currentNode;
	}
}
