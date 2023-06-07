package mascotasEncapsuladas;

public class Mascotas {
    // Atributos encapsulados
    private int codigo;
    private String nombre;
    private String especie;
    private int edad;
    private String edadString;
    
    private ArrayList<String> informacionMascota;
    
    

    // Constructor sin parámetros
    public Mascotas() {
        nombre = "Firu";
        especie = "Default";
        edad = 0;
        informacionMascota = new ArrayList<>();
    }
    
    public void ingresar() {
        String val;
    	
        do {
            nombre = JOptionPane.showInputDialog("Ingrese nombre");
            especie = JOptionPane.showInputDialog("Ingrese la especie de " + nombre);
            edad = Integer.parseInt(JOptionPane.showInputDialog("Edad de la mascota " + nombre));
        
            informacionMascota.add(nombre);
            informacionMascota.add(especie);
            edadString = Integer.toString(edad);
            informacionMascota.add(edadString);
        
            val = JOptionPane.showInputDialog("¿Desea ingresar otra mascota?");
        } while (val.equalsIgnoreCase("SI"));
    }

    // Método para ingresar datos desde la clase Mascotas
    public void ingresoDesdeClaseMascotas() {
        String val;
    	
        do {
            nombre = JOptionPane.showInputDialog("Ingrese nombre");
            especie = JOptionPane.showInputDialog("Ingrese la especie de " + nombre);
            edad = Integer.parseInt(JOptionPane.showInputDialog("Edad de la mascota " + nombre));
        
            informacionMascota.add(nombre);
            informacionMascota.add(especie);
            edadString = Integer.toString(edad);
            informacionMascota.add(edadString);
        
            val = JOptionPane.showInputDialog("¿Desea ingresar otra mascota?");
        } while (val.equalsIgnoreCase("SI"));
    }
    
    // Constructor con parámetros
    public Mascotas(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        informacionMascota = new ArrayList<>();
    }
    
    // Métodos getter y setter para acceder a los atributos encapsulados
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEdadString() {
        return edadString;
    }

    public void setEdadString(String edadString) {
        this.edadString = edadString;
    }

    public ArrayList<String> getInformacionMascota() {
        return informacionMascota;
    }

    public void setInformacionMascota(ArrayList<String> informacionMascota) {
        this.informacionMascota = informacionMascota;
    }
    
    // Método para mostrar información de la mascota
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Edad: " + edad + " años");
    }

    public void mostrarInformacionGeneral(){
        for (int i = 0; i < informacionMascota.size(); i++) {
            System.out.println(informacionMascota.get(i));
        }
    }
    
    public void consultaIndividual() {
        if (informacionMascota.isEmpty()) {
            System.out.println("No hay mascotas registradas.");
            return;
        }

        String nombreBuscado = JOptionPane.showInputDialog("Ingrese el nombre de la mascota a consultar");
        boolean encontrada = false;

        for (int i = 0; i < informacionMascota.size(); i += 3) {
            String nombre = informacionMascota.get(i);

            if (nombre.equalsIgnoreCase(nombreBuscado)) {
                String especie = informacionMascota.get(i + 1);
                String edadString = informacionMascota.get(i + 2);
                int edad = Integer.parseInt(edadString);

                Mascotas mascotaConsultada = new Mascotas(nombre, especie, edad);
                mascotaConsultada.mostrarInformacion();
                encontrada = true;

                // Modificar la mascota consultada
                String opcionModificacion = JOptionPane.showInputDialog("¿Qué desea modificar? (nombre/especie/edad)");
                opcionModificacion = opcionModificacion.toLowerCase();

                switch (opcionModificacion) {
                    case "nombre":
                        nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre");
                        informacionMascota.set(i, nombre);
                        mascotaConsultada.setNombre(nombre);
                        break;
                    case "especie":
                        especie = JOptionPane.showInputDialog("Ingrese la nueva especie");
                        informacionMascota.set(i + 1, especie);
                        mascotaConsultada.setEspecie(especie);
                        break;
                    case "edad":
                        edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva edad"));
                        informacionMascota.set(i + 2, Integer.toString(edad));
                        mascotaConsultada.setEdad(edad);
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }

                System.out.println("Mascota modificada:");
                mascotaConsultada.mostrarInformacion();
                break;
            }
        }

        if (!encontrada) {
            System.out.println("La mascota no se encontró en la lista.");
        }
    }

    // Método para hacer que la mascota realice un sonido
    public void hacerSonido() {
        if (especie.equalsIgnoreCase("perro")) {
            System.out.println("Guau guau!");
        } else if (especie.equalsIgnoreCase("gato")) {
            System.out.println("Miau miau!");
        } else {
            System.out.println("La mascota no hace sonidos conocidos.");
        }
    }
    
    public void metodoJugar() {
        if (especie.equalsIgnoreCase("Perro")) {
            System.out.println("El perro está jugando");
        } else if (especie.equalsIgnoreCase("gato")) {
            System.out.println("El gato está jugando");
        } else {
            System.out.println("La mascota no está jugando");
        }
        
    }
 // Acceder a los atributos encapsulados utilizando los métodos getter
    System.out.println("Nombre de la mascota: " + mascota.getNombre());
    System.out.println("Especie de la mascota: " + mascota.getEspecie());
    System.out.println("Edad de la mascota: " + mascota.getEdad());

    // Modificar los atributos encapsulados utilizando los métodos setter
    mascota.setNombre("Firulais");
    mascota.setEspecie("Perro");
    mascota.setEdad(3);
//Acceder nuevamente a los atributos modificados
    System.out.println("Nombre de la mascota: " + mascota.getNombre());
    System.out.println("Especie de la mascota: " + mascota.getEspecie());
    System.out.println("Edad de la mascota: " + mascota.getEdad());
}