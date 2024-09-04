import java.util.ArrayList;
import java.util.Objects;

public class ControlGaleria {

   /*public ControlGaleria(ArrayList<Obra> listaObras, ArrayList<Artista> listaArtistas, ArrayList<Cliente> listaClientes) {
        crearListaObras(listaObras);
        crearListaArtistas(listaArtistas);
        crearListaClientes(listaClientes);
    }

    public static void crearListaObras(ArrayList<Obra> listaObras){
        GestionObras.llenarListaObras(listaObras);
    }*/

    public static void imprimirObras(ArrayList<Obra> listaObras){
        int cont = 0;
        System.out.println("Las obras disponibles para la venta son: ");
        for(Obra obra : listaObras){
            if(listaObras.size() != cont+1) {
                if (!obra.isComprada()) {
                    System.out.print(obra);
                    cont++;
                }
            }
            else{
                if (!obra.isComprada()) {
                    System.out.println(obra);
                }
            }
        }
        System.out.println("\n");
    }

    public static void imprimirArtistas(ArrayList<Artista> listaArtistas){
        System.out.println(listaArtistas);
    }

    public static void imprimirClientes(ArrayList<Cliente>listaClientes){
        System.out.println(listaClientes);
    }

    public static void imprimirCompras(ArrayList<Compra>listaCompras){
        System.out.println(listaCompras);
    }

    public static Obra buscarTitulo(ArrayList<Obra> listaObras, String titulo){
        boolean existe = false;
        for(Obra obra:listaObras){
            //System.out.println(obra.getTitulo());
            if(Objects.equals(obra.getTitulo(), titulo)){
                existe = true;
                return obra;
            }
        }
        return null;
    }

    public static Artista buscarArtista(ArrayList<Artista> listaArtistas, String nombre){
        boolean existe = false;
        for(Artista artista:listaArtistas){
            String cadena = artista.getNombre().concat(" " + artista.getApellidos());
            //System.out.println(cadena);
            if(Objects.equals(cadena, nombre)){
                existe = true;
                return artista;
            }
        }
        return null;
    }

    public static Cliente buscarCliente(ArrayList<Cliente> listaClientes, long cedula){
        boolean existe = false;
        for (Cliente cliente : listaClientes){
            if(cliente.getCedula() == cedula){
                existe = true;
                return cliente;
            }
        }
        return null;
    }

    /*public static void crearListaArtistas(ArrayList<Artista> listaArtistas){
        GestionObras.llenarListaArtistas(listaArtistas);
    }*/

    /*public static void crearListaClientes(ArrayList<Cliente> listaClientes){
        GestionClientes.llenarListaClientes(listaClientes);
    }*/
}
