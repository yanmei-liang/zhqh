import request from '@/utils/request'

// 查询地名预审格列表
export function listINQUIRY(query) {
  return request({
    url: '/government/INQUIRY/list',
    method: 'get',
    params: query
  })
}

// 查询地名预审格详细
export function getINQUIRY(inquiryId) {
  return request({
    url: '/government/INQUIRY/' + inquiryId,
    method: 'get'
  })
}

// 新增地名预审格
export function addINQUIRY(data) {
  return request({
    url: '/government/INQUIRY',
    method: 'post',
    data: data
  })
}

// 修改地名预审格
export function updateINQUIRY(data) {
  return request({
    url: '/government/INQUIRY',
    method: 'put',
    data: data
  })
}

// 删除地名预审格
export function delINQUIRY(inquiryId) {
  return request({
    url: '/government/INQUIRY/' + inquiryId,
    method: 'delete'
  })
}
