import request from '@/utils/request'

// 查询年度账单列表
export function listYear(query) {
  return request({
    url: '/local/year/list',
    method: 'get',
    params: query
  })
}

// 查询年度账单详细
export function getYear(id) {
  return request({
    url: '/local/year/' + id,
    method: 'get'
  })
}

// 新增年度账单
export function addYear(data) {
  return request({
    url: '/local/year',
    method: 'post',
    data: data
  })
}

// 修改年度账单
export function updateYear(data) {
  return request({
    url: '/local/year',
    method: 'put',
    data: data
  })
}

// 删除年度账单
export function delYear(id) {
  return request({
    url: '/local/year/' + id,
    method: 'delete'
  })
}
