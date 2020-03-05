
package pvehiculos;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.bson.Document;


public class conexionMongo {

    public static MongoClient client;
    public static MongoDatabase database;
    public static MongoCollection<Document> colecion;


    public static void  conectar_a_servidor(){
        client = new MongoClient("localhost",27017);
    } 
    public static void  conectar_a_base(String nomebase){
        database = client.getDatabase(nomebase);
    }
    public static void  conectar_a_unha_colecion(String coleccion){
        colecion = database.getCollection(coleccion);
    }
    
    public static void cerrar_conexion(){
        client.close();
    }
    
    public static ArrayList<exportMongo> sacarDatos(){
        
        ArrayList<exportMongo> arrayList = new ArrayList<exportMongo>();
        FindIterable<Document> cursornovo = colecion.find();
        MongoCursor<Document> iterator = cursornovo.iterator();
        while (iterator.hasNext()){
            Document next = iterator.next();
                double j1 = next.getDouble("_id");
                String j2 = next.getString("dni");
                String j3 = next.getString("codveh");
                
                int j11 = (int)j1;
                     
                exportMongo objeto = new exportMongo(j11,j2,j3);
                arrayList.add(objeto);
            }
        return arrayList;
    }
    
    
}
