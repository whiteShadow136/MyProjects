package ObserveTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:ObserveTest
 * @Date:2024/6/16
 * @Author:谢锦创
 */
public abstract class GenericObservable implements Observable{
    public List<Class<? extends BeObservable>> beObserverds =  new ArrayList<>();

    public GenericObservable() {
        initBeObserved();
    }
}
