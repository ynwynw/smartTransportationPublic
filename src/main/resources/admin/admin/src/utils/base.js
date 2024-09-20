const base = {
    get() {
        return {
            url : "http://localhost:8080/smartTransportation/",
            name: "smartTransportation",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/smartTransportation/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于springboot的智能交通管理系统"
        } 
    }
}
export default base
