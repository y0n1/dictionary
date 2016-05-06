package dictionary;

import exceptions.ChildlessNodeException;
import exceptions.InvalidRootException;
import exceptions.WordNotFoundException;

public interface IDictionary {
	/**
	 * Adds a word to this dictionary.
	 * @param word the word to add.
	 */
	public void addWord(String word);
	
	/**
	 * Removes a word from this dictionary.
	 * @param word the word to remove.
	 * @throws WordNotFoundException 
	 * @throws InvalidRootException 
	 * @throws ChildlessNodeException 
	 */
	public void removeWord(String word);
	
	/**
	 * Prints all words in this dictionary prefixed with the given word.
	 * @param word the prefix for all words to be printed.   
	 */
	public void printAllWords(String word);
}
