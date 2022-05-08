package car.practice8;
import java.util.*;
import java.lang.String;

import static java.lang.System.out;

public class wordTransformation {
    static String[][] resultMap;
    static Map<String,Integer> reverseDictionary;

    public static void main(String[] args) {
        HashMap<Integer, String> stringHashMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), min = 0, minStep = 0, stringHashMapSize = 0;
        String string = "", start = "", end = "";
        Set<Integer> set = new HashSet();
        Iterator<Integer> it;
        while (n != 0) {
            n = n - 1;
            while (!string.equals("*")) {
                string = scanner.nextLine();
                if (string.equals("\n"))
                    string = scanner.nextLine();
                stringHashMap.put(n, string);
                reverseDictionary.put(string,n);
                n++;//save dictionary
            }
            stringHashMapSize = stringHashMap.size();
            String[] used = new String[stringHashMapSize];
            resultMap = new String[stringHashMapSize][];
            for (int i = 0, j = 0; i < stringHashMapSize; i++) {
                resultMap[i] = new String[]{""};
            }
            while (!start.equals("\n")) {
                start = scanner.next();
                end = scanner.next();
                for (int i = 0, j = 0; i < stringHashMapSize; i++) {//字典開始查訪可能的
                    if (isNext(start, stringHashMap.get(i))) {
                        string = stringHashMap.get(i);
                        min++;
                        while (!end.equals(string)) {//當未到終點則持續尋找
                            if (isNext(string, stringHashMap.get(j++))) {
                                string = stringHashMap.get(j);
                                min++;
                            }
                        }
                        min++;
                    }
                    set.add(min);
                    min = 0;
                }
                it = set.iterator();
                for (int i : set) {
                    minStep = Math.min(it.next(), minStep);
                }
                out.printf("%s %s %d\n", start, end, minStep);
            }
        }

    }

    /*static boolean isNext(String string,String map) {
        int same=0;
        if(map==null||string==null||string.length()!=map.length()) return false;
        char[] charMap=map.toCharArray();
        for (int i=0; i < string.length(); i++) {
            for (int j=0; j < string.length(); j++) {
                if (string.charAt(i) == charMap[j]) {
                    same++;
                    charMap[j]='?';
                }
            }
        }
        return same == string.length()-1;
    }*/
    static boolean isNext(String string, String map) {
        int same = 0;
        if (map == null || string == null || string.length() != map.length()) return false;
        char[] charMap = map.toCharArray();
        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < string.length(); j++) {
                if (string.charAt(i) == charMap[j]) {
                    same++;
                    charMap[j] = '?';
                }
            }
        }
        if(same==string.length()-1){
            resultMap[reverseDictionary.get(string)][reverseDictionary.get(map)]="1";
            resultMap[reverseDictionary.get(map)][reverseDictionary.get(string)]="1";
        }
        return same == string.length()-1;
    }
}
