<template>
	<div class="actors">
		<li v-for="actor in actors">{{ actor.firstName }}</li>
	</div>
</template>

<script>
	import axios from 'axios'

	export default {
		name: 'ListActors',
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

