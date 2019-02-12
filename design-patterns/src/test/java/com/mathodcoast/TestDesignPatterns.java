package com.mathodcoast;

import com.mathodcoast.creational.ComputerFactory;
import com.mathodcoast.creational.JavaSingleton;
import com.mathodcoast.creational.PCFactory;
import com.mathodcoast.creational.ServerFactory;
import com.mathodcoast.model.Circle;
import com.mathodcoast.model.Computer;
import com.mathodcoast.model.Laptop;
import com.mathodcoast.model.Triangle;
import com.mathodcoast.structural.DrawingComposite;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertNotEquals;

@RunWith ( JUnit4.class )
public class TestDesignPatterns {

    @Test
    public void testSingleton() {
        JavaSingleton javaSingletonA = JavaSingleton.getInstance();
        JavaSingleton javaSingletonB = JavaSingleton.getInstance();

        assert javaSingletonA != null;
        assertEquals("You have a constructor",0,javaSingletonA.getClass().getConstructors().length);
        assertEquals(javaSingletonA.hashCode(),javaSingletonB.hashCode());
    }

    @Test
    public void testComputerFactory() {
        Computer pc = ComputerFactory.getComputer("PC","2 GB","1 TB","2.4 GHz");
        Computer server = ComputerFactory.getComputer("Server","16 GB","2 TB","3.4 GHz");

        assertEquals("RAM=2 GB, HDD=1 TB, CPU=2.4 GHz",pc.toString());
        assertEquals("RAM=16 GB, HDD=2 TB, CPU=3.4 GHz",server.toString());
    }

    @Test
    public void testAbstractComputerFactory() {
        Computer pc = ComputerFactory.getComputer(new PCFactory("2 GB","1 TB","2.4 GHz"));
        Computer server = ComputerFactory.getComputer(new ServerFactory("16 GB","2 TB","3.4 GHz"));

        assertEquals("RAM=2 GB, HDD=1 TB, CPU=2.4 GHz",pc.toString());
        assertEquals("RAM=16 GB, HDD=2 TB, CPU=3.4 GHz",server.toString());
    }

    @Test
    public void testComputerBuilder() {
        Laptop computerA = new Laptop.ComputerBuilder("2 GB","1 TB","2.4 GHz")
                .setGraphicalCardEnabled(true)
                .setBluetoothEnabled(true)
                .build();

        Laptop laptop = new Laptop.ComputerBuilder("2 GB","1 TB","2.4 GHz")
                .setGraphicalCardEnabled(true)
                .setBluetoothEnabled(true)
                .build();

        Laptop computerC = new Laptop.ComputerBuilder("2 GB","1 TB","2.4 GHz")
                .setGraphicalCardEnabled(true)
                .setBluetoothEnabled(false)
                .build();

        Laptop computerD = new Laptop.ComputerBuilder("2 GB","1 TB","2.4 GHz")
                .build();

        assertEquals(computerA,laptop);
        assertNotEquals(computerA,computerC);
        assertNotEquals(computerA,computerD);
    }

    @Test
    public void testDrawComposite(){
        DrawingComposite composite = new DrawingComposite();
        composite.add(new Triangle());
        composite.add(new Circle());

        Triangle triangle = new Triangle();
        composite.add(triangle);

        String resultA = composite.draw("Blue");
        String expectedA = "| Blue Triangle | Blue Circle | Blue Triangle ";

        composite.remove(triangle);

        String resultB = composite.draw("Blue");
        String expectedB = "| Blue Triangle | Blue Circle ";

        composite.clear();

        String resultC = composite.draw("Blue");
        String expectedC = "";

        assertEquals(expectedA,resultA);
        assertEquals(expectedB,resultB);
        assertEquals(expectedC,resultC);
    }
}
