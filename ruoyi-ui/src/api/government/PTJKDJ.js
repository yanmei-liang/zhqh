import request from '@/utils/request'

// 查询平台接口对接模块列表
export function listPTJKDJ(query) {
  return request({
    url: '/government/PTJKDJ/list',
    method: 'get',
    params: query
  })
}

// 查询平台接口对接模块详细
export function getPTJKDJ(ID) {
  return request({
    url: '/government/PTJKDJ/' + ID,
    method: 'get'
  })
}

// 新增平台接口对接模块
export function addPTJKDJ(data) {
  return request({
    url: '/government/PTJKDJ',
    method: 'post',
    data: data
  })
}

// 修改平台接口对接模块
export function updatePTJKDJ(data) {
  return request({
    url: '/government/PTJKDJ',
    method: 'put',
    data: data
  })
}

// 删除平台接口对接模块
export function delPTJKDJ(ID) {
  return request({
    url: '/government/PTJKDJ/' + ID,
    method: 'delete'
  })
}
