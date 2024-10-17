package models;

public class Contact {
    
    private int id;
    private int userId;  // Relaciona el contacto con el usuario
    private String nombre;
    private String apellido;
    private String telefono;
    
    public Contact() {
    }

    public Contact(int id, int userId, String nombre, String apellido, String telefono) {
        this.id = id;
        this.userId = userId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Contact [id=" + id + ", userId=" + userId + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + "]";
    }
    
}
