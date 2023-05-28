package ui;
import java.util.Scanner;
import model.Controller;

public class Executable {
    private Scanner reader;
    private Controller controller;
    
    public Executable(){
        reader=new Scanner(System.in);
        controller= new Controller();
    }
    public static void main(String[] args) {
        Executable ejecutable= new Executable();
        ejecutable.menu();
    }

    private void menu(){

        System.out.println("\nWelcome to READ-X");

        boolean flagMenu=false;

        while(flagMenu==false){
           
            System.out.println("\n-Enter a number-");
            System.out.println("\n1. Register Users");
            System.out.println("2. Manage products");
            System.out.println("3. Purchase product");
            System.out.println("4. Reading Simulation");
            System.out.println("5. My Product Library ");
            System.out.println("6. General reports");
            System.out.println("7. Exit");
            System.out.println("");
            int optionMenu=reader.nextInt();

            switch(optionMenu){
                case 1:
                    RegistrarUsuarios();
                    break;
                case 2:
                    System.out.println("\n-Enter a number-"); 
                    System.out.println("\n1. Create a bibliographic product");
                    System.out.println("2. Modify bibliographic product");
                    System.out.println("3. Delete bibliographic product");
                    System.out.println("4. Unsubscribe Magazine");
                    int optionProduct=reader.nextInt();
                    switch(optionProduct){
                        case 1:
                            CreateBibliographic();
                            break;
                        case 2:
                            modificarProducto();
                            break;
                        case 3:
                            borrarProducto();
                            break;
                        case 4:
                            cancelarSuscripcion();
                            break;
                    }
                    break;

                case 3:
                    ComprarLibro();
                break;
                case 4:
                    simulacionLectura();;
                    break;

                case 5:
                    bibliotecaProductos();
                    break;

                case 6:
                    System.out.println("\n\n   ----GENERAL REPORTS----");
                    System.out.println("\n1. Products and their pages Read");
                    System.out.println("2. Most Read Genre and Category");
                    System.out.println("3. Earnings by Gender");
                    System.out.println("4. Earnings by Category");
                    System.out.println("5. Top 5 Books");
                    System.out.println("6. Top 5 Magazines");
                    int opcion=reader.nextInt();
                    informesGenerales(opcion);
                    break;
                case 7:
                    System.out.println("\nGood bye :)");
                    flagMenu=true;
                    break;
            }
        }


    }

    private void RegistrarUsuarios(){
        System.out.println("\nWhat type of user do you want to register?");
        System.out.println("       -Enter a number-");
        System.out.println("\n1.Regular\n2.Premium");
        int optionUser=reader.nextInt();
        System.out.println("-Enter your name");
        reader.nextLine();
        String nameUser=reader.nextLine();
        System.out.println("-Enter your ID");
        String cedulaUser=reader.nextLine();
        
        if(controller.registrarUsuarios(optionUser, nameUser, cedulaUser)){
            if(optionUser==1){
                System.out.println("         -User successfully registered-");
                System.out.println("You can buy 5 books and subscribe to 2 magazines");
            }else if(optionUser==2){
                System.out.println("\n     -User successfully registered-");
                System.out.println("You have unlimited access to books and magazines");
            }
        }else{
            System.out.println("An unexpected error occurred");
        }
    }

