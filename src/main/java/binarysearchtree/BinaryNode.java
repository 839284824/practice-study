package binarysearchtree;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gongzhao
 * @description
 * @Date 14:432018/9/12
 */
@Data
public class BinaryNode {


    private Integer data;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode(Integer data,BinaryNode left,BinaryNode right){
        this.data = data;
        this.left =  left;
        this.right = right;
    }
}
