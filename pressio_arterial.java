import java.util.Scanner;

/**
 * pressió-arterial
 */

public class pressio_arterial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int auxIntInput, menuOpcio = 0, posició = 0;
        int parella = 0, totalParelles = 0;
        boolean parellaValida = true;

        int numeroMedidas = 10;
        int[] sistolica = new int[numeroMedidas];
        int[] diastolica = new int[numeroMedidas];

        int[] diastolicaMaxima = new int[2];
        String sistolicaMaximaTipus = "";
        int[] sistolicaMaxima = new int[2];
        String diastolicaMaximaTipus = "";
        int[] compensada = new int[2];
        String compensadaTipus = "";
        int[] media = new int[2];

        String[] menu = {
                "1- Sistòlica máxima",
                "2- Diastòlica mínima",
                "3- Més compensada",
                "4- Tensió mitjana",
                "5- Eixir"
        };

        int sistolicaAux = 0;
        int diastolicaAux = 0;
        int compensadaAux = 0;

        boolean semafor = false;

        final boolean dev = false;

        System.out.println("Benvingut al programa de pressió arterial");
        System.out.println("----------------------------------------");
        System.out.print("Introdueix les mesures: ");
        while (!semafor) {
            if (scanner.hasNextInt()) {
                auxIntInput = scanner.nextInt();
                if (auxIntInput >= 3 && auxIntInput <= 22) {
                    if (parella == 0) {
                        diastolicaAux = auxIntInput;
                    } else {
                        sistolicaAux = auxIntInput;
                    }
                } else {
                    parellaValida = false;
                    sistolicaAux = 0;
                    diastolicaAux = 0;
                }

                parella++;

                if (parella == 2) {
                    if (parellaValida && sistolicaAux < diastolicaAux) {
                        sistolica[totalParelles] = sistolicaAux;
                        diastolica[totalParelles] = diastolicaAux;
                        totalParelles++;
                    }
                    parella = 0;
                    parellaValida = true;
                }
                if (totalParelles >= 2 && auxIntInput == 0 || totalParelles >= 10) {
                    semafor = true;
                }
            } else {
                scanner.next();
            }
        }
        scanner.nextLine();

        if (dev) {
            System.out.println("total parelles: " + totalParelles);
            System.out.println("diastolica: ");
            for (int i : diastolica) {
                System.out.print(" " + i);
            }
            System.out.println("");
            System.out.println("sistolica: ");
            for (int i : sistolica) {
                System.out.print(" " + i);
            }
            System.out.println("");
        }

        // diastòlica máxima
        posició = 0;
        diastolicaAux = 0;
        for (int i = 0; i < totalParelles; i++) {
            if (diastolica[i] >= diastolicaAux) {
                diastolicaAux = diastolica[i];
                posició = i;
            }
        }
        diastolicaMaxima[0] = diastolica[posició];
        diastolicaMaxima[1] = sistolica[posició];

        if (sistolicaMaxima[1] < 12 && sistolicaMaxima[0] < 8) {
            sistolicaMaximaTipus = "Sistòlica aïllada";
        } else if (sistolicaMaxima[1] >= 12 && sistolicaMaxima[1] <= 12.9 && sistolicaMaxima[0] >= 8
                && sistolicaMaxima[0] <= 8.4) {
            sistolicaMaximaTipus = "Normal";
        } else if (sistolicaMaxima[1] >= 13 && sistolicaMaxima[1] <= 13.9 && sistolicaMaxima[0] >= 8.5
                && sistolicaMaxima[0] <= 8.9) {
            sistolicaMaximaTipus = "Normal-Alta";
        } else if (sistolicaMaxima[1] >= 14 && sistolicaMaxima[1] <= 15.9 && sistolicaMaxima[0] >= 9
                && sistolicaMaxima[0] <= 9.9) {
            sistolicaMaximaTipus = "Grave 1";
        } else if (sistolicaMaxima[1] >= 16 && sistolicaMaxima[1] <= 17.9 && sistolicaMaxima[0] >= 10
                && sistolicaMaxima[0] <= 10.9) {
            sistolicaMaximaTipus = "Grave 2";
        } else if (sistolicaMaxima[0] >= 18 && sistolicaMaxima[1] >= 11) {
            sistolicaMaximaTipus = "Grave 3";
        } else if (sistolicaMaxima[0] >= 14 && sistolicaMaxima[1] < 9) {
            sistolicaMaximaTipus = "Sistòlica aislada";
        } else {
            sistolicaMaximaTipus = "Desconegut";
        }

        // comprovant tipus de tensiò

        // optima

        // sistòlica mínima
        posició = 0;
        sistolicaAux = 100;
        for (int i = 0; i < totalParelles; i++) {
            if (sistolica[i] <= sistolicaAux) {
                sistolicaAux = sistolica[i];
                posició = i;
            }
        }
        sistolicaMaxima[0] = diastolica[posició];
        sistolicaMaxima[1] = sistolica[posició];

        if (diastolicaMaxima[1] < 12 && diastolicaMaxima[0] < 8) {
            diastolicaMaximaTipus = "Sistòlica aïllada";
        } else if (diastolicaMaxima[1] >= 12 && diastolicaMaxima[1] <= 12.9 && diastolicaMaxima[0] >= 8
                && diastolicaMaxima[0] <= 8.4) {
            diastolicaMaximaTipus = "Normal";
        } else if (diastolicaMaxima[1] >= 13 && diastolicaMaxima[1] <= 13.9 && diastolicaMaxima[0] >= 8.5
                && diastolicaMaxima[0] <= 8.9) {
            diastolicaMaximaTipus = "Normal-Alta";
        } else if (diastolicaMaxima[1] >= 14 && diastolicaMaxima[1] <= 15.9 && diastolicaMaxima[0] >= 9
                && diastolicaMaxima[0] <= 9.9) {
            diastolicaMaximaTipus = "Grave 1";
        } else if (diastolicaMaxima[1] >= 16 && diastolicaMaxima[1] <= 17.9 && diastolicaMaxima[0] >= 10
                && diastolicaMaxima[0] <= 10.9) {
            diastolicaMaximaTipus = "Grave 2";
        } else if (diastolicaMaxima[0] >= 18 && diastolicaMaxima[1] >= 11) {
            diastolicaMaximaTipus = "Grave 3";
        } else if (diastolicaMaxima[0] >= 14 && diastolicaMaxima[1] < 9) {
            diastolicaMaximaTipus = "Sistòlica aislada";
        } else {
            diastolicaMaximaTipus = "Desconegut";
        }

        // més compensada
        posició = 0;
        compensadaAux = 100;
        for (int i = 0; i < totalParelles; i++) {
            int operacio = diastolica[i] - sistolica[i];
            if (operacio <= compensadaAux) {
                compensadaAux = operacio;
                posició = i;
            }
        }
        compensada[0] = diastolica[posició];
        compensada[1] = sistolica[posició];

        if (compensada[1] < 12 && compensada[0] < 8) {
            compensadaTipus = "Sistòlica aïllada";
        } else if (compensada[1] >= 12 && compensada[1] <= 12.9 && compensada[0] >= 8
                && compensada[0] <= 8.4) {
            compensadaTipus = "Normal";
        } else if (compensada[1] >= 13 && compensada[1] <= 13.9 && compensada[0] >= 8.5
                && compensada[0] <= 8.9) {
            compensadaTipus = "Normal-Alta";
        } else if (compensada[1] >= 14 && compensada[1] <= 15.9 && compensada[0] >= 9
                && compensada[0] <= 9.9) {
            compensadaTipus = "Grave 1";
        } else if (compensada[1] >= 16 && compensada[1] <= 17.9 && compensada[0] >= 10
                && compensada[0] <= 10.9) {
            compensadaTipus = "Grave 2";
        } else if (compensada[0] >= 18 && compensada[1] >= 11) {
            compensadaTipus = "Grave 3";
        } else if (compensada[0] >= 14 && compensada[1] < 9) {
            compensadaTipus = "Sistòlica aislada";
        } else {
            compensadaTipus = "Desconegut";
        }

        // tensió mitjana
        sistolicaAux = 0;
        diastolicaAux = 0;
        for (int i = 0; i < totalParelles; i++) {
            sistolicaAux += sistolica[i];
            diastolicaAux += diastolica[i];
        }
        media[0] = diastolicaAux / totalParelles;
        media[1] = sistolicaAux / totalParelles;

        // Menú
        for (String string : menu) {
            System.out.println(string);
        }

        while (menuOpcio != 5) {
            System.out.print("Selecciona l'opció desitjada: ");
            if (scanner.hasNextInt()) {
                menuOpcio = scanner.nextInt();
                switch (menuOpcio) {
                    case 1:
                        System.out.printf("Sistòlica màxima: " + sistolicaMaxima[0] + " " + sistolicaMaxima[1] + "\n");
                        System.out.printf("Tipus: " + sistolicaMaximaTipus + "\n");
                        break;
                    case 2:
                        System.out.printf(
                                "Diastòlica mínima: " + diastolicaMaxima[0] + " " + diastolicaMaxima[1] + " \n");
                        System.out.printf("Tipus: " + diastolicaMaximaTipus + "\n");
                        break;
                    case 3:
                        System.out.printf("Més compensada: " + compensada[0] + " " + compensada[1] + " \n");
                        System.out.printf("Tipus: " + compensadaTipus + "\n");

                        break;
                    case 4:
                        System.out.printf("Tensió mitjana: " + media[0] + " " + media[1] + " \n");
                        break;
                    case 5:
                        System.out.println("Gràcies per utilitzar el programa");
                        break;
                    default:
                        System.out.println("Opció incorrecta");
                        break;
                }
            } else {
                scanner.next();
            }
        }
        scanner.close();
    }
}