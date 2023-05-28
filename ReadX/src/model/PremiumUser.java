package model;
import java.util.ArrayList;
import java.util.Calendar;

public class PremiumUser extends User {
    private ArrayList<Book> books;
    private ArrayList<Magazine>magazines;
    private ArrayList<Factura>facturas;
    private ArrayList<BibliographicP>productosOrganizadosP;
    private String[][] matrizId;
    private ArrayList<String[][]>arrayListMatriz;

    public PremiumUser(String nameUser, String idUser, Calendar fechaVinculacion) {
        super(nameUser, idUser, fechaVinculacion);
        this.books=new ArrayList<Book>();
        this.magazines=new ArrayList<Magazine>();
        this.facturas=new ArrayList<Factura>();
        this.productosOrganizadosP=new ArrayList<BibliographicP>();
        this.matrizId=new String[5][5];
        this.arrayListMatriz = new ArrayList<String[][]>();

    }



    public void setMatrizId(String[][] matrizId) {
        this.matrizId = matrizId;
    }

    public ArrayList<String[][]> getArrayListMatriz() {
        return arrayListMatriz;
    }

    public void setArrayListMatriz(ArrayList<String[][]> arrayListMatriz) {
        this.arrayListMatriz = arrayListMatriz;
    }
 

    public void setProductosOrganizadosP(ArrayList<BibliographicP> productosOrganizadosP) {
        this.productosOrganizadosP = productosOrganizadosP;
    }

    public ArrayList<BibliographicP> getProductosOrganizadosP() {
        return productosOrganizadosP;
    }


    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Magazine> getMagazines() {
        return magazines;
    }

    public void setMagazines(ArrayList<Magazine> magazines) {
        this.magazines = magazines;
    }

    @Override
    public String toString() {
        return "\nName:" + this.getNameUser()+ "\nIdentifier: " + this.getIdUser()
                + "\nDate of linkage: "+this.getFechaVinculacion();
    }

    public String toStringMin(){
        return this.getNameUser()+"-"+this.getIdUser();
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }

    
   
}
