package pvehiculos;

import java.sql.SQLException;
import java.util.ArrayList;

public class Pvehiculos {

    public static void main(String[] args) throws SQLException {

        conexionMongo.conectar_a_servidor();
        conexionMongo.conectar_a_base("test");
        conexionMongo.conectar_a_unha_colecion("vendas");
        ArrayList<exportMongo> arrayList = conexionMongo.sacarDatos();
        conexionMongo.cerrar_conexion();

        for (int x = 0; x < arrayList.size(); x++) {

            exportMongo objeto = arrayList.get(x);

            conexionObjectDB.conectar_a_servidor();
            Clientes cliente = conexionObjectDB.select_Clientes(objeto.getDni());
            Vehiculos vehiculo = conexionObjectDB.select_Vehiculos(objeto.getCodveh());
            conexionObjectDB.cerrar_conexion();

            int pf = 0;
            if (cliente.getNcompras() == 0) {
                pf = vehiculo.getPrezoorixe() - ((2019 - vehiculo.getAnomatricula()) * 500) - 0;
            } else {
                pf = vehiculo.getPrezoorixe() - ((2019 - vehiculo.getAnomatricula()) * 500) - 500;
            }

            conexionOrcacle.getConexion();
            conexionOrcacle.insertOracle(objeto.getId(), objeto.getDni(), cliente.getNomec(), vehiculo.getNomveh(),pf);
            conexionOrcacle.closeConexion();

        }
    }
}
