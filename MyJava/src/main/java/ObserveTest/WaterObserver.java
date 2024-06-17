package ObserveTest;

/**
 * @Description:ObserveTest
 * @Date:2024/6/15
 * @Author:谢锦创
 */
public class WaterObserver extends GenericObservable{
    @Override
    public void executeObserverEvent(Object object) {
        if (object instanceof Wind) {
            System.out.println("泛起波澜");
        }
    }

    @Override
    public void initBeObserved() {
        beObserverds.add(Wind.class);
    }
}
