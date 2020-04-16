package com.example.transportapp.ui.main.ui.slideshow;

public class Trans {
    public String conductor_id;
    public String nombre_trans;
    public String tarifa_trans;
    public String matricula_vehi;

    public Trans() {
    }

    public Trans(String conductor_id, String nombre_trans, String tarifa_trans, String matricula_vehi) {
        this.conductor_id = conductor_id;
        this.nombre_trans = nombre_trans;
        this.tarifa_trans = tarifa_trans;
        this.matricula_vehi = matricula_vehi;
    }

    public String getConductor_id() {
        return conductor_id;
    }

    public void setConductor_id(String conductor_id) {
        this.conductor_id = conductor_id;
    }

    public String getNombre_trans() {
        return nombre_trans;
    }

    public void setNombre_trans(String nombre_trans) {
        this.nombre_trans = nombre_trans;
    }

    public String getTarifa_trans() {
        return tarifa_trans;
    }

    public void setTarifa_trans(String tarifa_trans) {
        this.tarifa_trans = tarifa_trans;
    }

    public String getMatricula_vehi() {
        return matricula_vehi;
    }

    public void setMatricula_vehi(String matricula_vehi) {
        this.matricula_vehi = matricula_vehi;
    }

    @Override
    public String toString() {
        return "Trans{" +
                "nombre_trans='" + nombre_trans + '\'' +
                '}';
    }
}
