package models

class Biblioteca (val cataleg: MutableList<Llibre>, val lectors: MutableList<Lector>){

    fun afegirLlibre(llib: Llibre) {
        if (llib in cataleg) {
            println("El llibre ${llib.titol} ja esta en el catàleg, no es pot tornar a agregar.")
        } else {
            cataleg.add(llib)
            println("El llibre ${llib.titol} s'ha agregat al catàleg.")
        }
    }
    fun registrarLector(lector: Lector) {
        if (lector in lectors) {
            println("El lector ${lector.nom} ja està en la llista de lectors de la biblioteca")
        } else {
            lectors.add(lector)
            println("El lector ${lector.nom} s'ha agregat a la llista de lectors de la biblioteca.") }
    }
    fun llistarDisponibles() {
        println("Els llibres actualment disponibles son: ")
        cataleg.forEach { llibre -> if (!llibre.prestat) println(llibre.titol)}
    }
    fun llistarTotsElsLlibres() {
        var contador = 0
        for (llibres in cataleg) {
            contador += 1
            println("$contador - ${llibres.titol}")
        }
    }
    fun cercarPerAutor(autor: String): List<Llibre> {

        val llistaAutors = mutableListOf<Llibre>()
        for (llibres in cataleg) {
            if (autor == llibres.autor) {
                llistaAutors.add(llibres)
                println(llibres.titol)
            }
        }
        return llistaAutors
    }
    // Método para saber que autores hay disponibles en la biblioteca.

    fun autorsDisponibles(): List<String> {
        val autoresDisponibles = mutableListOf<String>()

        println("Els autors disponibles son:")
        for (llibre in cataleg) {
            if (llibre.autor !in autoresDisponibles) {
                println(llibre.autor)
                autoresDisponibles.add(llibre.autor)
            }
        }
        println("Si vols cercar per autor asegurat de que escrius exactament el nom de l'autor, si no")
        println("el programa no funcionara (consell, copia i enganxa l'autor que vulguis cercar!!!)")
        return autoresDisponibles
    }
    fun autorsDisponibles2(): List<String> {
        val autoresDisponibles = mutableListOf<String>()

        println("Els autors disponibles son:")
        for (llibre in cataleg) {
            if (llibre.autor !in autoresDisponibles) {
                autoresDisponibles.add(llibre.autor)
            }
        }
        return autoresDisponibles
    }
}