package com.epam.tat19.service;
import com.epam.tat19.entity.Furniture;
import com.epam.tat19.entity.Illumination;
import com.epam.tat19.entity.Room;
import com.epam.tat19.exception.IlluminanceTooMuchException;
import com.epam.tat19.exception.SpaceUsageTooMuchException;
import java.util.ArrayList;
import static com.epam.tat19.entity.Illumination.getMAX_ILLUM;
import static com.epam.tat19.entity.Illumination.getMIN_ILLUM;
import static com.epam.tat19.entity.Room.getWINDOW_LK;

public class BuildingDescribe {

    public static void describe(ArrayList<Room> rooms) throws IlluminanceTooMuchException, SpaceUsageTooMuchException {

        for (int i=0;i<rooms.size();i++) {
            Room item = rooms.get(i);
            System.out.println(item.getRoomNumber());
            if(getWINDOW_LK()* item.getWindowCount()+ item.getTotalIllumLamp()<getMIN_ILLUM()) {
                throw new IlluminanceTooMuchException("Insufficient lighting of the room. You need min 300Lk");
            }
            if(getWINDOW_LK()*item.getWindowCount()+item.getTotalIllumLamp()>getMAX_ILLUM()) {
                throw new IlluminanceTooMuchException("Exceeded allowed room lighting value");
            }
            System.out.print("Illumination total= "+(item.getTotalIllumLamp()+getWINDOW_LK()* item.getWindowCount())+'\n'+
                    "(window count "+ item.getWindowCount()+"; lamps: ");
            for (Illumination lamp:item.getLamps()) {
                System.out.print(lamp.getLampLk()+" lk ");
            }
            System.out.println(")");
            if(item.getArea()*70/100<item.getUseArea()){
                throw new SpaceUsageTooMuchException("Exceeded the allowed amount of furniture in the room");
            }
            System.out.println("Room area= " + item.getArea()+ "(use area "+item.getUseArea()
                    +", free area "+item.getFreeArea()+ " or "+
                    ((double)(item.getFreeArea())/(item.getArea())*100)+"%" +")");
            if(item.getFurniture().size()==0){
                System.out.println("Free 100% area"+'\n'+"No furniture ");
            }
            else {
                System.out.print("Furniture:");
                for (Furniture furniture : item.getFurniture()) {
                    System.out.print(furniture.getFurnitureName() + "  (area" + furniture.getFurnitureArea() + " )");
                }
                System.out.println();
            }
        }
    }
}
