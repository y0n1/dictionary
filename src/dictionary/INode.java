package dictionary;

public interface INode { 
	public boolean hasChildren();	
	public boolean hasChild(char charId);	
	public Node getChild(char charId);	
	public Node getParent();	
	public void addChild(char charId, Node node); 	
	public void addChild(char charId);	
//	public Character findLink(Node node);	
//	public Node getByWord(String word, Node node);	
}
