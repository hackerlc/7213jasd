package com.liangke.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.HashSet;

public class Preferences {
	private SharedPreferences preference;
	private Editor editor;

	private Preferences(Context context) {
		preference = context.getSharedPreferences("celuetong",
				Context.MODE_PRIVATE);
		editor = preference.edit();
	}

	public static Preferences getInstance(Context context) {
		return new Preferences(context);
	}

	// 首次使用
	public void setIsFirst(boolean flag) {
		editor.putBoolean("isfirst", flag);
		editor.commit();
	}

	public boolean getIsFirst() {
		boolean flag = preference.getBoolean("isfirst", true);
		return flag;
	}

	// token
	public void setToken(String token) {
		editor.putString("token", token);
		editor.commit();
	}

	public String getToken() {
		String token = preference.getString("token", null);
		return token;
	}

	// 设置用户信息
	public void setUserInfo(String userinfo) {
		editor.putString("userinfo", userinfo);
		editor.commit();
	}

	public String getUserInfo() {
		String userinfo = preference.getString("userinfo", null);

		return userinfo;
	}


	public void setIsLogin(boolean b){
		editor.putBoolean("islogin", b);
		editor.commit();
	}

	public boolean getIsLogin(){
		boolean islogin = preference.getBoolean("islogin", false);
		return islogin;
	}

	public String getJsessionid(){
		String jsessionid = preference.getString("jsessionid", "");
		return jsessionid;
	}

	public void setJsessionid(String jsessionid){
		editor.putString("jsessionid", jsessionid);
		editor.commit();
	}

    public HashSet<String> getCookie(){
        HashSet<String> set = (HashSet<String>) preference.getStringSet("cookie", new HashSet<String>());
        return set;
    }

    public void setCookie(HashSet<String> cookie){
        editor.putStringSet("cookie", cookie);
        editor.commit();
    }

    public void setBalance(String balance){
		editor.putString("balance", balance);
		editor.commit();
	}

	public String getBalance(){
		String jsessionid = preference.getString("balance", null);
		return jsessionid;
	}


	// token
	public void setAccountType(int type) {
		editor.putInt("accountType", type);
		editor.commit();
	}

	public int getAccountType() {
		int type = preference.getInt("accountType", 2);
		return type;
	}

	// 设置手势密码
	public void setGesturePath(String gesturePath) {
		editor.putString("gesturePath", gesturePath);
		editor.commit();
	}

	public String getGesturePath() {
		String gesturePath = preference.getString("gesturePath", null);
		return gesturePath;
	}

	public void setInputCount(int count){
		editor.putInt("inputcount", count);
		editor.commit();
	}

	public int getInputCount() {
		int count = preference.getInt("inputcount", 5);
		return count;
	}


	public void setShowType(int type){
		editor.putInt("showType", type);
		editor.commit();
	}

	public int getShowType() {
		int count = preference.getInt("showType", 0);
		return count;
	}


	public void setOrientation(int orientation){
		editor.putInt("orientation", orientation);
		editor.commit();
	}

	public int getOrientation() {
		int orientation = preference.getInt("orientation", 0);
		return orientation;
	}

}
