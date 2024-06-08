package com.geralexcas.gutendexlitelatura.principal;

import com.geralexcas.gutendexlitelatura.model.Datos;
import com.geralexcas.gutendexlitelatura.model.DatosLibros;
import com.geralexcas.gutendexlitelatura.service.ConsumoApi;
import com.geralexcas.gutendexlitelatura.service.ConvierteDatos;

import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private final String URL_BASE = "https://gutendex.com/books/";

    private ConvierteDatos conversor = new ConvierteDatos();
   // private AutorRepository repository;
    //	var consumoApi = new ConsumoApi();
	//	var json = consumoApi.obtenerDatos("https://gutendex.com/books/?search=%20romeo%20and%20juliet");
		//System.out.println(json);
	//	ConvierteDatos conversor = new ConvierteDatos();
   public void muestraElMenu() {

       var opcion = -1;
       while (opcion != 0) {
           var menu = """
                    \n ¡¡BIENVENIDO AL LITERALURA!! \n
                    1 - Buscar libro por título
                    2 - Buscar autor por nombre
                    3 - Listar libros registrados
                    4 - Listar autores registrados
                    5 - Listar autores vivos en un determinado año
                    6 - Listar libros por idioma
                    7 - Estadísticas generales
                    8 - Top 10 libros más descargados
                    9 - Listar autores nacidos en algún año
                    10 - Listar autores fallecidos en algún año
                    
                    0 - Salir
                    """;

           System.out.println(menu);
           opcion = teclado.nextInt();
           teclado.nextLine();

           switch (opcion) {
               case 1:
                   buscarLibro();
                   break;
              /* case 2:
                   buscarAutorPorNombre();
                   break;
               case 3:
                   listarLibrosRegistrados();
                   break;
               case 4:
                   listarAutoresRegistrados();
                   break;
               case 5:
                   listarAutoresVivos();
                   break;
               case 6:
                   listarLibrosPorIdioma();
                   break;
               case 7:
                   estadisticas();
                   break;
               case 8:
                   top10();
                   break;
               case 9:
                   listarAutorPorFechaNacimiento();
                   break;
               case 10:
                   listarAutorPorFechaFallecimiento();
                   break; */
               case 0:
                   System.out.println("Cerrando aplicación ... \n");
                   break;
               default:
                   System.out.println("Opción inválida");
           }
       }
   }

   private void buscarLibro(){
       System.out.println("Ingresa el título del libro que desea buscar");
       var titulo = teclado.nextLine();
       //	var json = consumoApi.obtenerDatos("https://gutendex.com/books/?search=%20romeo%20and%20juliet");
       var json = consumoApi.obtenerDatos(URL_BASE + "?search=" + titulo.replace(" ", "+").toLowerCase());

       var datosBusqueda = conversor.obtenerDatos(json, Datos.class);
      // System.out.println(datosBusqueda);
       Optional<DatosLibros> libroBuscado = datosBusqueda.resultados().stream()
               .findFirst();
       if (libroBuscado.isPresent()) {
           System.out.println(
                   "\n------------- LIBRO --------------" +
                           "\nTítulo: " + libroBuscado.get().titulo() +
                           "\nAutor: " + libroBuscado.get().autores().stream()
                           .map(a->a.nombre()).limit(1).collect(Collectors.joining())+
                           "\nIdioma: " +libroBuscado.get().idiomas().stream()
                           .collect(Collectors.joining())+


                           "\n--------------------------------------\n"
           );

       }



		}

}
