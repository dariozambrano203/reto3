package co.usa.reto3.reto3.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
/*
*
*se crea tabla computer como entidad
*@Dario Zambrano
*/
@Entity
@Table(name="computer")

public class Computer implements Serializable{
 /*headerCommentRequirement
*publicMethodCommentRequirement
*Se crea la llave primaria para computer
*Se relaciona con las clases Category, Client, Computer
*
*/   
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*Identidad*/
    private Integer id;
    /*id general*/
    private String name;
    /*Nombre del computador*/
    private String brand;
    /*marca del fabricante*/
    private Integer year;
    /*año de fabricación*/
    private String description;
    /*que procesador es*/
/*definicion de relacion muchos a uno*/
    @ManyToOne
    @JoinColumn(name = "categoryid")
    @JsonIgnoreProperties("computers")
    /*para no crear el loop infinito*/
    private Category category;
/*definicion de uno a muchos para mensaje*/
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "computer")
    @JsonIgnoreProperties({"computer", "client"})
    /*para no crear el loop infinito*/
    private List<Message> messages;
/*se define otra vez mucho a uno para reservas*/
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "computer")
    @JsonIgnoreProperties({"computer", "client"})
    /*para no crear el loop infinito*/
    private List<Reservation> reservations;

    public Integer getId() {
        /*getter del id*/
        return id;
    }

    public void setId(Integer id) {
/*setter del Id*/
        this.id = id;
    }

    public String getName() {
        /*getter del nombre*/
        return name;
    }

    public void setName(String name) {
        /*setter del nombre*/
        this.name = name;
    }

    public String getBrand() {
        /*getter de la marca*/
        return brand;
    }

    public void setBrand(String brand) {
        /*setter de la marca*/
        this.brand = brand;
    }

    public Integer getYear() {
        /*getter del año*/
        return year;
    }

    public void setYear(Integer year) {
        /*setter del año*/
        this.year = year;
    }

    public String getDescription() {
        /*getter de la descripcion*/
        return description;
    }

    public void setDescription(String description) {
        /*setter de la descripcion*/
        this.description = description;
    }

    public Category getCategory() {
        /*getter de la categoria*/
        return category;
    }

    public void setCategory(Category category) {
        /*setter de la categoria*/
        this.category = category;
    }

    public List<Message> getMessages() {
        /*/lista de mensajes*/
        return messages;
    }

    public void setMessages(List<Message> messages) {
        /*setter de la  lista de mensajes*/
        this.messages = messages;

    }

    public List<Reservation> getReservations() {
        /*getter de la reserva*/
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        /*setter de la reserva*/
        this.reservations = reservations;
    }



    
}
