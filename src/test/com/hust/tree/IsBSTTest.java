package test.com.hust.tree; 

import com.hust.tree.IsBST;
import com.hust.tree.TreeNode;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* IsBST Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 11, 2019</pre> 
* @version 1.0 
*/ 
public class IsBSTTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: isValidBST(TreeNode root) 
* 
*/ 
@Test
public void testIsValidBST() throws Exception { 
//TODO: Test goes here...
    TreeNode a = new TreeNode(1);
    a.left = new TreeNode(1);
    IsBST isBST = new IsBST();
    boolean validBST = isBST.isValidBST(a);
    System.out.println(validBST);
    
    // 法二 中序 测试
    TreeNode b = new TreeNode(0);
    boolean validBST2 = isBST.isValidBST2(b);
    System.out.println(validBST2);
} 

/** 
* 
* Method: processIsBST(TreeNode root) 
* 
*/ 
@Test
public void testProcessIsBST() throws Exception { 
//TODO: Test goes here... 
} 


} 
