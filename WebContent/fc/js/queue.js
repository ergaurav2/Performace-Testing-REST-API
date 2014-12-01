//code.stephenmorley.org
function Queue(){var a=[],b=0;
this.getLength=function(){return a.length-b};
this.isEmpty=function(){return 0==a.length};
this.enqueue=function(b){a.push(b)};
this.dequeue=function(){if(0!=a.length){var c=a[b];2*++b>=a.length&&(a=a.slice(b),b=0);return c}};
this.peek=function(){return 0<a.length?a[b]:void 0}
this.getAll=function(){var data="";
	if(0!=a.length){
		for (var i = b;i<a.length; i++) {
			//alert(a[i]);
		    data=data+a[i]+","; 
		}
		return data.substring(0, data.length - 1);;
        }
}
};
