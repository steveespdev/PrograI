package prograproject;

import java.io.IOException;

public class Boss extends Employees {

    private double bossSalary;

    public Boss(double bossSalary) {
        this.bossSalary = bossSalary;
    }
    Administrator ad = new Administrator();
    public Principal data = new Principal();

    private double bonus;

    public Boss() {
    }

    public Boss(double bossSalary, double bonus) {
        this.bossSalary = bossSalary;
        this.bonus = bonus;
    }

    public Boss(double bossSalary, double bonus, String name, String ID, String adress, String phoneNumber, int workedHours, String email, String password, Double salary) {
        super(name, ID, adress, phoneNumber, workedHours, email, password, salary);
        this.bossSalary = bossSalary;
        this.bonus = bonus;
    }

    public Boss(double bossSalary, double bonus, String name) {
        super(name);
        this.bossSalary = bossSalary;
        this.bonus = bonus;
    }


    /**
     * @return the bossSalary
     */
    public double getBossSalary() {
        return bossSalary;
    }

    /**
     * @param bossSalary the bossSalary to set
     */
    public void setBossSalary(double bossSalary) {
        this.bossSalary = bossSalary;
    }

    /**
     * @return the bonus
     */
    public double getBonus() {
        return bonus;
    }

    /**
     * @param bonus the bonus to set
     */
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void Hiring() throws IOException {

        System.out.println("Modulo Jefe");
        System.out.println("***********************\n");
        System.out.println("1. Insertar nuevo Empleado");
        System.out.println("2. Eliminar Empleado");
        System.out.println("3. Buscar Empleado");
        System.out.println("4. Modificar Empleado");
        System.out.println("5. Ver lista de Empleados");
        System.out.println("6. Salir");                        // aqui se debe agregar los valores que faltan en la descripcion del proyecto
        String selec = br.readLine();
        switch (selec) {
            case "1":
                addNewEmployee();
                Hiring();
                break;
            case "2":
                removeEmployee();
                Hiring();
                break;
            case "3":
                searchEmployee();
                Hiring();
                break;
            case "4":
                modifyEmployee();
                Hiring();
                break;
            case "5":
                printEmployeelist();
                Hiring();
                break;
            case "6":
                try {
                    System.out.println("Cerrando Sesión...");
                    Thread.sleep(2000);
                    Principal.login();
                } catch (InterruptedException ex) {
                    System.err.println("Hubo un error.");
                }
                break;
            default:
                System.out.println("Los valores ingresados no son correctos");
        }
    }

    private void addNewEmployee() throws IOException {
        System.out.println("Módulo agregar nuevo empleado");
        System.out.println("***********************\n");
        System.out.println("1. Agregar un nuevo Cajero/a");
        System.out.println("2. Agregar un nuevo Miscelaneo/a");
        System.out.println("3. Agregar un nuevo Organizador/a");
        System.out.println("4. Agregar un nuevo Secretario/a");
        System.out.println("5. Agregar un nuevo Vendedor/a");
        System.out.println("6. Regresar");
        String selec = br.readLine();
        switch (selec) {
            case "1":
                Principal.employeeData[data.getCounter()] = ad.addNewCashier();
                Principal.sumCounter();
                Hiring();
                break;
            case "2":
                Principal.employeeData[data.getCounter()] = ad.addNewCleaningAttend();
                Principal.sumCounter();
                Hiring();
                break;
            case "3":
                Principal.employeeData[data.getCounter()] = ad.addNewOrganizer();
                Principal.sumCounter();
                Hiring();
                break;
            case "4":
                Principal.employeeData[data.getCounter()] = ad.addNewSecretary();
                Principal.sumCounter();
                Hiring();
                break;
            case "5":
                Principal.employeeData[data.getCounter()] = ad.addNewSeller();
                Principal.sumCounter();
                Hiring();
                break;
            case "6":
                Hiring();
                break;
            default:
                System.out.println("Los valores ingresados no son correctos");
                addNewEmployee();
        }
    }

