import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConsultaApi consultaApi = new ConsultaApi();
        boolean salida = false;


        while (!salida){
            boolean salida2 = false;

            int election = 0;
            String MonedaBase = "";
            String MonedaFinal = "";
            double Importe = 0;

            System.out.println("**********************************************");
            System.out.println("""
                    Seleccione el tipo de conversion que desea realizar:
                    
                    1: USD a ARS
                    2: ARS a USD
                    3: USD a BRL 
                    4: BRL a USD
                    5: BOB a USD
                    6: USD a BOB
                    7: CLP a USD
                    8: USD a CLP
                    9: COP a USD 
                    10: USD a COP
                    0: Salir
                    """);
            System.out.println("**********************************************");

            System.out.println("Indique aqui ");
            election = teclado.nextInt();
            teclado.nextLine();

            switch (election) {
                case 1:
                    MonedaBase = "USD";
                    MonedaFinal = "ARS";
                    break;
                case 2:
                    MonedaBase = "ARS";
                    MonedaFinal = "USD";
                    break;
                case 3:
                    MonedaBase = "USD";
                    MonedaFinal = "BRL";
                    break;
                case 4:
                    MonedaBase = "BRL";
                    MonedaFinal = "USD";
                    break;
                case 5:
                    MonedaBase = "BOB";
                    MonedaFinal = "USD";
                    break;
                case 6:
                    MonedaBase = "USD";
                    MonedaFinal = "BOB";
                    break;
                case 7:
                    MonedaBase = "CLP";
                    MonedaFinal = "USD";
                    break;
                case 8:
                    MonedaBase = "USD";
                    MonedaFinal = "CLP";
                    break;
                case 9:
                    MonedaBase = "COP";
                    MonedaFinal = "USD";
                    break;
                case 10:
                    MonedaBase = "USD";
                    MonedaFinal = "COP";
                    break;

                case 0:
                    salida=true;
                    salida2 = true;


                    break;
                default:
                    System.out.println("Elija una opcion valida");
                    teclado.nextLine();
                    break;
            }
            while (!salida2) {
               System.out.println("Ingrese la cantidad de " + MonedaBase  + " que desea convertir: ");
                Importe = teclado.nextDouble();
                teclado.nextLine();

                if(Importe == 0 ){
                    System.out.println("Ingrese un importe valido! ");
                    teclado.nextLine();
                } else {
                    try {
                        Moneda moneda = consultaApi.convertidorMoneda(MonedaBase, MonedaFinal, Importe);
                        System.out.println("El valor convertido de " + MonedaBase + " " + Importe + " a " + MonedaFinal + " es: " + moneda.conversion_result() );
                        System.out.println("**********************************************");
                        System.out.println("Presionar enter para continuar");
                        teclado.nextLine();
                        Json json = new Json();
                        json.Json(moneda, Importe);
                        salida2 = true;
                    }
                    catch (NumberFormatException e ) {
                        System.out.println("Numero no encontrado " + e.getMessage());

                    }
                    catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }



                    



        }

}
    }
