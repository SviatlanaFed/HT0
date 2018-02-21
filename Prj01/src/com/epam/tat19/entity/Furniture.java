package com.epam.tat19.entity;

public class Furniture {
    private String furnitureName;
    private Integer furnitureArea;

    public Furniture(String furnitureName, Integer furnitureArea) {
        this.furnitureName = furnitureName;
        this.furnitureArea = furnitureArea;
    }

    public String getFurnitureName() {
        return furnitureName;
    }

    public void setFurnitureName(String furnitureName) {
        this.furnitureName = furnitureName;
    }

    public Integer getFurnitureArea() {
        return furnitureArea;
    }

    public void setFurnitureArea(Integer furnitureArea) {
        this.furnitureArea = furnitureArea;
    }
}
