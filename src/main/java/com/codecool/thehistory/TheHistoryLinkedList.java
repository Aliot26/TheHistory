package com.codecool.thehistory;

import java.util.*;

public class TheHistoryLinkedList implements TheHistory {
    /**
     * This implementation should use a String LinkedList so don't change that!
     */
    private List<String> wordsLinkedList = new LinkedList<>();

    @Override
    public void add(String text) {

        String[] newText = text.split("\\W");
        for (String word : newText) {
            if (!word.equals("")) {
                wordsLinkedList.add(word);
            }
        }
    }

    @Override
    public void removeWord(String wordToBeRemoved) {

        wordsLinkedList.removeIf(s -> s.equals(wordToBeRemoved));
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsLinkedList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsLinkedList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        Collections.replaceAll(wordsLinkedList, from, to);
    }
//        for (ListIterator iter = wordsLinkedList.listIterator(); iter.hasNext(); ) {
//            if (iter.next().equals(from)) {
//                iter.remove();
//                iter.add(to);

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        int lengthFromWords = fromWords.length;
        int lengthToWords = toWords.length;
        int lengthList = wordsLinkedList.size();
        ListIterator<String> iter = wordsLinkedList.listIterator();
        while (iter.nextIndex() <= lengthList - lengthFromWords) {
            String item = iter.next();
            if (item.equals(fromWords[0])) {
                ListIterator<String> iter2 = iter;
                while (iter2.hasNext()) {
                    System.out.println(iter2.next());
                    if (!word.equals(iter2.next())) {
                        break;
                    }
                }
            }
        }
    }

//
//        for (int i = 0; i < wordsLinkedList.size(); i++) {
//            if (wordsLinkedList.get(i).equals(fromWords[0])
//                    && i+lengthFromWords<=lengthList) {
//                List<String> sublist = wordsLinkedList.subList(i,i+lengthFromWords);
//                String[] sublistArr = sublist.toArray(new String[0]);
//                if(Arrays.equals(sublistArr, fromWords)){
//                    for (int j = i; j < i+lengthFromWords; j++) {
//                        wordsLinkedList.remove(wordsLinkedList.get(i));
//                    }
//                    for (int z = lengthToWords-1; z >=0 ; z--) {
//                        wordsLinkedList.add(i, toWords[z]);
//                    }
//                }
//            }
//        }
//
//    }
//        List <String> newWordsLinkedlist = new LinkedList<>();
//        List<String> listFromWords = new LinkedList<>(Arrays.asList(fromWords));
//        List<String> listToWords = new LinkedList<>(Arrays.asList(toWords));
//        int lengthWordsLinkedList = wordsLinkedList.size();
//        List<String> handleListWords;
//        int lengthfromWords;
//        int indexElementLinkedlist;
//        int indexElementFromWords;
//        for (int i = 0; i < lengthWordsLinkedList; i++) {
//            if(wordsLinkedList.get(i).equals(fromWords[0])
//                    && lengthWordsLinkedList-i>=fromWords.length){
//                lengthfromWords = fromWords.length;
//                indexElementLinkedlist = i;
//                indexElementFromWords = 0;
//                handleListWords = new LinkedList<>();
//
//                while (lengthfromWords>0){
//                    if(wordsLinkedList.get(indexElementLinkedlist).equals(fromWords[indexElementFromWords])){
//                        handleListWords.add(wordsLinkedList.get(indexElementLinkedlist));
//                        indexElementLinkedlist++;
//                        indexElementFromWords++;
//                    }
//                    lengthfromWords--;
//                }
//                if(handleListWords.equals(listFromWords)){
//                    newWordsLinkedlist.addAll(listToWords);
//                    i = i + fromWords.length - 1;
//                }else{
//                    newWordsLinkedlist.add(wordsLinkedList.get(i));
//                }
//
//            }else{
//                newWordsLinkedlist.add(wordsLinkedList.get(i));
//            }
//        }
//        wordsLinkedList.clear();
//        wordsLinkedList.addAll(newWordsLinkedlist);


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsLinkedList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
