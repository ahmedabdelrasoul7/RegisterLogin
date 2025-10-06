<template>
    <div class="card" align="left">
         <div class="card-header">Register Form</div>
         <div class="card-body"> 
         
             <form  @submit.prevent="saveData">
             
             <label>Employee Name</label>
             <input type="text" v-model="employee.employeename" name="employeename" id="employeename" class ="form-control"/> 
 
       
             <label>Email</label>
             <input type="email" v-model="employee.email" name="email" id="email" class ="form-control"/>
 
             <label>Password</label>
             <input type="password" v-model="employee.password" name="password" id="password" class ="form-control"/> 
 
 
             <input type="submit" value="Save" class="btn btn-success"> 
 
 
             </form>
         </div>
     </div>
</template>

<script>
        import Vue from 'vue';
        import axios from 'axios';
        Vue.use(axios)

      export default {
        name: 'Register',
        data () {
          return {
            result: {},
            employee:{
                       employeename: '',
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
               saveData()
               {
                axios.post("http://localhost:8085/api/v1/employee/save", this.employee)
                .then(
                  ({data})=>{
                   console.log(data);
                    try 
                      {
                         alert("Employee Registation Successfully");
                         
                       } 
                   catch(err) 
                       {
                         alert("failed");
                       }    
                  }
                )
               }
          }
      }
      </script>