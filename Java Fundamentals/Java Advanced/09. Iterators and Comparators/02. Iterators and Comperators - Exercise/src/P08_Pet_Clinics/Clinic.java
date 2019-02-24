package P08_Pet_Clinics;

import java.util.Iterator;

public class Clinic{
    private String name;
    private Pet[] rooms;

    public Clinic(String name, int rooms) {
        this.name = name;
        this.setRooms(rooms);
    }

    public void setRooms(int rooms) {
        if (rooms % 2 == 0){
            throw new IllegalArgumentException("Invalid Operation!");
        }else {
            this.rooms = new Pet[rooms];
        }
    }

    public boolean add(Pet pet){
        int room = this.rooms.length / 2;

        for (int i = 0; i < this.rooms.length; i++) {
            if (i % 2 != 0){
                room -= i;
            }else {
                room += i;
            }

            if (this.rooms[room] == null){
                this.rooms[room] = pet;
                return true;
            }
        }
        return false;
    }

    public boolean release(){
        int room = this.rooms.length / 2;
        for (int i = room; i < this.rooms.length; i++) {
            if (this.rooms[i] != null){
                this.rooms[i] = null;
                return true;
            }
        }
        for (int i = 0; i < room; i++) {
            if (this.rooms[i] != null){
                this.rooms[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean hasEmptyRooms(){
        for (Pet room : this.rooms) {
            if (room == null){
                return true;
            }
        }
        return false;
    }

    public Pet[] getRooms() {
        return rooms;
    }
}
