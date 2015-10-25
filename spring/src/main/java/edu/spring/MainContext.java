package edu.spring;

import annotation.MySpring;
import annotation.RunThis;

import org.apache.log4j.Logger;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;



/**
 * Created by виталий on 23.10.2015.
 */
public class MainContext {
 private final static String innerPackage = "org.reflections";
 private final static String innerPackage2 = "org.apache.log4j";

    private static final Logger log = Logger.getLogger(MainContext.class);
    /**
     * Default constructor
     */
    public MainContext() {
        init();
    }

    /**
     * Method for inicialization context
     */
    private void init() {
        Package[] aPackage = Package.getPackages();

        for (int i = 0; i < aPackage.length; i++) {
            String pkg = aPackage[i].getName();
            if (pkg.equalsIgnoreCase(innerPackage) || pkg.equalsIgnoreCase(innerPackage2)) {
                log.warn("Bag, we must understand how to choose only their packages !!!");
            }else{
                Set<Class<? extends Object>> classes = getClazzSet(pkg);
                if (classes != null) {
                    Iterator<Class<? extends Object>> curClass = classes.iterator();
                    while (curClass.hasNext()) {
                        try {
                            Class cl = curClass.next();
                            if(cl.isAnnotationPresent(MySpring.class)){

                                Method[] md = cl.getDeclaredMethods();
                                for (int b = 0; b < md.length; b++) {
                                    if (md[b].isAnnotationPresent(RunThis.class)) {
                                        if (md[b].getParameterTypes().length == 0) {
                                            invokeMethodWithOutParameter(cl, md[b]);
                                        }
                                    }
                                }
                            }
                        } catch (Exception e) {
                            log.error(e.getMessage());
                            e.printStackTrace();
                        }
                    }


                }
            }
        }

    }

    /**
     * Method return all calsses from current package
     * @param pkg package name
     * @return Cals<?  extends Object>
     */
    private static Set<Class<? extends Object>> getClazzSet(String pkg) {
        Set<Class<? extends Object>> obj = null;
        Reflections reflections = new Reflections(new ConfigurationBuilder().setScanners(new SubTypesScanner(false), new ResourcesScanner())
                .setUrls(ClasspathHelper.forClassLoader(ClasspathHelper.classLoaders(new ClassLoader[0])))
                .filterInputsBy(new FilterBuilder().includePackage(pkg)));
        try{
            obj = reflections.getSubTypesOf(Object.class);
        }
        catch(Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }
        finally {
            return obj;
        }
    }

    /**
     * Method return all method from current class
     * @param calss Class
     * @return Method arrays
     */
    private static Method[] getAllMethods(Class calss){
       return Class.class.getMethods();
    }

    /**
     * Method make invoke current method in current class.
     * Invike only method without parameters.
     * @param cl Class<? extends Object>
     * @param md Method
     */
    private static void invokeMethodWithOutParameter(Class<? extends Object> cl,Method md){
        try {
            Object obj = cl.newInstance();
            md.invoke(obj, null);
          //  log.info("method: " + md.getName()+" called");
        } catch (IllegalAccessException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        } catch (InstantiationException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

}
