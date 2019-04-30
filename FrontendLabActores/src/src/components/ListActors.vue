<template>
	<div class="actors">
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
				actors: []
			};
		},
		created(){
			axios.get('http://localhost:8081/actors').
			then( response => {
				this.actors = response.data;
				});
		}
	}

</script>

