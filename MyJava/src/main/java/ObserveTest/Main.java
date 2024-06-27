package ObserveTest;

/**
 * @Description:ObserveTest  事件源( )
 * @Date:2024/6/15
 * @Author:谢锦创
 */
public class Main {

    public static void main(String[] args) {

        Wind wind = new Wind();
        MiddlePersonImpl middlePerson = new MiddlePersonImpl();
        middlePerson.addObserver(new GrassObserver());
        middlePerson.addObserver(new WaterObserver());
        middlePerson.publishEvent(wind);

    }
}
