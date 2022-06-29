class AlumneStrate{
    var criterioEstudio: CriterioEstudio = CriterioEstudiosa
    val notas: MutableList<Int> = mutableListOf()

    fun criterioEstudiosa() { criterioEstudio = CriterioEstudiosa}
    fun criterioVaga() { criterioEstudio = CriterioVaga}
    fun criterioHijaDelRigor() { criterioEstudio = CriterioHijaDelRigor}

    fun rindioParcial(nota: Int) {notas.add(nota)}

    fun estudiaPara(parcial: ParcialStrate) = criterioEstudio.estudiaPara(parcial,this)

    fun desaproboUltimoExamen() = notas.last() < 6
}

interface CriterioEstudio{
    fun estudiaPara(parcial: ParcialStrate, alumneStrate: AlumneStrate) : Boolean
}

object CriterioEstudiosa : CriterioEstudio {
    override fun estudiaPara(parcial: ParcialStrate, alumne: AlumneStrate) = true
}

object CriterioVaga : CriterioEstudio{
    override fun estudiaPara(parcial: ParcialStrate, alumne: AlumneStrate) = alumne.desaproboUltimoExamen()
}

object CriterioHijaDelRigor : CriterioEstudio{
    override fun estudiaPara(parcial: ParcialStrate, alumneStrate: AlumneStrate) = parcial.parcialDificil()
}


data class ParcialStrate (val cantidadDePreguntas: Int = 10) {
    fun parcialDificil() = cantidadDePreguntas > 5
}