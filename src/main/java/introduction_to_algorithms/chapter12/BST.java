package introduction_to_algorithms.chapter12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 * Created by yuanzhuo on 2017/4/10.
 */

class BSTNode{
    int key;
    BSTNode left;
    BSTNode right;
    BSTNode parent;

    public BSTNode(int key){
        this.key = key;
        left = null;
        right = null;
        parent = null;
    }
    public BSTNode(){
        this.key = 0;
        left = null;
        right = null;
        parent = null;
    }

}


public class BST {
    public static BSTNode root; //声明全局变量，操作这个全局变量，改变才会生效

    public BST(){
        root = null;
    }

    /**
     * 向二叉搜索树插入新节点 非递归
     * @param key 待插入的关键字
     * @return
     */
    public BSTNode insert(int key){
        BSTNode new_node = new BSTNode(key);
        if (root == null ){
            root = new_node;
            return root;
        }

        BSTNode cur = root;
        BSTNode parent = null;


        while (true){
            parent = cur;
            if (key > cur.key){
                cur = cur.right;
                if (cur == null){
                    parent.right = new_node;
                    new_node.parent = parent;
                    return new_node;
                }

            }else {
                cur = cur.left;
                if (cur == null){
                    parent.left = new_node;
                    new_node.parent = parent;
                    return new_node;
                }
            }
        }
    }

    //构建BST
    public void createBST(int[] A){

        for (int i = 0; i < A.length; i++) {
            insert(A[i]);
        }
    }


    //** 如何递归的建树：难点，若把BSTNode 作为参数传递则，函数的内部改变对原节点无用。
    public void insertRecursion(int key){

    }


    /**
     * 在二叉搜索树中查找元素
     * @param x
     * @param key
     * @return
     */
    public BSTNode searchRecusion(BSTNode x, int key){
        if (x == null || x.key == key)
            return x;


        if (x.key > key)
           return searchRecusion(x.left, key);
        else
            return searchRecusion(x.right, key);

    }


    /**
     * 返回树中的最小元素
     * @return
     */
    public BSTNode minNum(BSTNode root){
        BSTNode x = root;
        if (x == null)
            return x;

        while (x.left != null){
            x=x.left;
        }
        return x;
    }


    /**
     * 返回树中最大元素
     * @return
     */
    public BSTNode maxNum(BSTNode root){
        BSTNode x = root;
        if (x == null)
            return x;

        while (x.right != null){
            x=x.right;
        }
        return x;
    }


    /**
     * 查找元素x的后继节点：比x大的最小元素，最大元素的后继为空
     * 1、如果x的右子树不为空，则后继为右子树中的最小元素
     * 2、如果x的右子树为空，则后继为x的一个具有做孩子的祖先，且该做孩子也是x的祖先。
     *       若x为其父的右孩子：顺着x的父节点往上找，直到找到一个祖先y，该y是其父f的左孩子，则f就是x的后继节点
     *       若x为其父的左孩子：则父节点即为后继。
     * @param x
     * @return
     */
    public BSTNode successor(BSTNode x){
        if (x == null)
            return x;

        if (x.right != null)
            return minNum(x.right);
        BSTNode p = x.parent;
        while (p != null && x == p.right){
            x = p;
            p = p.parent;
        }
        return p;
    }


    /**
     * 查找二叉搜索树中节点x的前驱：比x小的元素的最大值
     * 1、如果x的左子树存在，则x的前驱为x的左子树中的最大值
     * 2、如果x的左子树为空，则x的前驱为x的第一个有左子树的祖先，且该祖先的左孩子也是x的祖先或是x本身
     *      若x为其父的右孩子：则x的父节点即为前驱
     *      若x为其父的左孩子：则沿着x的父节点向上，找到一个祖先y，该y是其父的右孩子则y的父节点就是x的前驱。
     * @param x
     * @return
     */
    public BSTNode predecessor(BSTNode x){
        if (x == null)
            return x;

        if (x.left != null)//case1
            return maxNum(x.left);
        BSTNode p = x.parent;
        while (p != null && x == p.left){//case2
            x = p;
            p = p.parent;
        }
        return p;
    }



    public BSTNode search(int key){
        BSTNode x = root;
        while (x != null ){
            if (x.key == key) {
                break;
            }
            else if (x.key > key){
                x = x.left;
            }else {
                x = x.right;
            }

        }
        return x;
    }


    //中序遍历搜索二叉树，输出排序数组
    public void travelInorderR(BSTNode root){
        if (root == null){
            return;
        }
        travelInorder(root.left);
        System.out.print(root.key+" ");
        travelInorder(root.right);
    }

    //中序遍历搜索二叉树，输出排序数组
    public void travelInorder(BSTNode root){
        if (root == null)
            return;

    }



    //广度优先遍历
    public void travelBrandFistr(BSTNode root){
        Queue<BSTNode> q = new LinkedList<BSTNode>();
        ArrayList<String> as = new ArrayList<String>();
        int level_last = 0;
        q.offer(root);
        while (!q.isEmpty()){
            level_last = q.size();
            int level_cur = 0;
            String line = "";
            while (level_cur < level_last){
                BSTNode head = q.poll();
                System.out.print(head.key + " ");
                level_cur++;
                line += head.key+" ";
                if (head.left != null){
                    q.offer(head.left);
                }
                if (head.right != null) {
                    q.offer(head.right);
                }
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int A[] = {2,5,9,3,1,6};
        BST bst = new BST();
        bst.createBST(A);
        bst.travelBrandFistr(root);
        bst.travelInorder(root);
        System.out.println("查找关键字6 " + bst.search(6).key);
        System.out.println("最小值 " + bst.minNum(root).key);
        System.out.println("最大值 " + bst.maxNum(root).key);
        System.out.println("后继 "+bst.successor(root.left).key);
        System.out.println("前驱 "+bst.predecessor(root.left).key);


    }
}





