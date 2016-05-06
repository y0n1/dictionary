package dictionary;

public abstract class Node implements INode {
	private Node parent;
	private String data;
	private final Node[] children = new Node[AlphabetEnum.values().length];
	
	public Node(String data, Node parent) {
		this.data = data;
		this.parent = parent;
	}
	
	public boolean hasChildren() {
		for (Node child : children) {
			if (child != null) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean hasChild(char charId) {
		return children[charId] != null;
	}
	
	public Node getChild(char charId) {
		return children[charId];
	}
		
	public Node getParent() {
		return parent;
	}
	
	public void addChild(char charId, Node node) {
		
	}
	
	public void addChild(char charId) {
		
	}
	
	private Node[] getChildren() {
		return children;
	}

	public static Character findLink(Node parentNode, Node childNode) throws Exception {
		if (!parentNode.hasChildren()) {
			throw new Exception("This node has no children!");
		}
		
		Node[] children = parentNode.getChildren();
		for (int i = 0; i < children.length; i++) {
			if (children[i].equals(childNode)) {
				return new Character((char)('a' + 1));
			}
		}
		
		return null;
	}
	

	public Node getByWord(String word, Node node) {
		
	}
}
