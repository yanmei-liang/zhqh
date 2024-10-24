import request from '@/utils/request'

// 查询推送记录列表
export function listTSJL(query) {
  return request({
    url: '/government/TSJL/list',
    method: 'get',
    params: query
  })
}

// 查询推送记录详细
export function getTSJL(tsjlId) {
  return request({
    url: '/government/TSJL/' + tsjlId,
    method: 'get'
  })
}

// 新增推送记录
export function addTSJL(data) {
  return request({
    url: '/government/TSJL',
    method: 'post',
    data: data
  })
}

// 修改推送记录
export function updateTSJL(data) {
  return request({
    url: '/government/TSJL',
    method: 'put',
    data: data
  })
}

// 删除推送记录
export function delTSJL(tsjlId) {
  return request({
    url: '/government/TSJL/' + tsjlId,
    method: 'delete'
  })
}
