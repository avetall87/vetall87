
package edu.springCall;


import annotation.MySpring;
import annotation.RunThis;
import org.apache.log4j.Logger;

/**
 * Created by виталий on 25.10.2015.
 */
@MySpring
public class ClassWithAnot {
    private static final Logger log = Logger.getLogger(DemoClass.class);

    @RunThis
    public static void pickMe(){
        log.info("test call static !!!");
    }

    @RunThis
    public void pickMeAgain(){
        log.info("test call non static !!!");
    }

    @RunThis
    public void pickMeAgainTherd(String args){
        log.info("test call non static !!!");
    }


}
