<template>
  <v-app>
    <v-toolbar app color="pink" dark>
      <v-toolbar-title class="headline text-uppercase">
        <span>TBD</span>
        <span class="font-weight-light">Actores</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
         <v-btn
         flat
        href="/"
      >
        <span class="mr-2">Inicio</span>
      </v-btn>
      <v-btn
        flat
        href="https://github.com/Hackasteroid142/TallerTBD"
        target="_blank"
      >
        <span class="mr-2">GitHub</span>
      </v-btn>
    </v-toolbar>  
    <v-content>
      <router-view></router-view>
    </v-content>
  </v-app>
</template>

<script>
import HelloWorld from './components/HelloWorld'

export default {
  name: 'App',
  components: {
    HelloWorld
  },
  data () {
    return {
      //
    }
  }
}
</script>
