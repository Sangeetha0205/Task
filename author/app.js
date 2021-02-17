var express = require("express");  
var mongo = require("mongoose");   
var bodyParser = require('body-parser');   
var db = require("./config.js");  

var app = express();  
var port = process.env.port || 9000;    
app.use(bodyParser.json({limit:'5mb'}));    
app.use(bodyParser.urlencoded({extended:true, limit:'5mb'}));  

var mongoose = require('mongoose');  
var Schema = mongoose.Schema;  
var BookInfoSchema = new Schema({      
    name: { type: String, unique: true},       
    author: { type: String },     
    published_date: { type: Date},   
       
    price: { type: Number },
    quantity: {type: Number},       
},{ versionKey: false });  



var model = mongoose.model('BookInfo', BookInfoSchema, 'BookInfo');  
  
//api for Insert data from database  
app.post("/api/savebook",function(req,res){   
       var mod = new model(req.body);  
        mod.save(function(err,data)
        {  
            if(err){  
                res.send(err);                
            }  
            else{        
                 res.send({Data:"Book details have been Inserted..!!"});  
            }  
            });  
}) 

app.post("/api/saveBookDetails/:id",function(req,res){   
    model.findOne({ _id: req.params.id }, function(err,data) {  
               if(err){  
                   res.send(err);  
               }  
               else{    
                      res.send({Data:"Already exists"});             
                  }  
           });  
   })  

  
//api for get data from database  
app.get("/api/getallBooks",function(req,res){   
    model.find({},function(err,data){  
               if(err){  
                   res.send(err);  
               }  
               else{             
                   res.send(data);  
                   }  
           });  
   })  
     
   
app.get("/api/getBookDetails/:id",function(req,res){   
    model.find({ _id: req.params.id }, function(err,data) {  
               if(err){  
                   res.send(err);  
               }  
               else{    
                      res.send(data);             
                  }  
           });  
   })  


   //api for Delete data from database  
   app.delete("/api/removeBook/:id",function(req,res){   
    model.deleteOne({ _id: req.params.id }, function(err) {  
               if(err){  
                   res.send(err);  
               }  
               else{    
                      res.send({Data:"Book details have been Deleted..!!"});             
                  }  
           });  
   })  
     
     
   //api for Update data from database  
   app.put('/api/updateBookdetails/:id', function(req, res) {
       var userToUpdate = req.params.id;
       if(!(req.body.name && req.body.author))
        {
             model.updateOne({ _id: userToUpdate},req.body , function (err, result) {
             res.send(
               (err === null) ? {Data: 'Details updated successfully!!'} : {msg: err}
           );
         });
        }
       else
        {
           res.send( {Data: 'cannot upadated!!'});
        }
    
   });
   
        
    //server stat on given port  
   app.listen(port,function(){   
       console.log("server start on port"+ port);  
   })

