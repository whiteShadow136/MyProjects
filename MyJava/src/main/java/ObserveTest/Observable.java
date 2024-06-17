package ObserveTest;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:ObserveTest
 * @Date:2024/6/15
 * @Author:谢锦创
 */
public interface Observable<T> {
    
    void executeObserverEvent(Object object);

    void initBeObserved();
}
