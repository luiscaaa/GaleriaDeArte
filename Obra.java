import java.util.Calendar;

public class Obra {
    private long codigoObra;
    private String titulo;
    private Calendar fecha;
    private float precioRef;
    private String dimensiones;
    private boolean comprada = false;

    public Obra(long codigoObra, String titulo, Calendar fecha, float precioRef, String dimensiones) {
        this.codigoObra = codigoObra;
        this.titulo = titulo;
        this.fecha = fecha;
        this.precioRef = precioRef;
        this.dimensiones = dimensiones;
    }

    public Obra(long codigoObra, String titulo, float precioRef, String dimensiones) {
        this.codigoObra = codigoObra;
        this.titulo = titulo;
        this.precioRef = precioRef;
        this.dimensiones = dimensiones;
    }

    public boolean isComprada() {
        return comprada;
    }

    public void setComprada(boolean comprada) {
        this.comprada = comprada;
    }

    public long getCodigoObra() {
        return codigoObra;
    }

    public void setCodigoObra(long codigoObra) {
        this.codigoObra = codigoObra;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public float getPrecioRef() {
        return precioRef;
    }

    public void setPrecioRef(float precioRef) {
        this.precioRef = precioRef;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    @Override
    public String toString() {
            return "\n" + "Codigo obra: " + codigoObra +
                    ", Titulo: '" + titulo + '\'' +
                    ", Fecha: " + fecha.get(Calendar.DATE) + "/" + fecha.get(Calendar.MONTH) + "/" + fecha.get(Calendar.YEAR) +
                    ", Precio referencia: " + precioRef +
                    ", Dimensiones: '" + dimensiones + '\'' +
                    '}';
    }
}
