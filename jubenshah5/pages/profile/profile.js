// pages/profile/profile.js
const app = getApp();
Page({
  data: {
    userId:'',
    userName:'',
    userInfo: {
      avatarUrl: '/assets/images/avatar.png'
    }
  },


  gologin(){
    wx.navigateTo({
      url: '/pages/login/login',
    })
  },
  callShop() {
    wx.makePhoneCall({
      phoneNumber: '123456789' // 替换为真实电话
    });
  },
  yqyl: function() {
    wx.showModal({
      title: '提示',
      content: '活动还未开始，敬请期待......',
      showCancel: false, // 不显示取消按钮
      confirmText: "确定", // 确认按钮的文字
      success: function(res) {
        if (res.confirm) {
          console.log('用户点击了确定');
          // 这里可以写用户点击确定后要执行的操作
        }
      }
    });
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    this.setData({
      userId: app.globalData.userId,
      userName: app.globalData.userName
  });
  console.log(this.data.userId);
  console.log(this.data.userName);
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