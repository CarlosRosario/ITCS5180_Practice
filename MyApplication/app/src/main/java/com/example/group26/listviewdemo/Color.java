package com.example.group26.listviewdemo;

/**
 * Created by Carlos on 2/29/2016.
 */
public class Color {

    String colorName;
    String colorHex;

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorHex() {
        return colorHex;
    }

    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }

    public Color(String colorName, String colorHex) {

        this.colorName = colorName;
        this.colorHex = colorHex;
    }

    @Override
    public String toString() {
        return this.colorName;
    }
}
