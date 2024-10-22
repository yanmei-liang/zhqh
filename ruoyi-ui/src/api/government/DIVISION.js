import request from '@/utils/request'
// 获取用户列表
export function listDIVISION(data) {
    return request({
        url: '/government/DIVISIONS/list',
        method: 'get',
        data: data
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

// 导出级别类型
export function levelTypes(data) {
    return request({
        url: '/government​/DIVISIONS​/exportStatisticallevelList',
        method: "post",
        data: data
    })
}