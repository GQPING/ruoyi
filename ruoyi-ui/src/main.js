import Vue from 'vue'

import Cookies from 'js-cookie'

import Element from 'element-ui'
import './assets/styles/element-variables.scss'

import '@/assets/styles/index.scss' // global css
import '@/assets/styles/ruoyi.scss' // ruoyi css
import App from './App'
import store from './store'
import router from './router'
import directive from './directive' // directive
import plugins from './plugins' // plugins
import { download } from '@/utils/request'

import './assets/icons' // icon
import './permission' // permission control
import { getDicts } from "@/api/system/dict/data";
import { getConfigKey } from "@/api/system/config";
import { parseTime, resetForm, addDateRange, selectDictLabel, selectDictLabels, handleTree } from "@/utils/ruoyi";

// 全局修改默认配置，点击空白处不能关闭弹窗
// Element.Dialog.props.closeOnClickModal.default = false
// 全局修改element默认配置
// Element.TableColumn.props.showOverflowTooltip = { type: Boolean, default: true }

// 分页组件
import Pagination from "@/components/Pagination";
// 自定义表格工具组件
import RightToolbar from "@/components/RightToolbar"
// 富文本组件
import Editor from "@/components/Editor"
// 文件上传组件
import FileUpload from "@/components/FileUpload"
// 图片上传组件
import ImageUpload from "@/components/ImageUpload"
// 图片预览组件
import ImagePreview from "@/components/ImagePreview"
// 字典标签组件
import DictTag from '@/components/DictTag'
// 头部标签组件
import VueMeta from 'vue-meta'
// 字典数据组件
import DictData from '@/components/DictData'

// 全局方法挂载
Vue.prototype.getDicts = getDicts
Vue.prototype.getConfigKey = getConfigKey
Vue.prototype.parseTime = parseTime
Vue.prototype.resetForm = resetForm
Vue.prototype.addDateRange = addDateRange
Vue.prototype.selectDictLabel = selectDictLabel
Vue.prototype.selectDictLabels = selectDictLabels
Vue.prototype.download = download
Vue.prototype.handleTree = handleTree

// 全局组件挂载
Vue.component('DictTag', DictTag)
Vue.component('Pagination', Pagination)
Vue.component('RightToolbar', RightToolbar)
Vue.component('Editor', Editor)
Vue.component('FileUpload', FileUpload)
Vue.component('ImageUpload', ImageUpload)
Vue.component('ImagePreview', ImagePreview)

Vue.use(directive)
Vue.use(plugins)
Vue.use(VueMeta)
DictData.install()

// 百度地图插件
import VueAMap from 'vue-amap'
Vue.use(VueAMap)
VueAMap.initAMapApiLoader({
  key: '485b10bb92fe21c2750391e35774c18b',
  plugin: [
    "AMap.Autocomplete", // 输入提示插件
    "AMap.PlaceSearch", // POI搜索插件
    "AMap.Scale", // 右下角缩略图插件 比例尺
    "AMap.OverView", // 地图鹰眼插件
    "AMap.ToolBar", // 地图工具条
    "AMap.MapType", // 类别切换控件，实现默认图层与卫星图、实施交通图层之间切换的控制
    "AMap.PolyEditor", // 编辑 折线多，边形
    "AMap.CircleEditor", // 圆形编辑器插件
    "AMap.Geolocation", // 定位控件，用来获取和展示用户主机所在的经纬度位置,
    "AMap.Geocoder"
  ],
  v: '1.4.4'
});

// 自适应表格插件
import AFTableColumn from 'af-table-column'
Vue.use(AFTableColumn)

// mathjs精确计算插件
import * as math from 'mathjs'
Vue.prototype.$math = math

// 时间格式化组件
import moment from 'moment'
Vue.prototype.moment = moment;
Vue.use(moment)

// jquery组件
Vue.prototype.jquery = $

// 成功提示
Vue.prototype.msgSuccess = function (msg) {
  this.$message({ showClose: true, message: msg, type: "success" })
}

// 错误提示
Vue.prototype.msgError = function (msg) {
  this.$message({ showClose: true, message: msg, type: "error" })
}

// 信息提示
Vue.prototype.msgInfo = function (msg) {
  this.$message.info(msg)
}

/**
 * If you don't want to use mock-server
 * you want to use MockJs for mock api
 * you can execute: mockXHR()
 *
 * Currently MockJs will be used in the production environment,
 * please remove it before going online! ! !
 */

Vue.use(Element, {
  size: Cookies.get('size') || 'medium' // set element-ui default size
})

Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})
