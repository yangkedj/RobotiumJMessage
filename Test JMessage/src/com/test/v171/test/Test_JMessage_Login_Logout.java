package com.test.v171.test;

import java.util.Random;

import com.example.jpushdemo.MainActivity;
import com.robotium.solo.Solo;

import android.annotation.SuppressLint;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;

public class Test_JMessage_Login_Logout extends ActivityInstrumentationTestCase2<MainActivity> {

	private Solo solo;
	private String ExitUserName = "P1111";
	private String ExitUserPasswd = "123456";
	private String TAG = "JPush";
	private String username = "";
	private String passwd = "";
	
	
	// 测试的包名
	private static String PadgeName = "com.test.v171";
	
	@SuppressLint("NewApi")
	public Test_JMessage_Login_Logout() {
		super(MainActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	protected void tearDown() throws Exception {
		try {
			 solo.finalize();
			 solo.finishOpenedActivities();
			 } catch (Throwable e) {
			 e.printStackTrace();
			 }
			 getActivity().finish();
			 super.tearDown();
	}

	
	/**
	 * 注册接口！
	 * @throws InterruptedException 
	 * */
	public  void Register(String user,String pwd) throws InterruptedException
	{
		solo.scrollUp();
		solo.clearEditText(0);
		solo.clearEditText(1);
		solo.enterText(0, user);
		solo.enterText(1, pwd);
		
		Log.d(TAG, "注册用户为: "+user);
		Log.d(TAG, "注册密码:"+pwd);
		
		solo.clickOnButton("register");
		solo.sleep(3000);
	}
	
	/**
	 * 登录接口
	 * @throws InterruptedException 
	 * */
	public  void Login(String user,String pwd) throws InterruptedException
	{
		solo.scrollUp();
		solo.clearEditText(2);
		solo.clearEditText(3);
		solo.enterText(2, user);
		solo.enterText(3, pwd);
		solo.clickOnButton("imlogin");
		solo.sleep(3000);
	}
	
	/**
	 * 登出接口
	 * @throws InterruptedException 
	 * 
	 * */
	public  void Logout() throws InterruptedException
	{
		solo.scrollUp();
		solo.clickOnButton("imlogout");
		solo.sleep(3000);
	}
	
	/**
	 * 获取本地个人信息接口
	 * @throws InterruptedException 
	 * */
	public  void getCurrentUser() throws InterruptedException
	{
		solo.scrollUp();
		solo.clickOnButton("getCurrnetUser");
		solo.sleep(3000);
	}
	
	
	
	/***
	 * 从网络获取个人信息的接口
	 * @throws InterruptedException 
	 * 
	 */
	public  void getUserInfo(String username) throws InterruptedException
	{
		// 第一个参数是id，第二个固定，第三个是程序包名
		
		solo.scrollUp();
		int typeId = solo.getCurrentActivity().getResources().getIdentifier("getUserInfo_username", "id",PadgeName );
		EditText v = (EditText)solo.getView(typeId);
		solo.clearEditText(v);
		solo.enterText(v, username);
		
		// 点击查询
		
		
		solo.clickOnButton("getUserInfo");
		solo.sleep(3000);
	}
	
	/**
	 * 修改密码接口
	 * @throws InterruptedException 
	 * 
	 * */
	public  void updateUserPassword(String oldpasswd,String newpasswd) throws InterruptedException
	{
		solo.scrollUp();
		int typeIdold = solo.getCurrentActivity().getResources().getIdentifier("updateUserPassword_oldPassword", "id",PadgeName );
		EditText vold = (EditText)solo.getView(typeIdold);
		
		int typeIdnew = solo.getCurrentActivity().getResources().getIdentifier("updateUserPassword_newPassword", "id",PadgeName );
		EditText vnew = (EditText)solo.getView(typeIdnew);
		
		solo.clearEditText(vold);
		solo.clearEditText(vnew);
		solo.enterText(vold, oldpasswd);
		solo.enterText(vnew, newpasswd);
		
		//点击修改
		solo.clickOnButton("updateUserPassword");
		solo.sleep(3000);
	}
	
	/**
	 * 修改昵称
	 * @throws InterruptedException 
	 * 
	 * */
	public  void updateUserNickName(String nickname) throws InterruptedException
	{
		solo.scrollUp();
		int typeIdnew = solo.getCurrentActivity().getResources().getIdentifier("updateUserNickName_nickname", "id",PadgeName );
		EditText vnickN = (EditText)solo.getView(typeIdnew);
		solo.clearEditText(vnickN);
		solo.enterText(vnickN, nickname);
		
		//点击修改昵称
		solo.clickOnButton("updateUserNickName");
		solo.sleep(3000);
	}
	
	/**
	 * 修改生日
	 * @throws InterruptedException 
	 * 
	 * */
	public  void updateUserBirthday(String birthday) throws InterruptedException
	{
		solo.scrollUp();
		int typeIdnew = solo.getCurrentActivity().getResources().getIdentifier("updateUserBirthday_birthday", "id",PadgeName );
		EditText vbirth = (EditText)solo.getView(typeIdnew);
		solo.clearEditText(vbirth);
		solo.enterText(vbirth, birthday);
		solo.clickOnButton("updateUserBirthday");
		solo.sleep(3000);
	}
	
	/**
	 * 修改个性签名
	 * @throws InterruptedException 
	 * 
	 * */
	public  void updateUserSignature(String signature) throws InterruptedException
	{
		solo.scrollUp();
		int typeIdnew = solo.getCurrentActivity().getResources().getIdentifier("updateUserSignature_signature", "id",PadgeName );
		EditText vsignature = (EditText)solo.getView(typeIdnew);
		solo.clearEditText(vsignature);
		solo.enterText(vsignature, signature);
		
//      点击个性签名
		solo.clickOnButton("updateUserSignature");
		solo.sleep(3000);
	}
	
	/**
	 * 修改性别=== 男 女 未知
	 * @throws InterruptedException 
	 * */
	public  void updateUserGender(String gender) throws InterruptedException
	{
		solo.scrollUp();
		int typeIdnew = solo.getCurrentActivity().getResources().getIdentifier("updateUserGender_gender", "id",PadgeName );
		EditText vgender = (EditText)solo.getView(typeIdnew);
		solo.clearEditText(vgender);
		solo.enterText(vgender, gender);
		
//      点击修改性别
		solo.clickOnButton("updateUserGender");
		solo.sleep(3000);
	}
	
	/**
	 * 修改地区
	 * @throws InterruptedException 
	 * */
	public  void updateUserRegion(String region) throws InterruptedException
	{
		solo.scrollUp();
		int typeIdnew = solo.getCurrentActivity().getResources().getIdentifier("updateUserRegion_region", "id",PadgeName );
		EditText vregion = (EditText)solo.getView(typeIdnew);
		solo.clearEditText(vregion);
		solo.enterText(vregion, region);
		
//      点击修改地区信息
		solo.clickOnButton("updateUserRegion");
		solo.sleep(3000);
	}
	
	
	/**
	 * 随机字符串
	 * */
	public  String RandomString(int length) {  
	    String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@-_.";  
	    Random random = new Random();  
	    StringBuffer buf = new StringBuffer();  
	    for (int i = 0; i < length; i++) {  
	        int num = random.nextInt(62);  
	        buf.append(str.charAt(num));  
	    }  
	    return buf.toString();  
	}  

	
	
	/********************************************************************************************
	 * 2.测试登录登出接口
	 * 
	 ********************************************************************************************/
	
	public void testLoginLogout() throws InterruptedException
	{
		if(solo.searchButton("IM Android客户端对外接口基本功能测试"))
			solo.clickOnButton("IM Android客户端对外接口基本功能测试");
	
		solo.clickOnButton("注册_登录_个人信息");
		
		Log.d(TAG, "==========================");
		Log.d(TAG, "===========开始测试==========");
		Log.d(TAG, "===========登录、登出api==========");
		
		for(int i=1;i<=5;i++)
			switch (i) {
			case 1:
				Log.d(TAG, "@@@@@@ 2.1 存在的用户名，正确密码登录");
				Login(ExitUserName, ExitUserPasswd);
				
				break;
				
			case 2:
				Log.d(TAG, "@@@@@@ 2.2 存在的用户名，错误密码登录");
				passwd = "654321";
				Login(ExitUserName, passwd);
				
				break;
				
			case 3:
				Log.d(TAG, "@@@@@@ 2.3 不存在的用户名登录");
				username = "77994466qazplm";
				passwd = "123465";
				Login(username, passwd);
				
				break;
			
			case 4:
				Log.d(TAG, "@@@@@@ 2.4 非法的用户名登录");
				username = RandomString(3);
				passwd = "123456";
				Login(username, passwd);
				
				break;
				
			default:
				break;
			}
		
		Log.d(TAG, "@@@@@@ 3 用户名yk92连续登录5次，再登出5次");
		for (int i =1;i<=3;i++)
		{
			Log.d(TAG, "用户名"+ExitUserName+"登录"+i+"次");
			Login(ExitUserName, ExitUserPasswd);
			Logout();
			Log.d(TAG, "用户名"+ExitUserName+"登出"+i+"次");
			
		}
		
		Log.d(TAG, "@@@@@@ 4没有用户登录过，点击登出操作");
		Logout();
		
		
		
	}
	
}
