package datastructure.Link;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Desc
 * @Author gongzhao
 * @Date 2019/9/1815:10
 */
@Data
@Slf4j
public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

}
