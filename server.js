var express = require('express');
var app=express();
var to_remember

var server = app.listen(3000);
app.use(express.static(__dirname));
/* app.get('', function(req, res){

}) */
app.get('/hello', function(req, res){
  res.json({"hello": "world"})
})

app.get('/memory', function(req, res){
  to_remember = req.query.remember_me
  res.send(to_remember)
})

app.get('/memory_check', function(req, res){
  res.send(to_remember)
})
console.log("Server started!")
console.log("http://127.0.0.1:3000");