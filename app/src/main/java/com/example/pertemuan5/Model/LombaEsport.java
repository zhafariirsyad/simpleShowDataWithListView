package com.example.pertemuan5.Model;

public class LombaEsport {
    //Define field
    String game_name;
    char type;
    int total_slots,remaining_slots;

    public LombaEsport(String game_name, char type, int total_slots, int remaining_slots) {
        this.game_name = game_name;
        this.type = type;
        this.total_slots = total_slots;
        this.remaining_slots = remaining_slots;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getTotal_slots() {
        return total_slots;
    }

    public void setTotal_slots(int total_slots) {
        this.total_slots = total_slots;
    }

    public int getRemaining_slots() {
        return remaining_slots;
    }

    public void setRemaining_slots(int remaining_slots) {
        this.remaining_slots = remaining_slots;
    }
}
