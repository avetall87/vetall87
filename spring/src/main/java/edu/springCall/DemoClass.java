package edu.springCall;


import annotation.MySpring;
import annotation.RunThis;
import org.apache.log4j.Logger;

/**
 * Created by виталий on 25.10.2015.
 */
@MySpring
public class DemoClass {
    private static final Logger log = Logger.getLogger(DemoClass.class);
    @RunThis
    public void pickMeSecond(){
        log.info("test call non static second !!!");
    }
}
