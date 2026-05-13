package prog2.adaptador;

import prog2.model.Dades;
import prog2.vista.BiblioException;

import java.io.*;

public class Adaptador implements Serializable {
    public Dades dades;

    public Adaptador() {
        this.dades = new Dades();
    }


    public void guardaDades(String camiDesti) throws BiblioException {
        File fitxer = new File(camiDesti);

        try {
            FileOutputStream fout = new FileOutputStream(fitxer);
            ObjectOutputStream oos = new ObjectOutputStream(fout);

            oos.writeObject(dades);

            fout.close();
        } catch (FileNotFoundException e) {
            throw new BiblioException("No s'ha pogut guardar els dades: fitxer destí no trobat");
        } catch (IOException e) {
            throw new BiblioException("No s'ha pogut guardar els dades: IOException ocorregut al guardar dades a fitxer");
        }
    }

    public Adaptador carregaDades(String camiOrigen) throws BiblioException {
        File fitxer = new File (camiOrigen);

        try {
            FileInputStream fin = new FileInputStream(fitxer);
            ObjectInputStream ois = new ObjectInputStream(fin);

            return (Adaptador) ois.readObject();

        } catch (FileNotFoundException e) {
            throw new BiblioException("No s'ha pogut carregar els dades: fitxer no trobat");
        } catch (IOException e) {
            throw new BiblioException("No s'ha pogut carregar els dades: IOException ocurregut");
        } catch (ClassNotFoundException e) {
            throw new BiblioException("No s'ha pogut carregar els dades: ClassNotFound ocurregut");
        }
    }
}
