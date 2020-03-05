package pvehiculos;

public class exportMongo {
    
    public int id;
    public String dni;
    public String codveh;
    
    public exportMongo(){}
    
    public exportMongo(int id,String dni,String codveh){
        this.id=id;
        this.dni=dni;
        this.codveh=codveh;
    }

    public int getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getCodveh() {
        return codveh;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setCodveh(String codveh) {
        this.codveh = codveh;
    }

    @Override
    public String toString() {
        return "exportMongo{" + "id=" + id + ", dni=" + dni + ", codveh=" + codveh + '}';
    }
}
