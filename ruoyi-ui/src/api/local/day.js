import request from '@/utils/request'

// 查询日度账单列表
export function listDay(query) {
  return request({
    url: '/local/day/list',
    method: 'get',
    params: query
  })
}

// 查询日度账单详细
export function getDay(id) {
  return request({
    url: '/local/day/' + id,
    method: 'get'
  })
}

// 新增日度账单
export function addDay(data) {
  return request({
    url: '/local/day',
    method: 'post',
    data: data
  })
}

// 修改日度账单
export function updateDay(data) {
  return request({
    url: '/local/day',
    method: 'put',
    data: data
  })
}

// 删除日度账单
export function delDay(id) {
  return request({
    url: '/local/day/' + id,
    method: 'delete'
  })
}
