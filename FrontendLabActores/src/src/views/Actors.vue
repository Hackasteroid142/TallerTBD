<template>
    <div class="container">
    <ListActors/>
    </div>
</template>

<script>
import ListActors from '@/components/ListActors.vue'
export default {
    name: 'Actors',
    components: {
        ListActors
    }
}
</script>