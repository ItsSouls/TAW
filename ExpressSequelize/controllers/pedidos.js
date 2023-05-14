var initModels = require("../models/init-models");
const sequelize = require("sequelize");
var models = initModels(sequelize);

const controller = {};

// Listar pedidos /////////////////////////////////////////////////////////////////////////////////////////////////////
controller.listarpedidos = async function (req, res, next) {
    try {
        const pedidos = await models.PURCHASE_ORDER.findAll({
            where: {
                CUSTOMER_ID: req.params.id
            }
        });
        const productos = await models.PRODUCT.findAll();
        const id = req.params.id;

        res.render("pedidos", {id:id, pedidos:pedidos, productos:productos});

    } catch (error) {
        res.send("Se ha producido un error " + error);
    }
};

controller.nuevo = async function (req, res, next) {
    const productos = await models.PRODUCT.findAll();
    const pedido = false;
    const id = req.params.id;
    res.render("nuevo", {pedido:pedido, productos:productos, id:id});
};

controller.guardarpedido = async function (req, res, next) {
    try {
            await models.PURCHASE_ORDER.create(
                {
                    CUSTOMER_ID: req.params.id,
                    PRODUCT_ID: req.body.PRODUCT_ID,
                    QUANTITY: 1,
                    SHIPPING_COST: req.body.SHIPPING_COST,
                    SALES_DATE: new Date(),
                    SHIPPING_DATE: req.body.SHIPPING_DATE,
                    SHIPPING_COST: req.body.SHIPPING_COST,
                    FREIGHT_COMPANY: req.body.FREIGHT_COMPANY
                }
            );
        res.redirect('/pedidos/' + req.params.id);

    } catch (error) {
        res.send("Se ha producido un error " + error);
    }
};

module.exports = controller;