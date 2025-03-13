Page({
  data: {
    userName: '1',
    userPhone: '',
    userPwd: '',
    confirmPassword: ''
  },

  onUsernameInput(e) {
    this.setData({ userName: e.detail.value });
  },

  onPhoneInput(e) {
    this.setData({ userPhone: e.detail.value });
  },

  onPasswordInput(e) {
    this.setData({ userPwd: e.detail.value });
  },

  onConfirmPasswordInput(e) {
    this.setData({ confirmPassword: e.detail.value });
  },
    
  onRegister() {
    const { userName, userPhone, userPwd, confirmPassword } = this.data;
    // 简单的表单验证
    if (!userName || !userPhone || !userPwd || !confirmPassword) {
      wx.showToast({
        title: '请填写所有字段',
        icon: 'none'
      });
      return;
    }

    if (userPwd !== confirmPassword) {
      wx.showToast({
        title: '密码不一致',
        icon: 'none'
      });
      return;
    }

    
    // 发起注册请求
    wx.request({
      url: 'http://127.0.0.1:8080/user_enroll', 
      method: 'POST',
      header: {
        'Content-Type': 'application/x-www-form-urlencoded' // 或 'application/json'
      },
      data: {
        userName: userName,
        userPhone: userPhone,
        userPwd: userPwd
      },
      success: function(res) {
        console.log(res.data);
        // 假设注册成功后跳转到登录页面
        wx.navigateTo({
          url: '/pages/login/login'
        });
      }
    });
  }
});