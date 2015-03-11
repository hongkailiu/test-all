package com.hongkailiu.test.app.algorithm;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class AnagramTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		List<String> dictionary = new ArrayList<String>();
		dictionary.add("a");
		dictionary.add("abc");
		dictionary.add("cab");
		dictionary.add("bc");
		dictionary.add("aa");
		dictionary.add("bca");
		dictionary.add("bba");
		dictionary.add("c");
		
		Anagram anagram = new Anagram(dictionary);
		Set<String> anagrams = anagram.getAnagrams("abc");
		Set<String> expectedAnagrams = new HashSet<String>();
		expectedAnagrams.add("abc");
		expectedAnagrams.add("bca");
		expectedAnagrams.add("cab");
		
		assertEquals(expectedAnagrams, anagrams);
	}

}
