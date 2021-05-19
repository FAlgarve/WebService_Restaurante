package controller

import model.Pedido
import model.Prato
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import repo.PedidoRepo
import repo.PratoRepo

@RestController
class RestController {

    //pratos
    var pratoRepo = PratoRepo()

    @GetMapping("/getMenu")
    fun getMenu(): MutableList<Prato> {
        return pratoRepo.todososPratos
    }

    @PostMapping("/createPrato")
    fun createPrato(@RequestBody prato: Prato): String {
        return pratoRepo.addPrato(prato)
    }

    //Pedido

    var pedidoRepo = PedidoRepo()

    @GetMapping("/getPedido")
    fun getpedido(): List<Pedido> {
        return pedidoRepo.recebertodososPedidos()
    }

    @PostMapping("/order")
    fun order(@RequestBody pedido: Pedido): MutableList<Pedido> {
        pedidoRepo.addPedido(pedido)
        return pedidoRepo.todososPedidos
    }

    //MAC & LINUX
    //curl -X POST -H 'content-type: application/json' -d '{"id":5000, "name":"edgar", "active":true}' localhost:8080/createStudent

    //WIN
    //curl -X POST -H "content-type: Application/json" -d "{"""id""":2344, """name""":"""xpto""", """active""":true}" localhost:8080/createStudent

}