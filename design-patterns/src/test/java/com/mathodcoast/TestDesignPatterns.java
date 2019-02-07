package com.mathodcoast;

import com.mathodcoast.creational.ComputerFactory;
import com.mathodcoast.creational.JavaSingleton;
import com.mathodcoast.creational.PCFactory;
import com.mathodcoast.creational.ServerFactory;
import com.mathodcoast.model.Computer;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

@RunWith( JUnit4.class )
public class TestDesignPatterns {

    @Test
    public void testSingleton(){
        JavaSingleton javaSingletonA = JavaSingleton.getInstance();
        JavaSingleton javaSingletonB = JavaSingleton.getInstance();

        assert javaSingletonA != null;
        assertEquals("You have a constructor",0,javaSingletonA.getClass().getConstructors().length);
        assertEquals(javaSingletonA.hashCode(),javaSingletonB.hashCode());
    }

    @Test
    public void testComputerFactory(){
        Computer pc = ComputerFactory.getComputer("PC","2 GB","1 TB","2.4 GHz");
        Computer server = ComputerFactory.getComputer("Server","16 GB","2 TB","3.4 GHz");

        assertEquals("RAM=2 GB, HDD=1 TB, CPU=2.4 GHz",pc.toString());
        assertEquals("RAM=16 GB, HDD=2 TB, CPU=3.4 GHz",server.toString());
    }

    @Test
    public void testAbstractComputerFactory(){
        Computer pc = ComputerFactory.getComputer(new PCFactory("2 GB","1 TB","2.4 GHz"));
        Computer server = ComputerFactory.getComputer(new ServerFactory("16 GB","2 TB","3.4 GHz"));

        assertEquals("RAM=2 GB, HDD=1 TB, CPU=2.4 GHz",pc.toString());
        assertEquals("RAM=16 GB, HDD=2 TB, CPU=3.4 GHz",server.toString());
    }
}