    private void CreateBibliographic(){
        System.out.println("\nWhich bibliographic product would you like to register?");
        System.out.println("1.Book\n2.Magazines");
        int typeBibliographich=reader.nextInt();
        
        if(typeBibliographich==1){
            System.out.println("Enter the identifier");
            reader.nextLine();
            String identifier=reader.nextLine();
            System.out.println("Enter the name of the book");
            String name=reader.nextLine();
            System.out.println("Enter the number of pages of the book "+name);
            int cantidadPaginas=reader.nextInt();
            reader.nextLine();
            System.out.println("Enter a short review");
            String reseña=reader.nextLine();
            System.out.println("\n\nEnter the date of publication");
            System.out.println("Enter the day (In numbers)");
            int diaP=reader.nextInt();
            System.out.println("Enter the month (In numbers)");
            int mesP=reader.nextInt();
            System.out.println("Enter the year (In numbers)");
            int añoP=reader.nextInt();
            System.out.println("\nEnter the gender (With a number)");
            System.out.println("1.Science Fiction\n2.Fantasy\n3.Historical Novel");
            int typeGenre=reader.nextInt();
            System.out.println("Enter the URL");
            reader.nextLine();
            String URL=reader.nextLine();
            System.out.println("Enter the sale price");
            double precioVenta=reader.nextDouble();
            System.out.println("Number of copies sold");
            int ejemplaresVendidos=reader.nextInt();
            System.out.println("Enter the number of pages read");
            int paginasLeidas=reader.nextInt();
            if(controller.registarProductoBiblio(typeBibliographich, identifier, name, cantidadPaginas, reseña, diaP, mesP, añoP, typeGenre, añoP, typeGenre, URL, precioVenta, ejemplaresVendidos, ejemplaresVendidos, paginasLeidas)){
                System.out.println("\nBook successfully created");
                System.out.println("-This is how his book looked:-");
                System.out.println("\n"+controller.mostrarProductobiblio(true,-1));
            }else{
                System.out.println("A problem occurred");
            }
        }else if(typeBibliographich==2){
            System.out.println("Enter the identifier");
            reader.nextLine();
            String identifier=reader.nextLine();
            System.out.println("Enter the name of the magazine");
            String name=reader.nextLine();
            System.out.println("Enter the number of pages of the magazine "+"´"+name+"´");
            int cantidadPaginas=reader.nextInt();
            System.out.println("\n\nEnter the date of publication");
            System.out.println("Enter the day (In numbers)");
            int diaP=reader.nextInt();
            System.out.println("Enter the month (In numbers)");
            int mesP=reader.nextInt();
            System.out.println("Enter the year (In numbers)");
            int añoP=reader.nextInt();
            System.out.println("Enter the URL");
            reader.nextLine();
            String URL=reader.nextLine();
            System.out.println("Enter the subscription value");
            double valorSuscripcion=reader.nextDouble();
            System.out.println("Enter with a number the periodicity of the issuance.");
            int periocidad=reader.nextInt();
            System.out.println("\nEnter with a number the Category");
            System.out.println("1.Varieties\n2.Design\n3.Scientific");
            int categoria=reader.nextInt();
            System.out.println("Enter the number of pages read");
            int paginasLeidas=reader.nextInt();
            if(controller.registarProductoBiblio(typeBibliographich, identifier, name, cantidadPaginas, name, diaP, mesP, añoP, mesP, valorSuscripcion, periocidad, URL, valorSuscripcion, añoP, categoria, paginasLeidas)){
                System.out.println("-Magazine successfully created-");
                System.out.println("\nThis is how your magazine looked");
                System.out.println(controller.mostrarProductobiblio(true,-1));
            }else{
                System.out.println("\n-An error occurred-");
            }
        }
    }

