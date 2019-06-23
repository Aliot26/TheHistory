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
        ListIterator iter = this.wordsLinkedList.listIterator();
        int lengthFromWords = fromWords.length;
        int count = fromWords.length - 1;

        String[] partWords = new String[lengthFromWords];
        List<String> newList = new LinkedList<>();

        while (iter.hasNext()) {
            for (int j = 0; j < lengthFromWords - 1; j++) {
                partWords[j] = partWords[j + 1];
            }
            partWords[lengthFromWords - 1] = iter.next().toString();
            if (count == 0) {
                if (Arrays.equals(partWords, fromWords)) {
                    Collections.addAll(newList, toWords);
                    count = fromWords.length - 1;
                } else {
                    newList.add(partWords[0]);
                }
            } else {
                count--;
            }
        }
        for (int i = count + 1; i < lengthFromWords; i++) {
            newList.add(partWords[i]);
        }
        this.wordsLinkedList = newList;
    }



//    @Override
//    public void replaceMoreWords(String[] fromWords, String[] toWords) {
//        int lengthFromWords = fromWords.length;
//        if (lengthFromWords > 0
//                && toWords.length > 0) {
//            ListIterator<String> iterator = wordsLinkedList.listIterator();
//
//            while (iterator.hasNext()) {
//                if (isFromWordsAtIndex(fromWords, iterator.nextIndex())) {
//                    for (String word : fromWords) {
//                        if (iterator.hasNext()) {
//                            iterator.next();
//                            iterator.remove();
//                        }
//                        else {
//                            break;
//                        }
//                    }
//                    for (String word : toWords) {
//                        iterator.add(word);
//                    }
//                }
//                else {
//                    iterator.next();
//                }
//            }
//        }
//
//    }
//
//    private boolean isFromWordsAtIndex(String[] fromWords, int index) {
//        ListIterator<String> iter = wordsLinkedList.listIterator(index);
//        int matchCount = 0;
//
//        for (int i = 0; i < fromWords.length; i++) {
//            if (iter.hasNext()
//                    && iter.next().equals(fromWords[i])) {
//                matchCount++;
//            }
//            else {
//                break;
//            }
//        }
//        return matchCount == fromWords.length;
//    }

//    @Override
//    public void replaceMoreWords(String[] fromWords, String[] toWords) {
//        int lengthFromWords = fromWords.length;
//        int lengthToWords = toWords.length;
//        int lengthList = wordsLinkedList.size();
//        for (int i = 0; i < lengthList - lengthFromWords; i++) {
//            if (wordsLinkedList.get(i).equals(fromWords[0])) {
//                System.out.println(wordsLinkedList.get(i));
//                ListIterator<String> iter = wordsLinkedList.listIterator(i);
//                int indexFromWords = 0;
//                while (lengthFromWords > 0) {
//                    String temp = iter.next();
//                    if(iter.next().equals(fromWords[indexFromWords])){
//                        indexFromWords++;
//                        System.out.println(iter.next());
//                    }
//                    lengthFromWords--;
//                }
//            }
//        }
//    }
//        ListIterator<String> iter = wordsLinkedList.listIterator();
//        while (iter.nextIndex() <= lengthList - lengthFromWords) {
//            String item = iter.next();
//            if (item.equals(fromWords[0])) {
//                ListIterator<String> iter2 = iter;
//                while (iter2.hasNext()) {
//                    System.out.println();
//
//                }
//            }
//        }
//    }

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
