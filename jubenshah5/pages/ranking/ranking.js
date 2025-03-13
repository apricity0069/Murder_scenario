// pages/ranking/ranking.js
Page({
  /**
   * 页面初始数据
   */
  data: {
    // 示例剧本列表，你可以用实际数据替换
    scriptList: [
      {
        image:"https://wx1.sinaimg.cn/orj360/e60238a1gy1hv133tvtedj20m80uk7gl.jpg",
        score: '9.5分',
        title: '余光千百遍',
        tags: ' · 现代 · 情感 · 盒装',
        details: '我无数次深夜的思念，打了又删的短信，以及隔着人群，总是不自觉瞥向你的余光。这些最好你永远都不要知道。',
        time: ' 3男3女 | 4小时 | 入门'
      },
      {
        image:"https://wx3.sinaimg.cn/orj360/e60238a1gy1hv133v8bwcj20u0159b29.jpg",
        score: '9.5分',
        title: '雪乡连环杀人事件',
        tags: ' · 推理 · 悬疑',
        details: '年三十，北道河，村里出了个杀人魔。杀了一个又一个，最后一个杀老婆。七个小孩来串门，联起手来把案破。',
        time: ' 3男3女 | 4小时 | 进阶'
      },
      {
        image:"https://wx2.sinaimg.cn/orj360/e60238a1gy1hv133wyxphj21yv2rf1kz.jpg",
        score: '9.4分',
        title: '待君归',
        tags: ' · 情感 · 古风',
        details: '世人常说，黑白有界，善恶有别。可谁又分得清善恶黑白，是非对错。如今我已然知晓，只待与君常相守，可君，何时归…',
        time: ' 3男3女 | 4小时 | 入门'
      },
      {
        image:"https://wx4.sinaimg.cn/orj360/e60238a1gy1hv133xcfctj20gg0nx441.jpg",
        score: '9.4分',
        title: '烟云南渡',
        tags: ' · 情感 · 古风',
        details: '我曾在城市的炮火声中听到你们，也曾在山与海的雪色中凝望。风尘仆仆，你们身披朝日与皎月，踏烟云南渡',
        time: ' 3男4女 | 6小时 | 困难'
      },
      {
        image:"https://wx4.sinaimg.cn/mw690/e60238a1gy1hv133z9b2nj21ww2pg4qp.jpg",
        score: '9.3分',
        title: '祁山',
        tags: ' · 情感 · 古风',
        details: '正始十年，一场密谋已久的政变，敲响了时代变天的讯号。魏国朝堂风云四起，蜀汉又因丞相仙逝举国动荡。在这三国最后一舞中......',
        time: ' 3男3女 | 4小时 | 适中'
      }
    ]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // 你可以在这里进行网络请求以获取实际数据
    // 示例：wx.request({ url: 'your-api-url', success: (res) => { this.setData({ scriptList: res.data }) }})
    console.log("页面加载完成");
  },
// 返回上一页
goBack: function() {
  wx.navigateBack({
    delta: 1 // 返回的页面数，如果 delta 大于现有页面数，则返回到首页
  });
},
  /**
   * 生命周期函数--页面初次渲染完成
   */
  onReady: function () {
    console.log("页面已准备好");
  },

  /**
   * 生命周期函数--页面显示
   */
  onShow: function () {
    console.log("页面可见");
  },

  /**
   * 生命周期函数--页面隐藏
   */
  onHide: function () {
    console.log("页面已隐藏");
  },

  /**
   * 生命周期函数--页面卸载
   */
  onUnload: function () {
    console.log("页面已卸载");
  },

  /**
   * 用户下拉刷新事件处理函数
   */
  onPullDownRefresh: function () {
    console.log("用户下拉刷新");
    // 你可以在这里添加刷新数据的逻辑
    // 示例：wx.request({ url: 'your-api-url', success: (res) => { this.setData({ scriptList: res.data }) }})
    wx.stopPullDownRefresh();
  },

  /**
   * 用户到达页面底部事件处理函数
   */
  onReachBottom: function () {
    console.log("用户到达页面底部");
    // 你可以在这里添加加载更多数据的逻辑
  },

  /**
   * 用户分享页面事件处理函数
   */
  onShareAppMessage: function () {
    return {
      title: "剧本人气排行榜",
      path: "/pages/ranking/ranking"
    };
  }
});
