package ObserveTest;

/**
 * @Description:ObserveTest
 * @Date:2024/6/15
 * @Author:谢锦创
 */
public class GrassObserver extends GenericObservable{
    @Override
    public void executeObserverEvent(Object object) {
        if (object instanceof Wind) {
            System.out.println("起风了");
        }
        if (object instanceof Fire) {
            System.out.println("起火了");
        }
    }

    @Override
    public void initBeObserved() {
        addBeObserver(Wind.class);
        beObserverds.add(Wind.class);
        beObserverds.add(Fire.class);
    }
}
