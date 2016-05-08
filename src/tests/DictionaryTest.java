package tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dictionary.Dictionary;


/**
 * Testing from <b><i>STDOUT</i></b> and <b><i>STDERR</i></b> technique was based on <a href="http://stackoverflow.com/a/1119559/2147368">this post.</a>
 * 
 * @author y0n1
 *
 */
public class DictionaryTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private Dictionary _dic = Dictionary.getInstance();

	@Before
	public void setUp() throws Exception {
		String[] words = {"bear", "beer", "beans", "bean", "be"};
		for (String word : words) {
			_dic.addWord(word);
		}
	}
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}
	
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}

	@Test
	public void testAddWord() {
		_dic.printAllWords("b");
		String expected = "" + 
				"be\r\n" + 
				"bean\r\n" + 
				"beans\r\n" + 
				"bear\r\n" + 
				"beer\r\n";
		assertEquals(expected, outContent.toString());
		
	}

	@Test
	public void testRemoveWord() {
		_dic.removeWord("be");
		_dic.printAllWords("be");
		String expected = "" +
				"bean\r\n" + 
				"beans\r\n" + 
				"bear\r\n" + 
				"beer\r\n";
		assertEquals(expected, outContent.toString());
	}

	@Test
	public void testPrintAllWords() {
		_dic.addWord("back");
		_dic.printAllWords("be");
		String expected = "" + 
				"be\r\n" + 
				"bean\r\n" + 
				"beans\r\n" + 
				"bear\r\n" + 
				"beer\r\n";
		assertEquals(expected, outContent.toString());
	}
	
	@Test
	public void testAttemptRemoveActionFromEmptyDictionary() {
		_dic.removeWord("zorro");
		assertEquals("Word not found!\r\n", errContent.toString());
	}
	
	@Test
	public void testPrintMissingWord() {
		_dic.printAllWords("al");
		assertEquals("\"al\" is not present in the dictionary!\r\n", errContent.toString());
	}
	
}
