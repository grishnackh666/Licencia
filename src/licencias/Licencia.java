package licencias;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;


public abstract class Licencia {
    private static String correo;
    private final LocalDate fecha = LocalDate.now();
    private String codigo;
    private ArrayList<Transaccion> transacion = new ArrayList<Transaccion>();
    private int numero_transacciones = this.transacion.size();
    public boolean revocada = false;
    private static String servicio;

    public Licencia( String correo, String cadena) {
        this.correo = correo;
        this.codigo = UUID.randomUUID().toString();
        this.servicio = cadena;
    }
    
    public void revocar(){
        this.revocada = true;
    }
    
    protected abstract Transaccion autorizacion();
    protected abstract int getLimite_dia();
    
    
}
