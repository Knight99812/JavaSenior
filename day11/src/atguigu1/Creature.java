package atguigu1;

import java.io.Serializable;

/**
 * @author SHJ
 * @create 2023-01-09 9:09
 */
public class Creature<T> implements Serializable {

    private char gender;
    public double weight;

    private void breath() {
        System.out.println("生物呼吸");
    }

    public void eat() {
        System.out.println("生物吃东西");
    }

}
