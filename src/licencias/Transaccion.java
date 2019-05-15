/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package licencias;
import java.time.LocalDate;

/**
 *
 * @author Estudiante
 */
public class Transaccion {
    
    private static Licencia licencia;
    private final LocalDate fecha = LocalDate.now();

    public Transaccion(Licencia licencia) {
        this.licencia = licencia;
    }
    
    
    
}
