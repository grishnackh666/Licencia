package licencias;
import java.time.LocalDate;

public class LicenciaTemporal extends Licencia {
    
    private LocalDate fechaCaducar;
    private boolean caducada = false;

    public LicenciaTemporal(String email, String cadena, LocalDate fechaCaducar) {
        super(email, cadena);
        this.fechaCaducar = fechaCaducar;
        boolean caducada = false;
    }
    
    
    
    public LicenciaTemporal(String correo, String cadena) {
        super(correo, cadena);
        this.fechaCaducar = LocalDate.now().plusMonths(3);
        boolean caducada = false;
    }

    
    public LocalDate getFechaCaducar() {
        return fechaCaducar;
    }

    public void setFechaCaducar(LocalDate fecha_caducidad) {
        this.fechaCaducar = fecha_caducidad;
    }
    
    
    protected Transaccion autorizacion(){
        if(caducada){
            return new Transaccion(this);
        }else{
            return null;
        }
    }
    public void extender_fecha(int meses){
        this.setFechaCaducar(this.getFechaCaducar().plusMonths(meses));
    }
    
    protected int getLimite_dia(){
        return 1;
    }

    
    
    
    
}