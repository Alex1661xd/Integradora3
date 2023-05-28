package model;

import java.util.Calendar;

public class Magazine extends BibliographicP{
    
    private CategoryMagazine category;
    private double subscriptionValue;
    private double periocity;
    private int numberActives;
    
    public Magazine(String identifier, String name, int numberPages, Calendar datePublished, String URL, CategoryMagazine category, double subscriptionValue, double periocity, int numberPagesRead) {
        
        super(identifier, name, numberPages, datePublished, URL, numberPagesRead);
        this.category=category;
        this.subscriptionValue=subscriptionValue;
        this.periocity=periocity;
    }

    public CategoryMagazine getCategory() {
        return category;
    }

    public void setCategory(CategoryMagazine category) {
        this.category = category;
    }

    public double getSubscriptionValue() {
        return subscriptionValue;
    }

    public void setSubscriptionValue(double subscriptionValue) {
        this.subscriptionValue = subscriptionValue;
    }

    public double getPeriocity() {
        return periocity;
    }

    public void setPeriocity(double periocity) {
        this.periocity = periocity;
    }

    public int getNumberActives() {
        return numberActives;
    }

    public void setNumberActives(int numberActives) {
        this.numberActives = numberActives;
    }

    @Override
    public String toString() {
        return "\nName: "+this.getName()+"\nIdentifier: "+this.getIdentifier()+"\nNumber of pages: "+this.getNumberPages()+"\nCategory: " + category + "\nSubscription value: " + subscriptionValue + "\nPeriocity: "+
                + periocity +"\nNumber of pages read: "+this.getNumberPagesRead()+ "\nActives: " + numberActives;
    }

    public String toStringMin(){
        return this.getIdentifier()+"-"+this.getName();
    }

    
    
}