    public void removeEmployee() throws IOException {
        System.out.println("Módulo de Eliminar Empleado");
        System.out.println("****************************\n");
        System.out.println("Ingrese el ID del empleado");
        String id = br.readLine();
        int a = 0;
        for (int i = 0; i < data.getCounter(); i++) {
            if (id.equals(Principal.employeeData[i].getID())) {
            } else {
                System.out.println("Este Empleado no existe");
                searchEmployee();
            }
        }
    }

    private void searchEmployee() throws IOException {
        System.out.println("Módulo buscar Empleado");
        System.out.println("***********************\n");
        System.out.println("Ingrese el ID del empleado");
        String id = br.readLine();
        for (int i = 0; i < data.getCounter(); i++) {
            if (id.equals(Principal.employeeData[i].getID())) {
                System.out.println("Nombre: " + Principal.employeeData[i].getName());
                System.out.println("ID: " + Principal.employeeData[i].getID());
                Hiring();
            }
        }
        System.out.println("El empleado no existe");

    }

      private void modifyEmployee() throws IOException {
        System.out.println("Módulo de Modificar Empleado");
        System.out.println("*****************************\n");
        if (Principal.employeeData[0] != null) {
            System.out.println("Ingrese el ID del empleado");
            String entered = br.readLine();
            for (int i = 0; i < data.getCounter() && Principal.employeeData[i] != null; i++) {
                if (entered.equals(Principal.employeeData[i].getID())) {
                    System.out.println("¿Qué datos desea modificar del empleado?\n");
                    System.out.println("1. Nombre");
                    System.out.println("2. ID");
                    System.out.println("3. Dirección");
                    System.out.println("4. # de teléfono");
                    System.out.println("5. Correo Electronico");
                    System.out.println("6. Contrasenia");
                    System.out.println("7. Cancelar");
                    String selec = br.readLine();
                    switch (selec) {
                        case "1":
                            System.out.println("Ingrese el nuevo nombre");
                            String name = br.readLine();
                            Principal.employeeData[i].setName(name);
                            break;
                        case "2":
                            System.out.println("Ingrese el nuevo ID");
                            String id = br.readLine();
                            Principal.employeeData[i].setID(id);
                            break;
                        case "3":
                            System.out.println("Ingrese la nueva dirección");
                            String dir = br.readLine();
                            Principal.employeeData[i].setAdress(dir);
                            break;
                        case "4":
                            System.out.println("Ingrese el nuevo # de telefono");
                            String phoneN = br.readLine();
                            Principal.employeeData[i].setPhoneNumber(phoneN);
                            break;
                        case "5":
                            System.out.println("Ingrese el nuevo e-Mail ");
                            String email = br.readLine();
                            Principal.employeeData[i].setEmail(email);
                            break;
                        case "6":
                            System.out.println("Ingrese la nueva contrasenia");
                            String pass = br.readLine();
                            Principal.employeeData[i].setPassword(pass);
                            break;
                        case "7":
                            Hiring();
                            break;
                        default:
                            System.out.println("Ingrese un valor adecuado");
                            modifyEmployee();
                    }
                } else {
                    System.out.println("El ID del empleado no existe");
                    modifyEmployee();
                }
            }
        } else {
            System.out.println("La lista de empleados esta vacia.");
            Hiring();
        }
    }


    public void printEmployeelist() throws IOException {
        if (Principal.employeeData[0] == (null)) {
            System.out.println("La lista esta vacía");
            Hiring();
        } else {
            for (int i = 0; i < data.getCounter(); i++) {
                System.out.println("Posición : " + Principal.employeeData[i].getClass().getSimpleName());
                System.out.println("Nombre: " + Principal.employeeData[i].getName());
                System.out.println("ID: " + Principal.employeeData[i].getID());
                System.out.println("Dirección: " + Principal.employeeData[i].getAdress());
                System.out.println("# de teléfono: " + Principal.employeeData[i].getPhoneNumber());
                System.out.println("***********************\n");
            }
        }
    }

}
