package com.hongkailiu.test.app.algorithm;

import java.util.*;

/**
 * P91 java interview book
 * <p>
 * used by Ericsson
 *
 * @author Liu
 */
public class Anagram {

    private final Map<String, Set<String>> lookup = new HashMap<String, Set<String>>();

    public Anagram(final List<String> words) {
        for (final String word : words) {
            final String signature = alphabetize(word);
            if (lookup.containsKey(signature)) {
                lookup.get(signature).add(word);
            } else {
                final Set<String> anagramList = new HashSet<String>();
                anagramList.add(word);
                lookup.put(signature, anagramList);
            }
        }
    }

    private String alphabetize(final String word) {
        final byte[] bytes = word.getBytes();
        Arrays.sort(bytes);
        return new String(bytes);
    }

    public Set<String> getAnagrams(final String word) {
        final String signature = alphabetize(word);
        final Set<String> anagrams = lookup.get(signature);
        return anagrams == null ? new HashSet<String>() : anagrams;
    }
}
