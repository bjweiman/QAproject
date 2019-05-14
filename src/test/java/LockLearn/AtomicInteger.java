/*
package LockLearn;

import java.io.Serializable;

*/
/**
 * @program: QAproject
 * @description: 乐观锁
 * @author: bjweiman
 * @create: 2019-04-22 21:03
 **//*

public class AtomicInteger extends Number implements Serializable {
    private volatile int value;
    public final int get(){
        return value;
    }

    public final int getAndIncremnt(){
        for(;;){
            int current = get();
            int next = current +1;
            if (compareAndSet(current, next)){
                return current;
            }
        }
    }

    public boolean compareAndSet(int expect, int update){
//        return unsafe.compareAndSwapInt(this, valueOffset, expect, update);

    }
}
*/
