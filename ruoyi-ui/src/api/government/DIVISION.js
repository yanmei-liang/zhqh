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
        data
    })
}

// 导出级别类型
export function levelTypes(data) {
    return request({
        url: '/government/DIVISIONS/exportStatisticallevelList',
        method: "post",
        data
    })
}

// 删除行政区划
export function delDIVISION(divisionID) {
    return request({
        url: '/government/DIVISIONS/remove/' + divisionID,
        method: 'delete'
    })
}
// 统计级别  /government/DIVISIONS/selAdministrativeLevel/{administrativeDivisionCode}
export function selLevel(DivisionCode) {
    return request({
        url: '/government/DIVISIONS/selAdministrativeLevel/' + { administrativeDivisionCode },
        method: 'get'
    })
}

// 统计面积
export function selArea(administrativeDivisionCode) {
    return request({
        url: '/government/DIVISIONS/selAreaRadius/' + { administrativeDivisionCode },
        method: 'get'
    })
}