package model;
import java.util.Calendar;


public class BibliographicP implements Comparable<BibliographicP> {
    private String identifier;
    private String name;
    private int numberPages;
    private Calendar datePublished;
    private String URL;
    private int pagesRead;
    private int numberPagesRead;
    
    public BibliographicP(String identifier, String name, int numberPages, Calendar datePublished, String URL, int numberPagesRead) {
            
        this.identifier = identifier;
        this.name = name;
        this.numberPages = numberPages;
        this.datePublished = datePublished;
        this.URL = URL;
        this.numberPagesRead=numberPagesRead;
    }

    public int getNumberPagesRead() {
        return numberPagesRead;
    }

    public void setNumberPagesRead(int numberPagesRead) {
        this.numberPagesRead = numberPagesRead;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public Calendar getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Calendar datePublished) {
        this.datePublished = datePublished;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public int getPagesRead() {
        return pagesRead;
    }

    public void setPagesRead(int pagesRead) {
        this.pagesRead = pagesRead;
    }

    @Override
    public String toString() {
        return "BibliographicP [identifier=" + identifier + ", name=" + name + ", numberPages=" + numberPages
                + ", datePublished=" + datePublished + ", URL=" + URL + ", pagesRead=" + pagesRead + "]";
    }

    @Override
    public int compareTo(BibliographicP o) {
        int valor=this.datePublished.compareTo(o.datePublished);
        return valor;
    }

    
    
}
