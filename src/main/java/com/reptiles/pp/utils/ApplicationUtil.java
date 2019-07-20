package com.reptiles.pp.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Paul Lee
 */
public class ApplicationUtil {

    private static ApplicationContext ac;

    static {
        // Loading applicationContext.xml
        ac = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext-*.xml");
    }

    public static ApplicationContext getAc() {
        return ac;
    }
}
