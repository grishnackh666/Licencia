/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package licencias;

/**
 *
 * @author Estudiante
 */
public class LicenciaTransaccionesLimitadas extends Licencia {
    private static int transaccionesPermitidas;
    private static int transaccionesRestantes;

    public LicenciaTransaccionesLimitadas(String email, int numero_transacciones, String cadena) {
        super(email, cadena);
        this.transaccionesPermitidas = numero_transacciones;
        this.transaccionesRestantes = numero_transacciones;
    }
    
    protected Transaccion autorizacion(){
        if(this.getTransaccionesRestantes() > 0){
            this.setTransaccionesRestantes(this.getTransaccionesRestantes()-1);
            return new Transaccion(this);
        }else{
            return null;
        }
    }

    public static int getTransaccionesPermitidas() {
        return transaccionesPermitidas;
    }

    public static void setTransaccionesPermitidas(int transaccionesPermitidas) {
        LicenciaTransaccionesLimitadas.transaccionesPermitidas = transaccionesPermitidas;
    }

    public static int getTransaccionesRestantes() {
        return transaccionesRestantes;
    }

    public static void setTransaccionesRestantes(int transaccionesRestantes) {
        LicenciaTransaccionesLimitadas.transaccionesRestantes = transaccionesRestantes;
    }
    
    protected int getLimite_dia(){
        return 1;
    }
    
    
    
    
}
