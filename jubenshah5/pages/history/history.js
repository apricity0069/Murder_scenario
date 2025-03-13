// pages/history/history.js
const app = getApp();
Page({
  data: {
    jbs_history: []
  },

  onLoad(){
    this.fetchHistory();
  },

  fetchHistory: function () {
    const that = this;
    wx.request({
      url: 'http://127.0.0.1:8080/show_all_yy_dd',
      method: 'GET',
      header: {
        'Content-Type': 'application/x-www-form-urlencoded' // 或 'application/json'
      },
      data: {
        userId: app.globalData.userId
      },
      success: (res) =>{
        console.log(res)
        this.setData({
          jbs_history: res.data
      });
      console.log(this.data.jbs_history)
      },
    });
  },


  goback: function() {
    wx.navigateBack({
      delta: 1, // 返回的页面数，如果 delta 大于现有页面数，则返回到首页
    });
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