package com.xiaolu.jdk.myTest;

/**
 * 测试
 *
 * @author xiaolu
 * @since 2022/11/5
 */
public class myTest {
    static volatile Integer count = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread a = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                ++count;
            }
        }, "A");
        Thread b = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                ++count;
            }
        }, "B");
        a.start();
        b.start();
//        TimeUnit.SECONDS.sleep(2);

        for (; ; ) {
            if (count == 200) {
                System.out.println(count);
                return;
            }
        }

    }
}
