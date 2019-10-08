var express = require('express');
var request = require('request');
var app = express();
const querystring = require('querystring');
const bodyParser = require('body-parser');
var port = process.env.PORT || 3001;

app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

app.get('/', function (req, res) {
    let type = req.query.type;
    let value = req.query.value;
console.log(type)
    request('https://api.exchangeratesapi.io/latest?base=USD&symbols='+type , function(error, response,body){
        currency_json = JSON.parse(body);
        var result = Number(currency_json.rates[`${type}`]) * Number(value);
        //console.log(Number(currency_json.rates[`${type}`]) * Number(value));
        res.send(String(result));

    })
  })

app.listen(port, function() {
   console.log('Server started on port: ' + port);
});