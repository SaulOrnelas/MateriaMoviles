package com.example.directorioempleado.model;

import java.io.Serializable;

public class Empleado implements Serializable {
    private int id;
    private String nombre;
    private String apellido;
    private String nacimiento;
    private String telefono;
    private String correo;
    private String direccion;
    private int numNomnina;
    private String area;
    private String puesto;
    private String estadoCivil;
    private String curp;
    private String nss;
    private String cronicas;
    private String contEmergencia;
    //private String rutaFoto;
    private byte[] rutaFoto;
    private String escolaridad;
    private String nacionalidad;
    private String status;

    //Constructor para agregar
    public Empleado(String nombre, String apellido, String nacimiento, String telefono, String correo,
                    String direccion, int numNomnina, String area, String puesto, String estadoCivil,
                    String curp, String nss, String cronicas, String contEmergencia, byte[] rutaFoto,
                    String escolaridad, String nacionalidad, String status) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacimiento = nacimiento;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.numNomnina = numNomnina;
        this.area = area;
        this.puesto = puesto;
        this.estadoCivil = estadoCivil;
        this.curp = curp;
        this.nss = nss;
        this.cronicas = cronicas;
        this.contEmergencia = contEmergencia;
        this.rutaFoto = rutaFoto;
        this.escolaridad = escolaridad;
        this.nacionalidad = nacionalidad;
        this.status = status;
    }

    //Constructor para editar empleado
    public Empleado(int id, String nombre, String apellido, String nacimiento, String telefono,
                    String correo, String direccion, int numNomnina, String area, String puesto,
                    String estadoCivil, String curp, String nss, String cronicas, String contEmergencia,
                    byte[] rutaFoto, String escolaridad, String nacionalidad, String status) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacimiento = nacimiento;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.numNomnina = numNomnina;
        this.area = area;
        this.puesto = puesto;
        this.estadoCivil = estadoCivil;
        this.curp = curp;
        this.nss = nss;
        this.cronicas = cronicas;
        this.contEmergencia = contEmergencia;
        this.rutaFoto = rutaFoto;
        this.escolaridad = escolaridad;
        this.nacionalidad = nacionalidad;
        this.status = status;
    }

    //Constructor para obtener los empleados y mostrarlos en el RecyclerView
    public Empleado(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    //Constructor para mostrar los datos personales del empleado
    public Empleado(int id, String nombre, String apellido, String nacimiento, String telefono, String correo, String direccion, String estadoCivil, String cronicas, byte[] rutaFoto, String nacionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacimiento = nacimiento;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.estadoCivil = estadoCivil;
        this.cronicas = cronicas;
        this.rutaFoto = rutaFoto;
        this.nacionalidad = nacionalidad;
    }

    //Constructor para mostrar los datos laborales del empleado
    public Empleado(int id, String nombre, String apellido, int numNomnina, String area, String puesto, String curp, String nss, String contEmergencia, String escolaridad, String status) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numNomnina = numNomnina;
        this.area = area;
        this.puesto = puesto;
        this.curp = curp;
        this.nss = nss;
        this.contEmergencia = contEmergencia;
        this.escolaridad = escolaridad;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumNomnina() {
        return numNomnina;
    }

    public void setNumNomnina(int numNomnina) {
        this.numNomnina = numNomnina;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getCronicas() {
        return cronicas;
    }

    public void setCronicas(String cronicas) {
        this.cronicas = cronicas;
    }

    public String getContEmergencia() {
        return contEmergencia;
    }

    public void setContEmergencia(String contEmergencia) {
        this.contEmergencia = contEmergencia;
    }

    public byte[] getRutaFoto() {
        return rutaFoto;
    }

    public void setRutaFoto(byte[] rutaFoto) {
        this.rutaFoto = rutaFoto;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
