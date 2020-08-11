package general;

/**
 * https://leetcode.com/problems/integer-to-english-words/
 */
public class IntegerToEnglish {

    private final String[] SPECIAL_NUMBERS = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    private final String[] SUFFIXES = {"Billion" , "Million", "Thousand", "Hundred"};

    private final int BILLION = 1000000000;
    private final int MILLION = 1000000;

    private final String SPACE = " ";

    public static void main(String[] args) {
        int inputNumber = 69664511;
        IntegerToEnglish integerToEnglish = new IntegerToEnglish();
        System.out.println(integerToEnglish.numberToWords(inputNumber));
    }

    private String numberToWords(int num) {
        StringBuilder numberInWords = new StringBuilder();
        numberInWords = numberToWords(num, numberInWords);
        return numberInWords.toString().trim();
    }

    private StringBuilder numberToWords(int number, StringBuilder numberInWords) {
        if (number == 0 && numberInWords.length() == 0)
            return numberInWords.append("Zero");

        if (number > BILLION - 1) {
            numberInWords.append(generateNumberInWordsLessThanThousand(number / BILLION)).append(SPACE).append(SUFFIXES[0]).append(SPACE);
            number %= BILLION;
            return numberToWords(number, numberInWords);
        }
        else if (number > MILLION - 1) {
            numberInWords.append(generateNumberInWordsLessThanThousand(number / MILLION)).append(SPACE).append(SUFFIXES[1]).append(SPACE);
            number %= MILLION;
            return numberToWords(number, numberInWords);
        }
        else if (number > 1000 - 1) {
            numberInWords.append(generateNumberInWordsLessThanThousand(number / 1000)).append(SPACE).append(SUFFIXES[2]).append(SPACE);
            number %= 1000;
            return numberToWords(number, numberInWords);
        }
        else {
            StringBuilder numberInWordslessThanThousand = new StringBuilder();
            numberInWordslessThanThousand.append(generateNumberInWordsLessThanThousand(number));
            numberInWords.append(numberInWordslessThanThousand);
            return numberInWords;
        }
    }

    private String generateNumberInWordsLessThanThousand(int number) {
        StringBuilder numberInWords = new StringBuilder();
        numberInWords = wordifyNumbersLessThanthousand(number, numberInWords);
        return numberInWords.toString().trim();
    }

    private StringBuilder wordifyNumbersLessThanthousand(int number, StringBuilder numberInWords) {
        if (number > 99) {
            numberInWords.append(SPECIAL_NUMBERS[number / 100]).append(SPACE).append(SUFFIXES[3]);
            number %= 100;
            return wordifyNumbersLessThanthousand(number, numberInWords);
        }

        if (number > 19) {
            numberInWords.append(SPACE).append(TENS[number / 10]).append(SPACE);
            numberInWords.append((SPECIAL_NUMBERS[number % 10]));
        }
        if (number < 20) {
            numberInWords.append(SPACE).append(SPECIAL_NUMBERS[number]);
        }
        return numberInWords;
    }
}