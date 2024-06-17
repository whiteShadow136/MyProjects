package ObserveTest;

/**
 * @Description:ObserveTest
 * @Date:2024/6/15
 * @Author:谢锦创
 */
public interface MiddlePerson {

    void addObserver(GenericObservable observable);

    void deleteObserver(GenericObservable observable);

    void publishEvent(Object object);
}
