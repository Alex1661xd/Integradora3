package model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;

public class Controller {
    private ArrayList<User> users;
    private ArrayList<BibliographicP>productosBiblio;
    private ArrayList<Factura>facturas;

    public Controller(){
        this.users=new ArrayList<User>();
        this.productosBiblio=new ArrayList<BibliographicP>();
        productosBiblio.add(new Magazine("4AX", "Spider-Man", 100, new GregorianCalendar(2020, 0, 12), "JHCDUUHUC", CategoryMagazine.CIENTIFICA, 20, 10, 10));
        productosBiblio.add(new Book("9ZU", "Lechuza", 100, new GregorianCalendar(2025, 12, 4), "htpp:/jcjcdnjd", GenreBook.FANTASIA, 100, 20, "Lindo",22));
        productosBiblio.add(new Book("9RY", "Caperucita", 100,new GregorianCalendar(1900, 3, 16), "htpp:/jcjcdnjd", GenreBook.CIENCIA_FICCION, 200, 20, "Lindo",10));
        productosBiblio.add(new Magazine("4ZU", "Mario-Bros", 100, new GregorianCalendar(1990, 2, 12), "JHCDUUHUC", CategoryMagazine.VARIEDADES, 20, 10, 30));
        users.add(new RegularUser("Luis", "89489380", Calendar.getInstance()));
        users.add(new PremiumUser("Carlos", "00905904", Calendar.getInstance()));
        this.facturas=new ArrayList<Factura>();
    }
    
     /**
	 * Description: This method is responsible for registering users in the system.
	 * pre:
	 * pos:
	 * @param opcionUser num of selected User
     * @param nameUser the name of user
     * @param idUser the id of User
	 * @return boolean
	 */
    public boolean registrarUsuarios(int optionUser, String nameUser, String idUser ){
        boolean indicador=false;
        Calendar fechaVinculacion=Calendar.getInstance();
        if(indicador==false){
                 
            if(optionUser==1){
                users.add(new RegularUser(nameUser, idUser, fechaVinculacion)); 
                indicador=true;
                return indicador;
                
            }else if(optionUser==2){
                users.add(new PremiumUser(nameUser, idUser, fechaVinculacion));
                indicador=true;
                return indicador;
                    }
                    
                }
            return indicador;
        }
    
    /**
	 * Description: This method is responsible for registering products
	 * pre:
	 * pos:
	 * @param TypeBiblio the type of product
     * @param identifier the product identifier
     * @param name the name of product
     * @param cantidadPaginas
     * @param reseña the review of product
     * @param diaP day of publication
     * @param mesP month of publication
     * @param añoP year of publication
     * @param typeGenre the genre of product (Book)
     * @param valorSuscripcion subscription value of the product
     * @param periocidad periocity of product
     * @param URL URL of product
     * @param precioVenta selling price of the product
     * @param ejemplaresVendidos copies of the product sold
     * @param categoria product category
     * @param paginasLeidas product pages read
     *  @return boolean
	 */
        
    

    public boolean registarProductoBiblio(int TypeBiblio,String identifier,String name,int cantidadPaginas,String reseña,int diaP,int mesP,int añoP,int typeGenre, double valorsuscripcion,int periocidad, String URL, double precioventa, int ejemplaresVendidos, int categoria, int paginasLeidas){
        boolean indicador=false;
        Calendar fechaPublicacion=new GregorianCalendar(diaP, mesP-1, añoP);
        GenreBook genero=null;
        CategoryMagazine category=null;
        if(indicador==false){
            if(TypeBiblio==1){
                if(typeGenre==1){
                    genero=GenreBook.CIENCIA_FICCION;
                }else if(typeGenre==2){
                    genero=GenreBook.FANTASIA;
                }else if(typeGenre==3){
                    genero=GenreBook.NOVELA_HISTORICA;
                }
                productosBiblio.add(new Book(identifier, name, cantidadPaginas, fechaPublicacion, URL, genero, precioventa, ejemplaresVendidos, reseña, paginasLeidas));
                indicador=true;
                    
            }else if(TypeBiblio==2){
                if(categoria==1){
                        category=CategoryMagazine.VARIEDADES;
                    }else if(categoria==2){
                        category=CategoryMagazine.DISEÑO;
                    }else if(categoria==3){
                        category=CategoryMagazine.CIENTIFICA;
                    }
                    productosBiblio.add(new Magazine(identifier, name, cantidadPaginas, fechaPublicacion, URL, category, valorsuscripcion, periocidad, paginasLeidas));
                    indicador=true;
                    }
                }
                return indicador;
            }
        
     /**
	 * Description: this method shows one or many bibliographic products
	 * pre:
	 * pos:
	 * @param indicador indicator to know which option to execute
     * @param numero number to know which option to run
	 * @return String
	 */
        
    

    public String mostrarProductobiblio(boolean indicador, int numero){
        String msg="";
            //*Ultimo producto bibliografico creado */
        if(indicador==true&&numero==-1){
                    if(productosBiblio.get(productosBiblio.size()-1) instanceof Book){
                        msg+=((Book)productosBiblio.get(productosBiblio.size()-1)).toString();
                        return msg;
                    }else if(productosBiblio.get(productosBiblio.size()-1) instanceof Magazine){
                        msg+=((Magazine)productosBiblio.get(productosBiblio.size()-1)).toString();
                        return msg;
                    }
                }
            
            //*Todos los productos bibliograficos */
        else if(indicador==false&&numero==-1){
            for(int i=0;i<productosBiblio.size();i++){
                    if(productosBiblio.get(i) instanceof Book){
                        msg+="\n"+(i+1)+". "+((Book)productosBiblio.get(i)).toStringMin();
                    }else if(productosBiblio.get(i) instanceof Magazine){
                        msg+="\n"+(i+1)+". "+((Magazine)productosBiblio.get(i)).toStringMin();
                    }
                }
            }
        
            //*Producto en posicion exacta */
        if(numero!=-1){
                if(productosBiblio.get(numero) instanceof Book){
                    msg=((Book)productosBiblio.get(numero)).toString();
                }else if(productosBiblio.get(numero) instanceof Magazine){
                    msg=((Magazine)productosBiblio.get(numero)).toString();
                }
            }
            return msg;
        }
        
