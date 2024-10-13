import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;

public class Json {
    public void Json (Moneda moneda, double valorConvertido) throws IOException{
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String nombreArchivo = "De" + moneda.base_code() + "a" + moneda.tarjet_code() + ".Json";

        JsonObject jsonMoneda = gson.toJsonTree(moneda).getAsJsonObject();

        jsonMoneda.addProperty("valor convertido", valorConvertido);

        try(FileWriter escritura = new FileWriter(nombreArchivo)) {
            escritura.write(gson.toJson(jsonMoneda));
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo:" + e.getMessage());
            throw e;
        }

    }

}
