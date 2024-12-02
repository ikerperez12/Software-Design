package E1;



public  class EQUIPOA extends ProduccionCine {
    Pelicula p= new Pelicula("Alcarras2",300000);
    private double comision;

    public EQUIPOA(String nombre, String apellido, String DNI, int telefono, String nacionalidad, int salario, PUESTOS puestos, EspecialidadT especialidad, double comision) {
        super(nombre,apellido,DNI,telefono,nacionalidad,salario,puestos,especialidad);
        this.comision = comision;
    }



    @Override
    public double getComision() {

        if (this.getPuesto() == PUESTOS.MUSICO) {
            return p.getRecaudacion() * 0.04;
        }
        if (this.getPuesto() == PUESTOS.GUIONISTA) {
            return p.getRecaudacion() * 0.05;
        }
        if (this.getPuesto() == PUESTOS.PRODUCTORES) {
            return p.getRecaudacion() * 0.02;
        }
        else   return p.getRecaudacion() * 0.05;
    }

    public void setComision(double comision){
        this.comision = comision;
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
        sb.append(this.getComision());
        sb.append(" euro");
        return new String(sb);
    }
}


