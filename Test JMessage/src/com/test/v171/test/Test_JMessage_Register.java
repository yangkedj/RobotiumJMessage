package com.test.v171.test;


import java.util.ArrayList;
import java.util.Random;

import com.example.jpushdemo.MainActivity;
import com.robotium.solo.Solo;
import com.robotium.solo.WebElement;

import android.R.bool;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Test_JMessage_Register extends ActivityInstrumentationTestCase2<MainActivity> {

	private Solo solo;
	private String TAG = "JPush";
	private String username = "";
	private String passwd = "";
	private String ExitUserName = "P1111";
	private String ExitUserPasswd = "123456";
	
	// ���Եİ���
	private String PadgeName = "com.test.v171";
	
	private boolean TO_testRegister = true;
	
	
	@SuppressLint("NewApi")
	public Test_JMessage_Register() {
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
	 * ע��ӿڣ�
	 * @throws InterruptedException 
	 * */
	public  void Register(String user,String pwd) throws InterruptedException
	{
		solo.scrollUp();
		solo.clearEditText(0);
		solo.clearEditText(1);
		solo.enterText(0, user);
		solo.enterText(1, pwd);
		
		Log.d(TAG, "ע���û�Ϊ: "+user);
		Log.d(TAG, "ע������:"+pwd);
		
		solo.clickOnButton("register");
		solo.sleep(3000);
	}
	
	/**
	 * ��¼�ӿ�
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
	 * �ǳ��ӿ�
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
	 * ��ȡ���ظ�����Ϣ�ӿ�
	 * @throws InterruptedException 
	 * */
	public  void getCurrentUser() throws InterruptedException
	{
		solo.scrollUp();
		solo.clickOnButton("getCurrnetUser");
		solo.sleep(3000);
	}
	
	
	
	/***
	 * �������ȡ������Ϣ�Ľӿ�
	 * @throws InterruptedException 
	 * 
	 */
	public  void getUserInfo(String username) throws InterruptedException
	{
		// ��һ��������id���ڶ����̶����������ǳ������
		
		solo.scrollUp();
		
		int typeId = solo.getCurrentActivity().getResources().getIdentifier("getUserInfo_username", "id",PadgeName );
		EditText v = (EditText)solo.getView(typeId);
		solo.clearEditText(v);
		solo.enterText(v, username);
		
		// �����ѯ
		
		
		solo.clickOnButton("getUserInfo");
		solo.sleep(3000);
	}
	
	/**
	 * �޸�����ӿ�
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
		
		//����޸�
		solo.clickOnButton("updateUserPassword");
		solo.sleep(3000);
	}
	
	/**
	 * �޸��ǳ�
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
		
		//����޸��ǳ�
		solo.clickOnButton("updateUserNickName");
		solo.sleep(3000);
	}
	
	/**
	 * �޸�����
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
		
		//�����Ȳ��������
		//solo.clickOnButton("updateUserBirthday");
		solo.sleep(3000);
	}
	
	/**
	 * �޸ĸ���ǩ��
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
		
		//�������ǩ��
		solo.clickOnButton("updateUserSignature");
		solo.sleep(3000);
	}
	
	/**
	 * �޸��Ա�=== �� Ů δ֪
	 * @throws InterruptedException 
	 * */
	public  void updateUserGender(String gender) throws InterruptedException
	{
		solo.scrollUp();
		int typeIdnew = solo.getCurrentActivity().getResources().getIdentifier("updateUserGender_gender", "id",PadgeName );
		EditText vgender = (EditText)solo.getView(typeIdnew);
		solo.clearEditText(vgender);
		solo.enterText(vgender, gender);
		
		//����޸��Ա�
		solo.clickOnButton("updateUserGender");
		solo.sleep(3000);
	}
	
	/**
	 * �޸ĵ���
	 * @throws InterruptedException 
	 * */
	public  void updateUserRegion(String region) throws InterruptedException
	{
		solo.scrollUp();
		int typeIdnew = solo.getCurrentActivity().getResources().getIdentifier("updateUserRegion_region", "id",PadgeName );
		EditText vregion = (EditText)solo.getView(typeIdnew);
		solo.clearEditText(vregion);
		solo.enterText(vregion, region);
		
		//����޸ĵ�����Ϣ
		solo.clickOnButton("updateUserRegion");
		solo.sleep(3000);
	}
	
	
	/**
	 * ����ַ���
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
	
	
	/******************************************************************************************
	 * 1.����ע��ӿ� register
	 * @throws InterruptedException 
	 * ***************************************************************************************/
	
	public void testRegister() throws InterruptedException
	{
		
		Log.d(TAG, "==========================");
		Log.d(TAG, "===========��ʼ����==========");
		Log.d(TAG, "===========ע��api==========");
		
		if(solo.searchButton("IM Android�ͻ��˶���ӿڻ������ܲ���"))
			solo.clickOnButton("IM Android�ͻ��˶���ӿڻ������ܲ���");
	
		solo.clickOnButton("ע��_��¼_������Ϣ");
		
		for (int i =1 ;i <= 8;i++){
			
			switch(i)
			{
			case 1:
				Log.d(TAG, "@@@@@@ 1.1 ���û���ע��");
				username = "";
				passwd = "123456";
				Register(username,passwd);
				
				break;
				
			case 2:
				Log.d(TAG, "@@@@@@ 1.2 �Ƿ��û���ע��");
				username = "@#123";
			    passwd = "123456";
				Register(username, passwd);
				
				break;
				
			case 3:
				Log.d(TAG, "@@@@@@ 1.3 �û�������С��4ע��");
				username = "987";
				passwd = "123456";
				Register(username, passwd);
				
				break;
			
			case 4:
				Log.d(TAG, "@@@@@@ 1.4 �û������ȴ���128ע��");
				username = "";
				for(int j =1; j <= 129;j++)
					username +="1";
				passwd = "123456";
				Register(username, passwd);
				
				break;
			
			case 5:
				Log.d(TAG, "@@@@@@ 1.5 ���볤��С��4ע��");
				username = "abc"+RandomString(1);
				passwd =  "123";
				Register(username, passwd);
				
				break;
			
			case 6:
				Log.d(TAG, "@@@@@@ 1.6 ���볤�ȴ���128ע��");
				username = "abcd";
				passwd =  "";
				for (int k =1;k<=129;k++)
					passwd+="1";
				Register(username, passwd);
				
				break;
			
			case 7:
				Log.d(TAG, "@@@@@@ 1.7 �Ϸ�ע��");
				username = RandomString(4);
				passwd = RandomString(4);
				Register(username, passwd);
				
				
				solo.enterText(2, username);
				solo.enterText(3, passwd);
				Log.d(TAG, "@@@@@@ 1.8 ע��ɹ��󣬵����¼");
				solo.clickOnButton("imlogin");
				solo.sleep(3000);
				break;
				
			}
		}
	
	}
	
		
	
}
