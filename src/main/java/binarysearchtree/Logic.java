package binarysearchtree;

/**
 * @author gongzhao
 * @description
 * @Date 14:462018/9/12
 */
public  class Logic {

    /**
     * 是否包含data
     * @param data
     * @param root
     * @return
     */
    static boolean contains(Integer data,BinaryNode root){
        if (root == null){
            return false;
        }else {
            int compare = data.compareTo(root.getData());
            if (compare==0){
                return true;
            }
            else if (compare<0){
                return contains(data,root.getLeft());
            }else {
                return contains(data,root.getRight());
            }
        }
    }

    /**查找最小的元素
     * @param root
     * @return
     */
    static BinaryNode findMin(BinaryNode root){
        if (root==null){
            return null;
        }
        if (root.getLeft()==null){
            return root;
        }
        return findMin(root.getLeft());
    }

    /**
     * 查找最大的元素
     * @param root
     * @return
     */
    static BinaryNode findMax(BinaryNode root){
        if (root==null){
           return null;
        }
        while (root.getLeft()!=null){
            root = root.getRight();
        }
        return root;
    }

    /**插入元素
     * @param data
     * @param root
     * @return
     */
    static BinaryNode insert(Integer data,BinaryNode root){
        if (root==null){
            return new BinaryNode(data,null,null);
        }
        int compare = data.compareTo(root.getData());
        if(compare<0){
            root.setLeft(insert(data,root.getLeft()));
        }else if (compare>0){
            root.setRight(insert(data,root.getRight()));
        }
        return root;
    }
}
