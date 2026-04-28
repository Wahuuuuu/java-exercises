
package prog2.model;

import prog2.vista.ExcepcioCamping;

/**
 * Interfície que defineix les operacions bàsiques d'una llista d'accessos.
 */
public interface InLlistaAccessos {

    /**
     * Afegeix un accés rebut per paràmetre a la llista d'accessos.
     * @param acc Objecte de tipus Acces.
     * @throws ExcepcioCamping si ja existeix l'accés en la llista
     */
    public void afegirAcces(Acces acc) throws ExcepcioCamping;
    
    /**
     * Buida la llista d'accessos
     */
     public void buidar();
     
     /**
     * Itera sobre la llista d'accessos i retorna un String amb la informació de tots els accessos amb l'estat rebut per paràmetre.
     * En cas que no hi hagi accessos en l'estat passat com a paràmetre llança una excepció. 
     * @param estat boolean
     * @return String
     * @throws prog2.vista.ExcepcioCamping Aquest mètode llança una excepció en cas que no hi hagi accessos en l'estat passat com a parametre.
     * 
     */
     public String llistarAccessos(boolean estat) throws ExcepcioCamping;
     
     /**
      * Recorre tota la llista d'accessos i els tanca. Només decidirà obrir cadascun d'ells si permet l'accés a algun allotjament operatiu.
      */
     public void actualitzaEstatAccessos() ;

    /**
     * Itera sobre la llista d'accessos i retorna el número d'accessos sense accessibilitat amb vehicles.
     * @return int
     */
     public int calculaAccessosNoAccessibles();

    /**
     * Itera sobre la llista d'accessos, i pels accessos de terra suma el total de metres (longitud) i ho retorna.
     * @return float amb els metres totals.
     */
     public float calculaMetresTerra();
}
