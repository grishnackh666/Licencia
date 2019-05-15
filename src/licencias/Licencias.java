
package licencias;

import java.time.LocalDate;
import java.util.ArrayList;


public class Licencias {

   
    public static void main(String[] args) {
        
        
        LicenciaTemporal temporal = new LicenciaTemporal("juan@um.es", "http://api.um.es/disco/v1/", LocalDate.now().plusMonths(1));
        LicenciaTransaccionesLimitadas limitada1 = new LicenciaTransaccionesLimitadas("pepe@um.es", 3, "http://api.um.es/disco/v1/");
        Licencialimitediario limite = new Licencialimitediario(4, "paco@um.es", "http://api.um.es/disco/v1/");
        
        ArrayList<Licencia> lista_Licencias = new ArrayList<Licencia>();
        lista_Licencias.add(temporal);
        lista_Licencias.add(limitada1);
        lista_Licencias.add(limite);
        System.out.println(temporal.getClass().getName());
        
        for(Licencia to : lista_Licencias){
            if(to.getClass().getName() == "licencias.Licencia_limite_diario"){
                System.out.println("las transacciones restantes son:" + to.getLimite_dia());
            }else if(to.getClass().getName() == "licencias.LicenciaTemporal"){
                System.out.println("revocada");
                to.revocar();
            }
        }
        
        for(Licencia to : lista_Licencias){
            for(int i = 0; i < 4; i++){
                if(to.autorizacion() != null){
                    System.out.println("transaccion echa");
                }else{
                    System.out.println("no realizada");
                }
            }
        }
        
    }
    
}