       /**
	 * Description: this method is in charge of modifying a product
	 * pre:
	 * pos:
	 * @param posicionProducto number of positions and their producti
     * @param opcionNuevoM option to change
     * @param nuevoValor the new letter value
     * @param nuevoValor1 the new int value
     * @param nuevoValor2 the new position value
	 * @return boolean
	 */ 
    

    public boolean modificarProducto(int posicionProducto,int opcionNuevoM,int nuevoValor,String nuevoValor1,double nuevoValor2){
        boolean indicador=false;
        GenreBook nuevoGenero=null;
        if(indicador==false){
        if(productosBiblio.get(posicionProducto) instanceof Book){
            if(opcionNuevoM==1){
                ((Book)productosBiblio.get(posicionProducto)).setIdentifier(nuevoValor1);
                indicador=true;
            }else if(opcionNuevoM==2){
                ((Book)productosBiblio.get(posicionProducto)).setName(nuevoValor1);
                indicador=true;
            }else if(opcionNuevoM==4){
                ((Book)productosBiblio.get(posicionProducto)).setReview(nuevoValor1);
                indicador=true;
            }else if(opcionNuevoM==6){
                ((Book)productosBiblio.get(posicionProducto)).setURL(nuevoValor1);
                indicador=true;
            }else if(opcionNuevoM==3){
                ((Book)productosBiblio.get(posicionProducto)).setNumberPages(nuevoValor);
                indicador=true;
            }else if(opcionNuevoM==5){
                if(nuevoValor==1){
                    nuevoGenero=GenreBook.CIENCIA_FICCION;
                }else if(nuevoValor==2){
                    nuevoGenero=GenreBook.FANTASIA;
                }else{
                    nuevoGenero=GenreBook.NOVELA_HISTORICA;
                }
                ((Book)productosBiblio.get(posicionProducto)).setGenre(nuevoGenero);
                indicador=true;
            }else if(opcionNuevoM==7){
                ((Book)productosBiblio.get(posicionProducto)).setPrice(nuevoValor2);
                indicador=true;
            }else if(opcionNuevoM==8){
                ((Book)productosBiblio.get(posicionProducto)).setSoldCopies(nuevoValor);
                indicador=true;
            }
            indicador=true;
        }else if(productosBiblio.get(posicionProducto) instanceof Magazine){
            if(opcionNuevoM==1){
                ((Magazine)productosBiblio.get(posicionProducto)).setIdentifier(nuevoValor1);
                indicador=true;
            }else if(opcionNuevoM==2){
                ((Magazine)productosBiblio.get(posicionProducto)).setName(nuevoValor1);
                indicador=true;
            }else if(opcionNuevoM==3){
                ((Magazine)productosBiblio.get(posicionProducto)).setNumberPages(nuevoValor);
                indicador=true;
            }else if(opcionNuevoM==4){
                ((Magazine)productosBiblio.get(posicionProducto)).setURL(nuevoValor1);
                indicador=true;
            }else if(opcionNuevoM==5){
                ((Magazine)productosBiblio.get(posicionProducto)).setSubscriptionValue(nuevoValor2);
                indicador=true;
            }else if(opcionNuevoM==6){
                ((Magazine)productosBiblio.get(posicionProducto)).setPeriocity(nuevoValor2);
                indicador=true;
            }else if(opcionNuevoM==7){
                CategoryMagazine categoria=null;
                if(nuevoValor==1){
                    categoria=CategoryMagazine.VARIEDADES;
                }else if(nuevoValor==2){
                    categoria=CategoryMagazine.DISEÑO;
                }else if(nuevoValor==3){
                    categoria=CategoryMagazine.CIENTIFICA;
                }
                ((Magazine)productosBiblio.get(posicionProducto)).setCategory(categoria);
                indicador=true;
            }
        }
    }
        return indicador;
    }
           /**
	 * Description:this method is in charge of deleting a product
	 * pre:
	 * pos:
	 * @param posicionProducto number of positions and their product
	 * @return boolean
	 */ 
    public boolean borrarProducto(int posicionProducto){
        boolean indicador=false;
        if(indicador==false){
            productosBiblio.remove(posicionProducto);
            indicador=true;
        }

        return indicador;
    }
           /**
	 * Description:this method is responsible for calculating the type of product
	 * pre:
	 * pos:
	 * @param posicionProducto number of positions and their product
	 * @return int
	 */ 

    public int CalculateType(int posicionProducto){
        
        if(productosBiblio.get(posicionProducto) instanceof Book){
            return 1;
        }else if(productosBiblio.get(posicionProducto)instanceof Magazine){
            return 2;
        }

        return -1;
    }
         /**
	 * Description:this method is responsible for calculating the type of User
	 * pre:
	 * pos:
	 * @param posicionProducto number of positions and their user
	 * @return int
	 */ 

    public int CalculateTypeUsers(int posicionUsuario){
        
        if(users.get(posicionUsuario) instanceof RegularUser){
            return 1;
        }else if(users.get(posicionUsuario)instanceof PremiumUser){
            return 2;
        }

        return -1;
    }

    /**
	 * Description: this method shows one or many user
	 * pre:
	 * pos:
	 * @param indicador indicator to know which option to execute
     * @param numero number to know which option to run
	 * @return String
	 */
        

