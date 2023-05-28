package model;
import java.util.Calendar;

public abstract class User {
    private String nameUser;
    private String idUser;
    private Calendar fechaVinculacion;

    
    public User(String nameUser, String idUser, Calendar fechaVinculacion) {
        this.nameUser = nameUser;
        this.idUser = idUser;
        this.fechaVinculacion = fechaVinculacion;

    }

    

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public Calendar getFechaVinculacion() {
        return fechaVinculacion;
    }

    public void setFechaVinculacion(Calendar fechaVinculacion) {
        this.fechaVinculacion = fechaVinculacion;
    }

    @Override
    public String toString() {
        return "User [nameUser=" + nameUser + ", idUser=" + idUser + ", fechaVinculacion=" + fechaVinculacion + "]";
    }


    
    
}
