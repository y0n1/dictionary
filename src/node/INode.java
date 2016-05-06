package node;

public interface INode { 
	public boolean hasChildren();	
	public boolean hasChild(char charId);	
	public Node getChild(char charId);		
	public void removeChild(char charId); 	
	public void addChild(char charId);		
}
