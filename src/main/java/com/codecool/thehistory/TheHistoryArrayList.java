package com.codecool.thehistory;

import java.util.*;

public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
        String[] newText = text.split("\\W");
        for (String word : newText) {
            if (!word.equals("")) {
                wordsArrayList.add(word);
            }
        }
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        wordsArrayList.removeIf(x -> x.equals(wordToBeRemoved));
    }

    @Override
    public int size() {
        return wordsArrayList.size();
    }

    @Override
    public void clear() {
        wordsArrayList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        Collections.replaceAll(wordsArrayList, from, to);
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information

        List<String> newWordsArrayList = new ArrayList<>();
        List<String> fromWordsArr = new ArrayList<>(Arrays.asList(fromWords));
        List<String> toWordsArr = new ArrayList<>(Arrays.asList(toWords));
        int lengthWordArrayList = wordsArrayList.size();
        List<String> handleWordsArraylist;
        int lengthFromWords;
        int indexElementArrayList;
        int indexElementArray;
        for (int i = 0; i < lengthWordArrayList; i++) {
            if (wordsArrayList.get(i).equals(fromWords[0])
                    && (lengthWordArrayList - i) >= fromWords.length) {
                lengthFromWords = fromWords.length;
                indexElementArrayList = i;
                indexElementArray = 0;
                handleWordsArraylist = new ArrayList<>();

                while (lengthFromWords > 0) {
                    if (wordsArrayList.get(indexElementArrayList).equals(fromWords[indexElementArray])) {
                        handleWordsArraylist.add(wordsArrayList.get(indexElementArrayList));
                        indexElementArrayList++;
                        indexElementArray++;
                    }
                    lengthFromWords--;
                }
                if (handleWordsArraylist.equals(fromWordsArr)) {
                    newWordsArrayList.addAll(toWordsArr);
                    i = i + fromWords.length - 1;
                } else {
                    newWordsArrayList.add(wordsArrayList.get(i));
                }
            } else {
                newWordsArrayList.add(wordsArrayList.get(i));
            }
        }
        wordsArrayList.clear();
        wordsArrayList.addAll(newWordsArrayList);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
