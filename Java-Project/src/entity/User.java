/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


import java.io.Serial;
import java.io.Serializable;

/**
 *
 * @author SWL
 */
public class User implements Serializable{
 
    private int id;
    private String  email;
    private String password;
    private String first_name;
    private String last_name;
    private String gender;
    private int status;
    private String insert_time;
    private String last_update;
}
