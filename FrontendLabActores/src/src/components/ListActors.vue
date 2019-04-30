<template>
	<div class="actors">
		<li v-for="actor in actors">{{ actor.id }} <button type="button" @click="getFilms(actor)">Click to submit</button></li>	
		<li v-for="actor in actors">{{ actor.firstName }} {{actor.lastName}}</li>
		<AddActor/>
	</div>
</template>

<script>
	import axios from 'axios'
	import AddActor from './AddActor.vue'

	export default {
		name: 'ListActors',

		components:{
			AddActor
		},


		data() {
			return {
				actors: [],
				films: [],
				actor: '',
				idActor: ''
			};
		},
		created(){
			axios.get('http://localhost:8081/actors').
			then( response => {
				this.actors = response.data;
				});
		},
		methods: {
			getFilms(actor){ 
				console.log(actor.id);
				axios.get('http://localhost:8081/actors/'+ actor.id + '/films').
				then( response => {
					this.films = response.data;
					console.log(this.films);
				});
			}
		}
	}

</script>