    public String mostrarUsuarios(boolean indicador, int numero){
        String msg="";
            //*Ultimo usuario creado */
        if(indicador==true&&numero==-1){
                    if(users.get(users.size()-1) instanceof RegularUser){
                        msg+=((RegularUser)users.get(users.size()-1)).toString();
                        return msg;
                    }else if(users.get(users.size()-1) instanceof PremiumUser){
                        msg+=((PremiumUser)users.get(users.size()-1)).toString();
                        return msg;
                    }
                }
            
            //*Todos los usuarios creados */
        else if(indicador==false&&numero==-1){
            for(int i=0;i<users.size();i++){
                    if(users.get(i) instanceof RegularUser){
                        msg+="\n"+(i+1)+". "+((RegularUser)users.get(i)).toStringMin()+" (Regular)";
                    }else if(users.get(i) instanceof PremiumUser){
                        msg+="\n"+(i+1)+". "+((PremiumUser)users.get(i)).toStringMin()+" (Premium)";
                    }
                }
            }
        
            //*Usuario en posicion exacta */
        if(numero!=-1){
                if(users.get(numero) instanceof RegularUser){
                    msg=((RegularUser)users.get(numero)).toString();
                }else if(users.get(numero) instanceof PremiumUser){
                    msg=((PremiumUser)users.get(numero)).toString();
                }
            }
            return msg;
    }
         /**
	 * Description: this method is in charge of purchasing a product
	 * pre:
	 * pos:
	 * @param optionUser position of the user to buy
     * @param optionLibro position of the book to buy
	 * @return String
	 */
        

    public String comprarProducto(int optionUser, int optionLibro){
       
        String msg="";
        if(users.get(optionUser) instanceof RegularUser){
            if(productosBiblio.get(optionLibro)instanceof Book){
                        Book libroComprado=((Book)productosBiblio.get(optionLibro));
                        int ejemplaresVendidos= ((Book)productosBiblio.get(optionLibro)).getSoldCopies();
                        for(int i=0;i<((RegularUser)(users.get(optionUser))).getBooks().length;i++){
                            if(((RegularUser)users.get(optionUser)).getBooks()[i]==null){
                                ((RegularUser)users.get(optionUser)).getBooks()[i]=libroComprado;
                                boolean flag=false;
                                for(int z=0;z<((RegularUser)users.get(optionUser)).getOrganizados().length;z++){ 
                                    if(flag==false){
                                        if(((RegularUser)users.get(optionUser)).getOrganizados()[z]==null){
                                            ((RegularUser)users.get(optionUser)).getOrganizados()[z]=libroComprado;
                                            flag=true;
                                        }
                                    }
                                   
                                }
                              
                                ((Book)productosBiblio.get(optionLibro)).setSoldCopies(ejemplaresVendidos+1);
                                msg="\n-Book successfully purchased-";
                                return msg;
                            }else{
                                msg="You reached the limit of books";
                            }

                        }
            }else if(productosBiblio.get(optionLibro)instanceof Magazine){
                            Magazine revistaComprada=((Magazine)productosBiblio.get(optionLibro));
                            for(int j=0;j<((RegularUser)(users.get(optionUser))).getMagazines().length;j++){
                                if(((RegularUser)users.get(optionUser)).getMagazines()[j]==null){
                                    ((RegularUser)users.get(optionUser)).getMagazines()[j]=revistaComprada; 
                                    boolean flag=false;
                                    for(int z=0;z<((RegularUser)users.get(optionUser)).getOrganizados().length;z++){
                                        if(flag==false){
                                            if(((RegularUser)users.get(optionUser)).getOrganizados()[z]==null){
                                                ((RegularUser)users.get(optionUser)).getOrganizados()[z]=revistaComprada;
                                                flag=true;
                                            }
                                        }
                                       
                                    }
                                    int cantidadActivas=((Magazine)productosBiblio.get(optionLibro)).getNumberActives();
                                    ((Magazine)productosBiblio.get(optionLibro)).setNumberActives(cantidadActivas+1);
                                    msg="\nCorrectly subscribed magazine";
                                    return msg;
                                }else{
                                    msg="You reached the limit of magazines";
                                }
                                
                            }
            }
        }else if(users.get(optionUser) instanceof PremiumUser){
            if(productosBiblio.get(optionLibro)instanceof Book){
                Book libroComprado=((Book)productosBiblio.get(optionLibro));
                ((PremiumUser)users.get(optionUser)).getBooks().add(libroComprado);
                ((PremiumUser)users.get(optionUser)).getProductosOrganizadosP().add(libroComprado);
                int ejemplaresVendidos= ((Book)productosBiblio.get(optionLibro)).getSoldCopies();
                ((Book)productosBiblio.get(optionLibro)).setSoldCopies(ejemplaresVendidos+1);

                msg="\n-Book successfully purchased-";
                return msg;
                    
            }else if(productosBiblio.get(optionLibro)instanceof Magazine){
                    Magazine revistaComprada=((Magazine)productosBiblio.get(optionLibro));
                    ((PremiumUser)users.get(optionUser)).getMagazines().add(revistaComprada);    
                    ((PremiumUser)users.get(optionUser)).getProductosOrganizadosP().add(revistaComprada);
                    int cantidadActivas=((Magazine)productosBiblio.get(optionLibro)).getNumberActives();
                    ((Magazine)productosBiblio.get(optionLibro)).setNumberActives(cantidadActivas+1);      
                    msg="\n-Correctly subscribed magazine-";
                    return msg; 
                    
                }
        }

        return msg;
    }
            /**
	 * Description: This method generates the invoice for the purchased product.
	 * pre:
	 * pos:
	 * @param optionUser position of the user to buy
     * @param optionLibro position of the product to buy
	 * @return boolean
	 */

