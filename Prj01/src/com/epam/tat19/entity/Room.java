package com.epam.tat19.entity;
import java.util.ArrayList;

public class Room {
    private String roomNumber;
    private Integer area;
    ArrayList<Illumination> lamps=new ArrayList<>();
    ArrayList<Furniture> furniture=new ArrayList<>();
    private static final Integer WINDOW_LK = 700;
    private Integer windowCount=0;
    private Integer totalIllumLamp=0;
    private Integer useArea=0;

    public Room(String roomNumber, Integer area, Integer windowCount) {
        this.roomNumber = roomNumber;
        this.area = area;
        this.windowCount = windowCount;
    }

    public Room(String roomNumber, Integer area) {
        this.roomNumber = roomNumber;
        this.area = area;
    }

    public Room() {    }

    public Integer getWindowCount() {
        return windowCount;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public ArrayList<Illumination> getLamps() {
        return lamps;
    }

    public ArrayList<Furniture> getFurniture() {
        return furniture;
    }

    public Integer getArea() {
        return area;
    }

    public void addLamp(Illumination lamp){
        lamps.add(lamp);
    }

    public void addFurniture(Furniture furnitureObj) {
        furniture.add(furnitureObj);
    }

    public static Integer getWINDOW_LK() {
        return WINDOW_LK;
    }

    public Integer getTotalIllumLamp() {
        for (Illumination item:lamps ) {
            totalIllumLamp+=item.getLampLk();
        }

        return totalIllumLamp;
    }

    public Integer getUseArea() {
        for (Furniture item:furniture ) {
            useArea+=item.getFurnitureArea();
        }
        return useArea;
    }

    public Integer getFreeArea() {
        return area-useArea;
    }


}
