package free.MatchStrings;

import free.MatchStrings.abstractions.Strategy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SplitStrategy implements Strategy {
    static List<String> splits;

    @Override
    public String run(int m, int n, String s, String t){
        splits = new LinkedList<>(Arrays.asList(s.split("\\*")));

        if (!checkFirstPart(t)) return "NO";
        if(splits.isEmpty()){
            return "NO";
        }
        t = removeFirstPart(t);
        if (!checkLastPart(t)) return "NO";

        return "YES";
    }

    private static boolean checkLastPart(String t) {
        String part = splits.removeLast();
        return (t.endsWith(part));
    }

    private static boolean checkFirstPart(String t) {
        return t.startsWith(splits.getFirst());
    }
    private static String removeFirstPart(String t) {
        return t.substring(splits.removeFirst().length());
    }
}

