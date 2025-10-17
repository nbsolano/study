package one.digitalinnovation.gof.singleton;

/**
 * Singleton "preguiçoso".
 *
 * @author @nbsolano
 */
public class SingletonLazy {

    private static SingletonLazy instancia;

    private SingletonLazy(){
        //TODO Auto-generated constructor stub
        super();
    }

    public static SingletonLazy getInstancia(){
        if (instancia == null){
            instancia = new SingletonLazy();
        }
        return instancia;
    }
}
