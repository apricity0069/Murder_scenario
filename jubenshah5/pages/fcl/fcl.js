// pages/fcl/fcl.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    scriptList: [],
    jjyyidList:[],
    isshowjr:[],
  },

  showAllJbYy: function() {
    wx.request({
        url: 'http://127.0.0.1:8080/show_all_yying_jb',
        method: 'POST',
        header: {
            'Content-Type': 'application/x-www-form-urlencoded' // 或 'application/json'
        },
        success: (res) => {
            console.log(res.data);
            // 假设 res.data 是一个数组，其中每个元素都有 jb_yy_id 属性
            const scriptList = res.data;
            // 提取 jb_yy_id
            const jjyyidList = scriptList.map(item => item.jb_yy_id);
            // 设置状态
            this.setData({
                scriptList: scriptList,
                jjyyidList: jjyyidList
            });

            // 这里进行第二个请求
            const requests = jjyyidList.map(jbYyId => {
                return new Promise((resolve, reject) => {
                  console.log(jbYyId)
                  console.log(app.globalData.userId)
                    wx.request({
                        url: 'http://127.0.0.1:8080/is_show_jaru',
                        method: 'POST',
                        header: {
                            'Content-Type': 'application/x-www-form-urlencoded' // 或 'application/json'
                        },
                        data: {
                            userId: app.globalData.userId,
                            jbYyId: jbYyId
                        },
                        success: (res) => {
                            console.log(res.data);
                            resolve(res.data); // 将返回的数据传递给 Promise
                        },
                        fail: (error) => {
                            reject(error); // 处理请求失败
                        }
                    });
                });
            });

            // 使用 Promise.all 处理所有请求
            Promise.all(requests)
                .then(results => {
                    // 所有请求完成后，results 将包含所有返回的数据
                    this.setData({
                        isshowjr: results // 存储结果到 isshowjr
                    });
                    console.log(this.data.isshowjr); // 这里可以正常访问
                })
                .catch(error => {
                    console.error('请求出错:', error); // 处理错误
                });
        },
    });
},


goback: function() {
  wx.navigateBack({
    delta: 1, // 返回的页面数，如果 delta 大于现有页面数，则返回到首页
  });
},
  jiaqu:function(e){
    const jbId=e.currentTarget.dataset.jbId;
    const jbYyId = e.currentTarget.dataset.jbYyId; 
    const isjoq = e.currentTarget.dataset.isjoq;
    console.log(isjoq)
    if(isjoq==0){
      wx.request({
        url: 'http://127.0.0.1:8080/update_jb_yy_num', 
        method: 'POST',
        header: {
          'Content-Type': 'application/x-www-form-urlencoded' // 或 'application/json'
        },
        data:{
          userId:app.globalData.userId,
          jbId:jbId,
          jbYyId: jbYyId // 发送请求时携带 jb_yy_id
        },
        success: (res) => {
          console.log(res.data);
          this.showAllJbYy();
        }
      })
    }else{
      wx.request({
        url: 'http://127.0.0.1:8080/delete_yy', 
        method: 'POST',
        header: {
          'Content-Type': 'application/x-www-form-urlencoded' // 或 'application/json'
        },
        data:{
          userId:app.globalData.userId,
          jbYyId: jbYyId // 发送请求时携带 jb_yy_id
        },
        success: (res) => {
          console.log(res.data);
          this.showAllJbYy();
        }
      })
    }
    
    
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    this.showAllJbYy();
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  }
})
