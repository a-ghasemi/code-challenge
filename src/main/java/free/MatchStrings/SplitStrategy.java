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

        t = checkAndRemoveFirstPart(t);

        if (t == null) return "NO";

        if (!checkLastPart(t)) return "NO";

        return "YES";
    }

    private static boolean checkLastPart(String t) {
        String part = splits.removeLast();
        return (t.endsWith(part));
    }

    private static String checkAndRemoveFirstPart(String t) {
        String part = splits.removeFirst();
        if (!t.startsWith(part)) {
            return null;
        }
        t = t.substring(part.length());

        if(splits.isEmpty()){
            return null;
        }
        return t;
    }
}

