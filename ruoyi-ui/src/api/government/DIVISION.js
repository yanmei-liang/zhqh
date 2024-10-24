import request from '@/utils/request'
// 获取用户列表
export function listDIVISION(query) {
    return request({
        url: '/government/DIVISIONS/list',
        method: 'get',
        params: query
    })
}

// 导出面积统计
export function mapStatistics(data) {
    return request({
        url: "/government/DIVISIONS/exportselAreaRadius",
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
// 导出行政区划列表  /government/DIVISIONS/export
export function listExport(data) {
    return request({
        url: '/government/DIVISIONS/export',
        method: 'post',
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

// 行政级别下拉框  
export function optionsList() {
    return request({
        url: '/government/DIVISIONS/selStatisticallevel',
        method: 'get'
    })
}

// 新增行政区划
export function addDivision(data) {
    return request({
        url: "/government/DIVISIONS/addAdministrativeDivisions",
        method: "post",
        data
    })
}

// 统计级别  
export function selLevel(administrativeDivisionCode) {
    return request({
        url: '/government/DIVISIONS/selAdministrativeLevel/' + administrativeDivisionCode,
        method: 'get'
    })
}

// 统计面积
export function selArea(administrativeDivisionCode) {
    return request({
        url: '/government/DIVISIONS/selAreaRadius/' + administrativeDivisionCode,
        method: 'get'
    })
}