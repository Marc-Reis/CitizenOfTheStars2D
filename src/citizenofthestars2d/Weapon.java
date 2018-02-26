/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenofthestars2d;

/**
 *
 * @author reisma
 */
public class Weapon {
    
    private String name;
    private String beschreibung;
    private float gewicht;
    private float schaden;

    public Weapon(String name, String beschreibung, float gewicht, float schaden) {
        this.name = name;
        this.beschreibung = beschreibung;
        this.gewicht = gewicht;
        this.schaden = schaden;
    }

    @Override
    public String toString() {
        return "Name: "+getName()+" Beschreibung "+getBeschreibung()+
                " Schaden "+getSchaden()+" Gewicht "+getGewicht();
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the beschreibung
     */
    public String getBeschreibung() {
        return beschreibung;
    }

    /**
     * @param beschreibung the beschreibung to set
     */
    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    /**
     * @return the gewicht
     */
    public float getGewicht() {
        return gewicht;
    }

    /**
     * @param gewicht the gewicht to set
     */
    public void setGewicht(float gewicht) {
        this.gewicht = gewicht;
    }

    /**
     * @return the schaden
     */
    public float getSchaden() {
        return schaden;
    }

    /**
     * @param schaden the schaden to set
     */
    public void setSchaden(float schaden) {
        this.schaden = schaden;
    }
    
    

    
}
