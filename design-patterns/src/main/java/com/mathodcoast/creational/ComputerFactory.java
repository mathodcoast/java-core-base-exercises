package com.mathodcoast.creational;

import com.mathodcoast.model.Computer;
import com.mathodcoast.model.PC;
import com.mathodcoast.model.Server;

public class ComputerFactory {

    public static Computer getComputer(String type,String ram,String hdd,String cpu) {
        if ("PC".equalsIgnoreCase(type)) {
            return new PC(ram,hdd,cpu);
        } else {
            if ("Server".equalsIgnoreCase(type)) {
                return new Server(ram,hdd,cpu);
            }
        }
        return null;
    }

    public static Computer getComputer(AbstractComputerFactory factory){
        return factory.createComputer();
    }
}
