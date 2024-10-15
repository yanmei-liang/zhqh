import request from '@/utils/request'

// 查询地名申报列表
export function listDECLARE(query) {
  return request({
    url: '/government/DECLARE/list',
    method: 'get',
    params: query
  })
}

// 查询地名申报详细
export function getDECLARE(declareId) {
  return request({
    url: '/government/DECLARE/' + declareId,
    method: 'get'
  })
}

// 新增地名申报
export function addDECLARE(data) {
  return request({
    url: '/government/DECLARE',
    method: 'post',
    data: data
  })
}

// 修改地名申报
export function updateDECLARE(data) {
  return request({
    url: '/government/DECLARE',
    method: 'put',
    data: data
  })
}

// 删除地名申报
export function delDECLARE(declareId) {
  return request({
    url: '/government/DECLARE/' + declareId,
    method: 'delete'
  })
}
