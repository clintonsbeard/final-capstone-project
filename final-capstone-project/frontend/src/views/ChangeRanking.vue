<template>
    <div class="change-ranking">
        <div class="container-fluid">
            <div class="jumbotron">
                <h3>Change Ranking System</h3>
                <hr>
                <form v-on:submit.prevent="changeRanking()">
                    <h4>Rank Top Four Employers</h4>
                    <p>With this option, students will only be able to rank their top <strong>four</strong> employers.
                    <br>
                    <small class="text-muted"><em>NOTE: This is the default option.</em></small>
                    </p>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="rankingChoice" id="rankingChoice1" value="false" v-model="ranking.choice" checked>
                        <label class="form-check-label" for="rankingChoice1">
                            Choose Top Four Employers Ranking System
                        </label>
                    </div>
                    <p></p>
                    <h4>Rank All Employers</h4>
                    <p>With this option, students will be able to rank <strong>all</strong> potential employers.</p>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="rankingChoice" id="rankingChoice2" v-model="ranking.choice" value="true">
                        <label class="form-check-label" for="rankingChoice2">
                            Choose Rank All Employers Ranking System
                        </label>
                    </div>
                    <p></p>
                    <button type="submit" class="btn btn-primary btn-custom">Submit</button>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
import auth from '../auth';

export default {
    name: 'rankingChoice',
    data () {
        return {
            ranking: {
                choice: ''
            }
        }
    },
    methods: {
        changeRanking() {
            fetch(`${process.env.VUE_APP_API_URL}/toggleRankingChoice`,  {
            method: 'PUT',
            headers: new Headers({
                "Authorization": 'Bearer ' + auth.getToken(),
                "Content-Type": "application/json"
            }),
            body: JSON.stringify(this.ranking),
            credentials: 'same-origin'
            })
            .then((response) => {
                this.$router.push('/student-form');
            })
        }
    }
}
</script>
