package model;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class Factura {
    private double montoPagado;
    private Calendar fechaTransaccion;
    private String identificador;
    private String nameProducto;
    private String nameCliente;
    private DateFormat formatter;
    public Factura(String nameClient,double montoPagado, Calendar fechaTransaccion, String identificador, String nameProducto) {
        this.formatter = new SimpleDateFormat("dd/MM/yyyy");
        
        this.montoPagado = montoPagado;
        this.fechaTransaccion = fechaTransaccion;
        this.identificador=identificador;
        this.nameProducto=nameProducto;
        this.nameCliente=nameClient;
    }
    
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNameProducto() {
        return nameProducto;
    }

    public void setNameProducto(String nameProducto) {
        this.nameProducto = nameProducto;
    }

    public double getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(double montoPagado) {
        this.montoPagado = montoPagado;
    }

    public Calendar getFechaTransaccion() {
        return fechaTransaccion;
    }

    public String getFormatterFechaTransaccion(){
        return formatter.format(this.fechaTransaccion.getTime());
    }

    public void setFechaTransaccion(Calendar fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    @Override
    public String toString() {
        return "\nCustomer: " +nameCliente+"\nName of product: "+nameProducto +"\nIndentifier product: "+identificador+"\nProduct value: "+montoPagado + "\nTransaction Date: " + getFormatterFechaTransaccion();
    }

    public String getNameCliente() {
        return nameCliente;
    }

    public void setNameCliente(String nameCliente) {
        this.nameCliente = nameCliente;
    }

    

    
}
