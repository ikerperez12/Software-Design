package E1;

public abstract class ProduccionCine extends EHUMANO {
    private PUESTOS puestos;
    private int salario;
    private EspecialidadT especialidad;
    private double comision;


    public ProduccionCine(String nombre, String apellido, String DNI, int telefono, String nacionalidad, int salario, PUESTOS puestos, EspecialidadT especialidad) {
        super(nombre, apellido, DNI, nacionalidad, telefono);
        this.salario = salario;
        this.puestos = puestos;
        this.especialidad = especialidad;
    }



    public double getComision() {
        return comision;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public PUESTOS getPuesto() {
        return puestos;
    }

    public void setPuesto(PUESTOS puestos) {
        this.puestos = puestos;
    }

    public EspecialidadT getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(EspecialidadT especialidad) {
        this.especialidad = especialidad;
    }



    @Override
    public abstract String toString();
}






