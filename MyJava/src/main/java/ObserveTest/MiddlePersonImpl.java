package ObserveTest;

import java.util.*;

/**
 * @Description:ObserveTest
 * @Date:2024/6/15
 * @Author:谢锦创
 */
public class MiddlePersonImpl implements MiddlePerson{

    List<Observable> observers = new ArrayList<>();

    Map<Class, Set<Observable>> class2observable = new HashMap<>();

    @Override
    public void addObserver(GenericObservable observer) {
        observers.add(observer);
        List<Class<? extends BeObservable>> beObserverdClasses = observer.beObserverds;
        for (Class<? extends BeObservable> beObserverdClass : beObserverdClasses) {
            if (class2observable.containsKey(beObserverdClass)) {
                class2observable.get(beObserverdClass).add(observer);
            } else {
                HashSet<Observable> observables = new HashSet<>();
                observables.add(observer);
                class2observable.put(beObserverdClass, observables);
            }
        }
    }

    @Override
    public void deleteObserver(GenericObservable observer) {
        observers.remove(observer);
        List<Class<? extends BeObservable>> beObserverds = observer.beObserverds;
        for (Class<? extends BeObservable> beObserverdClass : beObserverds) {
            Set<Observable> observables = class2observable.get(beObserverdClass);
            observables.remove(observer);
        }
    }

    @Override
    public void publishEvent(Object object) {
//        for (Observable observer : observers) {
//            observer.executeObserverEvent(object);
//        }
        Set<Observable> observables = class2observable.get(object.getClass());
        observables.forEach(per -> per.executeObserverEvent(object));
    }
}