    public boolean generarFactura(int opcionUser, int opcionProducto){
        boolean indicador=false;
        String nameP=null;
        Calendar fechatransaccion=Calendar.getInstance();
        Double montoPagado=null;
        String identificador=null;
        String nameClient=null;
        if(indicador==false){
            if(productosBiblio.get(opcionProducto) instanceof Book){
                nameP=((Book)productosBiblio.get(opcionProducto)).getName();
                montoPagado=((Book)productosBiblio.get(opcionProducto)).getPrice();
                identificador=((Book)productosBiblio.get(opcionProducto)).getIdentifier();
            }else if(productosBiblio.get(opcionProducto) instanceof Magazine){
                nameP=((Magazine)productosBiblio.get(opcionProducto)).getName();
                montoPagado=((Magazine)productosBiblio.get(opcionProducto)).getSubscriptionValue();
                identificador=((Magazine)productosBiblio.get(opcionProducto)).getIdentifier();
            }
            
            if(users.get(opcionUser)instanceof PremiumUser){
                nameClient=((PremiumUser)users.get(opcionUser)).getNameUser();
                ((PremiumUser)users.get(opcionUser)).getFacturas().add(new Factura(nameClient,montoPagado, fechatransaccion, identificador, nameP));
                    indicador=true;
           }else if(users.get(opcionUser)instanceof RegularUser){
                nameClient=((RegularUser)users.get(opcionUser)).getNameUser();
                for(int i=0;i<6;i++){
                    if(((RegularUser)users.get(opcionUser)).getFacturas()[i]==null){
                        ((RegularUser)users.get(opcionUser)).getFacturas()[i]=new Factura(nameClient,montoPagado, fechatransaccion, identificador, nameP);
                        indicador=true;
                        return indicador;
                    }
                    
                }
           }
           facturas.add(new Factura(nameClient,montoPagado, fechatransaccion, identificador, nameP));
        }
        return indicador;
        
    }
         /**
	 * Description: This method displays the last invoice created.
	 * pre:
	 * pos:
	 * @param optionUser position of the user to show the invoice
	 * @return String
	 */

    public String ultimaFacturaCliente(int opcionUser){
        String msg="";

        if(users.get(opcionUser) instanceof RegularUser){
            for(int i=0;i<7;i++){
                if(((RegularUser)users.get(opcionUser)).getFacturas()[i]==null){
                    msg=((RegularUser)users.get(opcionUser)).getFacturas()[i-1].toString();
                    return msg;
                }
            }
        }else if(users.get(opcionUser) instanceof PremiumUser){
            msg=((PremiumUser)users.get(opcionUser)).getFacturas().get(facturas.size()-1).toString();
        }
        return msg;
    }

       /**
	 * Description: This method is in charge of displaying the user's last book.
	 * pre:
	 * pos:
	 * @param optionUser position of the user to show the Book
	 * @return String
	 */

    public String mostrarLibroUsuario(int opcionUser){
        String msg="";

        if(users.get(opcionUser)instanceof RegularUser){
            for(int i=0;i<((RegularUser)users.get(opcionUser)).getBooks().length;i++){
                if(((RegularUser)users.get(opcionUser)).getBooks()[i]!=null){
                    msg+="\n"+(i+1)+". "+((RegularUser)users.get(opcionUser)).getBooks()[i].toStringMin();
                }  
            }
        }else if(users.get(opcionUser)instanceof PremiumUser){
            for(int i=0;i<((PremiumUser)users.get(opcionUser)).getBooks().size();i++){
                msg+="\n"+(i+1)+". "+((PremiumUser)users.get(opcionUser)).getBooks().get(i).toStringMin();
            }            
        }
        return msg;
    }
           /**
	 * Description: This method is in charge of displaying the user's last Magazine.
	 * pre:
	 * pos:
	 * @param optionUser position of the user to show the Magazine
	 * @return String
	 */

    public String mostrarRevistaUsuario(int opcionUser){
        String msg="";

        if(users.get(opcionUser)instanceof RegularUser){
            for(int i=0;i<((RegularUser)users.get(opcionUser)).getMagazines().length;i++){
                if(((RegularUser)users.get(opcionUser)).getMagazines()[i]!=null){
                    msg+="\n"+(i+1)+". "+((RegularUser)users.get(opcionUser)).getMagazines()[i].toStringMin();
                }  
            }
        }else if(users.get(opcionUser)instanceof PremiumUser){
            for(int i=0;i<((PremiumUser)users.get(opcionUser)).getMagazines().size();i++){
                msg+="\n"+(i+1)+". "+((PremiumUser)users.get(opcionUser)).getMagazines().get(i).toStringMin();
            }            
        }
        return msg;
    }

      /**
	 * Description: This method is in charge of extracting the name of a product
	 * pre:
	 * pos:
	 * @param identificador identifier of product
	 * @return String
	 */

    public String extraerNombreProductoUsuario(String identificador){
        String name="";
        
        for(int i=0;i<productosBiblio.size();i++){
            if(productosBiblio.get(i).getIdentifier().equals(identificador)){
                name=productosBiblio.get(i).getName();
                return name;
            }
        }
        
        return name;
    }

          /**
	 * Description: This method is in charge of extracting the pages of product
	 * pre:
	 * pos:
	 * @param identificador identifier of product
	 * @return int
	 */

    public int extraerCantidadPaginasProductoUsuario(String identificador){
        int cantidadPaginas=-1;

        for(int i=0;i<productosBiblio.size();i++){
            if(productosBiblio.get(i).getIdentifier().equals(identificador)){
                cantidadPaginas=productosBiblio.get(i).getNumberPages();
                return cantidadPaginas;
            }
        }
        
        return cantidadPaginas;
    }

