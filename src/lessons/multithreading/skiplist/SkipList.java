package lessons.multithreading.skiplist;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class SkipList<T extends Comparable<T>>{

    public T get() {
        return head.node.value;
    }

    public int size() {
        return nodeSize;
    }

    public int levels() {
        return levels;
    }

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

        @Override
        public String toString() {
            return "Index{" +
                    "level=" + level +
                    ", node=" + node +
                    ", down=" + down +
                    ", right=" + right +
                    '}';
        }
    }

    private Index<T> head;
    private Index<T> tale;
    private int levels;
    private Random random = new Random();
    private int nodeSize = 0;

    public SkipList() {
        this.head = new Index<T>();
        this.tale = head;
        this.levels = 0;
    }

    public void add(T value){
        Node<T> insertNode = new Node<T>(value,null);
        //check head
        if (nodeSize == 0){
            head = new Index<T>(insertNode, null, null, 1);
            tale = head;
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
        while (currentNode != tale.node
                && insertNode.compareTo(currentNode) > 0
                ) {
            //Go RIGHT
            while (currentNode != tale.node
                    && insertNode.compareTo(currentNode) > 0
                    ) {//while insertNode > currentNode
                previousNode = currentNode;
                previousIndex = currentIndex;
                currentIndex = currentIndex.right;
                currentNode = currentIndex.node;
            }
            //Go DOWN
            if (previousIndex.level != 1) {
                left.add(previousIndex);
                right.add(currentIndex);
                previousIndex = previousIndex.down;
                currentIndex = previousIndex;//from beginning //currentIndex.down;
                previousNode = currentIndex.node;
                currentNode = previousNode;
            }
        }

        //find Node position
        Node<T> findNode = previousNode;
        while (previousNode.compareTo(insertNode) <= 0
                && insertNode.compareTo(currentNode) < 0
                && (findNode.next != tale.node)
                ){
            previousNode = findNode;
            findNode = findNode.next;
        }

        //insert node after previous node
        if (previousIndex == head
                && currentIndex == head){//rewrite head

            //inserted index -- to "middle"
            Index<T> newHead = new Index<T>(insertNode,head.down, head.right, head.level);
            //references
            insertNode.next = head.node;
            //head.down =
            previousIndex = newHead;
            previousNode = newHead.node;
            //currentIndex = head;//todo!!!
            //currentNode = currentIndex.node;

            head = newHead; // old head must be clear by GC
            insertNode = insertNode.next; //calc indexes for old "head"-node

        } else {
            previousNode.next = insertNode;
            insertNode.next = previousNode != findNode ? findNode : null;
        }
        nodeSize++;

        //insert indexes if need
        int currentLevel = 1;
        boolean needIndex = getIsNeedIndex(currentLevel) ;//|| nodeSize == 2;//currentNode == null;//?? if it is end -- index required!!
        Index<T> downIndex = null;
        while (needIndex && currentLevel <= levels){
            Index<T> insertIndex = new Index<>(insertNode,downIndex, currentIndex, currentLevel);
            previousIndex.right = insertIndex;
            downIndex = insertIndex;
            if (levels != 1){
                previousIndex = left.poll();
                currentIndex = right.poll();
            }
            currentLevel++;
            needIndex = getIsNeedIndex(currentLevel);//??
        }

        //on top -- if need new level?
        if (needIndex && currentLevel > levels){
            //find "end"
            Index<T> endIndex = downIndex;//.right;
            while (endIndex.right != null){
                endIndex = endIndex.right;
            }
            endIndex = endIndex.node != insertNode
                    ? new Index<T>(endIndex.node,endIndex, null, currentLevel)
                    : null;
            //inserted index -- to "middle"
            Index<T> insertIndex = //(previousNode != insertNode)
                    //?
                    new Index<T>(insertNode,downIndex, endIndex, currentLevel);
                    //: endIndex;
            //rewrite head
            head = new Index<T>(head.node,head, insertIndex, currentLevel);
            levels++;
        }

    }

    private boolean getIsNeedIndex(int level) {
        return random.nextInt(level) == 0;
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

            while (rightIndex != null){
                result.append(rightIndex.node.value);
                rightIndex = rightIndex.right;
                result.append(rightIndex == null ? "" : ", ");
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
