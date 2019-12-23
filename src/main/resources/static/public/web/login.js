new Vue({
  el: '#app',
  data: {
	  userAccount: 'wl',
	  userPwd: '123456',
  },methods:{
  	sayHai:function(){
  		document.write("你好！xx"); 
        //发送get请求
        this.$http.get('/login').then(function(res){
            //document.write(res.body);    
            console.log(res);
        },function(){
            console.log('请求失败处理');
        });
    }
}
})