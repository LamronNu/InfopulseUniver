package lessons.multithreading.skiplist;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class SkipList<T extends Comparable<T>>{

    class Node<T extends Comparable<T>>   implements Comparable<Node<T>>{
        private T value;
        private Node<T> next;

        Node() {
            this(null, null);
        }

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "" + value;
        }

        @Override
        public int compareTo(Node<T> o) {
            if (o == null || this == null){
                return o == null ? 1 : -1;
            }
            if (o.value == null || this.value == null){
                return o.value == null ? 1 : -1;
            }
            return this.value.compareTo(o.value);
        }
    }


    class Index<T extends Comparable<T>>{
        private Node<T> node;
        private Index<T> down;
        private Index<T> right;
        private int level;

        Index() {
            this(new Node<T>(), null, null, 1);
        }

        Index(Node<T> node, Index<T> down, Index<T> right, int level) {
            this.node = node;
            this.down = down;
            this.right = right;
            this.level = level;
        }
    }

    private Index<T> head;
    private int levels;
    private Random random = new Random();
    private int nodeSize = 0;

    SkipList() {
        this.head = new Index<T>();
        this.levels = 0;
    }

    public void add(T value){
        Node<T> insertNode = new Node<T>(value,null);
        //check head
        if (nodeSize == 0){
            head = new Index<T>(insertNode, null, null, 1);
            nodeSize++;
            levels = 1;
            return;
        }
        Node<T> currentNode = head.node;
        Node<T> previousNode = currentNode;
        Index<T> currentIndex = head;
        Index<T> previousIndex = currentIndex;
        Queue<Index<T>> left = new LinkedList<>();
        Queue<Index<T>> right = new LinkedList<>();
        //boolean insertToEnd = false;

        //find Index position
        while (currentNode != null
                && insertNode.compareTo(currentNode) > 0
                ) {
            //Go RIGHT
            while (currentNode != null
                    && insertNode.compareTo(currentNode) > 0
                    ) {//while insertNode > currentNode
                previousNode = currentNode;
                previousIndex = currentIndex;
                currentIndex = currentIndex.right;
                currentNode = currentIndex != null ? currentIndex.node : null;
            }
            //Go DOWN
            if (previousIndex.level != 1) {
                left.add(previousIndex);
                right.add(currentIndex);
                previousIndex = previousIndex.down;
                currentIndex = previousIndex;//from beginning //currentIndex.down;

            }
        }

        //find Node position
        Node<T> findNode = previousNode;
        while (previousNode.compareTo(insertNode) <= 0
                && insertNode.compareTo(currentNode) < 0
                ){
            previousNode = findNode;
            if (findNode.next == null) break;
            findNode = findNode.next;
        }

        //insert node after previous node
        previousNode.next = insertNode;
        insertNode.next = findNode;
        nodeSize++;

        //insert indexes if need
        boolean needIndex = random.nextBoolean() || currentNode == null;//?? if it is end -- index required!!
        int currentLevel = 1;
        Index<T> downIndex = null;
        while (needIndex && currentLevel <= levels){
            Index<T> insertIndex = new Index<>(insertNode,downIndex, currentIndex, currentLevel);
            previousIndex.right = insertIndex;
            downIndex = insertIndex;
            if (levels != 1){
                previousIndex = left.poll();
                currentIndex = right.poll();
                needIndex = random.nextBoolean();//??
                currentLevel++;
            }
        }

        //on top -- if need new level?
        if (needIndex && currentLevel > levels){
            //find "end"
            Index<T> endIndex = downIndex;//.right;
            while ((endIndex = endIndex.right) != null);
            endIndex = new Index<T>(endIndex.node,endIndex, null, currentLevel);
            //inserted index -- to "middle"
            Index<T> insertIndex = new Index<T>(insertNode,downIndex, endIndex, currentLevel);
            //rewrite head
            head = new Index<T>(head.node,head, insertIndex, currentLevel);
            levels++;
        }

    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("SkipList. ");
        result.append("Nodes: [");
        Node<T> node = head.node;
        while (node != null){
            result.append(node.value);
            node = node.next;
            result.append(node == null ? "" : ", ");
        }
        result.append("]\n")
                .append("Levels: ")
                .append(levels);
        int level = levels;
        Index<T> rightIndex = head;
        Index<T> leftIndex = head;
        while (level > 0){
            result.append("\n")
                    .append(level)
                    .append(": [");

            while (rightIndex.node != null){
                result.append(rightIndex.node.value);
                rightIndex = rightIndex.right;
                result.append(rightIndex.node == null ? "" : ", ");
            }
            result.append("]");
            rightIndex = leftIndex.down;
            leftIndex = rightIndex;
            level--;
        }
        result.append("\n");
        return  result.toString();
    }
}

public class SkipListTest {
    public static void main(String[] args) {
        SkipList<Integer> skipList = new SkipList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++){
            skipList.add(random.nextInt(20));
        }
        System.out.println(skipList);
    }
}
