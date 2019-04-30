<template>
	<div class="AddActor">
		
		<h1>Añadir actor</h1>
		<input type="text" class="form-control" v-model="firstName">
		<input type="text" class="form-control" v-model="lastName">
		<v-btn color="success" style="margin: auto; display: block;" @click="onSubmit">Enviar</v-btn >

	</div>
</template>	

<script>
	import axios from 'axios'
	export default{
		name: 'AddActor',

		data () {
			return {
				firstName: '',
				lastName: ''
			};
		},
		methods: {
			onSubmit(){
				if(this.firstName.length>2 && this.lastName.length>2){
				axios.post('http://localhost:8081/actors/create',
					{firstName: this.firstName, 
					lastName: this.lastName
				}).
				then(response =>{
					console.log(response.data);
                	this.firstName = '';
                	this.lastName = '';
				});
			}
			}
		}
	}

</script>