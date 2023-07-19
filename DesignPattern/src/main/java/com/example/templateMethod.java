//package com.example;
//
//import lombok.extern.log4j.Log4j;
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.ArrayList;
//
///**
// * @Author:谢锦创
// * @Date:2023/7/12
// * @Description:com.example
// * @VERSION:1.0
// */
//@Slf4j
////@Log4j
//public class templateMethod {
//
//     public static void main(String[] args) {
//          beanProcessProcessList.add(new BeanPostProcess() {
//               @Override
//               public void processBean() {
//                    log.info("后置操作");
//               }
//          });
//          beanProcess();
//     }
//
//     static void beanProcess() {
//          log.info("初始化bean");
//          log.info("加载bean");
//          beanProcessProcessList.forEach(System.out::println);
//          log.info("销毁bean");
//     }
//
//     static ArrayList beanProcessProcessList = new ArrayList<BeanPostProcess>();
//
//     interface BeanPostProcess {
//          void processBean();
//     }
//}
//
