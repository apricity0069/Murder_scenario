Page({
  data: {
    announcements: [
      '公告一：欢迎使用我们的应用！',
      '公告二：请注意最新的活动信息！',
      '公告三：保持关注，我们将有更多更新！'
    ],
    currentAnnouncement: '',
    autoplay: false, // 初始化
    currentRoomIndex: 0, // 当前主题房间索引
    currentDMIndex: 0, // 当前店内DM索引
    rooms: [
      {  image: "https://wx1.sinaimg.cn/orj360/e60238a1ly1hvjg2y4cvtj2140198qb2.jpg",name: "大都会" },
      { image: "https://wx1.sinaimg.cn/orj360/e60238a1ly1hvjg2yevt2j21400z4dn5.jpg", name: "长汀西苑" },
      { image: "https://wx1.sinaimg.cn/orj360/e60238a1ly1hvjg2yqvo5j21400u0jxh.jpg",name: "惊梦" },
      {  image: "https://wx2.sinaimg.cn/orj360/e60238a1ly1hvjg2yzwsdj21400u00xu.jpg",name: "五年三班" },
      { image: "https://wx4.sinaimg.cn/orj360/e60238a1ly1hvjg2zgfmlj21bz0zjdo4.jpg" ,name: "梨园"}
    ],
    dms: [
      { name: "Yummy", image: "https://wx3.sinaimg.cn/orj360/e60238a1ly1hvjg2zotsrj20tq15wgpu.jpg" },
      { name: "Jack", image: "https://wx3.sinaimg.cn/orj360/e60238a1ly1hvjg300km2j20u21944cq.jpg" },
      { name: "Jenny", image: "https://wx2.sinaimg.cn/orj360/e60238a1ly1hvjg30deoyj20q10w27ay.jpg" },
      { name: "Amy", image: "https://wx1.sinaimg.cn/mw690/e60238a1ly1hvjg319icej20p00zradp.jpg" },
      { name: "Candy", image: "https://wx1.sinaimg.cn/mw690/e60238a1ly1hvjg30yajqj20zk1i4grg.jpg"}
    ]
  },

  onLoad:function(options){
    this.startAnnouncementLoop();
  },
  startAnnouncementLoop() {
    let index = 0;
    const that = this;

    function updateAnnouncement() {
      that.setData({
        currentAnnouncement: that.data.announcements[index]
      });
      index = (index + 1) % that.data.announcements.length; // 循环播放
    }

    updateAnnouncement(); // 初始公告
    setInterval(updateAnnouncement, 10000); // 每3秒更新一次公告
  },
   
  

  goToScene() {
    wx.navigateTo({
      url: '/pages/scene/scene' // 跳转到“案发现场”页面
    });
  },

  goToProfile() {
    wx.navigateTo({
      url: '/pages/profile/profile' // 跳转到“个人档案”页面
    });
  },

  callShop() {
    wx.makePhoneCall({
      phoneNumber: '123456789' // 替换为真实电话
    });
  },

  contactWeChat() {
    wx.showToast({
      title: '请添加微信号进行联系！',
      icon: 'none'
    });
  },
  onLeftButtonTap: function () {

     wx.navigateTo({
       url: '/pages/playbook/playbook',
     })
  },
  
  onRightButton1Tap: function () {
    wx.navigateTo({
      url: '/pages/fcl/fcl',
    })
  },

  onRightButton2Tap: function () {
   wx.navigateTo({
     url: '/pages/ranking/ranking',
   })
  },
  goToScene() {
    wx.navigateTo({
      url: '/pages/scene/scene'
    });
  },

  goToProfile() {
    wx.navigateTo({
      url: '/pages/profile/profile'
    });
  }
});