          /**
	 * Description: This method is in charge of extracting the identifier of product
	 * pre:
	 * pos:
	 * @param opcionUusuario the user's choice 
     * @param filas the row of the matrix
     * @param columnas the column of the matrix
     * @param contador the counter for the matrix
	 * @return String
	 */

    public String extraerIdentificadorProducto(int opcionUusario, int filas, int columnas, int contador){
        String identificador="";
        if(users.get(opcionUusario)instanceof RegularUser){
            if(((RegularUser)users.get(opcionUusario)).getMisProductos()[filas][columnas]!=null){
                identificador=((RegularUser)users.get(opcionUusario)).getMisProductos()[filas][columnas];
            }
        }else if(users.get(opcionUusario)instanceof PremiumUser){
            if(((PremiumUser)users.get(opcionUusario)).getArrayListMatriz().get(contador)[filas][columnas]!=null){
                identificador=((PremiumUser)users.get(opcionUusario)).getArrayListMatriz().get(contador)[filas][columnas];
            }
        }
        return identificador;
    }
   /**
	 * Description: this method is in charge of creating advertisement
	 * pre:
	 * pos:
	 * @param numeroAnuncio to know which ad to display 
	 * @return String
	 */

    public String creadorAnucnio(int numeroAnuncio){
        String msg="";


        if(numeroAnuncio==0){
            msg="..............................................";
            msg+="\n               -ADVERTISEMENT-";
            msg+="            (Traducido al español)";
            msg+="\n Pañales pequeñin con descuento del 10%";
            msg+="\n             ¡Adquierelos ya!";
            msg+="\n..............................................";
        }else if(numeroAnuncio==2||numeroAnuncio==20||numeroAnuncio==5){
            msg="..............................................";
            msg+="\n               -ADVERTISEMENT-";
            msg+="            (Traducido al español)";
            msg+="\n     ¿No sabes hacer la Integradora III?";
            msg+="\n\n-No te preocupes -Presiona (x) para mas info.";
            msg+="\n            Por tan solo 9.99";
            msg+="\n..............................................";
        }

        return msg;
    }
       /**
	 * Description: this method is in charge of increasing the number of pages of a product
	 * pre:
	 * pos:
	 * @param identificadorProducto the identifier of product
     * @param nuevaCantidadLeidas new number of pages read
	 * @return boolean
	 */

    public boolean cambiarPaginasLeidadProducto(String identificadorProducto, int nuevaCantidadLeidas){
        boolean indicador=false;

        if(indicador==false){
            for(int i=0;i<productosBiblio.size();i++){
                if(productosBiblio.get(i).getIdentifier().equals(identificadorProducto)){
                    int nuevoAcumulado=productosBiblio.get(i).getNumberPagesRead();
                    nuevoAcumulado=nuevoAcumulado+nuevaCantidadLeidas;
                    productosBiblio.get(i).setNumberPagesRead(nuevoAcumulado);
                    indicador=true;
                }
            }
        }
        return indicador;
    }

    /**
	 * Description this method is responsible for filling the matrix of a user
	 * pre:
	 * pos:
	 * @param User the position of user to select
	 * @return boolean
	 */

    public boolean llenarBibliotecaMatriz(int User, int contador){
        acomodarProductos(User);
        String identificador=null;
        boolean flag=false;

        if(users.get(User)instanceof RegularUser){
            for(int z=0;z<((RegularUser)users.get(User)).getOrganizados().length;z++){
                if(((RegularUser)users.get(User)).getOrganizados()[z]!=null){
                    flag=false;   
                    identificador=((RegularUser)users.get(User)).getOrganizados()[z].getIdentifier(); 
                        for(int i=0;i<5;i++){
                            for(int j=0;j<5;j++){
                                if(((RegularUser)users.get(User)).getMisProductos()[i][j]==null){
                                    if(flag==false){
                                        ((RegularUser)users.get(User)).getMisProductos()[i][j]=identificador;
                                        flag=true;
                                    }   
                                } 
                            }
                        }
                    }
                }
        }else if(users.get(User)instanceof PremiumUser){
            
            String[][] matrizNueva = crearMatriz();
            ((PremiumUser)users.get(User)).getArrayListMatriz().add(contador, matrizNueva);
            boolean flag1=false;

            for(int i=0;i<((PremiumUser)users.get(User)).getProductosOrganizadosP().size();i++){
                String identificador1=((PremiumUser)users.get(User)).getProductosOrganizadosP().get(i).getIdentifier();
                flag1=false;
                for(int j=0;j<5;j++){
                    for(int z=0;z<5;z++){
                        if(flag1==false){
                            if(((PremiumUser)users.get(User)).getArrayListMatriz().get(contador)[j][z]==null){
                                ((PremiumUser)users.get(User)).getArrayListMatriz().get(contador)[j][z]=identificador1;
                                flag1=true;
                            }
                        }
                        
                    }
                }
            }
        }
        return false;
    }
    /**
	 * Description this method is responsible for calculating the type of product
	 * pre:
	 * pos:
	 * @param identifier the identifier of product
	 * @return int
	 */

    public int typeProductoMatriz(String identifier){
        for(int i=0;i<productosBiblio.size();i++){
            if(productosBiblio.get(i).getIdentifier().equals(identifier)){
                if(productosBiblio.get(i)instanceof Book){
                    return 1;
                }else if(productosBiblio.get(i)instanceof Magazine){
                    return 2;
                }
            }
        }
        return -1;
    }
       /**
	 * Description this method is responsible for displaying a user's product matrix.
	 * pre:
	 * pos:
	 * @param User the identifier of product
	 * @return String
	 */