    private void modificarProducto(){
        if(controller.mostrarProductobiblio(false,-1).equals("")){
            System.out.println("\n-No bibliographic products created-");
        }else{
            System.out.println(controller.mostrarProductobiblio(false,-1));    
            System.out.println("\nWhich product do you want to modify? - Enter a number");
            int typeProduct=reader.nextInt();
            int nuevoValor=-1;
            double nuevoValor1=-1;
            String nuevoValor2=null;
            if(controller.CalculateType(typeProduct-1)==1){
                System.out.println("\n-This bibliographic product is a Book-");
                System.out.println("\nDo you want to see its characteristics? \n1.YES\n2.NO");
                int decisionMostrar=reader.nextInt();
                if(decisionMostrar==1){
                    System.out.println(controller.mostrarProductobiblio(false,typeProduct-1));
                }
                System.out.println("\nWhat do you want to modify? - Check a number");
                System.out.println("\n1.Identifier\n2.Name\n3.Number of pages (Number)\n4.Review\n5.Genre\n6.URL");
                System.out.println("7.Sales price(Number)\n8.Copies sold(Number)");
                int opcionNuevoM=reader.nextInt();
                if(opcionNuevoM==1||opcionNuevoM==2||opcionNuevoM==4||opcionNuevoM==6){
                    System.out.println("\nEnter the new value");
                    reader.nextLine();
                    nuevoValor2=reader.nextLine();
                }else if(opcionNuevoM==3||opcionNuevoM==8){
                    System.out.println("\nEnter the new value");
                    nuevoValor=reader.nextInt();
                }else if(opcionNuevoM==5){
                    System.out.println("\nEnter with a number the new gender");
                    System.out.println("\n1.Sciencie Fiction\n2.Fantasy\n3.Historical Novel");
                    nuevoValor=reader.nextInt();
                }else{
                    System.out.println("\nEnter the new value");
                    nuevoValor1=reader.nextDouble();
                }
            
                if(controller.modificarProducto(typeProduct-1, opcionNuevoM, nuevoValor, nuevoValor2, nuevoValor1)){
                    System.out.println("\nCorrectly modified");
                    System.out.println("This is how the book looks like");
                    System.out.println("\n"+controller.mostrarProductobiblio(false, typeProduct-1));
                }else{
                    System.out.println("An unexpected error occurred :(");
                }
            }else if(controller.CalculateType(typeProduct-1)==2){
                System.out.println("\n-This bibliographic product is a Magazine-");
                System.out.println("\nDo you want to see its characteristics? \n1.YES\n2.NO");
                int decisionMostrar=reader.nextInt();
                if(decisionMostrar==1){
                    System.out.println(controller.mostrarProductobiblio(false,typeProduct-1));
                }
                System.out.println("\nWhat do you want to modify? - Check a number");
                System.out.println("\n1.Identifier\n2.Name\n3.Number of pages (Number)\n4.URL\n5.Subscription value\n6.Periocity");
                System.out.println("7.Category");
                int opcionNuevoM=reader.nextInt();
                System.out.println("\nEnter the new Value");
                if(opcionNuevoM==1||opcionNuevoM==2||opcionNuevoM==4){
                    reader.nextLine();
                    nuevoValor2=reader.nextLine(); 
                }else if(opcionNuevoM==3||opcionNuevoM==6){
                    nuevoValor=reader.nextInt();
                }else if(opcionNuevoM==5){
                    nuevoValor1=reader.nextDouble();
                }else{
                    System.out.println("\nEnter with a number the new Category");
                    System.out.println("\n1.Varieties\n2.Design\n3.Scientific");
                    nuevoValor=reader.nextInt();
                }
                if(controller.modificarProducto(typeProduct-1, opcionNuevoM, nuevoValor, nuevoValor2, nuevoValor1)){
                    System.out.println("\nCorrectly modified book");
                    System.out.println("  -This is how his book looked-");
                    System.out.println(controller.mostrarProductobiblio(false, typeProduct-1));
                }
            }

        }
    }

    private void borrarProducto(){
        int optionBorrar=-1;
        if(controller.mostrarProductobiblio(false, -1).equals("")){
            System.out.println("\n-No products created-");
        }else{
            boolean flag=false;
            while(flag==false){
                System.out.println(controller.mostrarProductobiblio(false, -1));
                System.out.println("Which product would you like to delete?");
                optionBorrar=reader.nextInt();
                System.out.println("\nThe following product will be deleted:");
                System.out.println("\n"+controller.mostrarProductobiblio(true, optionBorrar-1));
                System.out.println("\n¿Confirm?\n1.YES\n2.NO");
                int confirmar=reader.nextInt();
                if(confirmar==1){
                    flag=true;
                }
            }
            if(flag==true){
                if(controller.borrarProducto(optionBorrar-1)){
                    System.out.println("\n-The product was deleted correctly-");
                }else{
                    System.out.println("\nAn unexpected error occurred :(");
                }
            }
           
            
        }
    }

    private void ComprarLibro(){
        if(controller.mostrarUsuarios(false, -1).equals("")){
            System.out.println("No users created");
        }else{
            System.out.println(controller.mostrarUsuarios(false, -1));
            System.out.println("\nWhich user wants to buy a Product?");
            int optionUser=reader.nextInt();
            if(controller.mostrarProductobiblio(false, -1).equals("")){
                System.out.println("\nNo bibliographic products");
            }else{
                System.out.println(controller.mostrarProductobiblio(false, -1));
                System.out.println("\nWhich product would you like to purchase or subscribe to?");
                int optionProduc=reader.nextInt();
                int decisionConfirm=-1;
                if(controller.CalculateType(optionProduc-1)==1){
                    System.out.println("\nYou are going to buy a book");
                    System.out.println("-¿Confirm?\n1.YES\n2.NO");
                    decisionConfirm=reader.nextInt();
                }else if(controller.CalculateType(optionProduc-1)==2){
                    System.out.println("\nYou are subscribing to a Magazine");
                    System.out.println("-¿Confirm?\n1.YES\n2.NO");
                    decisionConfirm=reader.nextInt();
                }
                if(decisionConfirm==1){
                String query=controller.comprarProducto(optionUser-1, optionProduc-1);
               if(query.equals("")||query.equals("You have reached the limit of magazines")||query.equals("Alcanzaste el limite de Libros")){
                System.out.println("\n"+query);    
                System.out.println("An error occurred while generating the invoice");
               }else{
                        System.out.println(query);
                        if(controller.generarFactura(optionUser-1, optionProduc-1)){
                            System.out.println("    -Here is your bill-");
                            System.out.println(controller.ultimaFacturaCliente(optionUser-1));
                        }
                        
                    }
                }
            }
            }
        }

