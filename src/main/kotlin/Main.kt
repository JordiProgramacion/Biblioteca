import models.Llibre
import models.Lector
import models.Biblioteca
import models.Utils

fun main() {

    // Primero creamos la biblioteca y sus listas.
    val lectoresOlesa = mutableListOf<Lector>()
    val catalogoOlesa = mutableListOf<Llibre>()
    val bibliotecaOlesa = Biblioteca(cataleg = catalogoOlesa, lectors = lectoresOlesa)

    //Creamos algunos lectores para poder usarlos más adelante.

    val lector1 = Lector(nom = "Jordi")
    val lector2 = Lector(nom = "Iker")
    val lector3 = Lector(nom = "Gerard")

    // Creamos algunos libros para poder usarlos más adelante y los agregamos en la biblioteca.
    val llibre1 = Llibre(titol = "Geronimo Stilton", autor = "Elisabetta Dam")
    val llibre2 = Llibre(titol = "Harry Potter", autor = "J.K.Rowling")
    val llibre3 = Llibre(titol = "Guinness World Record", autor = "Guinness")
    val llibre4 = Llibre(titol = "Harry Potter y la Piedra Filosofal", autor = "J.K.Rowling")
    val llibre5 = Llibre(titol = "Caillou", autor = "Christine L'Heurnius Hélène Despertau")
    val llibre6 = Llibre(titol = "Harry Potter 5", autor = "J.K.Rowling")

    // Registramos algunos lectores y los libros creados arriba.

    bibliotecaOlesa.registrarLector(lector1)
    bibliotecaOlesa.registrarLector(lector2)
    bibliotecaOlesa.registrarLector(lector3)

    bibliotecaOlesa.afegirLlibre(llibre1)
    bibliotecaOlesa.afegirLlibre(llibre2)
    bibliotecaOlesa.afegirLlibre(llibre3)
    bibliotecaOlesa.afegirLlibre(llibre4)
    bibliotecaOlesa.afegirLlibre(llibre5)
    bibliotecaOlesa.afegirLlibre(llibre6)
    println()
    println()
    println()
    println()
    println()
    println()
    println()
    println()

    while (true) {

        println("============= Benvingut a la biblioteca d'Olesa! =============")
        println("======= 0 - Sortir del programa")
        println("======= 1 - Llistar llibres disponibles")
        println("======= 2 - Llistar autors disponibles")
        println("======= 3 - Cercar llibres per autor")
        println("======= 4 - Por hacer")
        println("======= 5 - Por hacer")
        println("======= 6 - Por hacer")
        println("======= 7 - Por hacer")
        println("======= 8 - Por hacer")
        println("======= 9 - Conectarse a una altres biblioteca d'Espanya")
        print("======= Introdueix l'acció que desitjas fer: ")
        val input = readln()

        when (input) {

            "0" -> { println("Sortint del programa..."); break }
            "1" -> {
                bibliotecaOlesa.llistarDisponibles()
                print("Clica enter per continuar: ")
                readln()
                continue
            }
            "2" -> {
                bibliotecaOlesa.autorsDisponibles()
                print("Clica enter per continuar: ")
                readln()
                continue
            }
            "3" -> {
                while (true) {
                    print("Introdueix el nom del autor que vols cercar: ")
                    val autor = readln()
                    if (autor in bibliotecaOlesa.autorsDisponibles2()) {
                        bibliotecaOlesa.cercarPerAutor(autor = autor)
                        print("Clica enter per continuar: ")
                        readln()
                        break
                    } else {
                        while (true) {
                            println("No has escrit bé el nom del autor.")
                            println("Clica 1 per tornar-ho a intentar")
                            println("Pulsa 2 si vols sortir d'aquest apartat")

                            when (readln()) {
                                "1" -> {
                                    println("Torna al menú i tornar a intentar-ho") // Mejorar esto
                                    Thread.sleep(2000)
                                    break
                                }
                                "2" -> break
                                else -> {
                                    println("No has introduit 1 o 2")
                                    Thread.sleep(2000)
                                    continue }
                            }
                        }
                        break
                    }
                }
            }
            "4" -> { println("4"); continue }
            "5" -> { println("5"); continue }
            "6" -> {}
            "7" -> {}
            "8" -> {}
            "9" -> {
                println("Buscant bibliotecas disponibles, si us plau, esperi...")
                Thread.sleep(5000)
                println("No hi han bibliotecas disponibles, torna a intentar-ho més tard.")
                print("Clica enter per continuar: ")
                readln()
                continue
            }
            else -> {
                println("Número invalid, si us plau introdueix un número valid.")
                print("Clica enter per tornar a intentar-ho: ")
                readln()
                continue
            }

        }

    }
    println("Gracies per visitar la biblioteca d'Olesa, esperem que tornis!!!")
}