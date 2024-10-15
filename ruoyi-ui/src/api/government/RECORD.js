import request from '@/utils/request'

// 查询地名备案列表
export function listRECORD(query) {
  return request({
    url: '/government/RECORD/list',
    method: 'get',
    params: query
  })
}

// 查询地名备案详细
export function getRECORD(recordId) {
  return request({
    url: '/government/RECORD/' + recordId,
    method: 'get'
  })
}

// 新增地名备案
export function addRECORD(data) {
  return request({
    url: '/government/RECORD',
    method: 'post',
    data: data
  })
}

// 修改地名备案
export function updateRECORD(data) {
  return request({
    url: '/government/RECORD',
    method: 'put',
    data: data
  })
}

// 删除地名备案
export function delRECORD(recordId) {
  return request({
    url: '/government/RECORD/' + recordId,
    method: 'delete'
  })
}
