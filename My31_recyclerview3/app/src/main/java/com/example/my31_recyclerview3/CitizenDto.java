package com.example.my31_recyclerview3;

import java.io.Serializable;

public class CitizenDto implements Serializable {
    String name, character, species;
    int resId;

    public CitizenDto(String name, String character, String species, int resId) {
        this.name = name;
        this.character = character;
        this.species = species;
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
