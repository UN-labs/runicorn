var express = require('express');
var app=express();

var server = app.listen(3000);
app.use(express.static(__dirname));

console.log("Server started!")
console.log("http://127.0.0.1:3000");