package lessons.multithreading.skiplist;


import java.util.Random;

public class SkipListTest {
    public static void main(String[] args) {
        SkipList<Integer> skipList = new SkipList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++){
            skipList.add(i);
        }
        System.out.println(skipList);
    }
}
