package com.epam.tat19.service;

import com.epam.tat19.entity.*;
import com.epam.tat19.exception.IlluminanceTooMuchException;
import com.epam.tat19.exception.SpaceUsageTooMuchException;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) throws SpaceUsageTooMuchException, IlluminanceTooMuchException {
        Building building=new Building();

        building.addRoom(new Room("Room 1",100,3));
        building.addRoom(new Room("Room 2",5,1));
        building.getRooms("Room 1").addLamp(new Illumination("Lamp",150));
        building.getRooms("Room 1").addLamp(new Illumination("Lamp",250));
        building.getRooms("Room 1").addFurniture(new Furniture("Table",3));
        building.getRooms("Room 1").addFurniture(new Furniture("Armchair", 2));
        System.out.println("Building");
        try {
            BuildingDescribe.describe(building.getRooms());
        } catch (IlluminanceTooMuchException e) {
            e.printStackTrace();
        } catch (SpaceUsageTooMuchException e) {
            e.printStackTrace();
        }


    }
}
