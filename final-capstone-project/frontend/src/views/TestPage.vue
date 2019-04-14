<template>
    <div class="v-col--auto">
  <div class="panel">
      <div class="panel__heading">
        <h3>List {{listName}}</h3>
      </div>
      <div class="panel__body">
        <vddl-list class="panel__body--list" :list="list" :horizontal="false">
            <vddl-draggable class="panel__body--item" v-for="(item, index) in list" :key="item.id"
              :draggable="item"
              :index="index"
              :wrapper="list"
              effect-allowed="move">
              {{item.label}}
            </vddl-draggable>
            <vddl-placeholder class="red">Custom placeholder</vddl-placeholder>
        </vddl-list>
      </div>
  </div>
</div>
</template>

<script>
export default {
    data() {
        return {
            "lists": {
            "A": [
                {
                "id": 1,
                "label": "Item A1"
                },
                {
                "id": 2,
                "label": "Item A2"
                },
                //...
            ],
            "B": [
                //...
            ]
            }
        };
    }
}

</script>

<style>

</style>