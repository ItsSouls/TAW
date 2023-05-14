package es.taw.starwars.ui;

public class Filtro {
    boolean checkpelicula;
    boolean checkpersonaje;

    public Filtro() {
        this.checkpelicula = false;
        this.checkpersonaje = false;
    }

    public boolean getCheckpelicula() {
        return this.checkpelicula;
    }

    public void setCheckpelicula(boolean checkpelicula) {
        this.checkpelicula = checkpelicula;
    }

    public boolean getCheckpersonaje() {
        return this.checkpersonaje;
    }

    public void setCheckpersonaje(boolean checkpersonaje) {
        this.checkpersonaje = checkpersonaje;
    }
}
