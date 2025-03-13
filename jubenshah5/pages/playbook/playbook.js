Page({
  data: {
    searchQuery:'',
    jbName:'',
    num: [
      { label: '全部', selected: false },
      { label: '4人', selected: false },
      { label: '5人', selected: false },
      { label: '6人', selected: false },
      { label: '7人', selected: false },
      { label: '8人', selected: false },
      { label: '9人', selected: false },
    ],
    nd: [
      { label: '全部', selected: false },
      { label: '入门', selected: false },
      { label: '进阶', selected: false },
      { label: '适中', selected: false },
      { label: '烧脑', selected: false },
      { label: '困难', selected: false },
    ],
    tag: [
      { label: '全部', selected: false },
      { label: '推理', selected: false },
      { label: '阵营', selected: false },
      { label: '情感', selected: false },
      { label: '恐怖', selected: false },
      { label: '民国', selected: false },
      { label: '古风', selected: false }

    ],
    price: [
      { label: '全部', selected: false },
      { label: '89￥', selected: false },
      { label: '99￥', selected: false },
      { label: '109￥', selected: false },
      { label: '119￥', selected: false },
      { label: '129￥', selected: false },
    ],
    scriptList: [],
    jbNum:null,
    jbNd:null,
    jbTag:null,
    jbPrice:null
  },

   // 输入框输入时的处理函数
   onSearchInput: function(e) {
    this.setData({
      searchQuery: e.detail.value // 更新输入框的内容
    });
  },
  // 图片点击时的处理函数
  onSearchIconTap: function() {
    console.log("点击了图片")
  // 获取输入框的内容
  const searchQuery = this.data.searchQuery;
  // 发送请求到后端
  console.log(searchQuery);
  wx.request({
    url: 'http://127.0.0.1:8080/show_name_jb',
    method: 'POST',
    header: {
      'Content-Type': 'application/x-www-form-urlencoded' // 或 'application/json'
    },
    data: {
    jbName:this.data.searchQuery
    },
    success: (res) => {
      console.log(res.data);
      this.setData({
        scriptList: res.data
    });
    }
  })
  },

  //选项点击时处理函数
  toggleFilter(e) {
    const index = e.currentTarget.dataset.index;
    const group = e.currentTarget.dataset.group;
    const groups = this.data;

    groups[group].forEach((item, idx) => {
      if (idx === index) {
        item.selected = !item.selected;
      } else {
        item.selected = false;
      }
    });

    this.setData(groups);
    //提取所有选中项目
    const groupNames = ['num', 'nd', 'price', 'tag'];
    let numcount = 0;
    let ndcount = 0;
    let pricecount = 0;
    let tagcount = 0;
    groupNames.forEach(groupName => {
        groups[groupName].forEach(item => {
            if(groupName=="num"&&item.selected==true){
              numcount++;
              this.setData({
                jbNum:item.label
              })
            }
            if(groupName=="nd"&&item.selected==true){
              ndcount++;
            this.setData({
              jbNd:item.label
            })
          }
            if(groupName=="tag"&&item.selected==true){
              tagcount++;
            this.setData({
              jbTag:item.label
            })
          }
            if(groupName=="price"&&item.selected==true){
              pricecount++;
            this.setData({
              jbPrice:item.label
            })
          }
           
        });

    });
    if(numcount==0){
      this.setData({
        jbNum:null
      })
    }
    if(ndcount==0){
      this.setData({
        jbNd:null
      })
    }
    if(tagcount==0){
      this.setData({
        jbTag:null
      })
    }
    if(pricecount==0){
      this.setData({
        jbPrice:null
      })
    }
    console.log('Num:', this.data.jbNum);
    console.log('ND:', this.data.jbNd);
    console.log('Price:', this.data.jbPrice);
    console.log('Tag:', this.data.jbTag);
    wx.request({
      url: 'http://127.0.0.1:8080/show_appoint_jb',
      method: 'POST',
      header: {
        'Content-Type': 'application/x-www-form-urlencoded' // 或 'application/json'
      },
      data: {
      jbNum: this.data.jbNum,
      jbNd: this.data.jbNd,
      jbTag: this.data.jbTag,
      jbPrice:this.data.jbPrice
      },
      success: (res) => {
        console.log(res.data);
        this.setData({
          scriptList: res.data
      });
      }
    })
    
  },
// jbname:'',
//jbtag:'',
//jbnum:'',
//jbnd:'',
//jbprice:'',
  detailshow: function(event){
    const item = event.currentTarget.dataset.item;
    console.log(item);
    wx.navigateTo({
      url: '/pages/detail/detail?jb_name=' + encodeURIComponent(item.jb_name) + 
           '&jb_tag=' + encodeURIComponent(item.jb_tag) + 
           '&jb_num=' + encodeURIComponent(item.jb_num) + 
           '&jb_nd=' + encodeURIComponent(item.jb_nd) +
           '&jb_price=' + encodeURIComponent(item.jb_price) +
           '&jb_jj=' + encodeURIComponent(item.jb_jj) +
           '&jb_id=' +encodeURIComponent(item.jb_id) +
           '&jb_wz=' +encodeURIComponent(item.jb_wz),
  });
  },

  goBack: function() {
    wx.navigateBack({
      delta: 1 // 返回的页面数，如果 delta 大于现有页面数，则返回到首页
    });
  },




   /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {

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
    wx.request({
        url: 'http://127.0.0.1:8080/show_all_jb',
        success: (res) => {  // 使用箭头函数
            console.log(res.data);
            this.setData({
                scriptList: res.data
            });
        }
    });
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
});
