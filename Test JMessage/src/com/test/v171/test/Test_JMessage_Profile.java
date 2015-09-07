package com.test.v171.test;

import java.util.Random;

import com.example.jpushdemo.MainActivity;
import com.robotium.solo.Solo;

import android.annotation.SuppressLint;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;

public class Test_JMessage_Profile extends ActivityInstrumentationTestCase2<MainActivity> {

	private Solo solo;
	private String IllegalUserName = "Illegal_!@#$";
	private String IllegalUserPasswd = "Illegal_passwd";
	private String UnExitUserName = "Un_Exit_User";
	private String ExitUserName = "P1111";
	private String ExitUserPasswd = "123456";
	private String TAG = "JPush";
//  测试的包名
	private static String PadgeName = "com.test.v171";
	
	@SuppressLint("NewApi")
	public Test_JMessage_Profile() {
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
	 *  小于4字节
	 * */
	public String LessThan4bytes()
	{
		return RandomString(3);
	}
	
	/**
	 *  大于64字节
	 * */
	public String MoreThan64bytes()
	{
		return RandomString(65);
	}
	
	/**
	 *  大于250字节
	 * */
	public String MoreThan250bytes()
	{
		return RandomString(251);
	}
	
	/**
	 *  大于128字节
	 * */
	public String MoreThan128bytes()
	{
		return RandomString(129);
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
//      第一个参数是id，第二个固定，第三个是程序包名
		solo.scrollUp();
		int typeId = solo.getCurrentActivity().getResources().getIdentifier("getUserInfo_username", "id",PadgeName );
		EditText v = (EditText)solo.getView(typeId);
		solo.clearEditText(v);
		solo.enterText(v, username);
		
//      点击查询				
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
		
//      点击修改
		solo.clickOnButton("updateUserPassword");
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
		
//      点击修改昵称
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

	
	
	public void testProfile() throws InterruptedException
	{
		if(solo.searchButton("IM Android客户端对外接口基本功能测试"))
			solo.clickOnButton("IM Android客户端对外接口基本功能测试");
		
		solo.clickOnButton("注册_登录_个人信息");
		
		Log.d(TAG, "==========================");
		Log.d(TAG, "===========开始测试==========");
		Log.d(TAG, "===========Profile api==========");
		
		Login(ExitUserName, ExitUserPasswd);
		
		
		Log.d(TAG, "||||||| 5进行Profile维护，条件是有用户登录");
		
		
		// 获取本地个人信息
		Log.d(TAG, "||||||| 5.1 获取本地个人信息");
		getCurrentUser();
		
		
		// 发起网络获取个人信息
		Log.d(TAG, "||||||| 5.2.1 测试获取不存在用户:"+UnExitUserName+"的userinfo,");
		getUserInfo(UnExitUserName);
		
		Log.d(TAG, "||||||| 5.2.2 测试非法用户名:"+IllegalUserName+"的userinfo");
		getUserInfo(IllegalUserName);
		
		Log.d(TAG, "||||||| 5.2.3 测试已经存在的用户"+ExitUserName+"的userinfo,");
		getUserInfo(ExitUserName);
		
		// 修改密码
		Log.d(TAG, "||||||| 5.3.1修改个人密码-测试用户名是:"+ExitUserName+",输入错误的旧密码:"+IllegalUserPasswd);
		updateUserPassword(IllegalUserPasswd, "111111");
		
		Log.d(TAG, "||||||| 5.3.2修改个人密码-测试用户名是:"+ExitUserName+",输入正确的旧密码:"+ExitUserPasswd+"错误的新密码（小于4位；大于128位）");
		String LT4 = LessThan4bytes();
		Log.d(TAG, "小于4位的新密码值:"+LT4);
		updateUserPassword(ExitUserPasswd, LT4);
		
		String MT128 = MoreThan128bytes();
		Log.d(TAG, "大于128位的新密码值:"+MT128);
		updateUserPassword(ExitUserPasswd, MT128);
		
		Log.d(TAG, "||||||| 5.3.3修改个人密码-测试用户名是:"+ExitUserName+",输入正确的旧密码:"+ExitUserPasswd+"合法的新密码:"+"111111");
		updateUserPassword(ExitUserPasswd, "111111");
		
		Log.d(TAG, "修改新密码后，测试登录是否成功");
		Login(ExitUserName, "111111");
		
		Log.d(TAG, "登录后，修改会原来的旧密码");
		updateUserPassword("111111",ExitUserPasswd);
		
		
		// 修改个人昵称
		Log.d(TAG, "||||||| 5.4.1修改个人昵称-不超过64字节");
		String LT64 = RandomString(10);
		Log.d(TAG, "小于64位的昵称值:"+LT64);
		updateUserNickName(LT64);
		getUserInfo(ExitUserName);
		
		Log.d(TAG, "||||||| 5.4.2修改个人昵称-测试超过64字节");
		String MT64 = MoreThan64bytes();
		Log.d(TAG, "大于64位的昵称值:"+MT64);
		updateUserNickName(MT64);
		getUserInfo(ExitUserName);
		
		// 修改生日
		Log.d(TAG, "||||||| 5.5修改生日信息");
		updateUserBirthday(String.valueOf(System.currentTimeMillis()));
		
		
		// 修改个性签名
		Log.d(TAG, "||||||| 5.6.1修改个性签名信息");
		String nicknl = RandomString(5);
		Log.d(TAG, "5位长度的昵称值:"+nicknl);
		updateUserSignature(nicknl);
		getUserInfo(ExitUserName);
		
		Log.d(TAG, "||||||| 5.6.2修改个性签名信息-测试超过250字节");
		String MT250 = MoreThan250bytes();
		Log.d(TAG, "大于250位的个性签名值:"+MT250);
		updateUserSignature(MT250);
		getUserInfo(ExitUserName);
		
		// 修改性别
		Log.d(TAG, "||||||| 5.7.1修改性别信息-未知");
		updateUserGender("未知");
		getUserInfo(ExitUserName);
		
		Log.d(TAG, "||||||| 5.7.2修改性别信息-男");
		updateUserGender("男");
		getUserInfo(ExitUserName);
		
		Log.d(TAG, "||||||| 5.7.3修改性别信息-女");
		updateUserGender("女");
		getUserInfo(ExitUserName);
		
		// 修改地区
		Log.d(TAG, "||||||| 5.8.1修改地区信息");
		updateUserRegion(RandomString(6));
		getUserInfo(ExitUserName);
		
		Log.d(TAG, "||||||| 5.8.2修改地区信息-大于250字节");
		String MT250_ = MoreThan250bytes();
		Log.d(TAG, "大于250位的地区值:"+MT250);
		updateUserRegion(MT250_);
		getUserInfo(ExitUserName);
		
	
	}
	
}
