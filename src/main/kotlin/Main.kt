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
    var sesionIniciada = false
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
        println("======= 8 - Inici de sessió")
        println("======= 9 - Conectarse a una altres biblioteca d'Espanya")
        println("======= 10 - Saber el número de llibres que estan prestats")
        println("======= 11 - Quants llibres té un escritor en aquesta biblioteca")
        print("======= Introdueix l'acció que desitjàs fer: ")
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
                                    println("No has introduït 1 o 2")
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
                    print("Introdueix el títol del llibre de cual vols obtenir informació (exemple: Caillou): ")
                    val titolLlibres = readln()
                    val llibreTrobat = catalogoOlesa.find { it.titol == titolLlibres }

                    if (llibreTrobat != null) {
                        println(llibreTrobat.info())
                    } else {
                        println("El títol del llibre introduït no existeix, torna a intentar-ho.")
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
                        else -> println("No has introduït 1 o 2, torna a intentar-ho.")
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

                            println("Envían sugerencia, esperi...")
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
                                    else -> { println("No has introduït 1 o 2, torna a intentar-ho"); continue }
                                }
                            }
                        }
                        else -> { println("No has introduït 1 o 2, torna a intentar-ho"); continue }
                    }
                }
                continue
            }
            "8" -> {
                    print("Introdueix el teu nom d'usuari per accedir a més funcions: ")
                    val nomUsuari = readln()
                    lectoresOlesa.forEach {
                        if (it.nom == nomUsuari) {
                            sesionIniciada = true
                        }
                    }
                while (true) {
                    if (sesionIniciada) {
                        // ESTAMOS POR AQUÍ
                        while (true) {
                            println("============= Benvingut $nomUsuari, quina acció desitjà fer? =============")
                            println("======= 1 - Veure els llibres prestats")
                            println("======= 2 - Veure els llibres disponibles actualment")
                            println("======= 3 - Emportar-se un llibre")
                            println("======= 4 - Retornar un llibre")
                            println("======= 5 - Tancar sessió i tornar al menu principal")
                            print("Elecció: ")
                            when (readln()) {
                                "1" -> {
                                    println("Els llibres prestats actualment son:")
                                    lectoresOlesa.forEach {
                                        if (it.nom == nomUsuari) {
                                            it.llistarPrestecs()
                                        }
                                    }
                                    print("Clica enter per continuar: ")
                                    readln()
                                    continue
                                }
                                "2" -> {
                                    bibliotecaOlesa.llistarDisponibles()
                                    print("Clica enter per continuar: ")
                                    readln()
                                    continue
                                }
                                "3" -> {
                                    while (true) {
                                        println("Aquests son els llibres disponibles actualment:")
                                        bibliotecaOlesa.llistarDisponibles()
                                        print("Escriu el títol del llibre que et vols emportar: ")
                                        val llibreUsuariPrestar = readln()
                                        val llibreUsuarioReal = catalogoOlesa.find { it.titol == llibreUsuariPrestar }
                                        if (llibreUsuarioReal != null && !llibreUsuarioReal.prestat) {
                                            lectoresOlesa.forEach {
                                                if (it.nom == nomUsuari) {
                                                    it.prestarLlibre(llibreUsuarioReal)
                                                }
                                            }
                                            break

                                        } else {
                                            println("El títol del llibre introduït no es a la nostra biblioteca")
                                            println("Torna a intentar-ho.")
                                            continue
                                        }
                                    }
                                }
                                "4" -> {
                                    while (true) {
                                        println("Aquests son els llibres que s'han de retornar:")
                                        bibliotecaOlesa.cataleg.forEach {
                                            if (it.prestat) {
                                                println(it.titol)
                                            }
                                        }
                                        print("Escriu el títol del llibre que vols retornar: ")
                                        val llibreARetornar = readln()
                                        val llibreARetornarReal = catalogoOlesa.find { it.titol == llibreARetornar }
                                        if (llibreARetornarReal != null && llibreARetornarReal.prestat) {
                                            lectoresOlesa.forEach {
                                                if (it.nom == nomUsuari) {
                                                    it.retornarLlibre(llibreARetornarReal)
                                                }
                                            }
                                            break

                                        } else {
                                            println("El títol que has introduït no esta prestat.")
                                            println("Torna a intentar-ho.")
                                            continue
                                        }
                                    }
                                }
                                "5" -> {
                                    println("Tancant sessió...")
                                    Thread.sleep(2000)
                                    sesionIniciada = false
                                    break
                                }
                                else -> {
                                    println("El número introduït no esta entre 1 i 5, torna a intentar-ho.")
                                    continue
                                }
                            }
                        }
                    break
                    } else {
                        println("El nom introduït no es un usuari de la nostra biblioteca.")
                            println("Clica 1 per tornar a intentar-ho.")
                            println("Clica 2 per tornar al menu principal")
                            print("Elecció: ")
                            val eleccionUsuario = readln()
                            try {
                                require(eleccionUsuario == "1" || eleccionUsuario == "2") { "Error: no has introduït 1 o 2." }
                            } catch (e: IllegalArgumentException) {
                                println(e.message)
                                println("Tornant al menu principal...")
                                Thread.sleep(3000)
                                break
                            }
                            when (eleccionUsuario) {
                                "1" -> {
                                    println("Error inesperat, torna a intentar-ho més tard.")
                                    Thread.sleep(2000)
                                    break
                                }
                                "2" -> break
                            }
                    }
                }
            }
            "9" -> {
                println("Buscant bibliotecas disponibles, si us plau, esperi...")
                Thread.sleep(8000)
                println("No hi han bibliotecas disponibles, torna a intentar-ho més tard.")
                print("Clica enter per continuar: ")
                readln()
                continue
            }
            "10" -> {
                val totalPrestats = Utils.comptarPrestats(catalogoOlesa)
                println("El número de llibres marcats com a prestats es de: $totalPrestats")
                print("Clica enter per continuar: ")
                readln()
                continue
            }
            "11" -> {
                println("Aquests son els autores que tenim a la biblioteca:")
                bibliotecaOlesa.autorsDisponibles()
                print("\nIntrodueix el nom del autor del cual vols saber el número de llibres\nque te a la biblioteca: ")
                val autorContarLlibres = readln()
                val autorContarReal = bibliotecaOlesa.autorsDisponibles2()
                if (autorContarLlibres in autorContarReal) {
                    val resultado11 = Utils.comptarPerAutor(llista = catalogoOlesa, autor = autorContarLlibres)
                    println("L'autor $autorContarLlibres ha escrit un total de: $resultado11 llibres.")
                    print("Clica enter per continuar: ")
                    readln()
                    continue
                } else {
                    println("L'autor introduït no existeix a la biblioteca.")
                    println("Clica 1 per tornar a intentar-ho")
                    println("Clica 2 per tornar al menú principal")
                    print("Elecció: ")
                    when (readln()) {
                        "1" -> continue
                        "2" -> continue
                        else -> {
                            println("Error: no has introduït 1 o 2")
                            Thread.sleep(2000)
                            continue
                        }
                    }
                }
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