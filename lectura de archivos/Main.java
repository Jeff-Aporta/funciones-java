import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    public static void main(String[] args) throws Exception {
        try {
            String rutaArchivoLocal = "C:\\prueba.txt";
            System.out.println(LeerArchivo_ASCII(new File(rutaArchivoLocal)));
        } catch (Exception e) {
        }
        try {
            String rutaArchivoWeb = "https://www.youtube.com/c/luisitocomunica";
            System.out.println(LeerArchivo_ASCII(new URL(rutaArchivoWeb)));
        } catch (Exception e) {
        }
    }

    public static String LeerArchivo_ASCII(URL ruta) throws Exception {
        if (ruta == null) {
            throw new RuntimeException("Error, la URL de lectura no puede ser nula");
        }
        URLConnection conexión = ruta.openConnection();
        InputStreamReader isr = new InputStreamReader(conexión.getInputStream());
        return LeerArchivo_ASCII(isr);
    }

    public static String LeerArchivo_ASCII(File archivo) throws Exception {
        if (archivo == null) {
            throw new RuntimeException("Error, el archivo de lectura no puede ser nulo");
        }
        FileReader fr = new FileReader(archivo);
        return LeerArchivo_ASCII(fr);
    }

    public static String LeerArchivo_ASCII(Reader reader) throws Exception {
        BufferedReader br = new BufferedReader(reader);
        String texto = "";
        String linea;
        boolean primerRenglón = true;
        while ((linea = br.readLine()) != null) {
            if (primerRenglón) {
                primerRenglón = false;
            } else {
                texto += "\n";
            }
            texto += linea;
        }
        reader.close();
        br.close();
        return texto;
    }

}
