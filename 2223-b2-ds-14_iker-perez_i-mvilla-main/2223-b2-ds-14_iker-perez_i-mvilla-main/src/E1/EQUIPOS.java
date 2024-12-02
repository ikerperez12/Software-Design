package E1;

public class EQUIPOS extends ProduccionCine {

    private int experiencia;
    private int horastrabajadas;

    public EQUIPOS(String nombre, String apellido, String DNI, int telefono, String nacionalidad, int salario, PUESTOS puestos, EspecialidadT especialidad, int experiencia,int horastrabajadas ) {
        super(nombre,apellido,DNI,telefono,nacionalidad,salario,puestos,especialidad);
        this.experiencia = experiencia ;
        this.horastrabajadas = horastrabajadas ;
    }


    public int getExperiencia() { return experiencia;}
    public void setExperiencia(int experiencia) { this.experiencia = experiencia; }

    public int getHorastrabajadas() { return horastrabajadas;}
    public void setHorastrabajadas(int horastrabajadas) { this.horastrabajadas = horastrabajadas; }





    @Override
    public int getSalario() {
        if (this.getPuesto() == PUESTOS.GUIONISTA) {
            if (this.getEspecialidad() == EspecialidadT.GORIGINAL) {
                return (super.getSalario() * horastrabajadas ) + 4000;
            } else if (this.getEspecialidad() == EspecialidadT.GADAPTADO)
                return (super.getSalario() * horastrabajadas);
        }
        if (this.getPuesto() == PUESTOS.MUSICO) {
            return (super.getSalario() * horastrabajadas);
        }

        if (this.getPuesto() == PUESTOS.PRODUCTORES) {
            return (super.getSalario() * horastrabajadas);
        }

        if (this.getPuesto() == PUESTOS.DIRECTORES) {
            if (this.getEspecialidad() == EspecialidadT.DEXPERIMENTADO) {
                return (super.getSalario() * horastrabajadas) + (this.getExperiencia() * 1000);
            } else if (this.getEspecialidad() == EspecialidadT.DNOVATO)
                return (super.getSalario() * horastrabajadas);
        }

        if (this.getPuesto() == PUESTOS.INTERPRETES) {
            if (this.getEspecialidad() == EspecialidadT.IPRINCIPAL) {
                return (super.getSalario() * horastrabajadas) * 3;
            } else if (this.getEspecialidad() == EspecialidadT.ISECUNDARIO)
                return (super.getSalario() * horastrabajadas);
        }

        if (this.getPuesto() == PUESTOS.ESPECIALISTAS) {
            if (this.getEspecialidad() == EspecialidadT.ERIESGO) {
                return (super.getSalario() * horastrabajadas) + 1000 ;
            } else if (this.getEspecialidad() == EspecialidadT.EBASICO)
                return (super.getSalario() * horastrabajadas);
        }

        if (this.getPuesto() == PUESTOS.DOBLADORES) {
            return (super.getSalario() * horastrabajadas);
        }


        return (super.getSalario() * horastrabajadas);

    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('\n');
        sb.append(this.getnombre());
        sb.append(" ");
        sb.append(this.getapellido());
        sb.append("  (");
        sb.append(this.getPuesto());
        sb.append(" ");
        if (this.getEspecialidad()!=null){
            sb.append(this.getEspecialidad());}
        sb.append(")   ");
        sb.append(this.getSalario());
        sb.append(" euro");
        return new String(sb);
    }
}




