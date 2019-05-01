<template>
	<div class="AddActor">
		<v-layout justify-center>
    <v-flex xs12 sm10 md8 lg6>
      <v-card ref="form">
				<h2>Añadir actor</h2>
        <v-card-text>
          <v-text-field
            ref="nombre"
            v-model="firstName"
            :rules="[() => !!nombre || 'Este campo es requerido']"
            :error-messages="errorMessages"
            label="Nombre"
            placeholder="Will"
            required
          ></v-text-field>
					<v-text-field
            ref="apellido"
            v-model="lastName"
            :rules="[() => !!apellido || 'Este campo es requerido']"
            :error-messages="errorMessages"
            label="Apellido"
            placeholder="Smith"
            required
          ></v-text-field>
        </v-card-text>
        <v-card-actions>
          <v-btn color="primary" style="margin:auto" flat @click="onSubmit">Agregar Actor</v-btn>
        </v-card-actions>
      </v-card>
    </v-flex>
  </v-layout>
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
					location.reload();
				});
			}
			}
		}
	}

</script>
