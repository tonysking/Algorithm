package com.leet.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 */
public class ZConvert {
    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            rows.add(new StringBuilder());
        }

        char[] chars = s.toCharArray();

        int curRow = 0;
        boolean isGoingDown = false;

        for (char ch : chars) {
            rows.get(curRow).append(ch);
            if (curRow == 0 || curRow == numRows - 1) {
                isGoingDown = !isGoingDown;
            }
            curRow += isGoingDown ? 1 : -1;
        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();

    }
}
