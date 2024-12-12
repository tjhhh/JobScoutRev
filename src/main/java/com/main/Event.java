package com.main;

import java.util.ArrayList;
import java.util.Date;


public class Event {
    private int idEvent;
    private String eventName;
    private Date eventDate;
    private String location;
    private String description;
    private String organizer;
    private int idPengguna;
    private boolean status = true;

    public Event(int idEvent, String eventName, Date eventDate, String location, String description, String organizer, int idPengguna) {
        this.idEvent = idEvent;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.location = location;
        this.description = description;
        this.organizer = organizer;
        this.idPengguna = idPengguna;
    }
    
    public void updateEvent(int idEvent, String eventName, Date eventDate, String location, String description, String organizer, int idPengguna){
       this.eventName = eventName;
       this.eventDate = eventDate;
       this.location = location;
       this.description = description;
       this.organizer = organizer;
       this.idPengguna = idPengguna;
    }
    
    public boolean cancelEvent(ArrayList<Event> event, int idEvent){
        for(Event acara : event){
            if (acara.idEvent == idEvent){
                if(acara.status != false){
                    System.out.println("Acara sudah dibatalkan.");
                    return true;
                }
                acara.status = false;
                System.out.println("Event dengan ID :" + idEvent + "telah berhasil dibatalkan");
                return false;
            }
        }
        System.out.println("Event tidak ditemukan");
        return true;
    }
}
