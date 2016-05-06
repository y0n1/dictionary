package main;

import dictionary.Dictionary;

public class Main {

	public static void main(String[] args) {
		Dictionary dic = Dictionary.getInstance();
		dic.addWord("bear");
		dic.addWord("beer");
		dic.addWord("beans");
		dic.addWord("bean");
		dic.addWord("be");
		dic.printAllWords("b");
		
		dic.removeWord("be");
		dic.printAllWords("b");
		
		dic.printAllWords("a");
		
	}
}
