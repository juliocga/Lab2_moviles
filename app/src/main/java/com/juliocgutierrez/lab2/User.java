package com.juliocgutierrez.lab2;

/**
 * Created by Julioc on 09/03/2016.
 */
public class User {
    private String loggin;
    private String password;
    private String email;
    private String sexo;
    private String fecha;
    private String ciudad;
    private String hobbies;

    public String getLoggin() {
        return loggin;
    }

    public String getPassword() {
        return password;
    }

    public String getHobbies() {
        return hobbies;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getFecha() {
        return fecha;
    }

    public String getSexo() {
        return sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setLoggin(String loggin) {
        this.loggin = loggin;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
