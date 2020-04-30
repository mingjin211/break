package geektime.structure.chapter24BinaryTree2;

import geektime.structure.chapter23BinaryTree1.Node;

/**
 * 二叉查找树是二叉树中最常用的一种类型，也叫二叉搜索树。顾名思义，二叉查找树是为了实现快速查找而生的。
 * 不过，它不仅仅支持快速查找一个数据，还支持快速插入、删除一个数据。
 * 这些都依赖于二叉查找树的特殊结构。
 * 二叉查找树要求，在树中的任意一个节点，其左子树中的每个节点的值，都要小于这个节点的值，而右子树节点的值都大于这个节点的值
 *
 */
public class BinarySearchTree {

    private Node tree;

    /**
     * 查找 Node.data = data 的节点
     *
     * 看如何在二叉查找树中查找一个节点。我们先取根节点，如果它等于我们要查找的数据，那就返回。
     * 如果要查找的数据比根节点的值小，那就在左子树中递归查找；如果要查找的数据比根节点的值大，那就在右子树中递归查找。
     *
     * @param data
     * @return
     */
    public Node find(int data){
        Node p = tree;
        while (p!=null){
            if(data < p.getData()){
                p = p.getLeft();
            }else if(data > p.getData()){
                p = p.getRight();
            }else return p;
        }
        return null;
    }

    /**
     * 插入 data 到合适位置
     *
     * 插入过程有点类似查找操作。新插入的数据一般都是在叶子节点上，所以我们只需要从根节点开始，依次比较要插入的数据和节点的大小关系。
     * 如果要插入的数据比节点的数据大，并且节点的右子树为空，就将新数据直接插到右子节点的位置；如果不为空，就再递归遍历右子树，查找插入位置。同理，
     * 如果要插入的数据比节点数值小，并且节点的左子树为空，就将新数据插入到左子节点的位置；如果不为空，就再递归遍历左子树，查找插入位置。
     *
     * @param data
     * @return
     */
    public void insert(int data){
        if(tree == null){
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while(p!=null){
            if(data < p.getData()){
                if(p.getLeft() == null){
                    p.setLeft(new Node(data));
                    return;
                }else{
                    p = p.getLeft();
                }
            }else if(data > p.getData()){
                if(p.getRight() == null){
                    p.setRight(new Node(data));
                    return;
                }else{
                    p = p.getRight();
                }
            }
        }
    }

    /**
     * 删除 Node.data = data 的节点
     *
     * 针对要删除节点的子节点个数的不同，我们需要分三种情况来处理。
     * 第一种情况是，如果要删除的节点没有子节点，我们只需要直接将父节点中，指向要删除节点的指针置为null。
     * 第二种情况是，如果要删除的节点只有一个子节点（只有左子节点或者右子节点），我们只需要更新父节点中，指向要删除节点的指针，让它指向要删除节点的子节点就可以了。
     * 第三种情况是，如果要删除的节点有两个子节点，这就比较复杂了。我们需要找到这个节点的右子树中的最小节点，把它替换到要删除的节点上。
     * 然后再删除掉这个最小节点，因为最小节点肯定没有左子节点（如果有左子结点，那就不是最小节点了），所以，我们可以应用上面两条规则来删除这个最小节点。
     *
     * @param data
     * @return
     */
    public void delete(int data){
        Node p = tree;
        Node pp = null; //记录p的父节点
        while( p != null && p.getData() != data){
            pp = p;
            if(data > p.getData()){
                p = p.getRight();
            }else{
                p = p.getLeft();
            }
        }

        //没找到
        if(p==null)return;

        //情况3 要删除的节点有两个子节点
        if(p.getRight() != null && p.getLeft() != null){
            Node minP = p;
            Node minPP = pp;
            while (minP.getLeft()!=null){
                minPP = minP;
                minP = minP.getLeft();
            }
            p.setData(minP.getData());
            p = minP;
            pp = minPP; //删除的操作留到下面操作
        }

        //情况2 要删除节点是叶子节点或者仅有一个子节点
        Node child;
        if(p.getLeft() != null){
            child = p.getLeft();
        }else if(p.getRight() != null){
            child = p.getRight();
        }else child = null;

        if(pp==null)tree=child;
        else if(pp.getLeft()==p)pp.setLeft(child);
        else pp.setRight(child);
    }

    //查找最大节点和最小节点、前驱节点和后继节点

    /**
     * 查找最大节点
     * @return
     */
    public Node searchForBiggest(){
        return null;
    }
    /**
     * 查找最小节点
     * @return
     */
    public Node searchForSmallest(){
        return null;
    }

    /**
     * 前驱节点
     * @Param p
     * @return
     */
    public Node searchForPre(Node p){
        return null;
    }

    /**
     * 后继节点
     * @Param p
     * @return
     */
    public Node searchForNext(Node p){
        return null;
    }

}
