import request from '@/utils/request'

// 查询月度账单列表
export function listMonth(query) {
  return request({
    url: '/local/month/list',
    method: 'get',
    params: query
  })
}

// 查询月度账单详细
export function getMonth(id) {
  return request({
    url: '/local/month/' + id,
    method: 'get'
  })
}

// 新增月度账单
export function addMonth(data) {
  return request({
    url: '/local/month',
    method: 'post',
    data: data
  })
}

// 修改月度账单
export function updateMonth(data) {
  return request({
    url: '/local/month',
    method: 'put',
    data: data
  })
}

// 删除月度账单
export function delMonth(id) {
  return request({
    url: '/local/month/' + id,
    method: 'delete'
  })
}
