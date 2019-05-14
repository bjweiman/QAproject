package DesignModel.ObserveModel;

import java.util.Observable;
import java.util.Observer;

/**
 * @program: QAproject
 * @description: 观察者
 * @author: bjweiman
 * @create: 2019-04-07 16:53
 **/
public class QuotationObserver2 implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("2被观察者满足条件，通知观察者执行，update方法");
    }
}
