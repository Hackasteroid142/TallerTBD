<template>
	<v-layout row>
    <v-flex xs12 sm6 offset-sm3>
      <v-card>
        <v-toolbar color="blue" dark>
          <v-toolbar-side-icon></v-toolbar-side-icon>
          <v-toolbar-title>Actores</v-toolbar-title>
          <v-spacer></v-spacer>

        </v-toolbar>
        <v-list two-line>
          <template v-for="(actor, index) in actors">
            <v-list-tile :key="index" avatar ripple @click="getFilms(actor)">
              <v-list-tile-content>
                <v-list-tile-title>{{ actor.firstName }} {{actor.lastName}}</v-list-tile-title>
              </v-list-tile-content>

            </v-list-tile>
            <v-divider v-if="index + 1 < actors.length" :key="`divider-${index}`"></v-divider>
          </template>
        </v-list>
      </v-card>
			<v-card>
				<v-toolbar color="pink" dark>
					<v-toolbar-side-icon></v-toolbar-side-icon>
					<v-toolbar-title>Peliculas</v-toolbar-title>
					<v-spacer></v-spacer>

				</v-toolbar>
				<v-list two-line>
					<template v-for="(film, index) in films">
						<v-list-tile :key="index" avatar ripple @click="">
							<v-list-tile-content>
								<v-list-tile-title>{{ film.title }}</v-list-tile-title>
							</v-list-tile-content>

						</v-list-tile>
						<v-divider v-if="index + 1 < actors.length" :key="`divider-${index}`"></v-divider>
					</template>
				</v-list>
			</v-card>
    </v-flex>
  </v-layout>

</template>
<!--<template>
	<div class="actors">
		<li v-for="actor in actors">{{ actor.firstName }} {{actor.lastName}}<button type="button" @click="getFilms(actor)">Click to submit</button></li>
		<AddActor/>
	</div>
</template>
-->
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
