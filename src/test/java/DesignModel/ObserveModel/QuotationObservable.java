package DesignModel.ObserveModel;

import java.util.Observable;

/**
 * @program: QAproject
 * @description: 被观察者
 * @author: bjweiman
 * @create: 2019-04-07 15:30
 **/
public class QuotationObservable extends Observable {

    public void observe(){
        System.out.println("被观察者满足条件，通知观察者");
        this.setChanged();
        this.notifyObservers();

    }
}
