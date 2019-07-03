package com.codecool.thehistory;


import java.util.Arrays;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        String[] addedWordsArr = text.split("\\s+");
        int countAddWords = addedWordsArr.length;
        String[] newWordsArr = new String[wordsArray.length + countAddWords];
        System.arraycopy(wordsArray, 0, newWordsArr, 0, wordsArray.length);
        System.arraycopy(addedWordsArr, 0, newWordsArr, wordsArray.length, countAddWords);
        wordsArray = Arrays.copyOf(newWordsArr, newWordsArr.length);

    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        wordsArray = Arrays.stream(wordsArray)
                .filter(e -> !e.equals(wordToBeRemoved))
                .toArray(String[]::new);

//        for (int i = 0; i < sizeArray; i++) {
//            if (wordsArray[i].equals(wordToBeRemoved)) {
//                for (int j = i; j < sizeArray - 1; j++) {
//                    wordsArray[j] = wordsArray[j + 1];
//                }
//                i--;
//                sizeArray--;
//                wordsArray = Arrays.copyOf(wordsArray, sizeArray);
//                break;
//            }
//        }
//
    }

    @Override
    public int size() {
        return wordsArray.length;
    }

    @Override
    public void clear() {
        wordsArray = new String[0];
    }

    @Override
    public void replaceOneWord(String from, String to) {

        for (int i = 0; i < wordsArray.length; i++) {
            if (wordsArray[i].equals(from)) {
                wordsArray[i] = to;
            }
        }
    }


    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        int newLength = wordsArray.length;
        int fromWordsLength = fromWords.length;
        int toWordsLength = toWords.length;
        if (toWordsLength > fromWordsLength) {
            for (int i = 0; i < wordsArray.length; i++) {
                if (Arrays.equals(fromWords, Arrays.copyOfRange(wordsArray, i, i + fromWordsLength))) {
                    newLength += toWordsLength - fromWordsLength;
                    i += (fromWordsLength - 1);
                }
            }
        }
        if (fromWordsLength > toWordsLength) {
            for (int i = 0; i < wordsArray.length; i++) {
                if (Arrays.equals(fromWords, Arrays.copyOfRange(wordsArray, i, i + fromWordsLength))) {
                    newLength -= fromWordsLength - toWordsLength;
                    i += (fromWordsLength - 1);
                }
            }
        }
        String[] result = new String[newLength];
        int count = 0;
        for (int i = 0; i < wordsArray.length; i++) {
            if (Arrays.equals(fromWords, Arrays.copyOfRange(wordsArray, i, i + fromWordsLength))) {
                for (int j = 0; j < toWordsLength; j++) {
                    result[count] = toWords[j];
                    count++;
                }
                i += (fromWordsLength - 1);
            } else {
                result[count] = wordsArray[i];
                count++;
            }
        }
        this.wordsArray = result;
    }


//        String joinedStr = String.join(" ", wordsArray);
//        String joinedFromWords = String.join(" ", fromWords);
//        String joinedToWords = String.join(" ", toWords);
//        joinedStr = joinedStr.replaceAll("\\b"+joinedFromWords+"\\b", joinedToWords);
//        System.out.println(joinedStr);
//
//        wordsArray = joinedStr.split(" ");
//    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
}
