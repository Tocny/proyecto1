package mx.unam.ciencias.modelado.proyecto1.clientes;

import java.text.Normalizer;

/**Enumeración para los paises. */
public enum Pais{
    
    /**Pais: Estados Unidos. */
    ESTADOS_UNIDOS,
    /**Pais: Brasil. */
    BRASIL,
    /**Pais: México. */
    MEXICO;

    /**
     * Método que convierte una cadena en el valor correspondiente de la enumeración.
     * @param nombre el nombre del país en formato de cadena.
     * @return el valor de la enumeración correspondiente al país, o null si no se encuentra.
     */
    public static Pais fromString(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return null; // Si la cadena está vacía o es null, retornamos null
        }

        // Normalizamos la cadena: eliminamos acentos y convertimos a mayúsculas
        String nombreNormalizado = Normalizer.normalize(nombre, Normalizer.Form.NFD)
                                             .replaceAll("\\p{M}", "") // Elimina los acentos
                                             .toUpperCase()
                                             .replace(" ", "_"); // Reemplaza espacios por guiones bajos

        // Comparamos con los valores de la enumeración
        for (Pais pais : Pais.values()) {
            if (pais.name().equals(nombreNormalizado)) {
                return pais;
            }
        }

        // Si no coincide, retornamos null o podemos lanzar una excepción
        return null;
    }
}
