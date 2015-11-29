package app.universus.Drawer;


import android.graphics.Bitmap;

public class DrawerItem {
    private String name;
    private Bitmap icono;

    public DrawerItem(String name, Bitmap icono) {
        this.name = name;
        this.icono = icono;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getIcono() {
        return icono;
    }

    public void setIcono(Bitmap icono) {
        this.icono = icono;
    }
}
