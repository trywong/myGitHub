package com.wc.pattern;

import com.wc.pattern.abstractFactory.food.DicosFactory;
import com.wc.pattern.abstractFactory.food.IFastFoodFactory;
import com.wc.pattern.abstractFactory.food.KFCFactory;
import com.wc.pattern.abstractFactory.food.MacDonaldFactory;
import com.wc.pattern.abstractFactory.tec.HaierFactory;
import com.wc.pattern.abstractFactory.tec.MiFactory;
import com.wc.pattern.abstractFactory.tec.TecFactory;
import com.wc.pattern.abstractFactory.tec.Television;
import com.wc.pattern.abstractFactory.tec.WashMachine;
import com.wc.pattern.headfirst.observer.PhoneObserver;
import com.wc.pattern.headfirst.observer.Subject;
import com.wc.pattern.headfirst.observer.TvObserver;
import com.wc.pattern.headfirst.observer.WeatherData;
import com.wc.pattern.observe.AbstractController;
import com.wc.pattern.observe.ConcreteController;
import com.wc.pattern.observe.Observer;
import com.wc.pattern.observe.Player;
import com.wc.pattern.templeMethod.AbstractEat;
import com.wc.pattern.templeMethod.ChickenEat;
import com.wc.pattern.templeMethod.NoodleEat;
import com.wc.pattern.visit.Attendence;
import com.wc.pattern.visit.ElementManager;
import com.wc.pattern.visit.HumanResourceVisitor;
import com.wc.pattern.visit.Salary;

/**
 * 抽象工厂模式
 *
 * @author wangchuan
 * @since V1.0.0
 */
public class FactoryTest {

