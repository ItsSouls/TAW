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

controller.editarpedido = async function (req, res, next) {
    try {
        const pedido = await models.PURCHASE_ORDER.findOne({
            where: {
                ORDER_NUM: req.params.id
            }
        });
        const productos = await models.PRODUCT.findAll();
        const id = req.params.id;
        res.render("pedido", {pedido: pedido, productos: productos, id:id});

    } catch (error) {
        res.send("Se ha producido un error " + error);
    }
};

controller.guardarpedido = async function (req, res, next) {
    try {
        if (req.body.ORDER_NUM != "") {
            const pedido = await models.PURCHASE_ORDER.findOne({
                where: {
                    ORDER_NUM: req.body.ORDER_NUM
                }
            });
            if (pedido) {
                await pedido.update(
                    {
                        ORDER_NUM: req.body.ORDER_NUM,
                        CUSTOMER_ID: req.body.CUSTOMER_ID,
                        PRODUCT_ID: req.body.PRODUCT_ID,
                        QUANTITY: req.body.QUANTITY,
                        SHIPPING_COST: req.body.SHIPPING_COST,
                        SALES_DATE: req.body.SALES_DATE,
                        SHIPPING_DATE: req.body.SHIPPING_DATE,
                        FREIGHT_COMPANY: req.body.FREIGHT_COMPANY
                    }
                );
            }
        } else {
            await models.PURCHASE_ORDER.create(
                {
                    CUSTOMER_ID: req.params.id,
                    PRODUCT_ID: req.body.PRODUCT_ID,
                    QUANTITY: 1,
                    SHIPPING_COST: req.body.SHIPPING_COST,
                    SALES_DATE: new Date(),
                    SHIPPING_DATE: req.body.SHIPPING_DATE,
                    FREIGHT_COMPANY: req.body.FREIGHT_COMPANY
                }
            );
        }
        }catch (error) {
            res.send("Se ha producido un error " + error);
        }
        res.redirect('/');
};

controller.nuevo = async function (req, res, next) {
    const productos = await models.PRODUCT.findAll();
    const pedido = false;
    const id = req.params.id;
    res.render("nuevo", {pedido:pedido, productos:productos, id:id});
};

    module.exports = controller;