package licencias;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class Licencialimitediario extends Licencia {
    private static int limiteDia;
    private HashMap<LocalDate, Integer> dias = new HashMap<LocalDate, Integer>();

    public Licencialimitediario(int limiteDia, String correo, String cadena) {
        super(correo, cadena);
        this.limiteDia = limiteDia;
    }
    
    public Map.Entry<LocalDate, Integer> transaccionesRestantes(){
        Map.Entry<LocalDate, Integer> valor = null;
        for(Map.Entry<LocalDate, Integer> to : this.dias.entrySet()){
            if(to.getKey() == LocalDate.now()){
                valor = to;
            }
        }
        
        return valor;
    }
    
    public Map.Entry<LocalDate, Integer> transaccionesRestantes(LocalDate fecha){
        Map.Entry<LocalDate, Integer> valor = null;
        for(Map.Entry<LocalDate, Integer> to : this.dias.entrySet()){
            if(to.getKey() == fecha){
                valor = to;
            }
        }
        
        return valor;
    }
    
    
    protected Transaccion autorizacion(){
        if(this.transaccionesRestantes().getValue() < this.limiteDia){
            this.transaccionesRestantes().setValue(this.transaccionesRestantes().getValue()+1);
            return new Transaccion(this);
        }else{
            return null;
        }
    }

    protected int getLimite_dia(){
        return this.limiteDia;
    }
    
    
    
    
}
