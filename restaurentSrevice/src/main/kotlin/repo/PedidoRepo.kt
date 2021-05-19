package repo

import model.Pedido
import org.springframework.stereotype.Repository

@Repository
class PedidoRepo {

    var todososPedidos = mutableListOf<Pedido>()


    init {
        val pedido1 = Pedido(101, 1001, "Antonio","Rua das avionetas mal batidas",true)
        val pedido2 = Pedido(102, 1002, "Gregorio","Rua das sirenes mundiais",false)
        todososPedidos.add(pedido1)
        todososPedidos.add(pedido2)
    }

    //return todos os pedidos
    fun recebertodososPedidos(): List<Pedido> {
        return todososPedidos
    }

    //adicionar novo pedido
    fun addPedido(newPedido: Pedido): String {
        todososPedidos.add(newPedido)
        return "Foi adicionado o novo Pedido ${newPedido.Nome}"
    }

    //get pedidos pelo id
    fun receberPedidosById(id: Int): Pedido? {
        return todososPedidos.find {
            it.id == id
        }
    }

    //delete pedidos
    fun deletePedido(id: Int): List<Pedido> {
        var pedido : Pedido? = receberPedidosById(id)
        todososPedidos.remove(pedido)
        return todososPedidos
    }
}