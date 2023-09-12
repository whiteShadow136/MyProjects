package 事务生成的代码类.测试类;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:国际化
 * @Date:2023/9/10
 * @Author:谢锦创
 */
@Component
public class TransacationGenerate implements MyInterface{
    public static void main(String[] args) {
        TransacationGenerate transacationGenerate = new TransacationGenerate();
        transacationGenerate.play();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void play() {
        System.out.printf("11111");
    }
}

