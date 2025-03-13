// pages/detail/detail.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    is_sc:0,
    jb_name: '',
        jb_tag: '',
        jb_num: '',
        jb_nd: '',
        jb_price: '',
        jb_jj: '',
        jb_id: '',
        jb_wz:'',
    summaryVisible: false, // 控制剧情简介的展开和收起
    currentBookIndex: 0, // 当前剧本推荐索引
    currentZCIndex: 0, // 当前主创索引
    rooms: [
      {  image: "https://wx3.sinaimg.cn/orj360/e60238a1gy1hv133v8bwcj20u0159b29.jpg",name: "连环杀人事件" },
      { image: "https://wx1.sinaimg.cn/orj360/e60238a1gy1hv133t4p5jj20b40fq0v7.jpg", name: "反派修正计划" },
      { image: "https://wx1.sinaimg.cn/orj360/e60238a1gy1hv133tvtedj20m80uk7gl.jpg",name: "余光千百遍" },
      {  image: "https://wx4.sinaimg.cn/orj360/e60238a1gy1hv133xcfctj20gg0nx441.jpg",name: "烟云南渡" },
      { image: "https://wx2.sinaimg.cn/orj360/e60238a1gy1hv133wyxphj21yv2rf1kz.jpg" ,name: "待君归2"}
    ],
    dms: [
      { name: "柯南", image: "https://ts2.cn.mm.bing.net/th?id=OIP.zrt3LQE-UhLRZIWH_Pq4eAAAAA&w=195&h=300&c=10&rs=1&qlt=99&bgcl=fffffe&r=0&o=6&dpr=1.4&pid=MultiSMRSV2Source" },
      { name: "毛利兰", image: "https://c-ssl.duitang.com/uploads/item/202002/22/20200222111756_cfpnq.jpg" },
      { name: "灰原哀", image: "https://pic4.zhimg.com/v2-f1b13f11d7d74725153a9df1d96879b5_r.jpg?source=1940ef5c" }
    ],
    scriptList: [
      {
        title: '待君归',
        tags: ' · 古风 · 情感 ',
        time: ' 3男3女',
        nandu:' 入门',
        money:'129¥'
      }
    ]
  },

  goBack(){
    wx.navigateBack({
      url: '/pages/playbook/playbook',
    })
  },

  showIsSC() {
    wx.request({
      url: 'http://127.0.0.1:8080/show_is_sc', // 确保 URL 是正确的
      method: 'POST',
      header: {
        'Content-Type': 'application/x-www-form-urlencoded'
      },
      data: {
        userId: app.globalData.userId,
        jbId: this.data.jb_id
      },
      success: (res) => {
        console.log(res.data);
        if (res.data) { // 确保 res.data 是有效的
          this.setData({
            is_sc: res.data
          });
        }else{
          this.setData({
            is_sc: 0
          });
        }
      },
    });
  },

  sc:function(e){
    console.log(this.data.is_sc)
    if(this.data.is_sc==0){
      wx.request({
        url: 'http://127.0.0.1:8080/insert_sc', // 确保 URL 是正确的
        method: 'POST',
        header: {
          'Content-Type': 'application/x-www-form-urlencoded'
        },
        data: {
          userId: app.globalData.userId,
          jbId: this.data.jb_id
        },
        success: (res) => {
          console.log(res.data);
          this.showIsSC();
          wx.showToast({
            title: '收藏成功',
          })
        },
      });
    }else{
      wx.request({
        url: 'http://127.0.0.1:8080/delete_sc', // 确保 URL 是正确的
        method: 'POST',
        header: {
          'Content-Type': 'application/x-www-form-urlencoded'
        },
        data: {
          userId: app.globalData.userId,
          jbId: this.data.jb_id
        },
        success: (res) => {
          console.log(res.data);
          this.showIsSC();
          wx.showToast({
            title: '取消收藏',
          })
        },
      });
      
  }
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    // 接收参数并赋值
    this.setData({
      jb_name: decodeURIComponent(options.jb_name),
      jb_tag: decodeURIComponent(options.jb_tag),
      jb_num: decodeURIComponent(options.jb_num),
      jb_nd: decodeURIComponent(options.jb_nd),
      jb_price: decodeURIComponent(options.jb_price),
      jb_jj: decodeURIComponent(options.jb_jj),
      jb_id: decodeURIComponent(options.jb_id),
      jb_wz:decodeURIComponent(options.jb_wz)
  });
  console.log(this.data.jb_name)
  console.log(this.data.jb_tag)
  console.log(this.data.jb_num)
  console.log(this.data.jb_nd)
  console.log(this.data.jb_price)
  console.log(this.data.jb_jj)
  console.log(this.data.jb_id)
  this.showIsSC()
},
    
  toggleSummary: function() {
    this.setData({
      summaryVisible: !this.data.summaryVisible
    });
  },

  yd:function(){
    console.log(app.globalData.userId);
    console.log(this.data.jb_id);
    wx.request({
      url: 'http://127.0.0.1:8080/insert_user_jb_yy',
      method: 'POST',
      header: {
        'Content-Type': 'application/x-www-form-urlencoded' // 或 'application/json'
      },
      data: {
        userId: app.globalData.userId,
        jbId: this.data.jb_id
      },
      success: function(res) {
        console.log(res.data);
      }
    })
    wx.showToast({
      title: '预定成功',
    })
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