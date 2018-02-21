package com.epam.tat19.entity;

import java.util.ArrayList;

public class Building {
    ArrayList<Room> rooms=new ArrayList<>();

    public void addRoom(Room room){
        rooms.add(room);
    }

    public Room getRooms(String  roomNumber) {
        Room item=new Room();
        for (Room room:rooms) {
            if(room.getRoomNumber()==roomNumber){
                item=room;
            }
        }
        return item;

    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }
}