    public String printMatrixProductos(int User, int contador) {
        llenarBibliotecaMatriz(User,contador);
		String print = "\n       (0)    (1)    (2)    (3)    (4)\n";
        print+="       ---    ---    ---    ---    ---\n";
        if(users.get(User)instanceof RegularUser){
            for (int i = 0; i < ((RegularUser)users.get(User)).getMisProductos().length ; i++) { // filas numbers.length
            
                print+="("+i+")  ";
                
                for (int j = 0; j < ((RegularUser)users.get(User)).getMisProductos()[0].length; j++) { // columnas numbers[0].length
                    if(((RegularUser)users.get(User)).getMisProductos()[i][j]==null){
                        print+="| ___ |";
                    }else{
                        print +="| "+((RegularUser)users.get(User)).getMisProductos()[i][j] + " |";
                    }
                }
                print += "\n";
            }
        
        }else if(users.get(User)instanceof PremiumUser){
            for(int i=0;i<((PremiumUser)users.get(User)).getArrayListMatriz().get(contador).length;i++){
                print+="("+i+")  ";

                for(int j=0;j<((PremiumUser)users.get(User)).getArrayListMatriz().get(contador)[0].length;j++){
                    if(((PremiumUser)users.get(User)).getArrayListMatriz().get(contador)[i][j]==null){
                        print+="| ___ |";
                    }else{
                        print +="| "+((PremiumUser)users.get(User)).getArrayListMatriz().get(contador)[i][j] + " |";
                    }
                }
                print +="\n";
            }
        }
        

		return print;
	}

     /**
	 * Description this method takes care of deleting the subscription
	 * pre:
	 * pos:
	 * @param User the position of user
     * @param product the position of product
	 * @return boolean
	 */

    public boolean borrarSuscripcion(int user, int product){
        boolean indicador=false;
        if(indicador==false){
            if(users.get(user) instanceof RegularUser){
                ((RegularUser)users.get(user)).getMagazines()[product]=null;
                indicador=true;
            }else if(users.get(user) instanceof PremiumUser){
                ((PremiumUser)users.get(user)).getMagazines().remove(product);
                indicador=true;
            }
        }
        return indicador;
    }
       /**
	 * Description This method is in charge of displaying the accumulated number of pages read
	 * pre:
	 * pos:
	 * @return String
	 */

    public String mostrarAcumPaginasLeidas(){
        String msg="";
        for(int i=0;i<productosBiblio.size();i++){
            if(productosBiblio.get(i) instanceof Book){
                msg+="\n"+(i+1)+". "+"Name: "+productosBiblio.get(i).getName()+" (Book)";
                msg+="\nPages Read: "+productosBiblio.get(i).getNumberPagesRead()+"\n";
            }else{
                msg+="\n"+(i+1)+". "+"Name: "+productosBiblio.get(i).getName()+" (Magazine)";
                msg+="\nPages Read "+productosBiblio.get(i).getNumberPagesRead()+"\n";
            }
            
        }
        return msg;
    }
    /**
	 * Description This method is in charge of showing the most read genre and category.
	 * pre:
	 * pos:
	 * @return String
	 */

    public String generoMasLeidoYCategoria(){
        String msg2="";
        String msg1="";
        int  gCiencia=0;
        int cVariedades=0;
        int gFantasia=0;
        int cDiseño=0;
        int gNovela=0;
        int cCientifica=0;

        for(int i=0;i<productosBiblio.size();i++){
            
            if(productosBiblio.get(i) instanceof Book){

                if(((Book)productosBiblio.get(i)).getGenre()==GenreBook.CIENCIA_FICCION){
                    gCiencia=((Book)productosBiblio.get(i)).getNumberPagesRead();
                }else if(((Book)productosBiblio.get(i)).getGenre()==GenreBook.FANTASIA){
                    gFantasia=((Book)productosBiblio.get(i)).getNumberPagesRead();
                }else{
                    gNovela=((Book)productosBiblio.get(i)).getNumberPagesRead();
                }

            }else if(productosBiblio.get(i) instanceof Magazine){
                if(((Magazine)productosBiblio.get(i)).getCategory()==CategoryMagazine.VARIEDADES){
                    cVariedades=((Magazine)productosBiblio.get(i)).getNumberPagesRead();
                }else if(((Magazine)productosBiblio.get(i)).getCategory()==CategoryMagazine.DISEÑO){
                    cDiseño=((Magazine)productosBiblio.get(i)).getNumberPagesRead();
                }else{
                    cCientifica=((Magazine)productosBiblio.get(i)).getNumberPagesRead();
                }
            }
            
        }

        if(gCiencia>gFantasia&&gCiencia>gNovela){
            msg1="\nThe genre with the most pages read is Science Fiction, with a total of "+gCiencia+" pages";
        }else if(gFantasia>gCiencia&&gFantasia>gNovela){
            msg1="\nThe genre with the most pages read is Fantasy, with a total of "+gFantasia+" pages";
        }else{
            msg1="\nThe genre with the most pages read is Historical Novels, with a total of "+gNovela+" pages";
        }

        if(cVariedades>cDiseño&&cVariedades>cCientifica){
            msg2="\nThe category with the most pages read is Varieties, with a total of "+cVariedades+" pages";
        }else if(cDiseño>cVariedades&&cDiseño>cCientifica){
            msg2="\nThe category with the most pages read is Design, with a total of "+cDiseño+" pages";
        }else{
            msg2="\nThe category with the most pages read is Scientific, with a total of "+cCientifica+" pages";
        }

        return msg1+msg2;
    }
     /**
	 * Description This method is responsible for displaying the earnings by gender.
	 * pre:
	 * pos:
	 * @return String
	 */
    public String gananciasGenero(){
        String msg="";
        int cienciaFiccion=0;
        int fantasia=0; 
        int novela_Historica=0;

        double gCienciaF=0;
        double gFantasia=0; 
        double gNovela_Historica=0;

        for(int i=0;i<productosBiblio.size();i++){
            if(productosBiblio.get(i)instanceof Book){
                if(((Book)productosBiblio.get(i)).getGenre()==GenreBook.CIENCIA_FICCION){
                    cienciaFiccion+=((Book)productosBiblio.get(i)).getSoldCopies();
                    double precio=((Book)productosBiblio.get(i)).getPrice();
                    double ganancias=((Book)productosBiblio.get(i)).getSoldCopies()*precio;
                    gCienciaF+=ganancias;
                }else if(((Book)productosBiblio.get(i)).getGenre()==GenreBook.FANTASIA){
                    fantasia+=((Book)productosBiblio.get(i)).getSoldCopies();
                    double precio=((Book)productosBiblio.get(i)).getPrice();
                    double ganancias=((Book)productosBiblio.get(i)).getSoldCopies()*precio;
                    gFantasia+=ganancias;
                }else if(((Book)productosBiblio.get(i)).getGenre()==GenreBook.NOVELA_HISTORICA){
                    novela_Historica+=((Book)productosBiblio.get(i)).getSoldCopies();
                    double precio=((Book)productosBiblio.get(i)).getPrice();
                    double ganancias=((Book)productosBiblio.get(i)).getSoldCopies()*precio;
                    gNovela_Historica+=ganancias;
                }
            }
        }

        msg="\nNumber of books sold of the genre Science Fiction: "+cienciaFiccion;
        msg+="\nYour total earnings : $ "+gCienciaF+" dollars";
        msg+="\n\nNumber of books sold in the Fantasy genre: "+fantasia;
        msg+="\nYour total earnings: $ "+gFantasia+" dollars";
        msg+="\n\nNumber of books sold of the genre Historical Novel: "+novela_Historica;
        msg+="\nYour total earnings: $ "+gNovela_Historica+" dollars";
        return msg;
    }

