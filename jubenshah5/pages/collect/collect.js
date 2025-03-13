// pages/collect/collect.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    jb_cs:[]
  },

  goback: function() {
    wx.navigateBack({
      delta: 1, // 返回的页面数，如果 delta 大于现有页面数，则返回到首页
    });
  },

  fetchCs: function () {
    const that = this;
    wx.request({
      url: 'http://127.0.0.1:8080/show_all_sc',
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
          jb_cs: res.data
      });
      console.log(this.data.jb_cs)
      },
    });
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
  this.fetchCs();
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