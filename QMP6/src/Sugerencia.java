//Requerimiento 1


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Sugerencia {
    private List<Atuendo> atuendos;
}
public class Usuario{
    private Sugerencia sugerenciaDiaria;
    public Usuario(Sugerencia sugerenciaDiaria){
        this.sugerenciaDiaria = sugerenciaDiaria;
    }
    public Sugerencia getSugerencia(){
        return this.sugerenciaDiaria;
    }
}

//Requerimiento 2

public class Empleado {
    private ServicioMeteorologico servicioMeteorologico;
    private List<Usuario> usuarios;

    public void calcularSugerenciasDiarias() {
        usuarios.forEach(usuario -> usuario.calcularSugerenciaDiaria();
    }

}
public class Usuario{
    private Sugerencia sugerenciaDiaria;
    public Usuario(Sugerencia sugerenciaDiaria){
        this.sugerenciaDiaria = sugerenciaDiaria;
    }
    public Sugerencia getSugerencia(){
        return this.sugerenciaDiaria;
    }
    public void calcularSugerencia() {

    }
}


//Requerimiento 3

public class Usuario{
    (...)
    private ListaDeAlertas listaDeAlertas;
    public ListaDeAlertas getAlertas(){
        return this.listaDeAlertas;
    }
}

public class ListaDeAlertas {
    ServicioMeteorologico servicioMeteorologico;
    List<AlertaMeteorologica> alertasActuales = new ArrayList<>();
}

enum AlertaMeteorologica {
    TORMENTA,
    GRANIZO
}

//Requerimiento 4
public class ListaDeAlertas {

    private ServicioMeteorologico servicioMeteorologico;
    List<AlertaMeteorologica> alertasActuales = new ArrayList<AlertaMeteorologica>();
    public void actualizarAlertas(){
        alertasActuales = new ArrayList<AlertaMeteorologica>();
    }
}

public class Empleado{
    (...)
    private ListaDeAlertas listaDeAlertas;
    public void ActualizarAlerta(){
        listaDeAlertas.actualizarAlertas();
    }
}

//Requerimiento 5

public class Empleado{
    (...)
    private ListaDeAlertas listaDeAlertas;
    private List<Usuario> usuarios;
    public void ActualizarAlerta(){
        listaDeAlertas.actualizarAlertas();
        usuarios.forEach(usuario -> usuario.actualizarSugerencia());
    }
}

public class Usuario{
    private Sugerencia sugerenciaDiaria;
    public void actualizarSugerencia(){
        sugerenciaDiaria = new Sugerencia();
    }
}


//Requerimiento 6 7 y 8

public class ListaDeAlertas {

    private ServicioMeteorologico servicioMeteorologico;
    List<AlertaMeteorologica> alertasActuales = new ArrayList<AlertaMeteorologica>();

    public void realizarAccionesSobreAlertas(List<AlertaMeteorologica> alertas, Usuario usuario){
        if(alertas.contains(AlertaMeteorologica.TORMENTA)){
            new NotificationService().notify("Llevar tambien Paraguas");
            new MailSender().send(usuario.mail,"Llevar tambien Paraguas");
        }else if (alertas.contains(AlertaMeteorologica.GRANIZO)) {
            new NotificationService().notify("Evitar Auto");
            new MailSender().send(usuario.mail,"Evitar Auto");
        }
    }

    public void actualizarAlertas(){
        alertasActuales = new ArrayList<AlertaMeteorologica>();
    }
}

public class Empleado{
    (...)
    private ListaDeAlertas listaDeAlertas;
    private List<Usuario> usuarios;
    public void ActualizarAlerta(){
        listaDeAlertas.actualizarAlertas();
        usuarios.forEach(usuario ->
                listaDeAlertas.realizarAccionesSobreAlertas(listaDeAlertas,usuario));
    }
}
