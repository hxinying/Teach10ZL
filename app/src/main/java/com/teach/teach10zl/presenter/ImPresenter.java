package com.teach.teach10zl.presenter;

import android.text.TextUtils;
import android.util.Log;

import com.teach.datalibrary.LoginInfo;
import com.teach.frame10.frame.FrameApplication;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import com.tencent.qcloud.tim.demo.login.UserInfo;
import com.tencent.qcloud.tim.demo.signature.GenerateTestUserSig;
import com.tencent.qcloud.tim.tuikit.live.TUIKitLive;
import com.tencent.qcloud.tim.uikit.TUIKit;
import com.tencent.qcloud.tim.uikit.base.IUIKitCallBack;
import com.tencent.qcloud.tim.uikit.config.TUIKitConfigs;
import com.yiyatech.utils.LogUtil;

/*

 @胡欣颖  com.teach.teach10zl.presenter
2020/12/3
*/public class ImPresenter {
    private String TAG = "TAG";
    /*   public void doLogin(String pUser) {
     *   if (isLogin()){
         //登陆过
              String userId = UserInfo.getInstance().getUserId();
              String userSig = GenerateTestUserSig.genTestUserSig(userId);
              imLogin(userId,userSig);
          } else {//第一次登陆
              if (!TextUtils.isEmpty(pUser)){
                  String user = pUser;
                  UserInfo.getInstance().setUserId(user);
                  // 获取userSig函数
                  String userSig = GenerateTestUserSig.genTestUserSig(user);
                  imLogin(user,userSig);
              }
          }
      }*/

    private int needResetAvatar;

    public void doLogin(String pUserId, int loginType) {
        doLogin(pUserId);
        needResetAvatar = loginType;
    }

    public void doLogin(String pUserId) {
        if (!TextUtils.isEmpty(pUserId)) {//不是第一次的登录
            UserInfo.getInstance().setUserId(pUserId);
            String userId = UserInfo.getInstance().getUserId();
            String userSig = GenerateTestUserSig.genTestUserSig(userId);
            imLogin(userId, userSig);
        }
    }

    private void imLogin(String user, String userSig) {
        TUIKit.login(user, userSig, new IUIKitCallBack() {
            @Override
            public void onError(String module, final int code, final String desc) {
                LogUtil.e("通讯", "filed code:" + code);
            }

            @Override
            public void onSuccess(Object data) {
                UserInfo.getInstance().setUserId(user);
                LogUtil.e("通讯", "登陆成功");
                if (needResetAvatar == 2) {
                    resetAvatar();
                }
            }
        });

    }

    private void resetAvatar() {
        LoginInfo loginInfo = FrameApplication.getFrameApplication().getLoginInfo();
        String avatar = loginInfo.personHeader.getAvatar();//头像
        String username = loginInfo.getUsername();//用户名
        V2TIMUserFullInfo v2TIMUserFullInfo = new V2TIMUserFullInfo();
        // 头像
        if (!TextUtils.isEmpty(avatar)) {
            v2TIMUserFullInfo.setFaceUrl(avatar);
            UserInfo.getInstance().setAvatar(avatar);
        }

        if (!TextUtils.isEmpty(username)) {
            // 昵称
            String nickName = username;
            v2TIMUserFullInfo.setNickname(nickName);
            UserInfo.getInstance().setName(nickName);//sp保存
        }
        V2TIMManager.getInstance().setSelfInfo(v2TIMUserFullInfo, new V2TIMCallback() {
            @Override
            public void onError(int code, String desc) {
                Log.e(TAG, "modifySelfProfile err code = " + code + ", desc = " + desc);

            }

            @Override
            public void onSuccess() {
                Log.i(TAG, "modifySelfProfile success");
                TUIKitConfigs.getConfigs().getGeneralConfig().setUserFaceUrl(avatar);
                TUIKitConfigs.getConfigs().getGeneralConfig().setUserNickname(username);
                TUIKitLive.refreshLoginUserInfo(null);
            }
        });

    }

    public boolean isLogin() {
        LoginInfo loginInfo = FrameApplication.getFrameApplication().getLoginInfo();
        return loginInfo != null && !TextUtils.isEmpty(loginInfo.getUid());
    }
}
