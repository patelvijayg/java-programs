package com.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MatchBrackets {

    public static void main(String[] args) {
        MatchBrackets matchBrackets = new MatchBrackets();
        List<String> list = matchBrackets.generateParenthesis1(3);
        list.forEach(i -> System.out.println(i));
    }
    Map<Integer, List<String>> cache = new HashMap<>();
     public List<String> generateParenthesis1(int n) {
        if(cache.containsKey(n)) return cache.get(n);
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c) {
                for (String left : generateParenthesis1(c)) {
                    for (String right : generateParenthesis1(n - 1 - c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache.put(n, ans);
        return ans;
    }
    List<String> result = new ArrayList<String>();

    public List<String> generateParenthesis2(int n)
    {
        char[] chs = new char[2*n];

        generate(chs, 0, n, n);
        return result;
    }

    public void generate(char[] chs, int index, int l, int r)
    {
        if(r==0)
        {
            result.add(new String(chs));
        }

        if(l>0)
        {
            chs[index] = '(';
            generate(chs, index+1, l-1, r);
        }

        if(r>l)
        {
            chs[index] = ')';
            generate(chs, index+1, l, r-1);
        }
    }
}