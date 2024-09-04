import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class FileManager {
    public static void cargarObras(String fileName, ArrayList<Obra> listaObras) throws FileNotFoundException{
        File inFile = new File(fileName);
        Scanner input;
        String linea;
        input = new Scanner(inFile);
        while (input.hasNextLine()){
            try{
                linea = input.nextLine();
                String[] parts = linea.split(" - ");
                String codigo = parts[0];
                if (codigo.length() != 7){
                    throw new Exception("Error - El numero de caracteres del codigo es diferente de 7");
                }
                long codigoObra = Long.parseLong(codigo);
                String titulo = parts[1];
                String dia = parts[2];
                String mes = parts[3];
                String año = parts[4];
                float precioRef = Float.parseFloat(parts[5]);
                String dimensiones = parts[6];

                Calendar fechaAux = Calendar.getInstance();
                fechaAux.set(Calendar.DATE, Integer.parseInt(dia));
                fechaAux.set(Calendar.MONTH, Integer.parseInt(mes));
                fechaAux.set(Calendar.YEAR, Integer.parseInt(año));

                Obra o1 = new Obra(codigoObra, titulo, fechaAux, precioRef, dimensiones);
                listaObras.add(o1);
            }catch (FileNotFoundException e){
                System.out.println("ERROR - El archivo no fue abierto");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void cargarArtistas(String fileName, ArrayList<Artista> listaArtistas) throws FileNotFoundException{
        File inFile = new File(fileName);
        Scanner input;
        String linea;
        try{
        input = new Scanner(inFile);
        while (input.hasNextLine()) {

            linea = input.nextLine();
            String[] parts = linea.split(" - ");
            long cedula = Long.parseLong(parts[0]);
            String nombre = parts[1];
            String apellidos = parts[2];
            String dia = parts[3];
            String mes = parts[4];
            String año = parts[5];
            long telefono = Long.parseLong(parts[6]);

            Calendar fechaAux = Calendar.getInstance();
            fechaAux.set(Calendar.DATE, Integer.parseInt(dia));
            fechaAux.set(Calendar.MONTH, Integer.parseInt(mes));
            fechaAux.set(Calendar.YEAR, Integer.parseInt(año));

            Artista a1 = new Artista(cedula, nombre, apellidos, fechaAux, telefono);
            listaArtistas.add(a1);
        }
            }catch (FileNotFoundException e){
                System.out.println("ERROR - El archivo no fue abierto");
        }
    }

    public static void cargarClientes(String fileName, ArrayList<Cliente> listaClientes) throws FileNotFoundException{
        File inFile = new File(fileName);
        Scanner input;
        String linea;
        try{
            input = new Scanner(inFile);
            while (input.hasNextLine()){
                linea = input.nextLine();
                String[] parts = linea.split(" - ");
                long codigo = Long.parseLong(parts[0]);
                long cedula = Long.parseLong(parts[1]);
                String nombre = parts[2];
                String apellidos = parts[3];
                String direccion = parts[4];
                long telefono = Long.parseLong(parts[5]);

                Cliente c1 = new Cliente(codigo, cedula, nombre, apellidos, direccion, telefono);
                listaClientes.add(c1);
            }
        }catch (FileNotFoundException e){
            System.out.println("ERROR - El archivo no fue abierto");
        }
    }

    public static void sobreescribirObras(ArrayList<Obra> listaObras, String fileName){
        String regex = " - ";
        int cont = 0;
        try{
            FileWriter salida = new FileWriter(fileName);
            for(Obra obra : listaObras){
                if(listaObras.size() != (cont+1)){
                    salida.write(obra.getCodigoObra() + regex + obra.getTitulo() + regex + obra.getPrecioRef() + regex + obra.getDimensiones() + "\n");
                    cont++;
                }
                else{
                    salida.write(obra.getCodigoObra() + regex + obra.getTitulo() + regex + obra.getPrecioRef() + regex + obra.getDimensiones());
                }
            }
            salida.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Archivo de obras actualizado!");
    }

    public static void sobreescribirArtistas(ArrayList<Artista> listaArtistas, String fileName){
        String regex = " - ";
        int cont = 0;
        try{
            FileWriter salida = new FileWriter(fileName);
            for(Artista artista : listaArtistas){
                if(listaArtistas.size() != (cont+1)){
                    salida.write(artista.getCedula() + regex + artista.getNombre() + regex + artista.getApellidos() + regex + artista.getTelefono() + "\n");
                    cont++;
                }
                else{
                    salida.write(artista.getCedula() + regex + artista.getNombre() + regex + artista.getApellidos() + regex + artista.getTelefono());
                }
            }
            salida.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Archivo de artistas actualizado!");
    }

    public static void sobreescribirClientes(ArrayList<Cliente> listaClientes, String fileName){
        String regex = " - ";
        int cont = 0;
        try{
            FileWriter salida = new FileWriter(fileName);
            for(Cliente cliente : listaClientes){
                if(listaClientes.size() != (cont+1)){
                    salida.write(cliente.getCodigoCliente() + regex + cliente.getCedula() + regex + cliente.getNombre() + regex + cliente.getApellidos() + regex + cliente.getDireccionEntrega() + regex + cliente.getTelefono() + "\n");
                    cont++;
                }
                else{
                    salida.write(cliente.getCodigoCliente() + regex + cliente.getCedula() + regex + cliente.getNombre() + regex + cliente.getApellidos() + regex + cliente.getDireccionEntrega() + regex + cliente.getTelefono());
                }
            }
            salida.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Archivo de clientes actualizado!");
    }

}
