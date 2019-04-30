<template>
	<div class="AddActor">
		<h1>HOLA</h1>
		<input type="text" class="form-control" v-model="firstName">
		<input type="text" class="form-control" v-model="lastName">
		<button type="button" @click="onSubmit">Click to submit</button>
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

</script>