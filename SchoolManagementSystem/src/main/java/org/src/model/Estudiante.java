package org.src.model;

import java.time.LocalDate;

public class Estudiante extends Persona {
    private int id;
    private LocalDate fechaDeNacimiento;
    private Estado estado;

    public enum Estado {
        MATRICULADO,
        INACTIVO,
        GRADUADO
    }

    public Estudiante(int id, String nombre, String apellido, LocalDate fechaDeNacimiento, Estado estado) {
        super(nombre, apellido);
        this.id = id;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.estado = estado;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", nombre=" + getNombre() +
                ", apellido=" + getApellido() +
                ", fechaDeNacimiento=" + fechaDeNacimiento +
                ", estado=" + estado +
                '}';
    }
}
