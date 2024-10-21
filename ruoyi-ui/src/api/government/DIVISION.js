import request from '@/utils/request'
// 获取用户列表
export function listDIVISION(query) {
    return request({
        url: '/government/DIVISIONS/list',
        method: 'get',
        params: query
    })
}

// 面积统计
export function mapStatistics(data) {
    return request({
        url: "",
        method: 'post',
        data: data
    })
}