function validate(){
    if( document.getElementById( "user" ).value  ){
        return true;
    }
    else{
        document.getElementById("x").innerHTML="please dont behave like a stupid" ;
        document.getElementById("x").style.color = "red";
        return false ;
    }
}
function doit1(){
	//window.alert(document.getElementByName( "name" ).value);
	console.log(5+2)
    var flag=  0 ;
    var xx = document.getElementById( "name" ).value ;
    var yy = document.getElementById( "qoh" ).value;
    var zz = document.getElementById( "price" ).value ;
    console.log("name" + xx) ;
    console.log("qoh"+yy) ;
    console.log("price"+zz) ;
    
    if( (document.getElementById( "name" ).value) ===''  ){
        flag=1;
    	document.getElementById("print").innerHTML = "fill name";
    }
    if( isNaN(document.getElementById( "qoh" ).value) || yy==='' ){
        flag=1;
    	document.getElementById("print").innerHTML = "fill qohg";
    }
    if( isNaN(document.getElementById( "price" ).value)  ){
        flag=1;
    	document.getElementById("print").innerHTML = "fill price";
    }
    
    if(flag)
    	return false ;
    return true ;
}
console.log('hello my name is abhijeet');
var a = 'hello';
function b(){
    console.log('inside function ');
}

b();
console.log(a) ;
//console.log(c) ; not work 
// but when we do console.log(d) and d is defined below
// it will show undefined .. called hoysting 
console.log(b); // even can call before defining it 
console.log(b()); // method executed 

var xx = 8 ;
function d(){
    console.log(xx) ;
}
d();
var varcontainingfunc = d ;
varcontainingfunc();
function e(){
    var temp =2 ;
    function f(){
        console.log(a);
        console.log(temp) ;
        var aa ;
        if( aa ){
            console.log('it exists');
        }
        else{
            console.log('treated false ');
        }
    }
    
    f();
}
var myfunc =e ;
//myfunc();
//e().f();// not works 
function tgg(param1){
    console.log(param1);
}
tgg("hero");
tgg();