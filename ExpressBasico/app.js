const express = require('express');
const app = express();
const bodyParser = require('body-parser');
const session = require('express-session');
const cookieParser = require('cookie-parser');

app.set('view engine', 'ejs');
app.set('views','./views');

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

app.use(cookieParser());
app.use(session({secret: "Your secret key"}));

var Users = [];

app.get('/signup', function(req, res){
  res.render('signup', {message:""});
});

app.post('/signup', function(req, res){
  if(!req.body.id || !req.body.password){
    res.status("400");
    res.send("Información incompleta!");
  } else {
    Users.filter(function(user){
      if(user.id === req.body.id){
        res.render('signup', {
          message: "El usuario ya existen! Autentícate o utiliza otro nombre de usuario!"});
      }
    });
    var newUser = {id: req.body.id, password: req.body.password};
    Users.push(newUser);
    req.session.user = newUser;
    res.redirect('/protected_page');
  }
});

app.get('/protected_page', function(req, res, next){
  if(req.session.user) {
    res.render('protected_page', {id: req.session.user.id})
  } else {
    var err = new Error("No se ha realizado la autenticación!");
    console.log(req.session.user);
    next(err);  //Error, trying to access unauthorized page!
  }
});

app.get('/login', function(req, res){
  res.render('login', {message:""});
});

app.post('/login', function(req, res){
  var checked = false;
  console.log(Users);
  if(!req.body.id || !req.body.password){
    res.render('login', {message: "Por favor, introduzca usuario y contraseña"});
  } else {
    Users.filter(function(user){
      if(user.id === req.body.id && user.password === req.body.password){
        req.session.user = user;
        res.redirect('/protected_page');
      } else {
        res.render('login', {message: "Credenciales no válidas!"});
      }
      checked = true;
    });
    if (!checked) {
      res.render('login', {message: "Credenciales no válidas!"});
    }
  }
});

app.get('/logout', function(req, res){
  req.session.destroy(function(){
    console.log("Usuario ha salido del sistema")
  });
  res.redirect('/login');
});

app.use('/protected_page', function(err, req, res, next){
  console.log(err);
  //El usuario debe estar autenticado! Se le redirige al login.
  res.redirect('/login');
});


module.exports = app;