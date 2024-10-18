package mx.unam.ciencias.modelado.proyecto1.decorator;

import java.text.Normalizer;

/**Enumeración para los Departamentos de productos. */
public enum Departamento{
    /**Departamento: Electrodomésticos. */
    ELECTRODOMESTICOS,
    /**Departamento: Electrónicos. */
    ELECTRONICOS,
    /**Departamento: Alimentos. */
    ALIMENTOS,
    /**Departamento: Otro */
    OTRO,
    /**Departamento: None, es ningún departamento. */
    NONE;


    /**
     * Método que convierte una cadena en el valor correspondiente de la enumeración.
     * @param nombre el nombre del país en formato de cadena.
     * @return el valor de la enumeración correspondiente al país, o null si no se encuentra.
     */
    public static Departamento fromString(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return Departamento.OTRO; // Si la cadena está vacía o es null, retornamos null
        }

        // Normalizamos la cadena: eliminamos acentos y convertimos a mayúsculas
        String nombreNormalizado = Normalizer.normalize(nombre, Normalizer.Form.NFD)
                                             .replaceAll("\\p{M}", "") // Elimina los acentos
                                             .toUpperCase()
                                             .replace(" ", "_"); // Reemplaza espacios por guiones bajos

        // Comparamos con los valores de la enumeración
        for (Departamento departamento : Departamento.values()) {
            if (departamento.name().equals(nombreNormalizado)) {
                return departamento;
            }
        }

        // Si no coincide, retornamos null o podemos lanzar una excepción
        return Departamento.OTRO;
    }
}