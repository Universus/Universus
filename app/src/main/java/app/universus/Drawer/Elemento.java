package app.universus.Drawer;

public class Elemento {
    private String descipcion;
    private int path;

    public Elemento(String descripcion, int path){
        this.descipcion = descripcion;
        this.path = path;
    }

    public int getPath() {
        return path;
    }

    public String getDescipcion() {
        return descipcion;
    }
}
