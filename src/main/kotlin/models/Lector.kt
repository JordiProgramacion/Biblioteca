package models

class Lector (val nom: String) {
    private val llibresPrestats = mutableListOf<Llibre>()
    fun prestarLlibre(llib: Llibre) {
        if (llib.prestat) {
            println("El llibre ${llib.titol} ja está prestat, esperi a que el retornin.")
        } else {
            llibresPrestats.add(llib)
            llib.prestar()
            println("S'ha agregat el llibre ${llib.titol} a la llista de llibres prestats.")
        }
    }
    fun retornarLlibre(llib: Llibre) {
        if (llib.prestat) {
            llibresPrestats.remove(llib)
            llib.retornar()
            println("El llibre s'ha retornar correctament.")
        } else {
            println("El llibre no es pot retornar perqué no està prestat.")
        }
    }
    fun llistarPrestecs() {
        println("Bon dia $nom, els llibres que tens prestats actualment son: ")
        llibresPrestats.forEach { llibre -> println("${llibre.titol} de autor ${llibre.autor}") }
    }
}