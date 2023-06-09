const express = require("express");
const router = express.Router();

const clientesController = require('../controllers/clientes');
const pedidosController = require('../controllers/pedidos');

router.get("/", clientesController.listarClientes);
router.get("/editar/:id",clientesController.editarCliente);
router.get("/nuevo",clientesController.nuevoCliente);
router.post ("/guardar", clientesController.guardarCliente);
router.post ("/filtrar", clientesController.filtrarClientes);
router.get("/borrar/:id", clientesController.borrarCliente);
router.get("/pedidos/:id", pedidosController.listarpedidos);
router.get("/pedidos/:id/nuevo", pedidosController.nuevo);
router.post ("/pedidos/:id/guardar", pedidosController.guardarpedido);
router.get("/pedidos/:id/editar", pedidosController.editarpedido);

module.exports = router;
