Page({
  data: {
    userPhone: '',
    userPwd: ''
  },
  
  onInputUsername(e) {
    this.setData({
      userPhone: e.detail.value
    });
  },
  
  onInputPassword(e) {
    this.setData({
      userPwd: e.detail.value
    });
  },

  onLogin() {
    const { userPhone, userPwd } = this.data;

    if (userPhone === '' || userPwd === '') {
      wx.showToast({
        title: '请输入用户名和密码',
        icon: 'none'
      });
      return;
    }

    wx.request({
      url: 'http://127.0.0.1:8080/user_login', 
      method: 'POST',
      header: {
        'Content-Type': 'application/x-www-form-urlencoded' // 或 'application/json'
      },
      data: {
        userPhone: userPhone,
        userPwd: userPwd
      },
      success: function(res) {
        console.log(res.data);
        if (res.data.user_id!=null) { 
          wx.showToast({
            title: '登录成功',
            icon: 'success'
          });
          const app = getApp();
          app.globalData.userId = res.data.user_id;
          app.globalData.userName = res.data.user_name;
          wx.switchTab({
            url: '/pages/index/index' 
        });
        } else {
          wx.showToast({
            title: '账号或密码错误',
            icon: 'none'
          });
        }
      }
    });
  },

  goToRegister() {
    wx.navigateTo({
      url: '../register/register'  // 根据实际的页面路径修改
    });
  }
});
