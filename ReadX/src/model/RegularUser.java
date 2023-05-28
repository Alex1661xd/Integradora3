package model;

import java.util.Calendar;

public class RegularUser extends User{
    private Book[] books;
    private Magazine[] magazines;
    private Factura[] facturas;
    private BibliographicP[] organizados;
    private int cantidadPaginasLeidas=0;
    private String[][]misProductos;

    public RegularUser(String nameUser, String idUser, Calendar fechaVinculacion) {
        super(nameUser, idUser, fechaVinculacion);
        
        this.books=new Book[5];
        this.magazines=new Magazine[2];
        this.facturas=new Factura[7];
        this.organizados=new BibliographicP[7];
        misProductos=new String[5][5];
    }


    public int getCantidadPaginasLeidas() {
        return cantidadPaginasLeidas;
    }

    public void setCantidadPaginasLeidas(int cantidadPaginasLeidas) {
        this.cantidadPaginasLeidas = cantidadPaginasLeidas;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public Magazine[] getMagazines() {
        return magazines;
    }

    public void setMagazines(Magazine[] magazines) {
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


    public Factura[] getFacturas() {
        return facturas;
    }


    public void setFacturas(Factura[] facturas) {
        this.facturas = facturas;
    }


    public BibliographicP[] getOrganizados() {
        return organizados;
    }


    public void setOrganizados(BibliographicP[] organizados) {
        this.organizados = organizados;
    }


    public String[][] getMisProductos() {
        return misProductos;
    }


    public void setMisProductos(String[][] misProductos) {
        this.misProductos = misProductos;
    }

    
}
