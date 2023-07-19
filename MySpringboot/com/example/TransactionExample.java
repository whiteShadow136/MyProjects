package com.example;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class TransactionExample {

    private PlatformTransactionManager transactionManager;

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void performTransaction() {
        // 定义事务属性
        TransactionDefinition txDefinition = new DefaultTransactionDefinition();

        // 获取事务状态
        TransactionStatus txStatus = transactionManager.getTransaction(txDefinition);

        try {
            // 执行业务逻辑，可能涉及数据库操作等
            // ...
            // 提交事务
            transactionManager.commit(txStatus);
        } catch (Exception ex) {
            // 发生异常，回滚事务
            transactionManager.rollback(txStatus);
        }
    }
}
