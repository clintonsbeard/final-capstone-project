<template>
    <div class="view-schedule">

    </div>
</template>

<script>
export default {

    data() {
        return{
            schedule: []
        }
    },
    created() {
        fetch(`${process.env.VUE_APP_API_URL}/getFinalSchedule/${this.$route.params.scheduleChoice}`, {
        }).then( (response) => {
            return response.json();
        }).then ( (data) => {
            console.table(data);
            this.schedule = data;
        })
    }
}
</script>