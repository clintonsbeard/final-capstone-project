<template>
    <div class="registered-students">
        <table class="table dragArea">
            <thead>
                <tr>
                    <th>ID</th>
                </tr>
            </thead>
            <draggable v-model="approveDocsNew" :options="{group:'people'}" :element="'tbody'">
                <tr v-for="element in approveDocsNew" :key="" class="dragArea">
                    <td class="dragArea">{{element.document_id}}</td>
                </tr>
            </draggable>
        </table>
        <table class="table dragArea">
            <thead class="table">
                <tr>
                    <th>ID</th>
                </tr>
            </thead>
            <draggable v-model="forApprovalDocsNew" :options="{group:'people'}" :element="'tbody'">
                <tr v-for="element in forApprovalDocsNew" class="dragArea">
                    <td class="dragArea">{{element.document_id}}</td>
                </tr>
            </draggable>
        </table>
    </div>
</template>

<script>
    import draggable from 'vuedraggable'

    export default {
        components: {
            draggable
        },

        props: ['approvedDocs','forApprovalDocs'],

        data() {
            return {
                approveDocsNew: this.approvedDocs,
                forApprovalDocsNew: this.forApprovalDocs
            }
            
        },

        method: {

        }
    }
</script>

<style>
.dragArea {
  min-height: 10px;
}

</style>
