package test.com.hust.tree; 

import com.hust.tree.PreorderTraversal;
import com.hust.tree.TreeNode;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;

/** 
* PreorderTraversal Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 24, 2019</pre> 
* @version 1.0 
*/ 
public class PreorderTraversalTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: preorderTraversal(TreeNode root) 
* 
*/ 
@Test
public void testPreorderTraversal() throws Exception { 
//TODO: Test goes here...
    /*
               1
             2   3
           4  5 6  7
     */
    TreeNode root = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(5);
    TreeNode n6 = new TreeNode(6);
    TreeNode n7 = new TreeNode(7);
    root.left = n2; root.right = n3;
    n2.left = n4; n2.right = n5;
    n3.left = n6; n3.right = n7;
    PreorderTraversal preorderTraversal = new PreorderTraversal();
    ArrayList<Integer> arrayList = preorderTraversal.preorderTraversal(root);
    for (int i = 0; i < arrayList.size(); i++) {
        System.out.println(arrayList.get(i));
    }


} 


} 
