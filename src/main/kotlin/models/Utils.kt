package models

class Utils {
    companion object {

        fun comptarPrestats(llista: List<Llibre>): Int {
            var numeroPrestados = 0
            for (llibre in llista) {
                if (llibre.prestat) { numeroPrestados += 1 }
            }
            return numeroPrestados
        }

        fun comptarPerAutor(llista: List<Llibre>, autor: String): Int {
            var llibresAutor = 0

            for (llibre in llista) {
                if (llibre.autor == autor) {
                    llibresAutor += 1
                }
            }
            return llibresAutor
        }
    }

}