    public static void main(String[] args) {
        /*
         * 简单工厂模式
         */
        /*Shape shape = SimpleFactory.createShape("circle");
        shape.draw();
        shape.erase();*/

        /*
         * 工厂方法模式
         */
        /*ShapeFactory factory = new CircleButtonFactory();
        factory.generateButton();*/
        
        /*ImageFactory factory = new JpgImageFactory();
        factory.showImage();*/

        /*
         * 抽象工厂模式
         */
        /*IFastFoodFactory factory = new KFCFactory();
        factory.generateHamburger().wenwenwen();
        factory.generateChicken().chichichi();
        
        factory = new MacDonaldFactory();
        factory.generateHamburger().wenwenwen();
        factory.generateChicken().chichichi();
        
        factory = new DicosFactory();
        factory.generateHamburger().wenwenwen();
        factory.generateChicken().chichichi();*/
        
        TecFactory factory = new MiFactory();
        Television tv = factory.createTV();
        tv.wach();
        WashMachine washMachine = factory.createWashMachine();
        washMachine.wash();

        /**
         * 单例模式
         */
        /*Singleton singleton = Singleton.getInstance();
        singleton.doSomething();
        
        singleton = Singleton.getInstance();
        singleton.doAnotherthing();*/

        /*
         * 建造者模式
         */
        /*ActorController controller = new ActorController();
        // 传递不同的建造者，产生不同的完整产品; 类似抽象工厂模式，抽象工厂产生一系列零件模块
        Actor actor = controller.actorConstruct(new AngelBuilder());
        System.out.println(actor.toString());*/

        /*
         * 桥接模式
         * 型号和颜色分开，便于扩展
         */
        /*BrushPen brushPen = new MiddleBrushPen();
        brushPen.setColor(new BlueColor());
        brushPen.paint();

        brushPen = new MiniBrushPen();
        brushPen.setColor(new RedColor());
        brushPen.paint();

        brushPen.setColor(new BlueColor());
        brushPen.paint();*/

        /*
         * 组合模式
         * 按照统一处理的方式，不用区分是文件夹还是文件
         */
        /*Component folder = new Folder("E盘");
        Component imageFolder = new Folder("我的图片");
        Component textFolder = new Folder("我的文档");
        Component imageFile = new File("图片图片");
        Component textFile = new File("文档文档");

        imageFolder.add(imageFile);
        textFolder.add(textFile);

        folder.add(imageFolder);
        folder.add(textFolder);

        folder.display();*/

        /*装饰模式*/
        /*Component component = new ChildComponent();
        Component decoratorA = new ConcreteDecoratorA(component);
        Component decoratorB = new ConcreteDecoratorB(decoratorA);
        decoratorB.operation();*/

        /*责任链模式*/
        /*Handler worker = new WorkerHandler("张三");
        Handler manager = new ManagerHandler("mana");
        Handler president = new PresidentHandler("preeee");
        Handler meeting = new MeetingHandler("meettt");

        // 创建责任链
        worker.setHandler(manager);
        manager.setHandler(president);
        president.setHandler(meeting);

        PurchaseRequest req1 = new PurchaseRequest(1500, "123123123");
        PurchaseRequest req2 = new PurchaseRequest(3500, "123222222");
        PurchaseRequest req3 = new PurchaseRequest(6500, "123333333");
        PurchaseRequest req4 = new PurchaseRequest(25000, "123444444");

        worker.handle(req1);
        worker.handle(req2);
        worker.handle(req3);
        worker.handle(req4);*/

        /*命令模式*/
        /*AbstractCommand command = new OneConmmand();
        CalculatorForm calculatorForm = new CalculatorForm(command);
        calculatorForm.add(11);
        calculatorForm.add(22);
        calculatorForm.add(33);

        calculatorForm.undo();*/

        /**迭代器模式*/
        /*List<String> products = new ArrayList();
        products.add("倚天剑");
        products.add("屠龙刀");
        products.add("断肠草");
        products.add("葵花宝典");
        products.add("四十二章经");

        AbstractObjectList list = new ProductList(products); //创建聚合对象
        AbstractIterator iterator = list.createIterator(); //创建迭代器对象

        System.out.println("正向遍历：");
        while(!iterator.isLast()) {
            System.out.print(iterator.getNextItem() + "，");
            iterator.next();
        }
        System.out.println();

        System.out.println("-----------------------------");

        System.out.println("逆向遍历：");
        while(!iterator.isFirst()) {
            System.out.print(iterator.getPreviousItem() + "，");
            iterator.previous();
        }*/

        /**中介者模式*/
        /*ConcreteMediator mediator = new ConcreteMediator();
        Button button = new Button(mediator);
        TextLabel label = new TextLabel(mediator);
        ComboBox comboBox = new ComboBox(mediator);

        mediator.setButton(button);
        mediator.setLabel(label);
        mediator.setComboBox(comboBox);

        button.change();
        System.out.println("===========");
        comboBox.change();*/

        /**备忘录模式*/
        /*Chessman chessman = new Chessman("车", 1, 1);
        chessman.display();

        MementoManager manager = new MementoManager();
        manager.addMemento(chessman.save());

        chessman.setY(3);
        chessman.display();
        manager.addMemento(chessman.save());

        chessman.setX(5);
        chessman.display();
        manager.addMemento(chessman.save());

        chessman.setX(15);
        chessman.display();

        System.out.println("悔棋----");

        chessman.restore(manager.getMemento());
        chessman.display();

        chessman.restore(manager.getMemento());
        chessman.display();

        chessman.restore(manager.getMemento());
        chessman.display();*/

        /**观察者模式(发布-订阅模式)*/
        /*AbstractController controller = new ConcreteController();

        Observer guojing = new Player("郭靖");
        Observer hr = new Player("黄蓉");
        Observer yg = new Player("杨过");
        Observer oyf = new Player("欧阳锋");
        Observer gx = new Player("郭襄");

        controller.addPlay(guojing);
        controller.addPlay(hr);
        controller.addPlay(yg);
        controller.addPlay(oyf);
        controller.addPlay(gx);

        controller.quitPlay(oyf);
        controller.quitPlay(hr);

        gx.beAttacked(controller);*/

        /**状态模式*/
        /*VoteManager manager = new VoteManager();
        for (int i = 0; i < 10; i++) {
            manager.vote("user1", "item");
        }*/

        /**策略模式*/
        /*TicketManager manager = new TicketManager("建国大业", 52.5f);
        //manager.setStrategy(new StudentStrategy());
        manager.setStrategy(new NormalStrategy());
        //manager.setStrategy(new VipStrategy());
        manager.sellTicket();*/

        /**
         * 模板方法模式
         */
        /*AbstractEat eat = new ChickenEat();
        eat.haveLunch();

        eat = new NoodleEat();
        eat.haveLunch();*/

        /**
         * 访问者模式
         */
        /*ElementManager manager = new ElementManager();
        manager.addElement(new Salary(200, 300));
        manager.addElement(new Salary(100, 150));
        manager.addElement(new Salary(50, 20));
        manager.addElement(new Salary(10, 50));

        manager.addElement(new Attendence(25));
        manager.addElement(new Attendence(12));
        manager.addElement(new Attendence(0));
        manager.addElement(new Attendence(22));

        //manager.accept(new FinanceVisitor());
        manager.accept(new HumanResourceVisitor());*/
    }

}
