package com.dynamicprog;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.isEmpty()) {
            return false;
        }

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // Empty string is always breakable

        for (int end = 1; end <= n; end++) {
            for (int start = 0; start < end; start++) {
                if (dp[start] && wordDict.contains(s.substring(start, end))) {
                    dp[end] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("leet"); wordDict.add("code");
        //List<String> wordDict = List.of("leet", "code");
        
        s = "applepenapple";
        wordDict = new ArrayList<String>();
        wordDict.add("apple"); wordDict.add("pen");

        boolean canBreak = wordBreak(s, wordDict);
        System.out.println("Can the string be broken? " + canBreak);
    }
}
