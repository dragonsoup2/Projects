var MongoClient = require('mongodb').MongoClient;
var bcrypt = require('bcryptjs');
// Connect to the db
MongoClient.connect("mongodb://localhost:27017/loldb", function (err, db) {
         
 if (err) throw err;
 var pw = "dydrnr123";
 var accountinfo;
 var encrypting;

/*function gethash1(req, res, next) {
  gethash2(pw, function(result){
	  console.log(result);
	  res.send(result);
  }
}
function gethash2(pwd, callback){
    bcrypt.genSalt(10, function(err, salt) {
		bcrypt.hash(pwd, salt, function(err, hash) {
			callback(hash);
		});
	});
  };*/

function getsomedata(some_parameter_recieved, callback) {
			bcrypt.hash("dydrnr123", some_parameter_recieved, function(err, hash) {
			callback(hash);
		});
  }
  
var a = bcrypt.genSalt(10, function(req, res, next) {
  getsomedata(res, function(result) {
    console.log(result);
		var accountinfo = { lolusername: "dragonsoup2", username: "dragonsoup2", email: "dragonsoup2@hotmail.com", password: result}; 
		db.collection("account").insertOne(accountinfo, function(err, res) {
		if (err) throw err;
		console.log("1 document inserted");
		db.close();
	  });
  });
});

//console.log(a);

 /*var bcpw = function(saving){
		 bcrypt.genSalt(10, function(err, salt) {
		bcrypt.hash(pw, salt, function(err, hash, saving) {
			console.log(hash);
			return saving;
		});
	});
 };*/
//var encrypted = bcpw(encrypting);
//console.log(encrypted);

  /*var accountinfo = { lolusername: "dragonsoup2", username: "dragonsoup2", email: "dragonsoup2@hotmail.com", password: a}; 
  db.collection("account").insertOne(accountinfo, function(err, res) {
    if (err) throw err;
    console.log("1 document inserted");
    db.close();
  });*/
  /*db.collection("account").findOne({},function(err, res) {
    if (err) throw err;
	  bcrypt.compare(pw, res.password, function(err, resp) {
			if(resp)
				console.log("password match");
			else
			{
				
				console.log("not matching " + res.password);
			}
		});
    db.close();
  });*/
  /*var q = {lolusername: "dragonsoup2"}
    db.collection("account").deleteOne(q, function(err, res) {
    if (err) throw err;
	console.log("1 document deleted");
    db.close();
  });*/
});