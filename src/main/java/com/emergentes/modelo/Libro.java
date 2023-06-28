package com.emergentes.modelo;

public class Libro {
    private int id;
    private String titulo;
    private String cantidad_disponible;
    private String estado_libro;
    private String fecha_edicion;
    private String formato;
    private String descripcion;
    private String imagen_pdf;
    private String observaciones;
    private int categoria_id;
    private int autor_id;
    private int editorial_id;

    public Libro() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCantidad_disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_disponible(String cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }

    public String getEstado_libro() {
        return estado_libro;
    }

    public void setEstado_libro(String estado_libro) {
        this.estado_libro = estado_libro;
    }

    public String getFecha_edicion() {
        return fecha_edicion;
    }

    public void setFecha_edicion(String fecha_edicion) {
        this.fecha_edicion = fecha_edicion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen_pdf() {
        return imagen_pdf;
    }

    public void setImagen_pdf(String imagen_pdf) {
        this.imagen_pdf = imagen_pdf;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public int getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(int autor_id) {
        this.autor_id = autor_id;
    }

    public int getEditorial_id() {
        return editorial_id;
    }

    public void setEditorial_id(int editorial_id) {
        this.editorial_id = editorial_id;
    }

    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", titulo=" + titulo + ", cantidad_disponible=" + cantidad_disponible + ", estado_libro=" + estado_libro + ", fecha_edicion=" + fecha_edicion + ", formato=" + formato + ", descripcion=" + descripcion + ", imagen_pdf=" + imagen_pdf + ", observaciones=" + observaciones + ", categoria_id=" + categoria_id + ", autor_id=" + autor_id + ", editorial_id=" + editorial_id + '}';
    }
    
    
}
