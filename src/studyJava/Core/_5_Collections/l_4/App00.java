package studyJava.Core._5_Collections.l_4;

import java.util.NavigableSet;
import java.util.TreeSet;
/**
 * Created by Olga on 01.07.2014.
 */
public class App00 {
    public static void main(String[] args) {
        NavigableSet<User> users = new TreeSet();
        users.add(new User(25, "Mike"));
        users.add(new User(20, "Ann"));
        users.add(new User(25, "Kate"));
        System.out.println(users);

    }
}

class User implements Comparable<User> {
    public int age;
    public String name;

    User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
     public int compareTo(User that) {
        int result = this.age - that.age;
        return result == 0 ? this.name.compareTo(that.name) : result;
    }

    @Override
    public String toString() {
        return "User{" +
                "age="+age+
                ",name='"+name+'\'' + '}';
    }
}
