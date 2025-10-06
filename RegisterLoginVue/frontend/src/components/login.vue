<template>

    <div class="row">
    
    <div class="col-sm-4" >
     <h2 align="center"> Login</h2>
   
     <form @submit.prevent="LoginData">
     
   
     <div class="form-group" align="left">
       <label>Email</label>
       <input type="email" v-model="employee.email" class="form-control"  placeholder="Email">
     </div>


    <div class="form-group" align="left">
    <label>Password</label>
    <input type="password" v-model="employee.password" class="form-control"  placeholder="Password">
  </div>
  <br/>

     <button type="submit" class="btn btn-primary">Login</button>
     </form>
   </div>
   </div>

</template>
   
   <script>
       import Vue from 'vue';
       import axios from 'axios';
   
     Vue.use(axios)
     export default {
       name: 'Registation',
       data () {
         return {
           result: {},
           employee:{
                      email: '',
                      password: ''
           }
         }
       },
       created() { 
       },
       mounted() {
             console.log("mounted() called.......");
         },
       methods: {
              LoginData()
              {
               axios.post("http://localhost:8085/api/v1/employee/login", this.employee)
               .then(
                 ({data})=>{
                  console.log(data);
                  try {
                  if (data.message === "Email not exits") 
                      {
                       alert("Email not exits");
                       
                        }
                         else if(data.message == "Login Success")
                        {
                       
                         this.$router.push({ name: 'Home' })
                        }
                         else 
                        { 
                            alert("Incorrect Email and Password not match");
                        }

                        } catch (err) {
                        alert("Error, please try again");
                        }    
                 }
               )
              }
         }
     }
     </script>