        /**
	 * Description This method is responsible for displaying the earnings by Category.
	 * pre:
	 * pos:
	 * @return String
	 */

    public String gananciaCategoria(){
        String msg="";
        int variedades=0;
        int diseño=0;
        int cientifica=0;

        double gVariedades=0;
        double gDiseño=0;
        double gCientifica=0;

        for(int i=0;i<productosBiblio.size();i++){
            if(productosBiblio.get(i) instanceof Magazine){
                if(((Magazine)productosBiblio.get(i)).getCategory()==CategoryMagazine.VARIEDADES){
                    variedades+=((Magazine)productosBiblio.get(i)).getNumberActives();
                    double precio=((Magazine)productosBiblio.get(i)).getSubscriptionValue();
                    double ganancias=((Magazine)productosBiblio.get(i)).getNumberActives()*precio;
                    gVariedades+=ganancias;
                }else if(((Magazine)productosBiblio.get(i)).getCategory()==CategoryMagazine.DISEÑO){
                    diseño+=((Magazine)productosBiblio.get(i)).getNumberActives();
                    double precio=((Magazine)productosBiblio.get(i)).getSubscriptionValue();
                    double ganancias=((Magazine)productosBiblio.get(i)).getNumberActives()*precio;
                    gDiseño+=ganancias;
                }else if(((Magazine)productosBiblio.get(i)).getCategory()==CategoryMagazine.CIENTIFICA){
                    cientifica+=((Magazine)productosBiblio.get(i)).getNumberActives();
                    double precio=((Magazine)productosBiblio.get(i)).getSubscriptionValue();
                    double ganancias=((Magazine)productosBiblio.get(i)).getNumberActives()*precio;
                    gCientifica+=ganancias;
                }
            }
        }
        msg="\nNumber of subscribed magazines in the Varieties category: "+variedades;
        msg+="\nYour total earnings : $ "+gVariedades+" dollars";
        msg+="\n\nNumber of subscribed magazines in the Design category: "+diseño;
        msg+="\nYour total earnings: $ "+gDiseño+" dollars";
        msg+="\n\nNumber of subscribed journals in the scientific category: "+cientifica;
        msg+="\nYour total earnings: $ "+gCientifica+" dollars";
        return msg;
    }
      /**
	 * Description This method is in charge of showing the top 5 most read books.
	 * pre:
	 * pos:
	 * @return String
	 */
    public String topLibros(){
        String msg="";
        int n1=0; String numero1="-There is no more-";
        int n2=0; String numero2="-There is no more-";
        int n3=0; String numero3="-There is no more-";
        int n4=0; String numero4="-There is no more-";
        String numero5="-There is no more-";
        for(int j=0;j<productosBiblio.size();j++){
        for(int i=0;i<productosBiblio.size();i++){
            if(productosBiblio.get(i)instanceof Book){
                if(productosBiblio.get(i).getNumberPagesRead()>=n1){
                    n1=productosBiblio.get(i).getNumberPagesRead();
                    numero1=productosBiblio.get(i).getName()+"- "+((Book)productosBiblio.get(i)).getGenre()+" - Paginas: "+productosBiblio.get(i).getNumberPagesRead();   
                }else if(productosBiblio.get(i).getNumberPagesRead()>=n2){
                    n2=productosBiblio.get(i).getNumberPagesRead();
                    numero2=productosBiblio.get(i).getName()+"- "+((Book)productosBiblio.get(i)).getGenre()+" - Paginas: "+productosBiblio.get(i).getNumberPagesRead();    
                }else if(productosBiblio.get(i).getNumberPagesRead()>=n3){
                    n3=productosBiblio.get(i).getNumberPagesRead();
                    numero3=productosBiblio.get(i).getName()+"- "+((Book)productosBiblio.get(i)).getGenre()+" - Paginas: "+productosBiblio.get(i).getNumberPagesRead();   
                }else if(productosBiblio.get(i).getNumberPagesRead()>=n4){
                    n4=productosBiblio.get(i).getNumberPagesRead();
                    numero4=productosBiblio.get(i).getName()+"- "+((Book)productosBiblio.get(i)).getGenre()+" - Paginas: "+productosBiblio.get(i).getNumberPagesRead();
                }else{
                    numero5=productosBiblio.get(i).getName()+"-"+((Book)productosBiblio.get(i)).getGenre()+"- Paginas: "+productosBiblio.get(i).getNumberPagesRead();
                    
                }
            }
        }
        
        }
        msg="\n(Top 1)";
        msg+="\n"+numero1;
        msg+="\n\n(Top 2)";
        msg+="\n"+numero2;
        msg+="\n\n(Top 3)";
        msg+="\n"+numero3;
        msg+="\n\n(Top 4)";
        msg+="\n"+numero4;
        msg+="\n\n(Top 5)";
        msg+="\n"+numero5; 
        return msg;
    }
    /**
	 * Description This method is in charge of showing the top 5 most read Magazines.
	 * pre:
	 * pos:
	 * @return String
	 */
    

