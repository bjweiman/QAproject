package DesignModel.ObserveModel;

/**
 * @program: QAproject
 * @description: 观察者模式测试方法
 * @author: bjweiman
 * @create: 2019-04-07 15:35
 **/
public class ObserveModel {

    public static void main(String[] args) {
        QuotationObservable observable = new QuotationObservable();
        QuotationObserver observer = new QuotationObserver();
        observable.addObserver(observer);
//        observable.observe();

        QuotationObserver2 observer2 = new QuotationObserver2();
        observable.addObserver(observer2);

        observable.observe();

    }
}
