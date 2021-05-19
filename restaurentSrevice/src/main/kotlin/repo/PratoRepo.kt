package repo

import model.Prato
import org.springframework.stereotype.Repository

@Repository
class PratoRepo {

    var todososPratos = mutableListOf<Prato>()


    init {
        val prato1 = Prato(1001, "Prato do dia", 12.50)
        val prato2 = Prato(1002, "Arroz de polvo", 20.00)
        todososPratos.add(prato1)
        todososPratos.add(prato2)
    }

    //return todos os pratos
    fun recebertodososPratos(): List<Prato> {
        return todososPratos
    }

    //add novo prato
    fun addPrato(newPrato: Prato): String {
        todososPratos.add(newPrato)
        return "O prato foi adicionado ${newPrato.name}"
    }

    //get prato pelo id
    fun receberPratosById(id: Int): Prato? {
        return todososPratos.find {
            it.id == id
        }
    }

    //delete prato
    fun deletePrato(id: Int): List<Prato> {
        var prato :Prato? = receberPratosById(id)
        todososPratos.remove(prato)
        return todososPratos
    }
}