/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package co.edu.escuelaing.sparkdockerdemolive;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import static spark.Spark.get;
import static spark.Spark.port;

/**
 *
 * @author daniel.moreno-c
 */
public class Sparkdockerdemolive {

    public static void main(String... args) {
        port(getPort());
        get("calculadora", (req, res) -> clientWeb());
        get("calcular", (req, res) -> {
            res.type("text/html");
            return calcule(req.queryParams("comando"));
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    public static String calcule(String query) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        String outputLine = "";
        String[] commandAndParams = query.split("\\(");
        String command = commandAndParams[0];
        if (command.equals("pal")) {
            outputLine = palindrome(commandAndParams[1].replace(")", ""));
        } else {
            double[] array = doubleArrayParams(commandAndParams[1]);
            if (command.equals("vem")) {
                double magnitude = vectorMagnitude(array);
                outputLine += String.valueOf(magnitude);
            } else {
                double result = mathMethods(Double.parseDouble(commandAndParams[1].replace(")", "")), command);
                outputLine = String.valueOf(result);
            }
        }
        return outputLine;
    }

    public static double vectorMagnitude(double[] array) {
        if (array.length != 2) {
            throw new IllegalArgumentException("El vector es de dos dimensiones");
        }
        double x = array[0];
        double y = array[1];
        double magnitud = Math.sqrt(x * x + y * y);
        return magnitud;
    }

    public static String palindrome(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase();
        boolean isPalindrome = true;
        int longitud = str.length();
        for (int i = 0; i < longitud / 2; i++) {
            if (str.charAt(i) != str.charAt(longitud - 1 - i)) {
                isPalindrome = false;
            }
        }
        return String.valueOf(isPalindrome);
    }

    public static double mathMethods(double nmbr, String command) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        double anguloRadianes = Math.toRadians(nmbr);
        double result = 0.0D;
        if(command.equals("sin")){
            result = Math.sin(anguloRadianes);
        }
        else if(command.equals("cos")){
            result = Math.cos(anguloRadianes);
        }
        return result;
    }

    public static double[] doubleArrayParams(String paramsString) {
        String params = paramsString.replace(")", "");
        String[] arrayStrings = params.split(",");
        double[] array = new double[arrayStrings.length];
        for (int i = 0; i < arrayStrings.length; i++) {
            array[i] = Double.parseDouble(arrayStrings[i]);
        }
        return array;
    }

    public static String clientWeb() {
        return "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <title>Calculadora</title>\n"
                + "        <meta charset=\"UTF-8\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    </head>\n"
                + "    <body>\n"
                + "       <div>"
                + "        <h1>Calculadora</h1>\n"
                + "        <h2>Calcular Seno</h2>\n"
                + "        <form action=\"/calcular\">\n"
                + "            <label for=\"params-sin\">Digita el Angulo (El programa lo pasa a riadianes):</label><br>\n"
                + "            <input type=\"text\" id=\"params-sin\" name=\"name\" value=\"-3.67\"><br><br>\n"
                + "            <input type=\"button\" value=\"Calcular\" onclick=\"loadGetMsg('sin')\">\n"
                + "        </form> \n"
                + "        <h3>Resultado</h3>\n"
                + "        <div id=\"getrespmsg-sin\"></div>\n"
                + "       </div>"
                + "       <div>"
                + "        <h2>Calcular Coseno</h2>\n"
                + "        <form action=\"/calcular\">\n"
                + "            <label for=\"params-cos\">Digita el Angulo (El programa lo pasa a riadianes):</label><br>\n"
                + "            <input type=\"text\" id=\"params-cos\" name=\"name\" value=\"-3.67\"><br><br>\n"
                + "            <input type=\"button\" value=\"Calcular\" onclick=\"loadGetMsg('cos')\">\n"
                + "        </form> \n"
                + "        <h3>Resultado</h3>\n"
                + "        <div id=\"getrespmsg-cos\"></div>\n"
                + "       </div>"
                + "       <div>"
                + "        <h1>Palíndromo</h1>\n"
                + "        <form action=\"/calcular\">\n"
                + "            <label for=\"params-pal\">Cadena:</label><br>\n"
                + "            <input type=\"text\" id=\"params-pal\" name=\"name\" value=\"Reconocer\"><br><br>\n"
                + "            <input type=\"button\" value=\"Calcular\" onclick=\"loadGetMsg('pal')\">\n"
                + "        </form> \n"
                + "        <h3>Resultado</h3>\n"
                + "        <div id=\"getrespmsg-pal\"></div>\n"
                + "       </div>"
                + "       <div>"
                + "        <h1>Magnitud del Vector l</h1>\n"
                + "        <form action=\"/calcular\">\n"
                + "            <label for=\"params-vem\">Parametros (Deben estar separados por comas sin espacios):</label><br>\n"
                + "            <input type=\"text\" id=\"params-vem\" name=\"name\" value=\"3,4\"><br><br>\n"
                + "            <input type=\"button\" value=\"Calcular\" onclick=\"loadGetMsg('vem')\">\n"
                + "        </form> \n"
                + "        <h3>Resultado</h3>\n"
                + "        <div id=\"getrespmsg-vem\"></div>\n"
                + "       </div>"
                + "\n"
                + jsClient()
                + "    </body>";
    }

    public static String jsClient() {
        return "        <script>\n"
                + "            function loadGetMsg(command) {\n"
                + "                let number = document.getElementById(\"params-\"+ command).value;\n"
                + "                const xhttp = new XMLHttpRequest();\n"
                + "                xhttp.onload = function() {\n"
                + "                    document.getElementById(\"getrespmsg-\" + command).innerHTML =\n"
                + "                    this.responseText;\n"
                + "                }\n"
                + "                xhttp.open(\"GET\", \"/calcular?comando=\" + command + \"(\" + number +\")\");\n"
                + "                xhttp.send();\n"
                + "            }\n"
                + "        </script>\n";
    }

}