        private void simulacionLectura(){
            if(controller.mostrarUsuarios(false, -1).equals("")){
                System.out.println("No registered users");
                
            }else{
                System.out.println(controller.mostrarUsuarios(false, -1));
                System.out.println("\nWhich user would you like to read?");
                int optionUser=reader.nextInt();
                int contador=0;
                int decision=-1;
                System.out.println("\n         -THIS IS YOUR LIBRARY-");
                System.out.println(controller.printMatrixProductos(optionUser-1, contador));
                if(controller.CalculateTypeUsers(optionUser-1)==1){
                    mostrarLectura(optionUser-1, contador);
                    }
                
                    boolean flag=false;
                    if(controller.CalculateTypeUsers(optionUser-1)==2){
                    while(flag==false){
                        System.out.println("1. Show another Matrix");
                        System.out.println("2. Select product");
                        System.out.println("3. Exit");
                        decision=reader.nextInt();
                        switch(decision){
                            case 1: 
                                contador++;
                                System.out.println(controller.printMatrixProductos(optionUser-1, contador));
                                break;
                            case 2:
                            mostrarLectura(optionUser-1, contador);
                            flag=true;
                            break;
                            case 3:
                            flag=true;
                                break;
                        }
                    }
                    }   
                }
        }

        private void mostrarLectura(int optionUser, int contador){
            System.out.println("\n-Make sure to mark the correct position     ");
            System.out.println("\nWhich product would you like to read? -Mark the position");
            System.out.println("\n-Enter the row number - [HORIZONTAL].");
            int fila=reader.nextInt();
            System.out.println("\n-Enter column- [VERTICALS].");
            int columna=reader.nextInt();
            String identificadorProducto=controller.extraerIdentificadorProducto((optionUser), fila, columna, contador);
                if(identificadorProducto.equals("")){
                     System.out.println("\n-This position is null-");
                }else{
                    String nombreProducto=controller.extraerNombreProductoUsuario(identificadorProducto);
                    int cantidadPaginas=controller.extraerCantidadPaginasProductoUsuario(identificadorProducto);
                    int contadorPaginasRegular=0;
                    int paginaActual=1;
                    String omitir=null;
                    String cambioPagina=null;
                        while(cambioPagina!="c"||cambioPagina!="C"){
                            if(controller.CalculateTypeUsers(optionUser)==1){
                                if(controller.typeProductoMatriz(identificadorProducto)==1){
                                    if(contadorPaginasRegular==0||contadorPaginasRegular==20){
                                        System.out.println(controller.creadorAnucnio(contadorPaginasRegular));
                                          System.out.println("\nEnter any letter to omit");
                                            if(contadorPaginasRegular==0){
                                                reader.nextLine();
                                            }
                                            omitir=reader.nextLine();
                                            if(contadorPaginasRegular!=0){
                                                if(omitir.equals("X")||omitir.equals("x")){
                                                    System.out.println("\n-Sorry, no one was able to handle this integrator :( -");
                                                }
                                            }
                                            
                                        }
                                    
                                
                                    }else if(controller.typeProductoMatriz(identificadorProducto)==2){
                                        if(contadorPaginasRegular==0||contadorPaginasRegular==5){
                                            System.out.println(controller.creadorAnucnio(contadorPaginasRegular));
                                            System.out.println("\n   -Enter any letter to omit-");
                                            if(contadorPaginasRegular==0){
                                                reader.nextLine();
                                            }
                                            omitir=reader.nextLine();
                                            if(contadorPaginasRegular!=0){
                                                if(omitir.equals("X")||omitir.equals("x")){
                                                    System.out.println("\n-Lo siento, nadie pudo con esta integradora :( -");
                                                }
                                            }
                                        }
                                    }
                                }
                                
                                System.out.println("\n\n--------------------------------");
                                System.out.println("-Reading Simulation in Progress-");
            
                                System.out.println("\n\n\n\n           "+nombreProducto);
                                System.out.println("            Id: "+identificadorProducto);
                                System.out.println("\n\n       -Page "+paginaActual+" de "+ cantidadPaginas+"-");
                                if(controller.typeProductoMatriz(identificadorProducto)==1){
                                System.out.println("             Book");
                                }else{
                                    System.out.println("            Magazine");
                                }
                                System.out.println("--------------------------------");
                                System.out.println("\nEnter (A) to advance");
                                if(paginaActual>1){
                                    System.out.println("Enter (B) to go back");
                                }
                                System.out.println("Enter (C) to exit");
                                if(paginaActual==1&&controller.CalculateTypeUsers(optionUser)==2){
                                    reader.nextLine();
                                }
                                cambioPagina=reader.nextLine();
            
                                if(cambioPagina.equals("A")||cambioPagina.equals("a")){
                                    paginaActual++;
                                    contadorPaginasRegular++;
                                }else if(cambioPagina.equals("B")||cambioPagina.equals("b")){
                                    paginaActual--;
                                    contadorPaginasRegular++;
                                }else if(cambioPagina.equals("C")||cambioPagina.equals("c")){
                                    if(controller.cambiarPaginasLeidadProducto(identificadorProducto,(contadorPaginasRegular+1))){
                                        System.out.println("\nThe number of pages read in this session was: "+(contadorPaginasRegular+1)+" paginas");
                                        System.out.println("\n-The pages read in the global product have been updated.-");
                                    }else{
                                        System.out.println("Did not update the pages read in the global product.");
                                    }
                                    return;
                                }
                                    
                                
                                } 
                            
                                }
                            
        }

