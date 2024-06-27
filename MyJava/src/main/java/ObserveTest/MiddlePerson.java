package ObserveTest;

/**
 * @Description:ObserveTest 多播器
 * @Author:谢锦创
 */
public interface MiddlePerson {

    void addObserver(GenericObservable observable);

    void deleteObserver(GenericObservable observable);

    void publishEvent(Object object);
}
