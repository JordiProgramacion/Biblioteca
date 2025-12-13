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

    val llibresEnProces = mutableListOf<String>()

    while (true) {

        println("============= Benvingut a la biblioteca d'Olesa! =============")
        println("======= 0 - Sortir del programa")
        println("======= 1 - Llistar llibres disponibles")
        println("======= 2 - Llistar autors disponibles")
        println("======= 3 - Cercar llibres per autor")
        println("======= 4 - Informació d'un llibre en concret")
        println("======= 5 - Llistar els llibres que estan prestats actualment")
        println("======= 6 - Llistar els usuaris disponibles")
        println("======= 7 - Sugerir un llibre per agregar-lo a la biblioteca")
        println("======= 8 - Por hacer (Iniciar sesion)")
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
                                    println("Carregant...")
                                    Thread.sleep(2000)
                                    println("Hi ha hagut un error, torna a intentar-ho.")
                                    Thread.sleep(3000)
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
            "4" -> {
                println("Aquests son tots els llibres de la biblioteca: ")
                while (true) {
                    bibliotecaOlesa.llistarTotsElsLlibres()
                    print("Introdueix el titol del llibre de cual vols obtenir informació (exemple: Caillou): ")
                    val titolLlibres = readln()
                    val llibreTrobat = catalogoOlesa.find { it.titol == titolLlibres }

                    if (llibreTrobat != null) {
                        println(llibreTrobat.info())
                    } else {
                        println("El titol del llibre introduit no existeix, torna a intentar-ho.")
                        continue
                    }
                    println("Clica 1 per obtenir informació d'un altre llibre")
                    println("Clica 2 per tornar al menu principal")
                    print("Elecció: ")
                    when (readln()) {
                        "1" -> { continue }
                        "2" -> {
                            break
                        }
                        else -> println("No has introduit 1 o 2, torna a intentar-ho.")
                    }
                }
            }
            "5" -> {
                println("Aquest son els llibres que en aquest moment estan prestats: ")
                for (x in catalogoOlesa) {
                    if (x.prestat) {
                        println(x.titol)
                    }
                }
                print("Clica enter per continuar: ")
                readln()
                continue
            }
            "6" -> {
                println("Els usuaris (lectors) disponibles actualment son:")
                lectoresOlesa.forEach { println(it.nom) }
                print("Clica enter per continuar: ")
                readln()
                continue
            }
            "7" -> {
                while (true) {
                    println("Clica 1 per veure totes les sugerencias de nous llibres")
                    println("Clica 2 per afegir un nou llibre")
                    print("Elecció: ")
                    when (readln()) {
                        "1" -> {
                            println("Els llibres suggests actualment son: ")
                            for (x in llibresEnProces) {
                                println(x)
                            }
                            print("Clica enter per continuar: ")
                            readln()
                            break
                        }
                        "2" -> {
                            println("Escriu el nom del llibre que t'agradaría afegir: ")
                            val nouLlibre = readln()

                            println("Envian sugerencia, esperi...")
                            llibresEnProces.add(nouLlibre)
                            Thread.sleep(2000)
                            println ("La teva sugerencia s'ha enviat correctament t'agradarià\nque s'agregues algun altre llibre?")
                            while (true) {
                                println("Clica 1 per agregar un nou llibre")
                                println("Clica 2 per tornar al menù")
                                print("Elecció: ")
                                when (readln()) {
                                    "1" -> {
                                        println("Carregant...")
                                        Thread.sleep(2000)
                                        println("Error inesperat, torna a intentar-ho.")
                                        Thread.sleep(3000)
                                        break
                                    }
                                    "2" -> break
                                    else -> { println("No has introduit 1 o 2, torna a intentar-ho"); continue }
                                }
                            }
                        }
                        else -> { println("No has introduit 1 o 2, torna a intentar-ho"); continue }
                    }
                }
                continue
            }
            "8" -> {
                continue
            }
            "9" -> {
                println("Buscant bibliotecas disponibles, si us plau, esperi...")
                Thread.sleep(8000)
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
    Thread.sleep(2500)
}