    public String topRevistas(){
        String msg="";
        int n1=0; String numero1="-There is no more-";
        int n2=0; String numero2="-There is no more-";
        int n3=0; String numero3="-There is no more-";
        int n4=0; String numero4="-There is no more-";
        String numero5="-There is no more-";
        for(int j=0;j<productosBiblio.size();j++){
        for(int i=0;i<productosBiblio.size();i++){
            if(productosBiblio.get(i)instanceof Magazine){
                if(productosBiblio.get(i).getNumberPagesRead()>=n1){
                    n1=productosBiblio.get(i).getNumberPagesRead();
                    numero1=productosBiblio.get(i).getName()+" - "+((Magazine)productosBiblio.get(i)).getCategory()+" - Paginas: "+productosBiblio.get(i).getNumberPagesRead();
                }else if(productosBiblio.get(i).getNumberPagesRead()>=n2){
                    n2=productosBiblio.get(i).getNumberPagesRead();
                    numero2=productosBiblio.get(i).getName()+" - "+((Magazine)productosBiblio.get(i)).getCategory()+" - Paginas: "+productosBiblio.get(i).getNumberPagesRead();
                }else if(productosBiblio.get(i).getNumberPagesRead()>=n3){
                    n3=productosBiblio.get(i).getNumberPagesRead();
                    numero3=productosBiblio.get(i).getName()+" - "+((Magazine)productosBiblio.get(i)).getCategory()+" - Paginas: "+productosBiblio.get(i).getNumberPagesRead();
                }else if(productosBiblio.get(i).getNumberPagesRead()>=n4){
                    n4=productosBiblio.get(i).getNumberPagesRead();
                    numero4=productosBiblio.get(i).getName()+" - "+((Magazine)productosBiblio.get(i)).getCategory()+" - Paginas: "+productosBiblio.get(i).getNumberPagesRead();
                }else{
                    numero5=productosBiblio.get(i).getName()+" - "+((Magazine)productosBiblio.get(i)).getCategory()+" - Paginas: "+productosBiblio.get(i).getNumberPagesRead();
                }
            }
        }
        
    }
        msg="\n(Top 1)";
        msg+="\n"+numero1;
        msg+="\n\n(Top 2)";
        msg+="\n"+numero2;
        msg+="\n\n(Top 3)";
        msg+="\n"+numero3;
        msg+="\n\n(Top 4)";
        msg+="\n"+numero4;
        msg+="\n\n(Top 5)";
        msg+="\n"+numero5; 
        return msg;
    }

       /**
	 * Description This method is responsible for organizing the products purchased.
	 * pre:
	 * pos:
     * @param User the position of User
	 * @return boolean
	 */

    private boolean acomodarProductos(int User){
        boolean indicador=false;
        if(users.get(User)instanceof RegularUser){
            for (int i=0;i<((RegularUser)users.get(User)).getOrganizados().length;i++){
                indicador=false;
                for(int j=0;j<((RegularUser)users.get(User)).getOrganizados().length;j++){
                    if(((RegularUser)users.get(User)).getOrganizados()[i]!=null&&((RegularUser)users.get(User)).getOrganizados()[j]!=null){
                    if(((RegularUser)users.get(User)).getOrganizados()[i].compareTo(((RegularUser)users.get(User)).getOrganizados()[j])==-1){
                        BibliographicP productoMenor=((RegularUser)users.get(User)).getOrganizados()[i];
                        BibliographicP productoMayor=((RegularUser)users.get(User)).getOrganizados()[j];
                        ((RegularUser)users.get(User)).getOrganizados()[i]=productoMayor;
                        ((RegularUser)users.get(User)).getOrganizados()[j]=productoMenor;
                        indicador=true;
                    }
                }
                }
            }
        }else if(users.get(User)instanceof PremiumUser){
            for (int i=0;i<((PremiumUser)users.get(User)).getProductosOrganizadosP().size();i++){
                indicador=false;
                for(int j=0;j<((PremiumUser)users.get(User)).getProductosOrganizadosP().size();j++){
                    if(((PremiumUser)users.get(User)).getProductosOrganizadosP().get(i).compareTo(((PremiumUser)users.get(User)).getProductosOrganizadosP().get(j))==-1){
                        BibliographicP productoMenor=((PremiumUser)users.get(User)).getProductosOrganizadosP().get(i);
                        BibliographicP productoMayor=((PremiumUser)users.get(User)).getProductosOrganizadosP().get(j);
                        ((PremiumUser)users.get(User)).getProductosOrganizadosP().set(i, productoMayor);
                        ((PremiumUser)users.get(User)).getProductosOrganizadosP().set(j, productoMenor);
                        indicador=true;
                    }
                
                }
            }
        }
        

        return indicador;
    }
    
    public String[][] crearMatriz(){
        String[][] matrizId;
        return matrizId= new String[5][5];
    }
    

    }


        
    

