package com.company.baidu;

/**
 * 象棋盘：将、帅、士
 * 打印所有结果（将帅不能碰面）
 *      将（J）
 *
 *  --- 楚汉 ---
 *
 *      士（T）
 *      帅（S）
 */
public class ChessFinal {

    int count = 0;
    int curCount = 0;
    // 士所有位置
    int[][] tPos = new int[][]{{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}};
    public void getRes(char[][] cUp, char[][] cDown) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                curCount = 0;
                // 将
                cUp[i][j] = 'J';
                System.out.println("将: (" + i + ", " + j + ") " + "开始");
                // 士和帅
                for (int k = 0; k < tPos.length; k++) {
                    putGuardAndKing(j, cUp, cDown, tPos[k][0], tPos[k][1]);
                }
                System.out.println("将: (" + i + ", " + j + ") " + "结果数：" + curCount);
                System.out.println("==========================");
                cUp[i][j] = '*';
            }
        }
        System.out.println("全部结果数：" + count);
    }

    private void putGuardAndKing(int jCol, char[][] cUp, char[][] cDown, int tRow, int tCol) {
        // 士
        cDown[tRow][tCol] = 'T';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i != tRow || j != tCol) {
                    // 士挡住了将 或 将和帅非同一列
                    if(jCol == tCol && tRow < i || j != jCol) {
                        // 放帅
                        cDown[i][j] = 'S';
                        System.out.println("----------------");
                        printArray(cUp);
                        printArray(cDown);
                        System.out.println("----------------");
                        cDown[i][j] = '*';
                        curCount++;
                        count++;
                    }
                }
            }
        }
        cDown[tRow][tCol] = '*';
    }

    private void printArray(char[][] chars) {
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                System.out.print(chars[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        char[][] cUp = new char[][]{
                {'*','*','*'},
                {'*','*','*'},
                {'*','*','*'}
        };

        char[][] cDown = new char[][]{
                {'*','*','*'},
                {'*','*','*'},
                {'*','*','*'}
        };


        ChessFinal res = new ChessFinal();
        res.getRes(cUp, cDown);
    }
}
