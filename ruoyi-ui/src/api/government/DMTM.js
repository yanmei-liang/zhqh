import request from '@/utils/request'

// 查询通名管理列表
export function listDMTM(query) {
  return request({
    url: '/government/DMTM/list',
    method: 'get',
    params: query
  })
}

// 查询通名管理详细
export function getDMTM(Id) {
  return request({
    url: '/government/DMTM/' + Id,
    method: 'get'
  })
}

// 新增通名管理
export function addDMTM(data) {
  return request({
    url: '/government/DMTM',
    method: 'post',
    data: data
  })
}

// 修改通名管理
export function updateDMTM(data) {
  return request({
    url: '/government/DMTM',
    method: 'put',
    data: data
  })
}

// 删除通名管理
export function delDMTM(Id) {
  return request({
    url: '/government/DMTM/' + Id,
    method: 'delete'
  })
}
