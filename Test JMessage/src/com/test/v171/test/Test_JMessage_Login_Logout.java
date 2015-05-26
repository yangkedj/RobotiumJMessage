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
	
	
	// ���Եİ���
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
		solo.clickOnButton("updateUserBirthday");
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
		
//      �������ǩ��
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
		
//      ����޸��Ա�
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
		
//      ����޸ĵ�����Ϣ
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

	
	
	/********************************************************************************************
	 * 2.���Ե�¼�ǳ��ӿ�
	 * 
	 ********************************************************************************************/
	
	public void testLoginLogout() throws InterruptedException
	{
		if(solo.searchButton("IM Android�ͻ��˶���ӿڻ������ܲ���"))
			solo.clickOnButton("IM Android�ͻ��˶���ӿڻ������ܲ���");
	
		solo.clickOnButton("ע��_��¼_������Ϣ");
		
		Log.d(TAG, "==========================");
		Log.d(TAG, "===========��ʼ����==========");
		Log.d(TAG, "===========��¼���ǳ�api==========");
		
		for(int i=1;i<=5;i++)
			switch (i) {
			case 1:
				Log.d(TAG, "@@@@@@ 2.1 ���ڵ��û�������ȷ�����¼");
				Login(ExitUserName, ExitUserPasswd);
				
				break;
				
			case 2:
				Log.d(TAG, "@@@@@@ 2.2 ���ڵ��û��������������¼");
				passwd = "654321";
				Login(ExitUserName, passwd);
				
				break;
				
			case 3:
				Log.d(TAG, "@@@@@@ 2.3 �����ڵ��û�����¼");
				username = "77994466qazplm";
				passwd = "123465";
				Login(username, passwd);
				
				break;
			
			case 4:
				Log.d(TAG, "@@@@@@ 2.4 �Ƿ����û�����¼");
				username = RandomString(3);
				passwd = "123456";
				Login(username, passwd);
				
				break;
				
			default:
				break;
			}
		
		Log.d(TAG, "@@@@@@ 3 �û���yk92������¼5�Σ��ٵǳ�5��");
		for (int i =1;i<=3;i++)
		{
			Log.d(TAG, "�û���"+ExitUserName+"��¼"+i+"��");
			Login(ExitUserName, ExitUserPasswd);
			Logout();
			Log.d(TAG, "�û���"+ExitUserName+"�ǳ�"+i+"��");
			
		}
		
		Log.d(TAG, "@@@@@@ 4û���û���¼��������ǳ�����");
		Logout();
		
		
		
	}
	
}
