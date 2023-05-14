var express = require('express');
var router = express.Router();
var Users = [
  {
    "CUSTOMER_ID": 1,
    "DISCOUNT_CODE": "H",
    "ZIP": "10096",
    "NAME": "Big Bill Company",
    "ADDRESSLINE1": "8585 South Upper Murray Drive",
    "ADDRESSLINE2": "P.O. Box 456",
    "CITY": "New York",
    "STATE": "GA",
    "PHONE": "555-555-0175",
    "FAX": "555-555-0176",
    "EMAIL": "www.smallbill.example.com",
    "CREDIT_LIMIT": 90000
  },
  {
    "CUSTOMER_ID": 2,
    "DISCOUNT_CODE": "H",
    "ZIP": "94401",
    "NAME": "Bob Hosting Corp.",
    "ADDRESSLINE1": "65653 Lake Road",
    "ADDRESSLINE2": "Suite 2323",
    "CITY": "San Mateo",
    "STATE": "CA",
    "PHONE": "650-555-0160",
    "FAX": "650-555-0161",
    "EMAIL": "www.bobhostcorp.example.com",
    "CREDIT_LIMIT": 65000
  },
  {
    "CUSTOMER_ID": 3,
    "DISCOUNT_CODE": "H",
    "ZIP": "95035",
    "NAME": "Early CentralComp",
    "ADDRESSLINE1": "829 E Flex Drive",
    "ADDRESSLINE2": "Suite 853",
    "CITY": "San Jose",
    "STATE": "CA",
    "PHONE": "408-555-0157",
    "FAX": "408-555-0150",
    "EMAIL": "www.centralcomp.example.com",
    "CREDIT_LIMIT": 26500
  },
  {
    "CUSTOMER_ID": 4,
    "DISCOUNT_CODE": "L",
    "ZIP": "95117",
    "NAME": "John Valley Computers",
    "ADDRESSLINE1": "4381 Kelly Valley Ave",
    "ADDRESSLINE2": "Suite 77",
    "CITY": "Santa Clara",
    "STATE": "CA",
    "PHONE": "408-555-0169",
    "FAX": "408-555-0167",
    "EMAIL": "www.johnvalley.example.com",
    "CREDIT_LIMIT": 70001
  },
  {
    "CUSTOMER_ID": 5,
    "DISCOUNT_CODE": "N",
    "ZIP": "94401",
    "NAME": "Big Network Systems",
    "ADDRESSLINE1": "456 444th Street",
    "ADDRESSLINE2": "Suite 45",
    "CITY": "Redwood City",
    "STATE": "CA",
    "PHONE": "650-555-0181",
    "FAX": "650-555-0180",
    "EMAIL": "www.bignet.example.com",
    "CREDIT_LIMIT": 25000
  },
  {
    "CUSTOMER_ID": 6,
    "DISCOUNT_CODE": "L",
    "ZIP": "48128",
    "NAME": "West Valley Inc.",
    "ADDRESSLINE1": "88 Northsouth Drive",
    "ADDRESSLINE2": "Building C",
    "CITY": "Dearborn",
    "STATE": "MI",
    "PHONE": "313-555-0172",
    "FAX": "313-555-0171",
    "EMAIL": "www.westv.example.com",
    "CREDIT_LIMIT": 100000
  },
  {
    "CUSTOMER_ID": 7,
    "DISCOUNT_CODE": "N",
    "ZIP": "48128",
    "NAME": "Zed Motor Co",
    "ADDRESSLINE1": "2267 NE Michigan Ave",
    "ADDRESSLINE2": "Building 21",
    "CITY": "Dearborn",
    "STATE": "MI",
    "PHONE": "313-555-0151",
    "FAX": "313-555-0152",
    "EMAIL": "www.parts@ford.example.com",
    "CREDIT_LIMIT": 5000000
  },
  {
    "CUSTOMER_ID": 8,
    "DISCOUNT_CODE": "N",
    "ZIP": "48124",
    "NAME": "Big Car Parts",
    "ADDRESSLINE1": "52963 Notouter Dr",
    "ADDRESSLINE2": "Suite 35",
    "CITY": "Detroit",
    "STATE": "MI",
    "PHONE": "313-555-0144",
    "FAX": "313-555-0145",
    "EMAIL": "www.bparts.example.com",
    "CREDIT_LIMIT": 50000
  },
  {
    "CUSTOMER_ID": 9,
    "DISCOUNT_CODE": "H",
    "ZIP": "48128",
    "NAME": "Small Bill Company",
    "ADDRESSLINE1": "8585 South Upper Murray Drive",
    "ADDRESSLINE2": "P.O. Box 456",
    "CITY": "Alanta",
    "STATE": null,
    "PHONE": "555-555-0175",
    "FAX": "555-555-0176",
    "EMAIL": "www.smallbill.example.com",
    "CREDIT_LIMIT": null
  }
]


/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express', users: Users});
});
router.get('/crearUsuario', function(req, res, next) {
  res.render('crear', { title: 'Crear'});
});
router.post('/guardar', function(req, res) {
  var user;
  user.NAME = req.body.name;
  user.ID = req.get(id);
  Users.push(user);
});
module.exports = router;
