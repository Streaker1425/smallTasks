package Babaeva_RB11;

import java.util.Locale;
import java.util.regex.Pattern;

public class LearnStringMethods {

    public static boolean isBurg(String cityName){
        //В пору использовать regex, но мы тут учим методы класса String, а не регулярные выражения
        //посему напишем свою уникальную (нет) штуку:
        String burg = "burg";
        return cityName.endsWith(burg);
    }
    public static String replaceString(String mainStr, String strToChange,  String changingStr){
        //очень смыслововой метод. Просто же вызвать в меине метод replace мы не можем
        return mainStr.replace(strToChange, changingStr);
    }
    public static String extractString(String str, int beg, int end){
        return str.substring(beg, end+1);
    }
    public static boolean isEqual(String firstStr, String secondStr){
        //а давайте записиси нашего сверхполезного метода и стандартного
        firstStr = replaceString(firstStr, " ", "");
        secondStr = secondStr.replace(" ", "");
        //разница в том, что для второго время выполнения и нагрузка на ОЗУ меньше, ведь javac не всегда делает такие методы встраиваемыми
        return firstStr.equalsIgnoreCase(secondStr);
    }
    public static boolean isStartWith(String mainStr, String beg){
        return mainStr.toLowerCase(Locale.ROOT).startsWith(beg.toLowerCase(Locale.ROOT));
    }
    public static int numberOfOccurrences(String seekIn, String seekFor){
        int occurrences = 0;
        for(int i = 0; i < seekIn.length()-1; i++){
            if(seekIn.charAt(i) == seekFor.charAt(0)){
                seekIn = seekIn.replaceFirst(seekFor, "");
                occurrences++;
            }
        }
        return occurrences;
    }
    public static double gcContent(String sequence){
        double cAmount = 0.0, gAmount = 0.0;
        for(int i = 0; i<sequence.length()-1; i++){
            if(sequence.charAt(i) == 'g' || sequence.charAt(i) == 'G'){
                gAmount++;
            }
            if(sequence.charAt(i) == 'c' || sequence.charAt(i) == 'C'){
                cAmount++;
            }
        }
        return ((cAmount+gAmount)/(sequence.length()))*100;
    }
    public static boolean isLucky(String number){
        int beg = 0, end = 0;
        for(int i = 0; i<number.length(); i++){
            if(i<=2){
                beg = beg + Character.getNumericValue(number.charAt(i));
            } else {
                end = end + Character.getNumericValue(number.charAt(i));
            }
        }
        return beg == end;
    }
    public static String longestWord(String str){
        //писать понятный код - одна из обязанностей программиста
        //как хорошо, что я не программист
        int longestSize = 0, lastSpaceIndex = 0;
        String longest = "";
        str = str.concat("  ");
        for(int i = 0; i<str.length()-1; i++){
            if(str.charAt(i) == ' '){
                int lettersNum = 0;
                while(str.charAt(lastSpaceIndex)!=' '){
                    lettersNum++;
                    lastSpaceIndex++;
                }
                if(lettersNum>longestSize){
                    longestSize = lettersNum;
                    int j = lastSpaceIndex - longestSize;
                    while(str.charAt(j)!=' '){
                        j++;
                    }
                    longest = str.substring(lastSpaceIndex-lettersNum, j);
                }
                lastSpaceIndex++;
            }
        }
        return longest;
        //не спрашивай что делают отдельные строки метода, я под конец написания уже и сам не помню. Главное, что работает)))))))
    }
    public static String formatDate(String date){
        String newDate = "";
        newDate = date.substring(5, 7) + '/'
                + date.substring(8, 10) + '/'
                + date.substring(0, 4);
        return newDate;
    }
    public static void main(String[] args) {
        System.out.println("Result for method isBurg with value:");
        System.out.println("Augsburg: " + isBurg("Augsburg"));
        System.out.println("Saint Petersburg: " + isBurg("Saint Petersburg"));
        System.out.println("Tu: " + isBurg("Tu") + '\n');

        System.out.println("Result for method replaceString with values:");
        System.out.println("bca, a, b: " + replaceString("bca", "a", "b") + '\n');

        System.out.println("Result for method extractString with values:");
        System.out.println("Java, 0, 2: " + extractString("Java", 0, 2) + '\n');

        System.out.println("Result for method isEquals with values:");
        System.out.println("string, str ing : " + isEqual("string", "str ing"));
        System.out.println("string, my string : " + isEqual("string", "my string")+ '\n');

        System.out.println("Result for method isStartWith with values:");
        System.out.println("Java, j: " + isStartWith("Java", "j"));
        System.out.println("Kotlin, j: " + isStartWith("Kotlin", "j")+ '\n');

        System.out.println("Result for method numberOfOccurrencies with values:");
        System.out.println("ababa, aba: " + numberOfOccurrences("ababa", "aba"));
        System.out.println("hello there, the: " + numberOfOccurrences("hello there", "the"));
        System.out.println("hello yellow jelly, ll: " +numberOfOccurrences("hello yellow jelly", "ll") + '\n');

        System.out.println("Result for method gcContent with value:");
        System.out.println("acggtgttat: " + gcContent("acggtgttat")+ '\n');

        System.out.println("Result for method isLucky with values:");
        System.out.println("090234: " + isLucky("090234"));
        System.out.println("123456: " + isLucky("123456")+ '\n');

        System.out.println("Result for method longestWord with values:");
        System.out.println("one two three four five six: " + longestWord("one two three five sex")+ '\n');

        System.out.println("Result for method formatDate with value:");
        System.out.println("2012-09-28: " + formatDate("2012-09-28")+ '\n');
    }
}
