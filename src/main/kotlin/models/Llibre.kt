package models

class Llibre (val titol: String, val autor: String, var prestat: Boolean = false) {

    fun info(): String {
        return "El títol del llibre és $titol, va ser escrit per \n$autor i ara mateix ${if (prestat) "no està disponible." else "està disponible."}"
    }

    fun prestar() {
        prestat = true
    }

    fun retornar() {
        prestat = false
    }
}