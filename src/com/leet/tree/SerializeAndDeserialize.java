package com.leet.tree;

/**
 * 449. 序列化和反序列化二叉搜索树
 */
public class SerializeAndDeserialize {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    // 必须加分割符，否则节点值>=10无法分割，如[20, 10, 30] -> [201030]
    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#-");
            return;
        }
        sb.append(String.valueOf(root.val)).append("-");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] datas = data.split("-");
        return preorderBuild(datas, 0, datas.length - 1);
    }

    private TreeNode preorderBuild(String[] data, int start, int end) {
        if (start > end) {
            return null;
        }
        String s = data[start];
        if (s.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(s));
        if (start == end) {
            return node;
        }

        /*
            从先序遍历结果[start, end]得到左子树结束位置
            root为data[start]
            二叉搜索树左子树节点均小于root, 由此划分左右子树
         */
        int leftEnd = start + 1;
        while (leftEnd <= end &&
                (data[leftEnd].equals("#")
                        || Integer.parseInt(data[leftEnd]) < Integer.parseInt(data[start]))){
            leftEnd++;
        }

        node.left = preorderBuild(data, start + 1, leftEnd - 1);
        node.right = preorderBuild(data, leftEnd, end);
        return node;
    }

    public static void main(String[] args) {
        SerializeAndDeserialize res = new SerializeAndDeserialize();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        String serialize = res.serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = res.deserialize(serialize);
    }
}
