import java.util.*;

public class Main {
    static Map<String, CuerpoCeleste> sistemaSolar = new HashMap<>();
    static Set<CuerpoCeleste> planetas = new HashSet<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = -1;
        CuerpoCeleste Mercurio = new Planeta("Mercurio", 88, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        sistemaSolar.put("mercurio", Mercurio);
        planetas.add(Mercurio);

        CuerpoCeleste Venus = new Planeta("Venus", 225, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        sistemaSolar.put("venus", Venus);
        planetas.add(Venus);

        CuerpoCeleste LaTierra = new Planeta("La Tierra", 365, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        sistemaSolar.put("la tierra", LaTierra);
        planetas.add(LaTierra);

        CuerpoCeleste Marte = new Planeta("Marte", 687, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        sistemaSolar.put("marte", Marte);
        planetas.add(Marte);

        CuerpoCeleste Jupiter = new Planeta("Jupiter", 4332, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        sistemaSolar.put("jupiter", Jupiter);
        planetas.add(Jupiter);

        CuerpoCeleste Saturno = new Planeta("Saturno", 10759, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        sistemaSolar.put("saturno", Saturno);
        planetas.add(Saturno);

        CuerpoCeleste Urano = new Planeta("Urano", 30660, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        sistemaSolar.put("urano", Urano);
        planetas.add(Urano);

        CuerpoCeleste Neptuno = new Planeta("Neptuno", 165, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        sistemaSolar.put("neptuno", Neptuno);
        planetas.add(Neptuno);

        CuerpoCeleste Pluton = new Planeta("Pluton", 248, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        sistemaSolar.put("pluton", Pluton);
        planetas.add(Pluton);

        CuerpoCeleste Luna = new Luna("Luna", 27, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        sistemaSolar.put("Luna", Luna);
        LaTierra.addSatelite(Luna);

        CuerpoCeleste Deimos = new Luna("Deimos", 1.3, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        CuerpoCeleste Phobos = new Luna("Phobos", 0.3, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        sistemaSolar.put("Deimos", Deimos);
        sistemaSolar.put("Phobos", Phobos);
        Marte.addSatelite(Phobos);
        Marte.addSatelite(Deimos);

        CuerpoCeleste lo = new Luna("lo", 1.8, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        CuerpoCeleste Europa = new Luna("Europa", 3.5, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        CuerpoCeleste Ganymede = new Luna("Ganymede", 7.1, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        CuerpoCeleste Callisto = new Luna("Callisto", 16.7, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        sistemaSolar.put("lo", lo);
        sistemaSolar.put("Europa", Europa);
        sistemaSolar.put("Ganymede", Ganymede);
        sistemaSolar.put("Callisto", Callisto);
        Jupiter.addSatelite(lo);
        Jupiter.addSatelite(Europa);
        Jupiter.addSatelite(Ganymede);
        Jupiter.addSatelite(Callisto);

        CuerpoCeleste planeta = new Planeta("Pluton", 884, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        planetas.add(planeta);
        CuerpoCeleste planeta2 = new PlanetaEnano("Pluton", 884, CuerpoCeleste.TipoCuerpoCeleste.PLANETA_ENANO);
        planetas.add(planeta2);

        menu();
        try {
            while (opcion != 0) {
                System.out.print("Elige la opción: ");
                opcion = sc.nextInt();
                sc.nextLine();
                System.out.println("----------------------------------------------");
                switch (opcion) {
                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;

                    case 1:
                        printPlanetas();
                        break;

                    case 2:
                        System.out.print("Elige un planeta del sistema solar: ");
                        String nombre = sc.nextLine();

                        printLunas(nombre);
                        break;

                    case 3:
                        unionLunas();
                        break;

                    case 4:
                        System.out.print("Elige un planeta del sistema solar: ");
                        nombre = sc.nextLine();
                        interseccionLunas(nombre);
                        break;

                    case 5:
                        System.out.print("Elige un planeta del sistema solar: ");
                        nombre = sc.nextLine();
                        diferenciaLunas(nombre);
                        break;

                    case 6:
                        menu();
                        break;

                    default:
                        System.out.println("Opción invalida.");
                        break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Error. Introduce solo números");
        }
    }

    public static void printPlanetas() {
        System.out.println("PLANETAS DEL SISTEMA SOLAR:");
        for (CuerpoCeleste c : planetas) {
            System.out.println(c.toString());
        }
        System.out.println("----------------------------------------------");
    }

    public static void printLunas(String nombre) {
        if (sistemaSolar.containsKey(nombre.toLowerCase())) {
            CuerpoCeleste planeta = sistemaSolar.get(nombre.toLowerCase());
            System.out.println("LUNAS DE " + nombre.toUpperCase() + ":");

            if (planeta.getSatelites().isEmpty()) {
                System.out.println(nombre.toUpperCase() + " NO TIENE LUNAS.");
            } else {
                System.out.println(planeta.getSatelites());
            }
        } else {
            System.out.println("No existe ese planeta.");
        }
        System.out.println("----------------------------------------------");
    }

    public static void unionLunas() {
        System.out.println("UNIÓN DE TODAS LAS LUNAS:");
        Set<CuerpoCeleste> lunas = new HashSet<>();
        for (CuerpoCeleste c : planetas) {
            lunas.addAll(c.getSatelites());
        }
        System.out.println(lunas);
        System.out.println("----------------------------------------------");
    }

    public static void interseccionLunas(String nombre) {
        if (!sistemaSolar.containsKey(nombre.toLowerCase())) {
            System.out.println("No existe ese planeta.");
            System.out.println("----------------------------------------------");
            return;
        }

        System.out.println("INTERSECCIÓN CON LAS LUNAS DE " + nombre.toUpperCase() + ":");
        Set<CuerpoCeleste> lunas = new HashSet<>();
        Set<CuerpoCeleste> lunasResto = new HashSet<>();

        for (CuerpoCeleste c : planetas) {
            lunas.addAll(c.getSatelites());
        }

        lunasResto.addAll(sistemaSolar.get(nombre.toLowerCase()).getSatelites());
        lunas.retainAll(lunasResto);

        if (lunas.isEmpty()) {
            System.out.println("NO HAY LUNAS EN COMÚN.");
        } else {
        System.out.println(lunas);
        }
        System.out.println("----------------------------------------------");
    }

    public static void diferenciaLunas(String nombre) {
        if (!sistemaSolar.containsKey(nombre.toLowerCase())) {
            System.out.println("No existe ese planeta.");
            System.out.println("----------------------------------------------");
            return;
        }

        System.out.println("DIFERENCIA CON LAS LUNAS DE " + nombre.toUpperCase() + ":");
        Set<CuerpoCeleste> lunas = new HashSet<>();
        Set<CuerpoCeleste> lunasResto = new HashSet<>();

        for (CuerpoCeleste c : planetas) {
            lunas.addAll(c.getSatelites());
        }

        lunasResto.addAll(sistemaSolar.get(nombre.toLowerCase()).getSatelites());
        lunas.removeAll(lunasResto);

        System.out.println(lunas);
        System.out.println("----------------------------------------------");
    }

    public static void menu() {
        System.out.println("MENU DEL SISTEMA SOLAR:\n" +
                "0. Salir\n" +
                "1. Imprimir todos los planetas\n" +
                "2. Imprimir lunas de un planeta\n" +
                "3. Unión de todas las lunas\n" +
                "4. Intersección de las lunas de un planeta\n" +
                "5. Diferencia de las lunas de un planeta\n" +
                "6. Volver a imprimir el menú");
    }
}