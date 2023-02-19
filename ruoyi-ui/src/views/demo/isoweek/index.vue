<template>
  <div class="app-container">
    <span id="currentWeekly">
       <el-date-picker v-model='dataStart' size="small" :clearable='false' :format='dateFormat'
          type="week"></el-date-picker>
    </span>
  </div>
</template>
<script>
const nowWeek = new Date();
export default {
  name: "isoweek",
  data() {
    return {
      pickerOptions2:{
        firstDayOfWeek:1,
      },
      dataStart: nowWeek,
    };
  },
  mounted(){
    this.$nextTick(() => {
      //初始显示当前时间非ISOWEEK周数
      $('#currentWeekly input').val(this.moment().isoWeekYear() + '第' + this.moment(nowWeek).week() + '周')
      console.log($('#currentWeekly input').val())
    })
  },
  computed: {
    dateFormat: function (day) {
      return 'yyyy[第]WW[周]';
    },
  },
  watch: {
    dataStart(newVal, oldVal) {
      //change事件中获取date-picker值
      this.$nextTick(() => {
        //获取当前非ISOWEEK周数
        $('#currentWeekly input').val(this.moment().isoWeekYear() + '第' + this.moment(newVal).week() + '周')
        console.log(this.dataStart)
        console.log($('#currentWeekly input').val())
      })
    },
  },
  methods: {

  }
};
</script>

<style lang="scss" scoped>

</style>
