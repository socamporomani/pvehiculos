package pvehiculos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class conexionObjectDB {
    
    public static EntityManagerFactory emf;
    public static EntityManager em;
    
    public static void  conectar_a_servidor(){
        emf = Persistence.createEntityManagerFactory("objectdb/db/vehicli.odb");
        em = emf.createEntityManager();
    } 
    
    
    public static Clientes select_Clientes(String dni){
        
        TypedQuery<Clientes> query = em.createQuery("SELECT p FROM Clientes p WHERE p.dni='" + dni + "'", Clientes.class);
        List<Clientes> results = query.getResultList();
        
        Clientes cliente = new Clientes();
        
        for (Clientes p : results) {
        //Recogemos y guardamos datos de clientes
            cliente.setDni(p.dni);
            cliente.setNcompras(p.ncompras);
            cliente.setNomec(p.nomec);
        }
        
        return cliente;
    }
    
    public static Vehiculos select_Vehiculos(String codveh){
        
            TypedQuery<Vehiculos> query2 = em.createQuery("SELECT p FROM Vehiculos p where p.codveh='" + codveh + "'", Vehiculos.class);
            List<Vehiculos> results2 = query2.getResultList();
            
            Vehiculos vehiculo = new Vehiculos();
            
            for (Vehiculos p : results2) {
                vehiculo.setAnomatricula(p.anomatricula);
                vehiculo.setCodveh(p.codveh);
                vehiculo.setNomveh(p.nomveh);
                vehiculo.setPrezoorixe(p.prezoorixe);
            }
            
            return vehiculo;
    }    
    
    public static void cerrar_conexion(){
        em.close();
        emf.close();
    }   
}