        private void cancelarSuscripcion(){
            if(controller.mostrarUsuarios(false, -1).equals("")){
                System.out.println("No registered users");
                
            }else{
                System.out.println(controller.mostrarUsuarios(false, -1));
                System.out.println("\nWhich user wants to unsubscribe?");
                int optionUser=reader.nextInt();
                if(controller.mostrarRevistaUsuario(optionUser-1).equals("")){
                    System.out.println("\n-This user has no subscribed magazines-");
                }
                System.out.println(controller.mostrarRevistaUsuario(optionUser-1));
                System.out.println("Which product would you like to unsubscribe?");
                int revistaDes=reader.nextInt();

                if(controller.borrarSuscripcion(optionUser-1, revistaDes-1)){
                    System.out.println("\n-Subscription successfully cancelled-");
                }else{
                    System.out.println("\n-A problem occurred-");
                }
            }

        }

        private void bibliotecaProductos(){
            if(controller.mostrarUsuarios(false, -1).equals("")){
                System.out.println("No registered users");
                
            }else{
                System.out.println(controller.mostrarUsuarios(false, -1));
                System.out.println("\nWhich user would you like to display your library?");
                int optionUser=reader.nextInt();
                int contador=0;
                String decisionMatriz=null;
                boolean flag=false;
                if(controller.CalculateTypeUsers(optionUser-1)==2){
                    while(flag==false){
                    System.out.println(controller.printMatrixProductos(optionUser-1,contador));
                        System.out.println("             Matrix number: "+"("+(contador)+")");
                        System.out.println("\n(A) Display the following matrix");
                        if(contador!=0){
                         System.out.println("(B) Previous matrix");
                         }
                        System.out.println("(C) Exit");
                        if(contador==0){
                            reader.nextLine();
                        }
                        decisionMatriz=reader.nextLine();
                        if(decisionMatriz.equals("A")||decisionMatriz.equals("a")){
                            contador++;
                        }else if(decisionMatriz.equals("B")||decisionMatriz.equals("b")){
                            contador--;
                        }else if(decisionMatriz.equals("C")||decisionMatriz.equals("c")){
                            flag=true;
                        }
                    }
                }else{
                    System.out.println(controller.printMatrixProductos(optionUser-1, contador));
                }
               
        
    }
}

    private void informesGenerales(int opcion){
        if(opcion==1){
            System.out.println("\n-Products and their pages read:");
            System.out.println(controller.mostrarAcumPaginasLeidas());
        }else if(opcion==2){
            System.out.println(controller.generoMasLeidoYCategoria());
        }else if(opcion==3){
            System.out.println(controller.gananciasGenero());
        }else if(opcion==4){
            System.out.println(controller.gananciaCategoria());
        }else if(opcion==5){
            System.out.println(controller.topLibros());
        }else if(opcion==6){
            System.out.println(controller.topRevistas());
        }
        
    }


    }



